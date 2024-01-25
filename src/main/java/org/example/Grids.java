package org.example;

public class Grids {
    public static int[][] applyRules(int[][] grid) {
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
    public static int countLivingNeighbors(int grid[][], int row, int col) {
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
}