package com.thoughtworks.tafarii;


import java.io.PrintStream;

public class Game {
    private Board board;
    private Player firstPlayer;
    private Player secondPlayer;
    private final PrintStream printStream;

    public Game(Board board, Player firstPlayer, Player secondPlayer, PrintStream printStream) {
        this.board = board;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.printStream = printStream;
    }

    public void start() {
        board.drawBoard();

        takeTurns(firstPlayer, secondPlayer);
    }

    public void takeTurns(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;

        while(true && board.isFull() == false){
            firstPlayer.makeMove();
            secondPlayer.makeMove();
        }

        if(board.isFull() == true){
            printStream.println("Game is a draw");
        }
    }
}
