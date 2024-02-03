package org.example;
public class Cell {
    private CellStatus status;
    public Cell(CellStatus status) {
        this.status = status;
    }
    public CellStatus getStatus() {
        return this.status;
    }
    @Override
    public String toString() {
        return (status== CellStatus.ALIVE ? "X" : ".");
    }
    public int countLiveNeighbors(int row, int col, Cell[][] cells) {
        int count = 0;
        for (int r = row-1; r <= row+1; r++) {
            for (int c = col-1; c <= col+1; c++) {
                if (r>=0 && r<cells.length && c>=0 && c<cells[0].length && !(r==row && c==col) && cells[r][c].status == CellStatus.ALIVE) {
                    count++;
                }
            }
        }
        return count;
    }

    public void evolve(int livingNeighbors) {
        if (status == CellStatus.ALIVE) {
            if (livingNeighbors<2 || livingNeighbors>3) {
                status = CellStatus.DEAD;
            }
        }
        else {
            if (livingNeighbors == 3) {
                status = CellStatus.ALIVE;
            }
        }
    }
}
