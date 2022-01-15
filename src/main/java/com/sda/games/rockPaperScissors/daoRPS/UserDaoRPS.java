package com.sda.games.rockPaperScissors.daoRPS;

import com.sda.utils.HibernateFactory;

public class UserDaoRPS extends EntityDao {
    public UserDaoRPS(HibernateFactory hibernateFactory, Class clazz) {
        super(hibernateFactory, clazz);
    }
}
