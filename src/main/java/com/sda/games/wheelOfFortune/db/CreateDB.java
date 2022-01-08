package com.sda.games.wheelOfFortune.db;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {
    static Connection connection;
    static String dbpath = "jdbc:hsqldb:file:src/main/java/com/sda/games/wheelOfFortune/db/database/dupa;user=root;password=root";

    public void createAndLoad() throws Exception {
        String createTables = readToString("src/main/java/com/sda/games/wheelOfFortune/db/scripts/CREATE_TABLES.sql");
        String loadData = readToString("src/main/java/com/sda/games/wheelOfFortune/db/scripts/ADD_DATA.sql");
        System.out.println(createTables); //czyli skrypt się ładuje
        System.out.println("Tworzenie i uzupełnianie bazy ... ");
        try {
            System.out.println("dupa " + dbpath);
            connection = DriverManager.getConnection(dbpath, "root", "root");
            connection.createStatement().execute(createTables);
            connection.createStatement().execute(loadData);
            System.out.println("chyba ok");
        } catch (SQLException e) {
            System.out.println("cos jeblo");
            throw e;
        } finally {
           connection.close();
        }
    }

    public static String readToString(String fname) throws Exception {
        File file = new File(fname);
        return FileUtils.readFileToString(file, "utf-8");
    }

}
