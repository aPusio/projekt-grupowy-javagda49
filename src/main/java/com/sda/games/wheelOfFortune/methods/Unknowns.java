package com.sda.games.wheelOfFortune.methods;

import java.util.Locale;

public class Unknowns {
    static String[] phraseUnknown = prepareUnknown();

    public static String[] prepareUnknown() {
        String[] phraseUnknown = new String[Knowns.phraseLength];
        for (int i = 0; i < Knowns.phraseLength; i++) {
            if (Knowns.phraseKnown[i].equals(" ")) {
                phraseUnknown[i] = " ";
                WheelGame.emptySlots--;
            } else {
                phraseUnknown[i] = "_";
            }
        }
        return phraseUnknown;
    }

    public static void modifyUnknown(String letter) {
        for (int i = 0; i < Knowns.phraseLength; i++) {
            if (Knowns.phraseKnown[i].toUpperCase(Locale.ROOT).equals(letter)) {
                phraseUnknown[i] = letter;
                WheelGame.emptySlots--;
                WheelGame.score = WheelGame.score + WheelGame.basicPointValue;
            }
        }
        showMeUnknown();
        System.out.println("score = " + WheelGame.score + " do zgadnięcia " + WheelGame.emptySlots);
    }

    public static void showMeUnknownAndAsk() {
        System.out.println("Zgadnij hasło, Category: " + WheelGame.categoryDao.getById(WheelGame.drawnNumberCategory).getName() + " emptyslots " + WheelGame.emptySlots);
        showMeUnknown();
    }

    public static void showMeUnknown() {
        for (String i : phraseUnknown
        ) {
            System.out.print(i);
        }
        System.out.println();
    }

    static boolean isLetterInUnknown(String letter) {
        boolean unknownLetter = true;
        boolean duplicateLetter = false;
        int i = 0;
        while (i < Knowns.phraseLength) {
            if (phraseUnknown[i].equals(letter)) {
                System.out.println("Litera już wcześniej została dodana do wyrażenia. Punktów: " + WheelGame.score);
                showMeUnknown();
                unknownLetter = false;
                duplicateLetter = true;
            }
            i++;
        }

        if (!duplicateLetter) {
            System.out.println("Trafiony!");
        }
        return unknownLetter; //boolean
    }

}
