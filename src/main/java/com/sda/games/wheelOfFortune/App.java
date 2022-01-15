package com.sda.games.wheelOfFortune; //Tu piszemy jebany kod koła

import com.sda.games.wheelOfFortune.methods.WheelGame;

import java.util.Locale;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Start gry");
        //wybierz kategorie
        //losowanie w ramach kategori
     /*   String guessMeWord = WheelGame.idWord(4).toUpperCase(Locale.ROOT);
        System.out.println(guessMeWord);
        String[] wordUnknown = WheelGame.prepareUnknown(guessMeWord);
        WheelGame.showMeUnknown(wordUnknown);*/
        WheelGame.startGame();


    }
}
