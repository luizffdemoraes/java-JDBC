package com.schoolofnet.javaJdbc.model;

import com.schoolofnet.javaJdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {

    private Connection con;
    private PreparedStatement statement;

    public UsersDAO() {
        con = ConnectionFactory.getConnection();
    }

    public List<Users> findAll() throws SQLException {
        String query = "SELECT * FROM users";
        List<Users> users = new ArrayList<Users>();
        statement = con.prepareStatement(query);

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            users.add(new Users(rs.getInt("id"), rs.getString("name")));
        }

        return users;
    }

    public Users findById(Integer id) throws SQLException {
        String query = "SELECT * FROM users WHERE id  = ?";
        statement = con.prepareStatement(query);
        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();
        Users user = null;

        while (rs.next()) {
            user = new Users(rs.getInt("id"), rs.getString("name"));
//            user.setId(rs.getInt("id"));
//            user.setName(rs.getString("name"));
        }

        return user;
    }

    public void insert(Users user) throws SQLException {
//        String query = "INSERT INTO users (id , name) VALUES (?, ?)";
        String query = "INSERT INTO users ( name) VALUES ( ?)";

        statement = con.prepareStatement(query);

//        statement.setInt(1, user.getId());
        statement.setString(1, user.getName());
        statement.execute();
    }

    public void remove(Users users) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";
        statement = con.prepareStatement(query);
        statement.setInt(1, users.getId());
        statement.execute();
    }
}
