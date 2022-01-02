package com.sda.games.checkers.model;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Game.run();
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Enter White Player name:");
//        String whitePlayerName = scanner.nextLine();
//        System.out.println("Enter Black Player name:");
//        String blackPlayerName = scanner.nextLine();
//        Player whitePlayer = new Player(1, whitePlayerName, true);
//        Player blackPlayer = new Player(2, blackPlayerName, false);

        Board board = new Board();
        board.resetBoard();
        board.printBoard(board);

    }
}
