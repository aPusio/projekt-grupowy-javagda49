package com.sda.games.rockPaperScissors.dao;

import com.sda.utils.HibernateFactory;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@AllArgsConstructor
public abstract class EntityDao <T>{
    private HibernateFactory hibernateFactory;
    private Class<T> clazz;

public void save(T entity){
    SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    session.save(entity);
    transaction.commit();
    session.close();
    sessionFactory.close();
}

public void update(T entity){
    SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    session.update(entity);
    transaction.commit();
    session.close();
    sessionFactory.close();
}

public void delete(T entity){
    SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    session.delete(entity);
    transaction.commit();
    session.close();
    sessionFactory.close();
}
}
