package com.sda.games.checkers.model.dao;

import com.sda.games.checkers.model.player.Player;
import com.sda.utils.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import lombok.*;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Queue;

@AllArgsConstructor
public class PlayerDao {
    private HibernateFactory hibernateFactory;

    public void add(Player player) {
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(player);
        transaction.commit();
        session.close();
    }

    public List<Player> getByName(String name) {
        Session session = hibernateFactory.getSessionFactory().openSession();
        Query<Player> query = session.createQuery("FROM Player n WHERE n.name = :name", Player.class);
        query.setParameter("name", name);
        List<Player> players = query.list();
        session.close();
        return players;
    }

    public List<Player> getAll() {
        Session session = hibernateFactory.getSessionFactory().openSession();
        List<Player> fromPlayer = session.createQuery("FROM Player", Player.class).list();
        session.close();
        return fromPlayer;
    }
}
