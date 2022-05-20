public class Cell {

    private boolean alive;
    private boolean aliveNextRound;
    private boolean aliveLastRound;
    private int neighbours;

    public Cell(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAliveNextRound() {
        return aliveNextRound;
    }

    public void setAliveNextRound(boolean aliveNextRound) {
        this.aliveNextRound = aliveNextRound;
    }

    public boolean isAliveLastRound() {
        return aliveLastRound;
    }

    public void setAliveLastRound(boolean aliveLastRound) {
        this.aliveLastRound = aliveLastRound;
    }

    public int getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(int neighbours) {
        this.neighbours = neighbours;
    }
}
