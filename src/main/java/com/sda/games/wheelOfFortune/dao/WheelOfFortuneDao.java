package com.sda.games.wheelOfFortune.dao;

import com.sda.games.wheelOfFortune.model.WheelOfFortune;
import com.sda.utils.HibernateFactory;

public class WheelOfFortuneDao extends EntityDao<WheelOfFortune> {
    public WheelOfFortuneDao(HibernateFactory hibernateFactory){
        super(hibernateFactory, WheelOfFortune.class);
    }
}
