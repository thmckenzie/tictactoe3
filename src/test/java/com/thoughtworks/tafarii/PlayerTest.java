package com.thoughtworks.tafarii;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class PlayerTest {
    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private Board board;
    private Player player;

    @Before
    public void setUp() throws Exception {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        player = new Player(bufferedReader, printStream, board, "X");
    }

    @Test
    public void shouldPromptUserForLocationWhenMakingMove() throws Exception {
        //action
        player.makeMove();

        //assert
        verify(printStream).println("Please enter a number between 1 and 9 indicating the location where you would to place your mark");
    }

    @Test
    public void shouldPassCorrectMarkAndLocationUserIndicatesWhenMakingMoveToPlaceMark() throws Exception {
        //arrange
        when(bufferedReader.readLine()).thenReturn("1");

        //action
        player.makeMove();

        //assert
        verify(board).placeMark("X", "1");
    }

    @Test
    public void shouldRedrawBoardWhenPlayerMakesMove() throws Exception {
        //action
        player.makeMove();

        //assert
        verify(board).drawBoard();
    }

    @Test
    public void shouldDrawOInCorrectLocationWhenSecondPlayerMakesMove() throws Exception {
        //arrange
        Player secondPlayer = new Player(bufferedReader, printStream, board, "O");

        //action
        secondPlayer.makeMove();

        //assert
        verify(board).placeMark(eq("O"), anyString());
    }

    @Test
    public void shouldCheckIfLocationIsTakenWhenPlayerMakesMove() throws Exception {
        //action
        player.makeMove();

        //assert
        verify(board).isTaken(anyString());
    }
}