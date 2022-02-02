package com.schoolofnet.javaJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    //    private static ConnectionFactory instance = new ConnectionFactory();
    public static final String URL = "jdbc:mysql://localhost:3306/movies?serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    private Connection createConnection() throws ClassNotFoundException {
        Connection connection = null;

        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Connection getConnection() {
        try {
            return createConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}


//    private ConnectionFactory() {
//        // This is deprecated, The driver is automatically
//        try {
//            Class.forName(DRIVER_CLASS);
//        } catch (ClassNotFoundException ex) {
//            ex.getMessage();
//        }
//    }
//
//    private Connection createConnection() {
//        Connection con = null;
//        try {
//            con = DriverManager.getConnection(URL, USER, PASSWORD);
//        } catch (SQLException ex) {
//            ex.getMessage();
//        }
//        return con;
//    }
//
//    public static Connection getConnection() {
//        return instance.createConnection();
//    }
//}
