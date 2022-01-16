package com.sda.games.wheelOfFortune.dbGenerator;

import com.sda.games.wheelOfFortune.dao.CategoryDao;
import com.sda.games.wheelOfFortune.dao.WordsDao;
import com.sda.games.wheelOfFortune.model.Category;
import com.sda.games.wheelOfFortune.model.Word;
import com.sda.utils.HibernateFactory;
import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Path;

public class DbGenerator {
    private static final Path CATEGORTY_WHEEL_OF_FORTUNE_PATH =
            Path.of("src", "main", "java", "com", "sda",
                    "games", "wheelOfFortune", "csv", "WOFCategories.csv");
    private static final Path WORDS_WHEEL_OF_FORTUNE_PATH =
            Path.of("src", "main", "java", "com", "sda",
                    "games", "wheelOfFortune", "csv", "WOFWords.csv");

    @SneakyThrows
    public static void main(String[] args) {

        CategoryDao categoryDao = new CategoryDao(new HibernateFactory());
        fulfillCategoryData(categoryDao);
        fulfillWordData(categoryDao);
    }

    private static void fulfillCategoryData(CategoryDao categoryDao) throws IOException {
        BufferedReader brCategory = new BufferedReader(new FileReader(CATEGORTY_WHEEL_OF_FORTUNE_PATH.toFile()));
        String lineFromFileCategory;
        while ((lineFromFileCategory = brCategory.readLine())!= null){
            String[] split = lineFromFileCategory.split(",");
            Category category = new Category();
            category.setCategoryId(Integer.valueOf(split[0]));
            category.setName(split[1]);
            categoryDao.save(category, category.getCategoryId());
        }
    }

    private static void fulfillWordData(CategoryDao categoryDao) throws IOException {
        WordsDao wordDao = new WordsDao(new HibernateFactory());
        BufferedReader brWord = new BufferedReader(new FileReader(WORDS_WHEEL_OF_FORTUNE_PATH.toFile()));
        String lineFromFileWord;
        while ((lineFromFileWord = brWord.readLine())!= null){
            String[] split = lineFromFileWord.split(",");
            Word word = new Word();
            word.setWordId(Integer.valueOf(split[0]));
            word.setCategory(categoryDao.getById(Integer.valueOf(split[1])));
            word.setWord(split[2]);
            wordDao.save(word, word.getWordId());
        }
    }
}
