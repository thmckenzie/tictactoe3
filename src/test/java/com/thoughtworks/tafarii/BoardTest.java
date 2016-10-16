package com.thoughtworks.tafarii;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BoardTest {

    private PrintStream printStream;
    private Board board;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        ArrayList<String> boardContents = new ArrayList<String>();
        boardContents.add("1");
        boardContents.add("|");
        boardContents.add("2");
        boardContents.add("|");
        boardContents.add("3\n");
        boardContents.add("4");
        boardContents.add("|");
        boardContents.add("X");
        boardContents.add("|");
        boardContents.add("6\n");
        boardContents.add("7");
        boardContents.add("|");
        boardContents.add("8");
        boardContents.add("|");
        boardContents.add("9\n");

        board = new Board(printStream, boardContents);

    }

    @Test
    public void shouldPrintBoardWithNumbers1through9WhenDrawingBoard() throws Exception {
        //action
        board.drawBoard();

        //assert
        verify(printStream).print(  "1|2|3\n" +
                                    "4|X|6\n" +
                                    "7|8|9\n");
    }

    @Test
    public void shouldDrawBoardWithXInCorrectLocationWhenPlacingMark() throws Exception {
        //arrange
        board.placeMark("X", "1");

        //action
        board.drawBoard();

        //assert
        verify(printStream).print(  "X|2|3\n" +
                                    "4|X|6\n" +
                                    "7|8|9\n");

    }

    @Test
    public void whenLocationIsTakenShouldReturnFalse() throws Exception {
        //arrange: hardcoded 5 to be taken

        //action
        board.isTaken("5");

        //assert
        assertTrue(board.isTaken("5"));
    }

    @Test
    public void shouldPrintLocationTakenMessageWhenLocationIsTaken() throws Exception {
        //action
        board.isTaken("5");

        //assert
        verify(printStream).println("Location 5 is already taken");
    }

    @Test
    public void shouldReturnTrueWhenBoardIsFull() throws Exception {
        //arrange
        ArrayList<String> fullBoardContents = new ArrayList<String>();
        fullBoardContents.add("X");
        fullBoardContents.add("|");
        fullBoardContents.add("X");
        fullBoardContents.add("|");
        fullBoardContents.add("X\n");
        fullBoardContents.add("X");
        fullBoardContents.add("|");
        fullBoardContents.add("X");
        fullBoardContents.add("|");
        fullBoardContents.add("X\n");
        fullBoardContents.add("X");
        fullBoardContents.add("|");
        fullBoardContents.add("X");
        fullBoardContents.add("|");
        fullBoardContents.add("X\n");

        Board fullBoard = new Board(printStream, fullBoardContents);

        //assert
        Assert.assertTrue(fullBoard.isFull());
    }

}