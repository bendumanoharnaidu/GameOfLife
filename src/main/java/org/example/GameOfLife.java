package org.example;
import java.lang.*;
import java.util.Scanner;

import static org.example.Grids.applyRules;

public class GameOfLife {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int rows = sc.nextInt();

        System.out.println("Enter the number of columns: ");
        int cols = sc.nextInt();

        System.out.println("Enter seeding percentage: ");
        int seedingpercentage = sc.nextInt();

        int[][] grid = GetRandomGrid(rows, cols, seedingpercentage);

        while(true) {
            printGrid(grid);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            grid = applyRules(grid);
            if (CheckIfallCellsAreDead(grid)) {
                System.out.println("All cells are dead");
                break;
            }
            System.out.println("Press Enter to stop");
            //if we press enter then the game stops
        }

    }


    private static int[][] GetRandomGrid(int rows, int cols, int seedingpercentage) {
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //give random values to the grid with respective to seeding percentage
                if (Math.random() * 100 < seedingpercentage) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = 0;
                }
            }
        }
        return grid;
    }
    //checking if all cells are dead
    private static boolean CheckIfallCellsAreDead(int[][] grid) {
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
    //printing the grid
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




//public Grid(int rows, int cols) {
//    grid = new String[rows][cols];
//}
//public String get(int row, int col) {
//    return grid[row][col];
//}
//public void set(int row, int col, String value) {
//    grid[row][col] = value;
//}
//public int getRows() {
//    return grid.length;
//}
//public int getCols() {
//    return grid[0].length;
//}
//public String toString() {
//    java.lang.String result = "";
//    for (int i=0; i<getRows(); i++) {
//        for (int j=0; j<getCols(); j++) {
//            result += grid[i][j];
//        }
//        result = result + "\n";
//    }
//    return result;
//}
