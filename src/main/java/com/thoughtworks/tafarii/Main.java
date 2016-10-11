package com.thoughtworks.tafarii;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream printStream = new PrintStream(System.out);
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


        Board board = new Board(printStream, boardContents);

        Player firstPlayer = new Player(bufferedReader, printStream, board, "X");
        Player secondPlayer = new Player(bufferedReader, printStream, board, "O");

        Game game = new Game(board, firstPlayer, secondPlayer);

        game.start();
    }
}
