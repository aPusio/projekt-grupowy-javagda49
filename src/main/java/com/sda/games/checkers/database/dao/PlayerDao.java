package com.sda.games.checkers.database.dao;

import com.sda.games.checkers.database.model.PlayerEntity;
import com.sda.utils.HibernateFactory;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class PlayerDao {
    private HibernateFactory hibernateFactory;

    public void add(PlayerEntity player) {
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(player);
        transaction.commit();
        session.close();
    }

    public Optional<PlayerEntity> getByName(String name) {
        Session session = hibernateFactory.getSessionFactory().openSession();
        Query<PlayerEntity> query = session.createQuery("FROM PlayerEntity n WHERE n.name = :name", PlayerEntity.class);
        query.setParameter("name", name);
        List<PlayerEntity> players = query.list();
        PlayerEntity player = null;
        if (!players.isEmpty()) {
            player = players.get(0);
        }
        session.close();
        return Optional.ofNullable(player);
    }

    public List<PlayerEntity> getAll() {
        Session session = hibernateFactory.getSessionFactory().openSession();
        List<PlayerEntity> fromPlayer = session.createQuery("FROM PlayerEntity", PlayerEntity.class).list();
        session.close();
        return fromPlayer;
    }

    public void reset() {
        Session session = hibernateFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("DELETE FROM PlayerEntity").executeUpdate();
        transaction.commit();
        session.close();
    }
}
