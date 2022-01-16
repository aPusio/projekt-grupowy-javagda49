package com.sda.utils;

import com.sda.games.r_p_s.database.model.PlayerRPS;
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
        configuration.setProperty("hibernate.connection.url", "jdbc:hsqldb:file:db-data/mydatabase;hsqldb.write_delay_millis=0");
        configuration.setProperty("hibernate.connection.username", "admin123");
        configuration.setProperty("hibernate.connection.password", "admin123");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbc.JDBCDriver");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.addAnnotatedClass(Category.class);
        configuration.addAnnotatedClass(Turn.class);
        configuration.addAnnotatedClass(WheelOfFortune.class);
        configuration.addAnnotatedClass(Word.class);
        configuration.addAnnotatedClass(Player.class);
        configuration.addAnnotatedClass(UserRPS.class);
        configuration.addAnnotatedClass(PlayerRPS.class);
        return configuration;
    }

    public SessionFactory getSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(getHibernateConfig().getProperties()).build();
        return getHibernateConfig().buildSessionFactory(registry);
    }
}
