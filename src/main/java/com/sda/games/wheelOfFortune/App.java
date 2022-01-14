package com.sda.games.wheelOfFortune;

import com.sda.games.wheelOfFortune.db.config.ConnectionManager;
import com.sda.games.wheelOfFortune.db.config.CreateDB;

import java.sql.Connection;

public class App {
    public static void main(String[] args) throws Exception {
        ConnectionManager connect=new ConnectionManager();
        CreateDB createDB = new CreateDB();
        Connection connection=connect.getConnection();
        createDB.createAndLoad();
    }

}
