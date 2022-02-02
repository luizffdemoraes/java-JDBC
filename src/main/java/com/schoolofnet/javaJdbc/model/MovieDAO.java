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

    public Movie findById(Integer id) throws SQLException {
        String query = "SELECT * FROM movie WHERE id = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        Movie movie = null;

        while (resultSet.next()) {
            movie = new Movie(resultSet.getInt("id"), resultSet.getString("name"));
        }

        return movie;
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

    public void insert(Movie movie) throws SQLException {
        String query = "INSERT INTO movie (name) VALUES (?)";

        statement = connection.prepareStatement(query);
        statement.setString(1, movie.getName());
        statement.execute();
    }

    public void update(Movie movieOld, Movie movieNew) throws SQLException {
        String query = "UPDATE movie SET name = ? WHERE id = ?";

        statement = connection.prepareStatement(query);
        statement.setInt(1, movieNew.getId());
        statement.setString(2, movieNew.getName());
        statement.execute();

    }

    public void remove(Movie movie) throws SQLException {
        String query = "DELETE FROM movie WHERE id = ?";

        statement = connection.prepareStatement(query);
        statement.setInt(1, movie.getId());
        statement.execute();
    }
}
