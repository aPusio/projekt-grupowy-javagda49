package com.sda.games.wheelOfFortune.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
        String connectionString ="jdbc:hsqldb:file:src/main/java/com/sda/games/wheelOfFortune/db/database/dupa";
        String userName = "root";
        String password = "root";

    public Connection getConnection() throws SQLException{
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionString,userName,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}


