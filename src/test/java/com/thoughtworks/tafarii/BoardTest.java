package com.thoughtworks.tafarii;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
                                    "4|5|6\n" +
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
                                    "4|5|6\n" +
                                    "7|8|9\n");

    }

    @Test
    public void whenLocationIsTakenShouldReturnFalse() throws Exception {
        //action
        board.isTaken("5");

        //assert
        assertTrue(board.isTaken("5"));
    }
}