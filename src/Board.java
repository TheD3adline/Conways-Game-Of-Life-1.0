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
            //update();
            gen++;
            Thread.sleep(100);
        }
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
