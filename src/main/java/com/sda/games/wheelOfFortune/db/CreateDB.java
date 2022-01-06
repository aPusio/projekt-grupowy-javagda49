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
        String createLoad = readToString("src/main/java/com/sda/games/wheelOfFortune/db/scripts/CREATE_TABLES.sql");
        System.out.println(createLoad); //czyli skrypt się ładuje
        //powyzej docelowo chce calosc ale tu juz sprawdzalam czy sie nie czepia tego, że ddl i dml w jednym skrypcie
        //System.out.println("Tworzenie i uzupełnianie bazy ... ");
        try {
            System.out.println("dupa " + dbpath);
            connection = DriverManager.getConnection(dbpath, "root", "root");
            connection.createStatement().executeUpdate(createLoad); //cos tu nie tak
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
