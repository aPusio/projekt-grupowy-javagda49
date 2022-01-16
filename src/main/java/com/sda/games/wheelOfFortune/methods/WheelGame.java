package com.sda.games.wheelOfFortune.methods;

import com.sda.games.wheelOfFortune.dao.CategoryDao;
import com.sda.games.wheelOfFortune.dao.WordsDao;
import com.sda.utils.HibernateFactory;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WheelGame {
    final static int MIN = 1;
    final static HibernateFactory hibernateFactory = new HibernateFactory();
    static Scanner scanner = new Scanner(System.in);
    final static int basicPointValue = 10;
    final static int fullGuessBonus = 100;
    static int score = 0;
    static int emptySlots;
    //static int drawnNumberCategory = generateRNCategory;
    static int drawnNumberWord = 4; //to będzie importowane z metody losującej
    static String guessMePhrase = idWord(drawnNumberWord);
    final static Integer phraseLength = guessMePhrase.length();
    final static String[] phraseKnown = prepareKnown();
    static String[] phraseUnknown = prepareUnknown();


    public static void startGame() {
        System.out.println("Liter do zgadnięcia: " + emptySlots);
        showMeUnknownAndAsk();
        while (emptySlots > 0) {
            String letter = userInputLetter();
            System.out.print("Wprowadzono literę " + letter + ". ");
            if (isLetterInKnown(letter) == true) {
                if (isLetterInUnknown(letter) == true) { //pierwsza - "tak" - nieznana
                    modifyUnknown(letter);
                    if (choiceValidation()) {
                        guessFullPhrase();
                    }
                } /*else {
                    System.out.println("(do usuniecia: Litera już wcześniej została dodana do wyrażenia. Punktów: " + score);
                }*/
            }
        }
        System.out.println("Gra zakończona: hasło odgadnięte. Liczba punktów:  " + score);
    }


    private static String idWord(int nr) {
        //tu będzie pobieranie po podanym ID słowo z bazy

        String word = "Hasło do zgadnięcia";
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

    public static void showMeUnknownAndAsk() {
        System.out.println("Zgadnij hasło"); //dodac informacje z której kategorii pochodzi
        showMeUnknown();
    }

    public static void showMeUnknown() {
        for (String i : phraseUnknown
        ) {
            System.out.print(i);
        }
        System.out.println();
    }

    private static String userInputLetter() {
        boolean isCorrect = false;

        // while (isCorrect==false) {
        System.out.println("Podaj jedną literę");
        String letter=new String(scanner.nextLine().toUpperCase(Locale.ROOT));
       // letter = scanner.nextLine().toUpperCase(Locale.ROOT);
        if (letterValidation(letter)) {
            System.out.println("Wartosc poprawna");
            //isCorrect = true;
            return letter;
        } else {
            System.out.println("Wprowadzono niepoprawną wartość. Wprowadź ponownie");
            userInputLetter();
        }
        // }
        return letter + letter;
    }

    private static boolean letterValidation(String letter) {
        Pattern pattern = Pattern.compile("[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]{1}");
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
            System.out.println("score = " + score + " do zgadnięcia " + emptySlots);
            showMeUnknown();
            if (choiceValidation()) {
                guessFullPhrase();
            }
        }
        return inKnown;
    }

    private static boolean isLetterInUnknown(String letter) {
        boolean unknownLetter = true;
        boolean duplicateLetter = false;
        int i = 0;
        while (i < phraseLength) {
            if (phraseUnknown[i].equals(letter)) {
                System.out.println("Litera już wcześniej została dodana do wyrażenia. Punktów: " + score);
                showMeUnknown();
                unknownLetter = false;
                duplicateLetter = true;
            }
            i++;
        }

        if (duplicateLetter == false) {
            System.out.println("Trafiony! Litera do uzupełnienia.");//?
        }
        return unknownLetter; //boolean
    }

    private static boolean choiceValidation() {
        System.out.print("Czy chcesz zgadnąć pełne hasło? T/N");
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
                //choiceValidation();
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
            score = score + (emptySlots * basicPointValue) + fullGuessBonus;
            emptySlots = 0;

        }
        return isFullCorrect;
    }
}
