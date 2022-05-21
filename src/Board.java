public class Board {

    private final char charAlive = '#';
    private final char charDead = '.';

    private Cell[][] fields;
    private int gen;

    public Board(int height, int width) {
        fields = new Cell[height][width];
        gen = 1;
        for(int y = 0; y < fields.length; y++) {
            for(int x = 0; x < fields[0].length; x++) {
                if(Math.random() < 0.2) {
                    fields[y][x] =  new Cell(true);
                } else {
                    fields[y][x] =  new Cell(false);
                }
            }
        }
    }

    public void run() throws InterruptedException {
        while(true) {
            draw();
            update();
            gen += 1;
            Thread.sleep(700);
        }
    }

    private void draw() {
        System.out.println();
        System.out.println();
        for(int y = 0; y < fields.length; y++) {
            for(int x = 0; x < fields[0].length; x++) {
                if(fields[y][x].isAlive()) {
                    System.out.print(charAlive + "");
                } else {
                    System.out.print(charDead + "");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void update() {
        for(int y = 0; y < fields.length; y++) {
            for(int x = 0; x < fields[0].length; x++) {
                countAliveNeighbourCells(y, x);
                fields[y][x].checkNextCellStatus();
            }
        }
        for(int y = 0; y < fields.length; y++) {
            for(int x = 0; x < fields[0].length; x++) {
                fields[y][x].update();
            }
        }
    }

    private void countAliveNeighbourCells(int yPos, int xPos) {
        int counter = 0;
        for(int y = yPos - 1; y < yPos + 2; y++) {
            for(int x = xPos - 1; x < xPos + 2; x++) {
                if(y == yPos && x == xPos) {
                    continue;
                }
                if((y >= 0 && y < fields.length) && (x >= 0 && x < fields[0].length)) {
                    if(fields[y][x].isAlive()) {
                        counter++;
                    }
                }
            }
        }
        fields[yPos][xPos].setNeighbours(counter);
    }

    public Cell[][] getFields() {
        return fields;
    }

    public void setFields(Cell[][] fields) {
        this.fields = fields;
    }

    public int getGen() {
        return gen;
    }

    public void setGen(int gen) {
        this.gen = gen;
    }
}
