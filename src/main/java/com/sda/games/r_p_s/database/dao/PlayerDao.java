package com.sda.games.r_p_s.database.dao;

import com.sda.games.r_p_s.database.model.PlayerRPS;
import com.sda.utils.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PlayerDao {

    private HibernateFactory hibernateFactory;

    public void add(PlayerRPS playerRPS) {

        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(playerRPS);
        transaction.commit();
        session.close();
    }
}
