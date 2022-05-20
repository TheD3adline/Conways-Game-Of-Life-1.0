public class Cell {

    private boolean alive;
    private boolean aliveNextRound;
    private boolean aliveLastRound;
    private int neighbours;

    public Cell(boolean alive) {
        this.alive = alive;
    }

    public void checkNextCellStatus() {
        aliveLastRound = alive;
        if(!alive) {
            if(neighbours == 3) {
                aliveNextRound = true;
            }
        } else {
            if(neighbours < 2) {
                aliveNextRound = false;
            } else if(neighbours == 2 || neighbours == 3) {
                aliveNextRound = true;
            } else if(neighbours > 3) {
                aliveNextRound = false;
            }
        }
    }

    public void update() {
        alive = aliveNextRound;
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
