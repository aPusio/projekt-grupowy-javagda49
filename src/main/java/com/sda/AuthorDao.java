package com.sda;

import com.sda.utils.HibernateFactory;
import lombok.AllArgsConstructor;
import org.hibernate.Session;

@AllArgsConstructor
public class AuthorDao {
    private HibernateFactory hibernateFactory;

    public Authro getById(Long id) {
        Session session = hibernateFactory.getSessionFactory().openSession();
        Authro authro = session.find(Authro.class, id);
        session.close();
        return authro;
    }
}
