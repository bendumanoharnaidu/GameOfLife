package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void TestToCreateBoardWithInValidRows() {
        try {
            Board board = new Board(-1, 3, 50);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input", e.getMessage());
        }
    }
    @Test
    public void TestToCreateBoardWithInValidCols() {
        try {
            Board board = new Board(3, -1, 50);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input", e.getMessage());
        }
    }
    @Test
    public void TestToCreateBoardWithInValidSeedingPercentage() {
        try {
            Board board = new Board(3, 3, -1);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input", e.getMessage());
        }
    }
    @Test
    public void TestToGenerateABoardWhichGivesValidCountOfAliveCells1() {
        Board board = new Board(3,3,100);
        board.generateBoard();
        int expected = 9;
        int actual = board.getCountOfAliveCells();
        assertEquals(expected, actual);
    }
    @Test
    public void TestToGenerateABoardWhichGivesValidCountOfAliveCells2() {
        Board board = new Board(3,3,1);
        board.generateBoard();
        int expected = 0;
        int actual = board.getCountOfAliveCells();
        assertEquals(expected, actual);
    }

    @Test
    public void TestToGenerateBoardWithCorrectSeedingPercentage() {
        Board board = new Board(3,3,50);
        board.generateBoard();
        int expected = 4;
        int actual = board.getCountOfAliveCells();
        assertEquals(expected, actual);
    }

    @Test
    public void TestToGenerateBoardWithCorrectOutputBoard() {
        Board board = new Board(3,3,10);
        board.generateBoard();
        int expected = 0;
        int actual = board.getCountOfAliveCells();
        assertEquals(expected, actual);
    }
    @Test
    public void TestToGenerateBoardWithCorrectOutputBoard2() {
        Board board = new Board(3,3,12);
        board.generateBoard();      //One Alive Cell will be Alive
        board.nextGeneration();     //One Alive Cell will be dead
        int expected = 0;
        int actual = board.getCountOfAliveCells();
        assertEquals(expected, actual);
    }
    @Test
    public void TestToGenerateBoardWithCorrectOutputBoard3() {
        Board board = new Board(3,3,13);
        board.generateBoard();      //Two Alive Cells will be Alive
        board.nextGeneration();     //Two Alive Cells will be dead
        int expected = 0;
        int actual = board.getCountOfAliveCells();
        assertEquals(expected, actual);
    }
    @Test
    public void TestToGenerateBoardWithCorrectOutputBoard4() {
        Board board = new Board(2,2,75);
        board.generateBoard();      //Three Alive Cells will be Alive
        board.nextGeneration();     //One Cell will Evolve to be Alive
        int expected = 4;
        int actual = board.getCountOfAliveCells();
        assertEquals(expected, actual);
    }
}