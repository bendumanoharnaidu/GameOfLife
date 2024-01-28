package org.example;

public class Grids {
    private int newgrid[][];
    private int rows;
    private int cols;
    private int seedingpercentage;
    //Parameterized constructor
    public Grids(int rows, int cols, int seedingpercentage) {
        this.rows = rows;
        this.cols = cols;
        this.seedingpercentage = seedingpercentage;
    }

    public Grids() {
    }

    public void StartGame() {
        int newgrid[][] = GetRandomGrid(rows, cols, seedingpercentage);
        while(true) {
            printGrid(newgrid);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            newgrid = applyRules(newgrid);

            if (CheckIfallCellsAreDead(newgrid)) {
                System.out.println("All cells are dead");
                break;
            }
        }
    }
    protected int[][] GetRandomGrid(int rows, int cols, int seedingpercentage) {
        if (rows <= 0 || cols <= 0 || seedingpercentage < 0 || seedingpercentage > 100) {
            throw new IllegalArgumentException("Give a Valid Input");
        }
        int[][] grid = new int[rows][cols];
        int countalive = (rows * cols) * seedingpercentage/100;

        int count = 0;
        while (count<countalive) {
            int i = (int) (Math.random() * rows);
            int j = (int) (Math.random() * cols);
            if (grid[i][j] != 1) {
                grid[i][j] = 1;
                count++;
            }
        }
        return grid;
    }

    protected int[][] applyRules(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] newGrid = new int[rows][cols];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                int livingNeighbors = countLivingNeighbors(grid, i, j);

                if (grid[i][j] == 1) {
                    if (livingNeighbors < 2 || livingNeighbors > 3) {
                        newGrid[i][j] = 0;
                    } else {
                        newGrid[i][j] = 1;
                    }
                } else {
                    if (livingNeighbors == 3) {
                        newGrid[i][j] = 1;
                    }
                }
            }
        }
        return newGrid;
    }
    protected int countLivingNeighbors(int grid[][], int row, int col) {
        int livingNeighbors = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i=row-1; i<=row+1; i++) {
            for (int j=col-1; j<=col+1; j++) {
                if (i>=0 && i<rows && j>=0 && j<cols && !(i==row && j==col)) {
                    livingNeighbors += grid[i][j];
                }
            }
        }
        return livingNeighbors;
    }
    //checking if all cells are dead
    protected boolean CheckIfallCellsAreDead(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i=0; i<rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
    private static void printGrid(int[][] grid) {
        System.out.println("Printing the grid");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    System.out.print("*"+ " ");
                } else {
                    System.out.print("-"+ " ");
                }
            }
            System.out.println("");
        }
        System.out.println();
    }
}