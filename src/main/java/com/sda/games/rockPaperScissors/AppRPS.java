package com.sda.games.rockPaperScissors;

import java.util.Scanner;

import static com.sda.games.rockPaperScissors.game.Menu.printMenu;

public class AppRPS {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Player enter your name:");
        String playerName = scanner.nextLine();
        System.out.println("Hello " + playerName + ". Thank you for choosing our game, good luck !!");

        printMenu();


    }

}
