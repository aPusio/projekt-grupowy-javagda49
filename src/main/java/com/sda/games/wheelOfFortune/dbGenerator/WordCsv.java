package com.sda.games.wheelOfFortune.dbGenerator;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class WordCsv {
    @CsvBindByName(column = "ID")
    private Integer wordId;
    @CsvBindByName(column = "ID_Category")
    private Integer categoryId;
    @CsvBindByName(column = "Word")
    private String word;
}