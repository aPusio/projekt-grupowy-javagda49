package com.sda.utils;

import com.sda.games.wheelOfFortune.model.Category;
import com.sda.games.wheelOfFortune.model.Turn;
import com.sda.games.wheelOfFortune.model.WheelOfFortune;
import com.sda.games.wheelOfFortune.model.Word;
import com.sda.games.rockPaperScissors.modelRPS.UserRPS;
import com.sda.users.Player;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
    private Configuration getHibernateConfig() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "root");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.addAnnotatedClass(Category.class);
        configuration.addAnnotatedClass(Turn.class);
        configuration.addAnnotatedClass(WheelOfFortune.class);
        configuration.addAnnotatedClass(Word.class);
        configuration.addAnnotatedClass(Player.class);
        configuration.addAnnotatedClass(UserRPS.class);
        return configuration;
    }

    public SessionFactory getSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(getHibernateConfig().getProperties()).build();
        return getHibernateConfig().buildSessionFactory(registry);
    }
}
