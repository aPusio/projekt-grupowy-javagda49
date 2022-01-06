package com.sda.games.checkers.model;

import com.sda.games.checkers.model.game.Game;
import com.sda.games.checkers.model.game.Menu;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        int menuOption = Menu.printMenu();
        Game game = new Game();

        switch (menuOption) {
            case 1:
                    game.newGame();
                while (game.isActive()) {
                    game.makeMove();
                }
                System.out.println(game.getCurrentPlayer().getName() + " has won the game!");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + menuOption);
        }
    }
}
