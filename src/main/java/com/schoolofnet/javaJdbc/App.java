package com.schoolofnet.javaJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {


        ConnectionFactory.getConnection();

//        new ConnectionFactoryOld().getConnection();
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useLegacyDatatimeCode=false&serverTimeZone=UTC", "root", "root");
        System.out.println("Connected");

        // Trabalhar com QUERY
        // PreparedStatement é indicado para operações de DML dados concretos
        // Statement indicado para comando DDL é mais lento único resultado com mensagem de sucesso ou fracasso
        String query = "SELECT * FROM users WHERE id = ?";

        PreparedStatement preparedStatement = ConnectionFactory.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, 2);
//        preparedStatement.executeQuery();

        // Capturar resultados
        ResultSet rs = preparedStatement.executeQuery();

        // Manipular a coleção
        while(rs.next()) {
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("name"));
        }



    }

}
