package com.sda.games.wheelOfFortune.dao;


import com.sda.games.wheelOfFortune.model.Word;
import com.sda.utils.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;

public class WordsDao extends EntityDao<Word> {
        public WordsDao(HibernateFactory hibernateFactory) {
            super(hibernateFactory, Word.class);
        }

    public int getAllCountWordsFromCategory(Integer id) {
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Word> query = session.createQuery("FROM Word WHERE category_categorId=:idToFind", Word.class);
        query.setParameter("idToFind",id);
        List<Word> words = query.list();
        session.close();
        return words.size();
    }
}
