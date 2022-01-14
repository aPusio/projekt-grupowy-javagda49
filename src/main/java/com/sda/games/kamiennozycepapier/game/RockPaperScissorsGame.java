package com.sda.games.kamiennozycepapier.game;

import com.sda.games.kamiennozycepapier.game.manu.ChristmasTree;

import java.util.Scanner;


public class RockPaperScissorsGame {

    private static final int KAMIEN = 1;
    private static final int PAPIER = 2;
    private static final int NOZYCE = 3;

    private static final int RUDOLF = 1;
    private static final int MIKOLAJ = 2;
    private static final int REMIS = 3;

    public static int zwyciezca = 0;

    private static int wygrane = 0;
    private static int przegrane = 0;
    private static int remisy = 0;


    public static void start() {

        ChristmasTree christmasTree = new ChristmasTree('*',39);

        String znowu = "t";
        Scanner skan = new Scanner(System.in);

        do {
            System.out.println();
            System.out.print("Mikołaju: ");
            System.out.print("Wskaż swój wybór:\n\t\t1 = Kamień\n\t\t2 = Papier\n\t\t3 = Nożyczki\n\t\t");

            int mikołaj = skan.nextInt();

            System.out.print("Twój wybór: ");
            System.out.println();

            switch (mikołaj) {
                case KAMIEN:
                    System.out.println("Kamień.");
                    break;
                case PAPIER:
                    System.out.println("Papier.");
                    break;
                case NOZYCE:
                    System.out.println("Nożyczki.");
                    break;
            }
            System.out.println();

            System.out.print("Rudolfie czerwononosy: ");
            System.out.print("Wskaż swój wybór:\n\t\t1 = Kamien\n\t\t2 = Papier\n\t\t3 = Nozyczki\n\t\t");
            System.out.println();
            int rudolf = skan.nextInt();
            switch (rudolf) {
                case KAMIEN:
                    System.out.println("Kamień.");
                    if (mikołaj == NOZYCE) {
                        zwyciezca = RUDOLF;
                    } else if (mikołaj == PAPIER) {
                        zwyciezca = MIKOLAJ;
                    } else {
                        zwyciezca = REMIS;
                    }
                    break;
                case PAPIER:
                    System.out.println("Papier.");
                    if (mikołaj == KAMIEN) {
                        zwyciezca = RUDOLF;
                    } else if (mikołaj == NOZYCE) {
                        zwyciezca = MIKOLAJ;
                    } else {
                        zwyciezca = REMIS;
                    }
                    break;
                case NOZYCE:
                    System.out.println("Nożyczki.");
                    if (mikołaj == PAPIER) {
                        zwyciezca = RUDOLF;
                    } else if (mikołaj == KAMIEN) {
                        zwyciezca = MIKOLAJ;
                    } else {
                        zwyciezca = REMIS;
                    }
            }
            if (zwyciezca == RUDOLF) {
                System.out.println();
                System.out.println("RUDOLF --> wygrał!");
                przegrane++;

            } else if (zwyciezca == MIKOLAJ) {
                System.out.println();
                System.out.println("MIKOLAJ --> wygrał!");
                wygrane++;

            } else {
                System.out.println();
                System.out.println("RUDOLF i MIKOLAJ = Remis!");
                remisy++;

            }
            System.out.println();
            System.out.print("Grasz dalej (wprowadź 't' - jesteś kozak! lub  'n' - zwykła z Ciebie parówa! )?");
            znowu = skan.nextLine();
            znowu = skan.nextLine();
        } while (znowu.equalsIgnoreCase("T"));

        System.out.println();
        System.out.println("Mikołaju wygrałeś " + wygrane + " raz.");
        System.out.println("Mikołaju przegrałeś " + przegrane + " raz.");
        System.out.println("Mikołaju zremisowałeś " + remisy + " raz.");
        System.out.println();

        System.out.println("Rudolfie czerwononosy wygrałeś " + przegrane + " raz.");
        System.out.println("Rudolfie czerwononosy przegrałeś " + wygrane + " raz.");
        System.out.println("Rudolfie czerwononosy zremisowałeś" + remisy + " raz.");
    }

    public void con() {

    }

    public void exit() {

    }

}










