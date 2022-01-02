package com.sda.games.checkers.model;

import java.util.List;
import java.util.Scanner;

public class Game {
    static String whitePlayerName;
    static String blackPlayerName;

    private Player[] players;
    private Board board;
    private Player currentTurn;
    private GameStatus status;
    private List<Move> movesPlayed;

    public Game(Player[] players) {
        this.players = players;
    }

    public void initialize(Player player1, Player player2) {
        players[0] = player1;
        players[1] = player2;

        board.resetBoard();

        if (player1.getWhite()) {
            this.currentTurn = player1;
        } else {
            this.currentTurn = player2;
        }

        movesPlayed.clear();
    }

    public boolean isEnd()
    {
        return this.getStatus() != GameStatus.ACTIVE;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public static void run() {
        int option = Menu.printMenu();
//        switch (option) {
//            case 1:
//
//                Scanner scanner = new Scanner(System.in);
//
//                System.out.println("Enter White Player name:");
//                whitePlayerName = scanner.nextLine();
//                System.out.println("Enter Black Player name:");
//                blackPlayerName = scanner.nextLine();
//
//                Player whitePlayer = new Player(1, whitePlayerName, true);
//                Player blackPlayer = new Player(2, blackPlayerName, false);
//
//                Game game = new Game(new Player[]{whitePlayer, blackPlayer});
//
//                game.initialize(whitePlayer, blackPlayer);
////                System.out.println(whitePlayer.getName());
////                System.out.println(blackPlayer.getName());
//        }

    }
}
