package com.sda.games.wheelOfFortune.dao;

import com.sda.games.wheelOfFortune.model.Word;
import com.sda.utils.HibernateFactory;

public class WordsDao extends EntityDao<Word> {
        public WordsDao(HibernateFactory hibernateFactory) {
            super(hibernateFactory, Word.class);
        }
}
