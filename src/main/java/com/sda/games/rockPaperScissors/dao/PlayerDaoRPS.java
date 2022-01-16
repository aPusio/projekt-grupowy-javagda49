package com.sda.games.rockPaperScissors.dao;

import com.sda.utils.HibernateFactory;

public class PlayerDaoRPS extends EntityDao {
    public PlayerDaoRPS(HibernateFactory hibernateFactory, Class clazz) {
        super(hibernateFactory, clazz);
    }
}
