package com.sda.games.checkers.database.dao;

import com.sda.games.checkers.database.model.PlayerEntity;
import com.sda.games.checkers.logic.player.Player;
import com.sda.utils.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

@ExtendWith(MockitoExtension.class)
class PlayerDaoTest {

    private HibernateFactory hibernateFactory = Mockito.mock(HibernateFactory.class);
    private  PlayerDao playerDao = new PlayerDao((hibernateFactory));
    private  SessionFactory sessionFactory = Mockito.mock(SessionFactory.class);
    private  Session session = Mockito.mock(Session.class);
    private Query<Player> query = (Query<Player>) Mockito.mock(Query.class);

    @Test
    public void testtt() {
        //given
        Player player = new Player("White", true, 0);
        //when
        Mockito.when(sessionFactory.openSession()).thenReturn(session);
        Mockito.when(hibernateFactory.getSessionFactory()).thenReturn(sessionFactory);
//        Mockito.when(session.find((Mockito.eq(Player.class)), Mockito.any())).thenReturn(player);
        Mockito.when(session.createQuery(Mockito.any(), Mockito.eq(Player.class))).thenReturn(query);
        Mockito.when(query.list()).thenReturn(Collections.singletonList(player));

        Optional<PlayerEntity> byName = playerDao.getByName("White");
        //then
        Assertions.assertNotNull(byName);
        Assertions.assertEquals(player, byName.get());
    }

    @Test
    public void testttt() {
        //given
        Mockito.when(sessionFactory.openSession()).thenReturn(session);
        Mockito.when(hibernateFactory.getSessionFactory()).thenReturn(sessionFactory);
        Mockito.when(session.find(Mockito.eq(Player.class), Mockito.any())).thenReturn(null);
        //when
        Optional<PlayerEntity> byName = playerDao.getByName("Adam");
        //then
        Assertions.assertNull(byName);
    }

}