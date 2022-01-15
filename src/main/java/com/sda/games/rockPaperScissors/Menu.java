package com.sda.games.rockPaperScissors;



import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);


    public static void printGameLogo(){
        System.out.println(" _____     ___     ___                 _____      ___      _____    ______    _____");
        System.out.println("|     \\   //   \\ //   \\  |    //      |     \\   //    \\   |     \\   |        |     \\");
        System.out.println("|     // |     | |       |   //       |     //  |      |  |     //  |        |     //");
        System.out.println("|----//  |     | |       | //         |------   |------|  |-----    |----    |----//");
        System.out.println("|    \\    \\   // \\   //  |  \\         |         |      |  |         |        |    \\");
        System.out.println("|     \\    ___     ___   |    \\ ,,    |         |      |  |         |______  |     \\ ,,");
        System.out.println();
    }


    public static  void printMenuOptions(){
        System.out.println("------ Choose one of the options -------");
        System.out.println("------        1. NEW GAME         ------");
        System.out.println("------        2. CONTINUE         ------");
        System.out.println("------        3. EXIT             ------");
    }

    public static int optionsOfInput() {
        Pattern pattern = Pattern.compile("[1-3]");
        String input;
        while (true) {
            input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            Boolean isInputValid = matcher.matches();
            if (isInputValid) {
                break;
            } else {
                System.out.println("Wrong variable!!!");
            }
        }
        switch (Integer.parseInt(input)) {
            case 1:
                System.out.println("NEW GAME");
                return 1;
            case 2:
                System.out.println("CONTINUE");
                return 2;
            case 3:
                System.out.println("EXIT");
                return 3;

        }
        return 0;
    }
    public static int printMenu() {
        printGameLogo();
        printMenuOptions();
        return optionsOfInput();
    }



}
