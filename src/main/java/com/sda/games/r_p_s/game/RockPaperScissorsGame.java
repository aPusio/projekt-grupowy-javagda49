package com.sda.games.r_p_s.game;

import com.sda.games.r_p_s.database.dao.PlayerDao;
import com.sda.games.r_p_s.database.model.PlayerRPS;
import com.sda.games.r_p_s.game.menu.ChristmasTree;
import com.sda.utils.HibernateFactory;

import java.util.Optional;
import java.util.Scanner;

import static com.sda.games.r_p_s.game.Rps.*;


public class RockPaperScissorsGame {




    private static final int RUDOLF = 1;
    private static final int SANTA = 2;
    private static final int DRAW = 3;

    public static int winner = 0;

    private static int wins = 0;
    private static int defeats= 0;
    private static int ties = 0;


    public static void start() {

        HibernateFactory hibernateFactory = new HibernateFactory();
        PlayerDao playerDao = new PlayerDao(hibernateFactory);

        PlayerRPS playerRPS1 = new PlayerRPS(1,"Sebix");
        playerRPS1.setName("SebiX");
        PlayerRPS.add(playerRPS1);

        PlayerRPS playerRPS2 = new PlayerRPS(1,"Dorszyk");
        playerRPS1.setName("Dorszyk");
        PlayerRPS.add(playerRPS1);






        ChristmasTree christmasTree = new ChristmasTree('#',19);

        String znowu = "t";
        Scanner skan = new Scanner(System.in);

        do {
            System.out.println();
            System.out.print("Santa ");
            System.out.print("choice:\n\t\t1 = Rock\n\t\t2 = Paper\n\t\t3 = Scissors\n\t\t");

            int santa = skan.nextInt();
            Optional<Rps> byId = Rps.getById(santa);
            Rps rps = byId.get();

            System.out.print("Santa choice: ");
            System.out.println();

            switch (rps) {
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


            System.out.print("Rudolf!!!! ");
            System.out.print("make your choice!!!!:\n\t\t1 = Rock\n\t\t2 = Paper\n\t\t3 = Scissors\n\t\t");
            System.out.println();

            int rudolf = skan.nextInt();
            Optional<Rps> byId2 = Rps.getById2(rudolf);
            Rps rps2 = byId2.get();

            switch (rps2) {
                case ROCK:
                    System.out.println("*******");
                    if (rps == SCISSORS ) {
                        winner = RUDOLF;
                    } else if (rps == PAPER ) {
                        winner = SANTA;
                    } else {
                        winner = DRAW;
                    }
                    break;
                case PAPER:
                    System.out.println("*******");
                    if (rps == ROCK) {
                        winner = RUDOLF;
                    } else if (rps == SCISSORS) {
                        winner = SANTA;
                    } else {
                        winner = DRAW;
                    }
                    break;
                case SCISSORS:
                    System.out.println("*******");
                    if (rps == PAPER) {
                        winner = RUDOLF;
                    } else if (rps == PAPER) {
                        winner = SANTA;
                    } else {
                        winner = DRAW;
                    }
            }
            if (winner == RUDOLF) {
                System.out.println();
                System.out.println("Santa choose " + santa + ", " + "Rudolf choose " + rudolf);
                System.out.println();
                System.out.println("RUDOLF --> you win!");
                defeats++;

            } else if (winner == SANTA) {
                System.out.println();
                System.out.println("Santa choose " + santa + ", " + "Rudolf choose " + rudolf);
                System.out.println("SANTA --> you win!");
                wins++;

            } else {
                System.out.println();
                System.out.println("RUDOLF & SANTA = DRAW!");
                ties++;

            }
            System.out.println();



            System.out.print("Want to play more? (post 'Y' - U R awesome! or  'n' - nope means nope )?");
            znowu = skan.nextLine();
            znowu = skan.nextLine();
        } while (znowu.equalsIgnoreCase("Y"));

        System.out.println();
        System.out.println("Santa won " + wins + " times.");
        System.out.println("Santa was defeated " + defeats + " times.");
        System.out.println("Draw " + ties + " times.");
        System.out.println();

        System.out.println("Rudolf won " + defeats + " times.");
        System.out.println("Rudolf was defeated " + wins + " times.");
        System.out.println("Draw " + ties + " times.");
    }

    public void con() {

    }

    public void exit() {

    }

}










