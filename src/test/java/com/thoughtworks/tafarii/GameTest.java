package com.thoughtworks.tafarii;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class GameTest {

    private Board board;
    private Game game;
    private Player firstPlayer;
    private Player secondPlayer;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        firstPlayer = mock(Player.class);
        secondPlayer = mock(Player.class);

        game = new Game(board, firstPlayer, secondPlayer);

    }

    @Test
    public void shouldDrawEmptyBoardWhenStarting() throws Exception {
        //action
        game.start();

        //assert
        verify(board).drawBoard();
    }

    @Test
    public void firstPlayerShouldMakeMoveWhenStarting() throws Exception {
        //action
        game.start();

        //assert
        verify(firstPlayer).makeMove();
    }

    @Test
    public void secondPlayerShouldMakeMoveAfterFirstPlayerMakesMoveWhenStarting() throws Exception {
        //action
        game.start();

        //assert
        verify(secondPlayer).makeMove();
    }

    @Test
    public void shouldAlternatePlayersWhenTakingTurns() throws Exception {
        //action
        game.takeTurns(firstPlayer, secondPlayer);

        //assert
        verify(firstPlayer).makeMove();
        verify(secondPlayer).makeMove();
    }

}