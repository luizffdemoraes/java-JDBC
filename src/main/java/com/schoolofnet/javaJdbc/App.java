package com.schoolofnet.javaJdbc;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {


        ConnectionFactory.getConnection();

//        new ConnectionFactoryOld().getConnection();
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useLegacyDatatimeCode=false&serverTimeZone=UTC", "root", "root");
        System.out.println("Connected");


    }

}
