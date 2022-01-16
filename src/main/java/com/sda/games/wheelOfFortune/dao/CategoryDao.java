package com.sda.games.wheelOfFortune.dao;

import com.sda.games.wheelOfFortune.model.Category;
import com.sda.utils.HibernateFactory;
import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDao extends EntityDao<Category> {
    public CategoryDao(HibernateFactory hibernateFactory){
        super(hibernateFactory, Category.class);
    }

    public int getAllCount() {
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Category> fromCategory = session.createQuery("FROM Category", Category.class).list();
        session.close();
        return fromCategory.size();
    }
}
