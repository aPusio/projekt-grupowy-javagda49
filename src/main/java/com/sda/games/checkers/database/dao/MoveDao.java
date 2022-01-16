package com.sda.games.checkers.database.dao;

import com.sda.games.checkers.database.model.MoveEntity;
import com.sda.utils.HibernateFactory;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

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

    public List<MoveEntity> getAll() {
        Session session = hibernateFactory.getSessionFactory().openSession();
        List<MoveEntity> fromMove = session.createQuery("FROM MoveEntity", MoveEntity.class).list();
        session.close();
        return fromMove;
    }

}
