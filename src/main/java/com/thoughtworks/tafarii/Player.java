package com.thoughtworks.tafarii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Player {

    private final BufferedReader bufferedReader;
    private final PrintStream printStream;
    private final Board board;
    private String symbol;

    public Player(BufferedReader bufferedReader, PrintStream printStream, Board board, String symbol) {

        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
        this.board = board;
        this.symbol = symbol;
    }

    public void makeMove() {
        printStream.println("Please enter a number between 1 and 9 indicating the location where you would to place your mark");

        String location = "";
        try {
            location = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Boolean isTaken = board.isTaken(location);
        board.placeMark(symbol, location);
        board.drawBoard();
    }
}
