package org.example;

import java.util.Scanner;

//import static org.example.Grids.applyRules;

public class Simulation {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int rows = sc.nextInt();

        System.out.println("Enter the number of columns: ");
        int cols = sc.nextInt();

        System.out.println("Enter seeding percentage: ");
        int seedingpercentage = sc.nextInt();

        Grids grids = new Grids(rows, cols, seedingpercentage);

        grids.StartGame();

//        Grids grids = new Grids();

//        int[][] grid = grids.GetRandomGrid(rows, cols, seedingpercentage);

//        while(true) {
//            printGrid(grid);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            grid = grids.applyRules(grid);
//
//            if (grids.CheckIfallCellsAreDead(grid)) {
//                System.out.println("All cells are dead");
//                break;
//            }
//        }

    }
    //printing the grid
//    private static void printGrid(int[][] grid) {
//        System.out.println("Printing the grid");
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 1) {
//                    System.out.print("*"+ " ");
//                } else {
//                    System.out.print("-"+ " ");
//                }
//            }
//            System.out.println("");
//        }
//        System.out.println();
//    }

}
