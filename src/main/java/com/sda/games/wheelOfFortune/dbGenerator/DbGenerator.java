package com.sda.games.wheelOfFortune.dbGenerator;

import com.opencsv.bean.CsvToBeanBuilder;
import com.sda.games.wheelOfFortune.dao.EntityDao;
import com.sda.games.wheelOfFortune.model.Category;
import com.sda.games.wheelOfFortune.model.Word;
import com.sda.utils.HibernateFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.List;

public class DbGenerator {

    private static final Path CATEGORTY_WHEEL_OF_FORTUNE_PATH =
            Path.of("src", "main", "java", "com", "sda",
                    "games", "wheelOfFortune", "csv", "koloFortunyKategorie.csv");
    private static final Path WORDS_WHEEL_OF_FORTUNE_PATH =
            Path.of("src", "main", "java", "com", "sda",
                    "games", "wheelOfFortune", "csv","KolofortunyHaslanew.csv");

    public static void main(String[] args) throws FileNotFoundException {
        HibernateFactory hibernateFactory = new HibernateFactory();
        EntityDao<Category> categoryDao = new EntityDao<>(hibernateFactory, Category.class);
        EntityDao<Word> wordsDao = new EntityDao<>(hibernateFactory, Word.class);

        loadCategories(categoryDao);
        loadWords(wordsDao, categoryDao);

    }

    private static void loadCategories(EntityDao<Category> categoryEntityDao) throws FileNotFoundException {
        List<CategoryCsv> categoryCsvList =
        new CsvToBeanBuilder(new FileReader(CATEGORTY_WHEEL_OF_FORTUNE_PATH.toFile()))
                .withType(CategoryCsv.class)
                .build()
                .parse();
         categoryCsvList.stream()
                .map(DbGenerator::toDbCategory)
                    .forEach(categoryEntityDao::save);
    }

    private static Category toDbCategory(CategoryCsv categoryCsv){
        Category category = new Category();
        category.setCategorId(categoryCsv.getIdCategory());
        category.setName(categoryCsv.getNameCategory());
        return category;
    }
    private static void loadWords(EntityDao<Word> wordEntityDao, EntityDao<Category> categoryDao) throws FileNotFoundException {
        List<WordCsv> wordCsvList =
                new CsvToBeanBuilder(new FileReader(WORDS_WHEEL_OF_FORTUNE_PATH.toFile()))
                .withType(WordCsv.class)
                .build()
                .parse();
        wordCsvList.stream()
                .map(wordCsv -> doDbWord(wordCsv, categoryDao))
                .forEach(wordEntityDao::save);
    }


    private static Word doDbWord(WordCsv wordCsv, EntityDao<Category> categoryDao){
        Word word = new Word();
        word.setWordId(wordCsv.getWordId());
        word.setCategory(categoryDao.getById(wordCsv.getCategoryId()));
        word.setWord(wordCsv.getWord());
        return word;
    }

}
