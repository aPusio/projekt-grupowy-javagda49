package com.sda.games.checkers.model;

import java.util.List;

public class Game {
    private Player[] players;
    private Board board;
    private Player currentTurn;
    private GameStatus status;
    private List<Move> movesPlayed;

    public static void run() {
        Menu.printLogo();
        Menu.printOptions();
        Menu.optionInput();
    }
}
