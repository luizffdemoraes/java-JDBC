package com.schoolofnet.javaJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupDatabase {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Loaded");
        } catch (
                ClassNotFoundException ex) {
            System.out.println("Failed to Load");
            ex.printStackTrace();
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies?serverTimezone=UTC", "root", "root");

        } catch (
                SQLException ex) {
            ex.printStackTrace();
        }

        if (connection == null) {
            System.out.println("Connect failed");
            return;
        }

        Statement statement = connection.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS movie (id INTEGER NOT NULL AUTO_INCREMENT, name VARCHAR(255) NOT NULL, PRIMARY KEY(id))";

//        String sql = "DROP TABLE movie";

        //Comando DDL
        statement.executeUpdate(sql);

    }
}