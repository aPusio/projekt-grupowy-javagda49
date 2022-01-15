package com.sda.games.wheelOfFortune.methods;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WheelGame {
    static Scanner scanner = new Scanner(System.in);
    static int drawnNumber =4; //to będzie importowane z metody losującej
    static String guessMeWord = idWord(drawnNumber);
    final String[] wordKnown = prepareKnown(guessMeWord);
    String[] wordUnknown = prepareUnknown(guessMeWord);

    public static void startGame() {
        String letter = WheelGame.userInput();
        System.out.println("Wprowadzono literę " + letter);
        isLetterInKnown(letter);
    }

    private static String idWord(int nr) {
        //tu będzie pobieranie po podanym ID słowo z bazy
        String word = "Dupa dupa całka z dupy";
        return word;
    }
    private static String[] prepareKnown(String guessMeWord) {
        return guessMeWord.split("");
    }
    public static String[] prepareUnknown(String guessMeWord) {
        String[] wordUnknown = new String[guessMeWord.length()];
        String[] wordKnown = WheelGame.prepareKnown(guessMeWord);
        for (int i = 0; i < wordKnown.length; i++) {
            if (wordKnown[i].equals(" ")) {
                wordUnknown[i] = " ";
            } else {
                wordUnknown[i] = "_";
            }
        }
        return wordUnknown;
    }

    public static String[] modifyUnknown() {
        //do uzupelnienia
        return null;
    }

    public static void showMeUnknown(String[] wordUnknown) {
        for (String i : wordUnknown
        ) {
            System.out.print(i);
        }
        System.out.println();
    }

    private static String userInput() { //mozemy użyc też dla całego słowa
        boolean isCorrect = false;
        String letter = null;
        while (isCorrect == false) {
            System.out.println("Podaj jedną literę");
            letter = scanner.nextLine().toUpperCase(Locale.ROOT);
            if (letterValidation(letter) == true) {
                isCorrect = true;
            } else {
                System.out.println("Wprowadzono niepoprawną wartość. Wprowadź ponownie");
            }
        }
        ;
        return letter;
    }

    private static boolean letterValidation(String letter) {
        Pattern pattern = Pattern.compile("[A-Z]{1}");
        Matcher matcher = pattern.matcher(letter);
        return matcher.matches();
    }


    private static boolean isLetterInKnown(String letter) {

        return true;
    }

    private static boolean isLetterInUnknown(String letter) {

        return false;
    }
}
