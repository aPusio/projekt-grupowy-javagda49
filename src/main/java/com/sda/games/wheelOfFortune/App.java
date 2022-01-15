package com.sda.games.wheelOfFortune; //Tu piszemy jebany kod koła

import com.sda.games.wheelOfFortune.methods.WheelGame;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Start gry");
        //wybierz kategorie
        //losowanie w ramach kategori
        String wylosowaneHaslo = WheelGame.idWord(4);
        System.out.println(wylosowaneHaslo);
        //char[] haslo=new char[wylosowaneHaslo.length()];
        String[] haslo=wylosowaneHaslo.split("");
        String[] hasloStan=new String[wylosowaneHaslo.length()];

        for (int i=0;i<wylosowaneHaslo.length();i++) {
            if (haslo[i].equals(" ")) {
                hasloStan[i]=" ";
            } else {
                hasloStan[i]="_";
            }
        }

        for (String string: hasloStan
             ) {
            System.out.print(string);
            
        }
         

  
            
        
    }
}
