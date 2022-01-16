package com.sda.games.wheelOfFortune.dbGenerator;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class CategoryCsv {
    @CsvBindByName(column = "ID")
    private Integer idCategory;
    @CsvBindByName(column = "Name")
    private String nameCategory;
}
