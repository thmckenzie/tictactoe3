package com.thoughtworks.tafarii;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class GameTest {

    private Board board;
    private Game game;
    private Player firstPlayer;
    private Player secondPlayer;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        firstPlayer = mock(Player.class);
        secondPlayer = mock(Player.class);
        printStream = mock(PrintStream.class);

        game = new Game(board, firstPlayer, secondPlayer, printStream);

    }

    @Test
    public void shouldDrawEmptyBoardWhenStarting() throws Exception {
        //arrange
        when(board.isFull()).thenReturn(true);

        //action
        game.start();

        //assert
        verify(board).drawBoard();
    }

    @Test
    public void firstPlayerShouldMakeMoveWhenStarting() throws Exception {
        //arrange
        when(board.isFull()).thenReturn(true);

        //action
        game.start();

        //assert
        verify(firstPlayer).makeMove();
    }

    @Test
    public void secondPlayerShouldMakeMoveAfterFirstPlayerMakesMoveWhenStarting() throws Exception {
        //arrange
        when(board.isFull()).thenReturn(true);

        //action
        game.start();

        //assert
        verify(secondPlayer).makeMove();
    }

    @Test
    public void shouldAlternatePlayersWhenTakingTurns() throws Exception {
        //arrange
        when(board.isFull()).thenReturn(true);

        //action
        game.takeTurns(firstPlayer, secondPlayer);

        //assert
        verify(firstPlayer).makeMove();
        verify(secondPlayer).makeMove();
    }

    @Test
    public void shouldStopPlayersFromTakingTurnsWhenTheBoardIsFull() throws Exception {
        //arrange
        when(board.isFull()).thenReturn(true);

        //action
        game.takeTurns(firstPlayer, secondPlayer);

        //assert
        verify(printStream).println("Game is a draw");
    }
}