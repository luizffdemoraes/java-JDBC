package com.schoolofnet.javaJdbc.model;

import com.schoolofnet.javaJdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    private Connection connection = null;
    private PreparedStatement statement = null;

    public MovieDAO() {
        connection = new ConnectionFactory().getConnection();
    }

    public List<Movie> findAll() throws SQLException {
        String query = "SELECT * FROM movie";
        List<Movie> movies = new ArrayList<Movie>();

        statement = connection.prepareStatement(query);

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            movies.add(new Movie(resultSet.getInt("id"), resultSet.getString("name")));
        }

        return movies;
    }

    public void insert(Movie movie) {

    }

    public void update(Movie movieOld, Movie movieNew) {

    }

    public void remove(Movie movie) {

    }
}
