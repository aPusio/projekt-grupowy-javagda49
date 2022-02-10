package com.sda.games.wheelOfFortune.methods;

import com.sda.games.wheelOfFortune.dao.CategoryDao;
import com.sda.games.wheelOfFortune.dao.WordsDao;

import java.util.Random;

public class Randoms {
    static int generateRNCategory() {
        CategoryDao categoryDao = new CategoryDao(WheelGame.hibernateFactory);
        int max = categoryDao.getAllCount();
        Random random = new Random();
        return random.nextInt(max) + WheelGame.MIN;
    }

    static int generateRNWord(int drawnNumberCategory) {
        WordsDao wordsDao = new WordsDao(WheelGame.hibernateFactory);
        int max = wordsDao.getAllCountWordsFromCategory(drawnNumberCategory);
        Random random = new Random();
        return (random.nextInt(max) + WheelGame.MIN) + ((drawnNumberCategory - 1) * 10); //metoda łoma
    }

}
