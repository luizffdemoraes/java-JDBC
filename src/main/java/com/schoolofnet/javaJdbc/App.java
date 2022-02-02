package com.schoolofnet.javaJdbc;

import java.sql.Connection;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------- Menu -----------");
        System.out.println("1 - List movies");
        System.out.println("2 - Create new movie");
        System.out.println("3 - Update a movie");
        System.out.println("4 - Delete a movie");
        System.out.println("----------- Menu -----------");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Inserted");
                Connection con = new ConnectionFactory().getConnection();
                break;
            case 2:
                System.out.println("List");
                break;
            case 3:
                break;
            case 4:
                break;


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
