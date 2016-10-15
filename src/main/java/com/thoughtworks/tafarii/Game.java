package com.thoughtworks.tafarii;


public class Game {
    private Board board;
    private Player firstPlayer;
    private Player secondPlayer;

    public Game(Board board, Player firstPlayer, Player secondPlayer) {
        this.board = board;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void start() {
        board.drawBoard();

        takeTurns(firstPlayer, secondPlayer);
        //firstPlayer.makeMove();
        //secondPlayer.makeMove();
    }

    public void takeTurns(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;

        while(true){
            firstPlayer.makeMove();
            secondPlayer.makeMove();
        }
    }
}
