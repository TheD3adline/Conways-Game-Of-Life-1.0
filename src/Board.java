public class Board {

    private final char charAlive = '#';
    private final char charDead = '.';

    private Cell[][] fields;
    private int gen;



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
