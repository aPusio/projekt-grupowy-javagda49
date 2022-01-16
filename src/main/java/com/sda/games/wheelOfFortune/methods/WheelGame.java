package com.sda.games.wheelOfFortune.methods;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WheelGame {
    static Scanner scanner = new Scanner(System.in);
    final static int basicPointValue = 10;
    final static int fullGuessBonus = 100;
    static int score = 0;
    static int emptySlots;
    static int drawnNumber = 4; //to będzie importowane z metody losującej
    static String guessMePhrase = idWord(drawnNumber);
    final static Integer phraseLength = guessMePhrase.length();
    final static String[] phraseKnown = prepareKnown();
    static String[] phraseUnknown = prepareUnknown();


    public static void startGame() {
        System.out.println("Liter do zgadnięcia: " + emptySlots);
        showMeUnknown();

        while (emptySlots > 0) {
            String letter = WheelGame.userInputLetter();
            System.out.println("Wprowadzono literę " + letter);
            if (isLetterInKnown(letter)) {
                if (!isLetterInUnknown(letter)) {
                    modifyUnknown(letter);
                } else {
                    System.out.println("Litera już została dodana do wyrażenia");
                }
            }
        }
        System.out.println("Gra zakończona: hasło odgadnięte. Liczba punktów: " + score);
    }


    private static String idWord(int nr) {
        //tu będzie pobieranie po podanym ID słowo z bazy
        // String word = "Dupa dupa całka z dupy";
        String word = "Dupa";
        return word;
    }

    private static String[] prepareKnown() {
        return guessMePhrase.split("");
    }

    public static String[] prepareUnknown() {
        String[] phraseUnknown = new String[phraseLength];
        for (int i = 0; i < phraseLength; i++) {
            if (phraseKnown[i].equals(" ")) {
                phraseUnknown[i] = " ";
            } else {
                phraseUnknown[i] = "_";
                emptySlots = emptySlots + 1;
            }
        }
        return phraseUnknown;
    }

    public static void modifyUnknown(String letter) {
        for (int i = 0; i < phraseLength; i++) {
            if (phraseKnown[i].toUpperCase(Locale.ROOT).equals(letter)) {
                phraseUnknown[i] = letter;
                emptySlots = emptySlots - 1;
                score = score + basicPointValue;
            }
        }
        showMeUnknown();
        System.out.println("score = " + score + " do zgadnięcia " + emptySlots);
    }

    public static void showMeUnknown() {
        System.out.println("Zgadnij hasło"); //dodac informacje z której kategorii pochodzi
        for (String i : phraseUnknown
        ) {
            System.out.print(i);
        }
        System.out.println();
    }

    private static String userInputLetter() { //mozemy użyc też dla całego słowa
        boolean isCorrect = false;
        String letter = null;
        while (!isCorrect) {
            System.out.println("Podaj jedną literę");
            letter = scanner.nextLine().toUpperCase(Locale.ROOT);
            if (letterValidation(letter)) {
                isCorrect = true;
            } else {
                System.out.println("Wprowadzono niepoprawną wartość. Wprowadź ponownie");
                if (choiceValidation()) {
                    guessFullPhrase();
                }
            }
        }
        return letter;
    }

    private static boolean letterValidation(String letter) {
        Pattern pattern = Pattern.compile("[A-ZżźćńółęąśŻŹĆĄŚĘŁÓŃ]");
        Matcher matcher = pattern.matcher(letter);
        return matcher.matches();
    }

    private static boolean isLetterInKnown(String letter) {
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
            if (choiceValidation()) {
                guessFullPhrase();
            }
        }
        return inKnown;
    }
    //-------------

    private static boolean isLetterInUnknown(String letter) {
        boolean unknownLetter=true;
        int i = 0;
        while (i < phraseLength) {
            if (phraseUnknown[i].equals(letter)) {
                System.out.println("litera już jest");
                unknownLetter= false;
            }
            i++;
        }

        System.out.println("Trafiony! Litera do uzupełnienia.");
        if (choiceValidation()) {
            guessFullPhrase();
        }
        //isLetterInUnknown nie zostanie wywołany jeżeli nie będzie isLetterinKnown==true
        return unknownLetter;
    }

    private static boolean choiceValidation() {
        System.out.print(" Czy chcesz zgadnąć pełne hasło? T/N");
        String typeInFullPhase = scanner.nextLine().toUpperCase(Locale.ROOT);
        boolean isValidationCorrect = false;
        switch (typeInFullPhase) {
            case "T":
                isValidationCorrect = true;
                break;
            case "N":
                break;
            default:
                System.out.println("Niepoprawny wybór");
                choiceValidation();
                break;
        }
        return isValidationCorrect;
    }

    private static String[] prepareFullPhase(String fullPhraseAssumed) {
        return fullPhraseAssumed.split("");
    }

    //dodac opcje pelnego hasla jezeli brak litery w hasle glownym
    public static boolean guessFullPhrase() {
        boolean isFullCorrect = true;
        System.out.println("Wprowadź pełne hasło");
        String userInputfullPhrase = scanner.nextLine();
        String[] fullPhaseAssumed = prepareFullPhase(userInputfullPhrase);
        for (int i = 0; i < phraseLength; i++) {
            if (!phraseKnown[i].toUpperCase(Locale.ROOT).equals(fullPhaseAssumed[i].toUpperCase(Locale.ROOT))) {
                isFullCorrect = false;
                System.out.println("Niepoprawne hasło");
            }
        }
        if (isFullCorrect) {
            for (int i = 0; i < phraseLength; i++) {
                phraseUnknown[i] = phraseKnown[i];
            }
            score = score +(emptySlots * basicPointValue) + fullGuessBonus;
            emptySlots = 0;
            showMeUnknown();
            System.out.println("Gra zakończona");
        }
        return isFullCorrect;
    }
}
