package com.schoolofnet.javaJdbc;

import com.schoolofnet.javaJdbc.model.Users;
import com.schoolofnet.javaJdbc.model.UsersDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Loaded");
        } catch (ClassNotFoundException ex) {
            System.out.println("Failed to Load");
            ex.printStackTrace();
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies?serverTimezone=UTC", "root", "root");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (connection != null) {
            System.out.println("Connected");
        } else {
            System.out.println("Connect failed");
        }

//        ConnectionFactory.getConnection();
//
////        new ConnectionFactoryOld().getConnection();
////        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useLegacyDatatimeCode=false&serverTimeZone=UTC", "root", "root");
//        System.out.println("Connected");
//
//        UsersDAO usersDAO = new UsersDAO();
//        List<Users> users = usersDAO.findAll();
//        for (int i = 0; i < users.size(); i++) {
//            Users user = users.get(i);
//            System.out.println(user.getName());
//        }
//
//        Users user = usersDAO.findById(3);
//
//        System.out.println("Find by id => " + user.getName());
//
//        usersDAO.insert(new Users( "Debora Cruz"));
//
//        usersDAO.remove(user);

        // Trabalhar com QUERY
        // PreparedStatement é indicado para operações de DML dados concretos
        // Statement indicado para comando DDL é mais lento único resultado com mensagem de sucesso ou fracasso
//        String query = "SELECT * FROM users";
//        // WHERE id = ?";
//
//        PreparedStatement preparedStatement = ConnectionFactory.getConnection().prepareStatement(query);
//        preparedStatement.setInt(1, 2);
//        preparedStatement.executeQuery();

        // Capturar resultados
//        ResultSet rs = preparedStatement.executeQuery();
//        List<Users> users = new ArrayList<Users>();


        // Manipular a coleção
//        while (rs.next()) {
        //Armazenando
//            Users user = new Users(rs.getInt("id"), rs.getString("name"));
//            users.add(user);

//            System.out.println(user.getName());
//            System.out.println(rs.getInt("id"));
//            System.out.println(rs.getString("name"));
    }


}
