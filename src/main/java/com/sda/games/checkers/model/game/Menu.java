package com.sda.games.checkers.model.game;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);

    public static void printLogo() {
        System.out.println("      _               _");
        System.out.println("     | |             | |");
        System.out.println("  ___| |__   ___  ___| | _____ _ __ ___");
        System.out.println(" / __| '_ \\ / _ \\/ __| |/ / _ \\ '__/ __|");
        System.out.println("| (__| | | |  __/ (__|   <  __/ |  \\__ \\");
        System.out.println(" \\___|_| |_|\\___|\\___|_|\\_\\___|_|  |___/");
        System.out.println();
    }

    public static void printOptions() {
        System.out.println("1. New Game");
        System.out.println("2. Continue");
        System.out.println("3. Exit");
    }

    public static int optionInput() {
        Pattern pattern = Pattern.compile("[1-3]");
        String input;
        while (true) {
            input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            Boolean isInputValid = matcher.matches();
            if (isInputValid) {
                break;
            } else {
                System.out.println("Invalid input!");
            }
        }
        switch (Integer.parseInt(input)) {
            case 1:
                System.out.println("New game");
                return 1;
            case 2:
                System.out.println("Continue");
                return 2;
            case 3:
                System.out.println("Exit");
                return 3;
        }
        return 0;
    }

    public static int printMenu() {
        printLogo();
        printOptions();
        return (optionInput());
    }

    public static Game mainMenu() throws Exception {
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
            case 2:
                game.getBoard().printBoard();
                while (game.isActive()) {
                    game.makeMove();
                }
                System.out.println(game.getCurrentPlayer().getName() + " has won the game!");
                break;
            case 3:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + menuOption);
        }
        return game;
    }
}
