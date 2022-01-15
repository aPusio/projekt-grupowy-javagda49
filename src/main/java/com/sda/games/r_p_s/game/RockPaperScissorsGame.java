package com.sda.games.r_p_s.game;

import com.sda.games.r_p_s.game.menu.ChristmasTree;

import java.util.Scanner;


public class RockPaperScissorsGame {

    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS = 3;

    private static final int RUDOLF = 1;
    private static final int SANTA = 2;
    private static final int TIE = 3;

    public static int winner = 0;

    private static int wins = 0;
    private static int defeats= 0;
    private static int ties = 0;


    public static void start() {

        ChristmasTree christmasTree = new ChristmasTree('*',39);

        String znowu = "t";
        Scanner skan = new Scanner(System.in);

        do {
            System.out.println();
            System.out.print("Santa ");
            System.out.print("choose:\n\t\t1 = Rock\n\t\t2 = Paper\n\t\t3 = Scissors\n\t\t");

            int santa = skan.nextInt();

            System.out.print("Your choice: ");
            System.out.println();

            switch (santa) {
                case ROCK:
                    System.out.println("*******");
                    break;
                case PAPER:
                    System.out.println("*******");
                    break;
                case SCISSORS:
                    System.out.println("*******");
                    break;
            }
            System.out.println();

            System.out.print("Rudolf ");
            System.out.print("make your choice:\n\t\t1 = Rock\n\t\t2 = Paper\n\t\t3 = Scissors\n\t\t");
            System.out.println();
            int rudolf = skan.nextInt();
            switch (rudolf) {
                case ROCK:
                    System.out.println("*******");
                    if (santa == SCISSORS) {
                        winner = RUDOLF;
                    } else if (santa == PAPER) {
                        winner = SANTA;
                    } else {
                        winner = TIE;
                    }
                    break;
                case PAPER:
                    System.out.println("*******");
                    if (santa == ROCK) {
                        winner = RUDOLF;
                    } else if (santa == SCISSORS) {
                        winner = SANTA;
                    } else {
                        winner = TIE;
                    }
                    break;
                case SCISSORS:
                    System.out.println("*******");
                    if (santa == PAPER) {
                        winner = RUDOLF;
                    } else if (santa == ROCK) {
                        winner = SANTA;
                    } else {
                        winner = TIE;
                    }
            }
            if (winner == RUDOLF) {
                System.out.println();
                System.out.println("RUDOLF --> won!");
                defeats++;

            } else if (winner == SANTA) {
                System.out.println();
                System.out.println("SANTA --> won!");
                wins++;

            } else {
                System.out.println();
                System.out.println("RUDOLF & SANTA = TIE!");
                ties++;

            }
            System.out.println();
            System.out.print("U want play more Muthafucka? (post 'Y' - U R awesome! or  'n' - Fck U n00b! )?");
            znowu = skan.nextLine();
            znowu = skan.nextLine();
        } while (znowu.equalsIgnoreCase("Y"));

        System.out.println();
        System.out.println("Santa u won " + wins + " once.");
        System.out.println("Santa u defeat " + defeats + " once.");
        System.out.println("The game is tie " + ties + " once.");
        System.out.println();

        System.out.println("Rudolfie czerwononosy wygrałeś " + defeats + " raz.");
        System.out.println("Rudolfie czerwononosy przegrałeś " + wins + " raz.");
        System.out.println("Rudolfie czerwononosy zremisowałeś " + ties + " raz.");
    }

    public void con() {

    }

    public void exit() {

    }

}










