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
    final static CategoryDao categoryDao = new CategoryDao(hibernateFactory);
    static Scanner scanner = new Scanner(System.in);
    final static int basicPointValue = 10;
    final static int fullGuessBonus = 100;
    static int score = 0;
    static int emptySlots;
    static int drawnNumberCategory = generateRNCategory();
    static int drawnNumberWord = generateRNWord(drawnNumberCategory);
    static String guessMePhrase = idWord(drawnNumberWord);
    final static Integer phraseLength = guessMePhrase.length();
    final static String[] phraseKnown = prepareKnown();
    static String[] phraseUnknown = prepareUnknown();


    public static void startGame() {
        //noinspection SpellCheckingInspection
        System.out.println("Liter do zgadnięcia: " + emptySlots);
        showMeUnknownAndAsk();
        while (emptySlots > 0) {
            String letter = userInputLetter();
            //noinspection SpellCheckingInspection
            System.out.print("Wprowadzono literę " + letter + ". ");
            if (isLetterInKnown(letter)) {
                if (isLetterInUnknown(letter)) { //pierwsza - "tak" - nieznana
                    modifyUnknown(letter);
                    if (choiceValidation()) {
                        guessFullPhrase();
                    }
                } /*else {
                    System.out.println("(do usuniecia: Litera już wcześniej została dodana do wyrażenia. Punktów: " + score);
                }*/
            }
        }
        //noinspection SpellCheckingInspection
        System.out.println("Gra zakończona: hasło odgadnięte. Liczba punktów:  " + score);
    }


    private static String idWord(int nr) {
        WordsDao wordsDao = new WordsDao(WheelGame.hibernateFactory);
        return wordsDao.getById(nr).getWord();
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
        //noinspection SpellCheckingInspection
        System.out.println("score = " + score + " do zgadnięcia " + emptySlots);
    }

    public static void showMeUnknownAndAsk() {
        //noinspection SpellCheckingInspection
        System.out.println("Zgadnij hasło, Category: " + categoryDao.getById(generateRNCategory()).getName());
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
        //noinspection SpellCheckingInspection
        System.out.println("Podaj jedną literę");
        String letter = scanner.nextLine().toUpperCase(Locale.ROOT);
        if (letterValidation(letter)) {
            //noinspection SpellCheckingInspection
            System.out.println("Wartosc poprawna");
            return letter;
        } else {
            //noinspection SpellCheckingInspection
            System.out.println("Wprowadzono niepoprawną wartość. Wprowadź ponownie");
            userInputLetter();
        }
        return "a"; //needs to be corrected;
    }

    private static boolean letterValidation(String letter) {
        Pattern pattern = Pattern.compile("[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]");
        Matcher matcher = pattern.matcher(letter);
        return matcher.matches();
    }

    private static boolean isLetterInKnown(String letter) {
        int i = 0;
        boolean inKnown = false;
        while (i < phraseLength) {
            inKnown = phraseKnown[i].toUpperCase(Locale.ROOT).equals(letter);
            i++;
        }
        if (!inKnown) {
            //noinspection SpellCheckingInspection
            System.out.println("Brak litery w haśle głównym");
            System.out.println("Category: ");
            //noinspection SpellCheckingInspection
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

        if (!duplicateLetter) {
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
                choiceValidation();
               // break;
        }
        return isValidationCorrect;
    }

    private static String[] prepareFullPhase(String fullPhraseAssumed) {
        return fullPhraseAssumed.split("");
    }

    //add option to check if there are still missing letters in the word
    public static void guessFullPhrase() {
        boolean isFullCorrect = true;
        //noinspection SpellCheckingInspection
        System.out.println("Wprowadź pełne hasło");
        String userInputFullPhrase = scanner.nextLine();
        String[] fullPhaseAssumed = prepareFullPhase(userInputFullPhrase);
        for (int i = 0; i < phraseLength; i++) {
            if (!phraseKnown[i].toUpperCase(Locale.ROOT).equals(fullPhaseAssumed[i].toUpperCase(Locale.ROOT))) {
                isFullCorrect = false;
                //noinspection SpellCheckingInspection
                System.out.println("Niepoprawne hasło");
                break;
            }
        }

        if (isFullCorrect) {
            //noinspection ManualArrayCopy
            for (int i = 0; i < phraseLength; i++) {
                phraseUnknown[i] = phraseKnown[i];
            }
            score = score + (emptySlots * basicPointValue) + fullGuessBonus;
            emptySlots = 0;

        }
    }

    private static int generateRNCategory() {
        CategoryDao categoryDao = new CategoryDao(WheelGame.hibernateFactory);
        int max = categoryDao.getAllCount();
        Random random = new Random();
        return random.nextInt(max+MIN)-MIN;
    }
    private static int generateRNWord(int drawnNumberCategory) {
        WordsDao wordsDao = new WordsDao(WheelGame.hibernateFactory);
        int max = wordsDao.getAllCountWordsFromCategory(drawnNumberCategory);
        Random random = new Random();
        return  random.nextInt(max+MIN)-MIN;
    }
}
