package com.sda.games.wheelOfFortune; //Tu piszemy yeahbunny kod koła

import com.sda.games.wheelOfFortune.methods.WheelGame;
import com.sda.utils.HibernateFactory;
import org.hibernate.Session;

import java.util.Locale;

public class App {
    public static void main(String[] args)  {
       System.out.println("Start gry");
        //wybierz kategorie
        //losowanie w ramach kategorii
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.getSessionFactory().openSession();
        session.close();
        hibernateFactory.getSessionFactory().close();
        WheelGame.startGame();

    }
}
