package com.schoolofnet.javaJdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {


        ConnectionFactory.getConnection();

//        new ConnectionFactoryOld().getConnection();
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useLegacyDatatimeCode=false&serverTimeZone=UTC", "root", "root");
        System.out.println("Connected");

        // Trabalhar com QUERY
        // PreparedStatement é indicado para operações de DML
        // Statement indicado para comando DDL é mais lento
        String query = "SELECT * FROM users WHERE ID = ?";

        PreparedStatement preparedStatement = ConnectionFactory.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, 5);
        preparedStatement.executeQuery();



    }

}
