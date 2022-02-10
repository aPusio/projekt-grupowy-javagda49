package com.sda.games.wheelOfFortune.methods;

import java.util.Locale;

public class Knowns {

   static String guessMePhrase = WheelGame.idWord(WheelGame.drawnNumberWord);
   final static Integer phraseLength = guessMePhrase.length();

    private static String[] prepareKnown() {
        return guessMePhrase.split("");
    }
    final static String[] phraseKnown = prepareKnown();

    static String[] prepareFullPhase(String fullPhraseAssumed) {
        return fullPhraseAssumed.split("");
    }

    static boolean isLetterInKnown(String letter) {
        int i = 0;
        boolean inKnown = false;
        while (i < phraseLength) {
            if (phraseKnown[i].toUpperCase(Locale.ROOT).equals(letter)) {
                inKnown = true;
            }
            i++;
        }
        if (!inKnown) {
            System.out.println("Brak litery w haśle głównym");
            System.out.println("Category: ");
            System.out.println("score = " + WheelGame.score + " do zgadnięcia " + WheelGame.emptySlots);
            Unknowns.showMeUnknown();
        }
        return inKnown;
    }

}
