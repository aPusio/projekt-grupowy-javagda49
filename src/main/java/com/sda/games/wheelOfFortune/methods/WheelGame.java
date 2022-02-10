package com.sda.games.wheelOfFortune.methods;

import com.sda.games.wheelOfFortune.dao.CategoryDao;
import com.sda.games.wheelOfFortune.dao.WordsDao;
import com.sda.utils.HibernateFactory;
import java.util.Scanner;

public class WheelGame {
    final static int MIN = 1;
    final static HibernateFactory hibernateFactory = new HibernateFactory();
    final static CategoryDao categoryDao = new CategoryDao(hibernateFactory);
    static Scanner scanner = new Scanner(System.in);
    final static int basicPointValue = 10;
    final static int fullGuessBonus = 100;
    static int score = 0;
    static int drawnNumberCategory = Randoms.generateRNCategory();
    static int drawnNumberWord = Randoms.generateRNWord(drawnNumberCategory);
    static int emptySlots=Knowns.guessMePhrase.length();

    public static void startGame() {
        //linijka kontrolna - do usuniecia po ogarnieciu losowań
        System.out.println("Liter do zgadnięcia: " + emptySlots + " Knowns.guessMePhrase -> " + Knowns.guessMePhrase + " -> Knowns.guessMePhrase.length() " + Knowns.guessMePhrase.length()+" -> drawnNumberCategory " + drawnNumberCategory + " drawnNumberWord " + drawnNumberWord);
        Unknowns.showMeUnknownAndAsk();
        while (emptySlots > 0) {
            String letter = UserActions.userInputLetter();
            if (letter.equals("@")) {
                UserActions.guessFullPhrase();
            } else {
            System.out.print("Wprowadzono literę " + letter + ". ");
            if (Knowns.isLetterInKnown(letter)) {
                if (Unknowns.isLetterInUnknown(letter)) {
                    Unknowns.modifyUnknown(letter);
                }
            }
        }
        }
        System.out.println("Gra zakończona: hasło odgadnięte. Liczba punktów:  " + score);
    }


    static String idWord(int nr) {
        WordsDao wordsDao = new WordsDao(WheelGame.hibernateFactory);
        return wordsDao.getById(nr).getWord();
    }

}
