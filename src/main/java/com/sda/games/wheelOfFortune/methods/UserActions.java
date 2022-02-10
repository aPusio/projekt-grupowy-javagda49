package com.sda.games.wheelOfFortune.methods;

import java.util.Locale;
import java.util.Scanner;

public class UserActions {
    static String userInputLetter() {
        boolean isCorrect = false;
        Scanner scanner = new Scanner(System.in);
        String letter = null;
        while (!isCorrect) {
            System.out.println("Podaj jedną literę. Jeżeli chcesz zgadnąć całe hasło wpisz @");
            letter = scanner.nextLine().toUpperCase(Locale.ROOT);
            if (Validators.letterValidation(letter)) {
                isCorrect = true;
            } else {
                System.out.println("Wprowadzono niepoprawną wartość. Wprowadź ponownie");

            }
        }
        return letter;
    }

    public static boolean guessFullPhrase() {
        boolean isFullCorrect = true;
        System.out.println("Wprowadź pełne hasło");
        String userInputfullPhrase = WheelGame.scanner.nextLine();
        String[] fullPhaseAssumed = Knowns.prepareFullPhase(userInputfullPhrase);
        for (int i = 0; i < Knowns.phraseLength; i++) {
            if (!Knowns.phraseKnown[i].toUpperCase(Locale.ROOT).equals(fullPhaseAssumed[i].toUpperCase(Locale.ROOT))) {
                isFullCorrect = false;
                System.out.println("Niepoprawne hasło");
                break;
            }
        }

        if (isFullCorrect) {
            //Mutual array copy
            for (int i = 0; i < Knowns.phraseLength; i++) {
                Unknowns.phraseUnknown[i] = Knowns.phraseKnown[i];
            }
            WheelGame.score = WheelGame.score + (WheelGame.emptySlots * WheelGame.basicPointValue) + WheelGame.fullGuessBonus;
            WheelGame.emptySlots = 0;
        }
        return isFullCorrect;
    }
}
