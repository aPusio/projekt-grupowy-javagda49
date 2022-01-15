package com.sda.games.checkers.database.dao;

import com.sda.games.checkers.database.model.MoveEntity;
import com.sda.games.checkers.database.model.PlayerEntity;
import com.sda.utils.HibernateFactory;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@AllArgsConstructor
public class MoveDao {
    private HibernateFactory hibernateFactory;

    public void add(MoveEntity move) {
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(move);
        transaction.commit();
        session.close();
    }

}