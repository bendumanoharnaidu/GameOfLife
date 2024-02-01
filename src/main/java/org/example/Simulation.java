package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

//import static org.example.Grids.applyRules;

public class Simulation {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows = sc.nextInt();

        System.out.println("Enter the number of columns: ");
        int cols = sc.nextInt();

        System.out.println("Enter seeding percentage: ");
        int seedingpercentage = sc.nextInt();

        Board board = new Board(rows, cols, seedingpercentage);
        board.generateBoard();
        int generation = 0;

        while (board.getCountOfAliveCells() > 0) {
            board.DisplayBoard();
            Thread.sleep(1000);
            System.out.println("Generation Number:" + generation++);
            board.nextGeneration();
        }
    }
}
