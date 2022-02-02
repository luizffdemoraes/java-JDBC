package com.schoolofnet.javaJdbc;

import com.schoolofnet.javaJdbc.model.Movie;
import com.schoolofnet.javaJdbc.model.MovieDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static final Connection CONNECTION = null;

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        MovieDAO dao = new MovieDAO();

        System.out.println("----------- Menu -----------");
        System.out.println("1 - List movies");
        System.out.println("2 - Create new movie");
        System.out.println("3 - Update a movie");
        System.out.println("4 - Delete a movie");
        System.out.println("----------- Menu -----------");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                ArrayList<Movie> data = (ArrayList<Movie>) dao.findAll();

                for (Movie movie : data) {
                    System.out.println("Id: " + movie.getId());
                    System.out.println("Name: " + movie.getName());
                }

                break;
            case 2:
                System.out.println("Enter name:");
                String name = scanner.next();
                dao.insert(new Movie(name));
                break;
            case 3:
                System.out.println("Enter Movie id:");
                Integer id = scanner.nextInt();

                Movie movieExistis = dao.findById(id);

                if(movieExistis != null) {
                    System.out.println("Enter new movie name: ");
                    String movieName = scanner.next();
                    Movie movieNew = new Movie(movieExistis.getId(), movieName);
                } else {
                    System.out.println("Does not exists");
                }
                break;
            case 4:
                System.out.println("Enter Movie id:");
                Integer idDelete = scanner.nextInt();

                Movie movieExistsDelete = dao.findById(idDelete);

                if(movieExistsDelete != null){
                    dao.remove(movieExistsDelete);
                } else {
                    System.out.println("Does not exists");
                }

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
