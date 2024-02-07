package org.example;

public class Board {
    private Cell cells[][];
    private int rows;
    private int cols;
    private int seedingpercentage;

    public Board(int rows, int cols, int seedingpercentage) {
        if (rows<=0 || cols<=0 || seedingpercentage<0 || seedingpercentage>100) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.rows = rows;
        this.cols = cols;
        this.seedingpercentage = seedingpercentage;
        this.cells = new Cell[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c=0; c < cols; c++) {
                cells[r][c] = new Cell(CellStatus.DEAD);
            }
        }
    }
    public void generateBoard() {
        int alivecount = (rows*cols*seedingpercentage)/100;
        int count = 0;
        while (count < alivecount) {
            int row = (int) (Math.random() * rows);
            int col = (int) (Math.random() * cols);
            if (!cells[row][col].isAlive()) {
                cells[row][col] = new Cell(CellStatus.ALIVE);
                count++;
            }
        }
    }

    public void nextGeneration() {
        Cell newGeneration[][] = new Cell[rows][cols];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                int aliveNeighbors = cells[i][j].countLiveNeighbors(i, j, cells);
                newGeneration[i][j] = new Cell(cells[i][j].isAlive() ? CellStatus.ALIVE : CellStatus.DEAD);
                newGeneration[i][j].evolve(aliveNeighbors);
            }
        }
        cells = newGeneration;
    }

    public int getCountOfAliveCells() {
        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (cells[r][c].isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }

    public void DisplayBoard() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(cells[r][c]+" ");
            }
            System.out.println();
        }
    }

}
