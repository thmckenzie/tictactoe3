package com.thoughtworks.tafarii;

import java.io.PrintStream;
import java.util.ArrayList;

public class Board {
    private PrintStream printStream;
    private ArrayList<String> board;

    public Board(PrintStream printStream, ArrayList<String> boardContents) {
        this.printStream = printStream;
        this.board = boardContents;
    }

    public void drawBoard() {
        String print = board.get(0) + board.get(1) + board.get(2) + board.get(3) + board.get(4) + board.get(5) + board.get(6) + board.get(7) + board.get(8)
                + board.get(9) + board.get(10) + board.get(11) + board.get(12) + board.get(13) + board.get(14);

        printStream.print(print);
    }

    public void placeMark(String symbol, String location) {
        for (int i = 0; i < board.size(); i++) {
            if (board.get(i).equals(location)) {
                board.set(i, symbol);
            }
            if(board.get(i).equals(location + "\n")){
                board.set(i, symbol+"\n");
            }
        }
    }

    public boolean isTaken(String location) {
        Boolean isTaken;

        if(board.contains(location) || board.contains(location + "\n")){
            isTaken = false;
        }else{
            printStream.println("Location " + location + " is already taken");
            isTaken = true;
        }
        return isTaken;
    }

    public boolean isFull() {
        boolean isFull = true;
        for(int i =1; i < 10; i++){
            if(board.contains(i) || board.contains(i + "\n")){
                isFull = false;
            }
        }
        return isFull;
    }
}
