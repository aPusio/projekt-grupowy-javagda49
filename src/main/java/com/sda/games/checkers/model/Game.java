package com.sda.games.checkers.model;

import java.util.Scanner;

public class Game {

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
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                System.out.println("New game");
                break;
            case 2:
                System.out.println("Continue");
                break;
            case 3:
                System.out.println("Exit");
                break;
        }
        return 0;
    }

    public static void run() {
        printLogo();
        printOptions();
        optionInput();
    }
}
