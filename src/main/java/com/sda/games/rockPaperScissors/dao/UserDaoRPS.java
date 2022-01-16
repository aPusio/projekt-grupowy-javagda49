package com.sda.games.rockPaperScissors.dao;

import com.sda.utils.HibernateFactory;

public class UserDaoRPS extends EntityDao {
    public UserDaoRPS(HibernateFactory hibernateFactory, Class clazz) {
        super(hibernateFactory, clazz);
    }
}
