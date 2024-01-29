package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
//import  org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//import org.powermock.reflect.internal.WhiteboxImpl;

//import static org.junit.Assert.assertThrows;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest(Grids.class)

public class GridsTest {
    int grid[][];
    @Test(expected = IllegalArgumentException.class)
    public void IfInvalidValuesGiven() {
//        new Grids().GetRandomGrid(0,0,10);
        new Grids(0,0,10).StartGame();
    }
    @Test(expected = IllegalArgumentException.class)
    public void IfInvalidValuesGiven2() {
        new Grids(10,10,-10).StartGame();
    }
    @Test(expected = IllegalArgumentException.class)
    public void IfInvalidValuesGiven3() {
        new Grids(10,10,110).StartGame();
    }
    @Test (expected = IllegalArgumentException.class)
    public void IfInvalidValuesGiven4() {
        new Grids(-10,10,10).StartGame();
    }
    @Test
    public void testRules_CellShouldDie() throws Exception {
        int grid[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int expected[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        assertEquals(expected, new Grids().applyRules(grid));
        Grids temp = new Grids(3,3,0);
//
//        int out [][] = WhiteboxImpl.invokeMethod(temp, "applyRules", grid);
//
//        assertEquals(expected, out);
    }
    @Test
    public void testRules_CellShouldDie1() {
        int grid[][] = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int expected[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
//        Grids.applyRules(grid);
        assertEquals(expected, new Grids().applyRules(grid));
    }
    @Test
    public void testRules_CellShouldDie2() {
        int grid[][] = {{0, 0, 0}, {0, 1, 1}, {0, 0, 0}};
        int expected[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
//        Grids.applyRules(grid);
        assertEquals(expected, new Grids().applyRules(grid));
    }
//    //- *
//    //* *
    @Test
    public void testRules_CellShouldReproduce() {
        int grid[][] = {{0, 1, 0}, {0, 1, 1}, {0, 0, 0}};
        int expected[][] = {{0, 1, 1}, {0, 1, 1}, {0, 0, 0}};

        assertEquals(expected, new Grids().applyRules(grid));
    }
    @Test
    public void testRules_CellShouldNotReproduce2() {
        int grid[][] = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};
        int expected[][] = {{0, 1, 0}, {1, 0, 1}, {0, 1, 0}};

        assertEquals(expected, new Grids().applyRules(grid));
    }
//    //* *
//    //* -
    @Test
    public void testRules_CellShouldReproduce2() {
        int grid[][] = {{0, 0, 0, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        int expected[][] = {{0, 0, 0, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};

        assertEquals(expected, new Grids().applyRules(grid));
    }
//    //* -
//    //- *
    @Test
    public void testRules_CellShouldReproduce3() {
        int grid[][] = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        int expected[][] = {{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};

        assertEquals(expected, new Grids().applyRules(grid));
    }

    @Test
    public void countAllLivingNeighbors() {
        int grid[][] = {{1, 0, 0, 0}, {1, 1, 0, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}};

        assertEquals(3, new Grids().countLivingNeighbors(grid, 2, 0));
    }
    @Test
    public void countAllLivingNeighbors2() {
        int grid[][] = {{1, 0, 0, 0}, {1, 1, 1, 0}, {1, 1, 1, 0}, {1, 1, 0, 1}};

        assertEquals(7, new Grids().countLivingNeighbors(grid, 2, 1));
    }
    @Test
    public void countAllLivingNeighbors3() {
        int grid[][] = {{1, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};

        assertEquals(8, new Grids().countLivingNeighbors(grid, 1, 1));
    }
//    //Check If All Cells Are Dead
    @Test
    public void CheckIfallCellsAreDeadGivesTrue() {
        int grid[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        assertEquals(true, new Grids().CheckIfallCellsAreDead(grid));
    }
    @Test
    public void CheckIfallCellsAreDeadGivesFalse() {
        int grid[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 1}};

        assertEquals(false, new Grids().CheckIfallCellsAreDead(grid));
    }
    @Test
    public void GiveRandomGridWith50PercentSeeding() {
        int[][] grid = new Grids().GetRandomGrid(10,10,0);

        assertEquals(0, CountLivingCells(grid));
    }
    @Test
    public void GiveRandomGridWith50PercentSeeding1() {
        int[][] grid = new Grids().GetRandomGrid(5,5,100);

        assertEquals(25, CountLivingCells(grid));
    }
    @Test
    public void GiveRandomGridWith50PercentSeeding2() {
        int[][] grid = new Grids().GetRandomGrid(5,5,50);

        assertEquals(12, CountLivingCells(grid));
    }
    public int CountLivingCells(int grid[][]) {
        int count = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                count += grid[i][j];
            }
        }
        return count;
    }
//
}
