package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class GridsTest {
    public void printGrid(int[][] grid) {
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    @Test
    public void testRules_CellShouldDie1() {
        int grid[][] = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int expected[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        Grids.applyRules(grid);
        assertEquals(expected, Grids.applyRules(grid));
    }
    @Test
    public void testRules_CellShouldDie2() {
        int grid[][] = {{0, 0, 0}, {0, 1, 1}, {0, 0, 0}};
        int expected[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        Grids.applyRules(grid);
        assertEquals(expected, Grids.applyRules(grid));
    }
    //- *
    //* *
    @Test
    public void testRules_CellShouldReproduce() {
        int grid[][] = {{0, 1, 0}, {0, 1, 1}, {0, 0, 0}};
        int expected[][] = {{0, 1, 1}, {0, 1, 1}, {0, 0, 0}};
        printGrid(grid);
        printGrid(Grids.applyRules(grid));
        System.out.println(expected);
        assertEquals(expected, Grids.applyRules(grid));
    }
    @Test
    public void testRules_CellShouldNotReproduce2() {
        int grid[][] = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};
        int expected[][] = {{0, 1, 0}, {1, 0, 1}, {0, 1, 0}};
        printGrid(grid);
        printGrid(Grids.applyRules(grid));
        System.out.println(expected);
        assertEquals(expected, Grids.applyRules(grid));
    }
    //* *
    //* -
    @Test
    public void testRules_CellShouldReproduce2() {
        int grid[][] = {{0, 0, 0, 0}, {0, 1, 1, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}};
        int expected[][] = {{0, 0, 0, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        printGrid(grid);
        printGrid(Grids.applyRules(grid));
        Grids.applyRules(grid);
        assertEquals(expected, Grids.applyRules(grid));
    }
    //* -
    //- *
    @Test
    public void testRules_CellShouldReproduce3() {
        int grid[][] = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        int expected[][] = {{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        printGrid(grid);
        printGrid(Grids.applyRules(grid));
        Grids.applyRules(grid);
        assertEquals(expected, Grids.applyRules(grid));
    }
}
