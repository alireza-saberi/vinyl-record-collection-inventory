package com.vinyl.DAO;

import com.vinyl.model.Album;
import com.vinyl.model.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alans
 */
public class AlbumDAO {

    PreparedStatement preparedstatement = null;
    ResultSet resultSet = null;
    DBConnector obj_DB_Connection = null;
    Connection connection = null;

    // add album for a specific user
    public void addAlbum(Users user, Album album) {

        try {
            obj_DB_Connection = new DBConnector();
            connection = obj_DB_Connection.getConnection();

            String query = "INSERT INTO album (album_name, artist, album_year, album_condition, upc, note, username) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, album.getAlbum_name());
            preparedstatement.setString(2, album.getArtist());
            preparedstatement.setString(3, Integer.toString(album.getAlbum_year()));
            preparedstatement.setString(4, album.getAlbum_condition());
            preparedstatement.setString(5, album.getUpc());
            preparedstatement.setString(6, album.getNote());
            preparedstatement.setString(7, user.getUsername());

            int rowsAffected = preparedstatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            obj_DB_Connection.closeConnection(obj_DB_Connection, preparedstatement);

        }

    }

    // read albums for specific user
    public ArrayList<Album> readAlbums(Users user) {
        ArrayList<Album> albums = new ArrayList<>();
        Album album;

        try {
            obj_DB_Connection = new DBConnector();
            connection = obj_DB_Connection.getConnection();

            String query = "SELECT * from album "
                    + "WHERE username=?";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, user.getUsername());

            resultSet = preparedstatement.executeQuery();

            while (resultSet.next()) {
                //System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
                album = new Album();
                album.setAlbum_name(resultSet.getString("album_name"));
                album.setArtist(resultSet.getString("artist"));
                album.setAlbum_year(Integer.parseInt(resultSet.getString("album_year")));
                album.setAlbum_condition(resultSet.getString("album_condition"));
                album.setUpc(resultSet.getString("upc"));
                album.setNote(resultSet.getString("note"));
                album.setUsername(resultSet.getString("username"));
                albums.add(album);
            };

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            obj_DB_Connection.closeConnection(obj_DB_Connection, preparedstatement);
        }

        return albums;

    }

    // update album for a specific user
    public void updateAlbum(Users user, Album album) {
        try {
            obj_DB_Connection = new DBConnector();
            connection = obj_DB_Connection.getConnection();

            String query = "UPDATE album "
                    + "SET album_name=?, artist=?, album_year=?, album_condition=?, upc=?, note=? "
                    + "WHERE username=?";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, album.getAlbum_name());
            preparedstatement.setString(2, album.getArtist());
            preparedstatement.setString(3, Integer.toString(album.getAlbum_year()));
            preparedstatement.setString(4, album.getAlbum_condition());
            preparedstatement.setString(5, album.getUpc());
            preparedstatement.setString(6, album.getNote());
            preparedstatement.setString(7, user.getUsername());

            int rowsAffected = preparedstatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            obj_DB_Connection.closeConnection(obj_DB_Connection, preparedstatement);

        }

    }

    // delete album for a specific user
    public void deleteAlbum(Users user, Album album) {
        try {
            obj_DB_Connection = new DBConnector();
            connection = obj_DB_Connection.getConnection();

            String query = "DELETE FROM album "
                    + "WHERE album_name=? AND artist=? AND album_year=? AND album_condition=? AND upc=? AND note=? AND username=?";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, album.getAlbum_name());
            preparedstatement.setString(2, album.getArtist());
            preparedstatement.setString(3, Integer.toString(album.getAlbum_year()));
            preparedstatement.setString(4, album.getAlbum_condition());
            preparedstatement.setString(5, album.getUpc());
            preparedstatement.setString(6, album.getNote());
            preparedstatement.setString(7, user.getUsername());

            int rowsAffected = preparedstatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            obj_DB_Connection.closeConnection(obj_DB_Connection, preparedstatement);

        }

    }

    // delete album for a specific user
    public void deleteAllAlbum(Users user) {
        try {
            obj_DB_Connection = new DBConnector();
            connection = obj_DB_Connection.getConnection();

            String query = "DELETE FROM album "
                    + "WHERE username=?";
            preparedstatement.setString(1, user.getUsername());

            int rowsAffected = preparedstatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            obj_DB_Connection.closeConnection(obj_DB_Connection, preparedstatement);

        }

    }

}
