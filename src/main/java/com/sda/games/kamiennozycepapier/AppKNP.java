package com.sda.games.kamiennozycepapier;

import java.util.Scanner;

public class AppKNP {

    public static void main(String[] args) {

        printChristmasTree('*', 39);


        final int KAMIEN = 1;
        final int PAPIER = 2;
        final int NOZYCE = 3;

        final int RUDOLF = 1;
        final int MIKOLAJ = 2;
        final int REMIS = 3;

        int Rudolf, zwyciezca = 0;

        int wygrane = 0, przegrane = 0, remisy = 0;


        String znowu = "t";
        Scanner skan = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("=========================================");
            System.out.println("====== Świąteczne wydanie gry : =========");
            System.out.println("****** Papier, Kamień, Nożyce ******* ");
            System.out.println("=========================================");
            System.out.println();
            System.out.print("Mikołaju: ");
            System.out.print("Wskaż swój wybór:\n\t\t1 = Kamień\n\t\t2 = Papier\n\t\t3 = Nożyczki\n\t\t");
            int Mikołaj = skan.nextInt();
            System.out.print("Twój wybór: ");
            System.out.println();
            switch (Mikołaj) {
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
            Rudolf = skan.nextInt();
            switch (Rudolf) {
                case KAMIEN:
                    System.out.println("Kamień.");
                    if (Mikołaj == NOZYCE) {
                        zwyciezca = RUDOLF;
                    } else if (Mikołaj == PAPIER) {
                        zwyciezca = MIKOLAJ;
                    } else {
                        zwyciezca = REMIS;
                    }
                    break;
                case PAPIER:
                    System.out.println("Papier.");
                    if (Mikołaj == KAMIEN) {
                        zwyciezca = RUDOLF;
                    } else if (Mikołaj == NOZYCE) {
                        zwyciezca = MIKOLAJ;
                    } else {
                        zwyciezca = REMIS;
                    }
                    break;
                case NOZYCE:
                    System.out.println("Nożyczki.");
                    if (Mikołaj == PAPIER) {
                        zwyciezca = RUDOLF;
                    } else if (Mikołaj == KAMIEN) {
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

    public static void printChristmasTree(final char sign, int numberOfSignsAtTheBoottom) {

        int numberOfSignsAtTheTop = numberOfSignsAtTheBoottom % 2 == 0 ? 2 : 1;

        int height = 0;
        for (int i = numberOfSignsAtTheBoottom; i > 0; i = i - 2) {
            height++;
        }

        int numberOfSingsInARow = numberOfSignsAtTheTop;
        for (int row = 0; row < height; row++) {
            int numberOfSpace = (numberOfSignsAtTheBoottom - numberOfSingsInARow) / 2;

            for (int column = 0;
                 column < numberOfSignsAtTheBoottom - numberOfSpace;
                 column++
            ) {
                System.out.print(column < numberOfSpace ? " " : sign);
            }
            numberOfSingsInARow = numberOfSingsInARow + 2;
            System.out.println();
        }
    }
}

