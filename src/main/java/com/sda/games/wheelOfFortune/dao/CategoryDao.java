package com.sda.games.wheelOfFortune.dao;

import com.sda.games.wheelOfFortune.model.Category;
import com.sda.utils.HibernateFactory;

public class CategoryDao extends EntityDao<Category> {
    public CategoryDao(HibernateFactory hibernateFactory){
        super(hibernateFactory, Category.class);
    }
}
