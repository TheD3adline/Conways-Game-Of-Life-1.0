public class Board {

    private final char charAlive = '#';
    private final char charDead = '.';

    private Cell[][] fields;
    private int gen;

    public Board(int height, int width) {
        fields = new Cell[height][width];
        gen = 1;
        for(int i = 0; i < fields[0].length; i++) {
            for(int j = 0; j < fields.length; j++) {
                fields[j][i] =  new Cell(false);
            }
        }
    }

    public void run() throws InterruptedException {
        while(true) {
            //draw();
            update();
            gen += 1;
            Thread.sleep(100);
        }
    }

    public void update() {
        for(int i = 0; i < fields[0].length; i++) {
            for(int j = 0; j < fields.length; j++) {
                countAliveNeighbourCells(j, i);
                fields[j][i].checkNextCellStatus();
            }
        }
        for(int i = 0; i < fields[0].length; i++) {
            for(int j = 0; j < fields.length; j++) {
                fields[j][i].update();
            }
        }
    }

    private void countAliveNeighbourCells(int jPos, int iPos) {
        int counter = 0;
        for(int i = iPos - 1; i < iPos + 2; i++) {
            for(int j = jPos - 1; j < jPos + 2; j++) {
                if(j == jPos && i == iPos) {
                    continue;
                }
                if((j >= 0 && j < fields.length) && (i >= 0 && i < fields[0].length)) {
                    if(fields[j][i].isAlive()) {
                        counter++;
                    }
                }
            }
        }
        fields[jPos][iPos].setNeighbours(counter);
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
