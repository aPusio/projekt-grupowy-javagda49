package com.sda.games.rockPaperScissors.dao;

import com.sda.utils.HibernateFactory;

public class PlayerDao extends EntityDao {
    public PlayerDao(HibernateFactory hibernateFactory, Class clazz) {
        super(hibernateFactory, clazz);
    }
}