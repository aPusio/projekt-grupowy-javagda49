package com.sda.games.wheelOfFortune;

import com.sda.games.wheelOfFortune.methods.WheelGame;
import com.sda.utils.HibernateFactory;
import org.hibernate.Session;

import java.util.Locale;

public class App {
    public static void main(String[] args)  {
        System.out.println("Start gry");
        WheelGame.startGame();

    }
}
