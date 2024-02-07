package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {
    @Test
    public void TestAliveCellWithOneNeighborDies() {
        Cell cell = new Cell(CellStatus.ALIVE);
        cell.evolve(1);

        assertFalse(cell.isAlive());
    }
    @Test
    public void TestAliveCellWithTwoNeighborsLives() {
        Cell cell = new Cell(CellStatus.ALIVE);
        cell.evolve(2);

        assertTrue(cell.isAlive());
    }
    @Test
    public void TestDeadCellWithThreeNeighborsLives() {
        Cell cell = new Cell(CellStatus.DEAD);
        cell.evolve(3);

        assertTrue(cell.isAlive());
    }
    @Test
    public void TestDeadCellWithTwoNeighborsStaysDead() {
        Cell cell = new Cell(CellStatus.DEAD);
        cell.evolve(2);
        
        assertFalse(cell.isAlive());
    }

    @Test
    public void TestCountLivingNeighbors() {
        Cell[][] cells = new Cell[3][3];
        cells[0][0] = new Cell(CellStatus.ALIVE);
        cells[0][1] = new Cell(CellStatus.ALIVE);
        cells[0][2] = new Cell(CellStatus.ALIVE);
        cells[1][0] = new Cell(CellStatus.ALIVE);
        cells[1][1] = new Cell(CellStatus.ALIVE);
        cells[1][2] = new Cell(CellStatus.ALIVE);
        cells[2][0] = new Cell(CellStatus.ALIVE);
        cells[2][1] = new Cell(CellStatus.ALIVE);
        cells[2][2] = new Cell(CellStatus.ALIVE);
        int expected = 8;
        int actual = cells[1][1].countLiveNeighbors(1,1, cells);
        assertEquals(expected, actual);
    }

}