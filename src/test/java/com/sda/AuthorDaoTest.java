package com.sda;

import com.sda.utils.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AuthorDaoTest {

    private HibernateFactory hibernateFactory = Mockito.mock(HibernateFactory.class);
    private AuthorDao authorDao = new AuthorDao(hibernateFactory);
    private SessionFactory sessionFactory = Mockito.mock(SessionFactory.class);
    private Session session = Mockito.mock(Session.class);


    @Test
    public void gettingExistingAuthorShouldReturnAuthor() {
        //given
        Authro authro = new Authro(1L, "Adam", "P");
        Mockito.when(sessionFactory.openSession()).thenReturn(session);
        Mockito.when(hibernateFactory.getSessionFactory()).thenReturn(sessionFactory);
        Mockito.when(session.find(Mockito.eq(Authro.class), Mockito.any())).thenReturn(authro);

        //when
        Authro byId = authorDao.getById(2L);

        //then
        Assertions.assertNotNull(byId);
    }

    @Test
    public void gettingNoyExistingAuthorShouldReturnAuthor() {
        //given
        Mockito.when(sessionFactory.openSession()).thenReturn(session);
        Mockito.when(hibernateFactory.getSessionFactory()).thenReturn(sessionFactory);
        Mockito.when(session.find(Mockito.eq(Authro.class), Mockito.any())).thenReturn(null);

        //when
        Authro result = authorDao.getById(2L);

        //then
        Assertions.assertNull(result);
    }
}