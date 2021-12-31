package com.sda.games.checkers.model;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        int menuOption = Menu.printMenu();
        Game game = new Game();

        switch (menuOption) {
            case 1:
                    game.newGame();
                while (game.getStatus() != GameStatus.ACTIVE) {
                    game.makeMove();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + menuOption);
        }
    }
}
