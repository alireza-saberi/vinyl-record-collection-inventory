package com.vinyl.DAO;

import com.vinyl.model.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alans
 */
public class UserDAO {

    PreparedStatement preparedstatement = null;
    ResultSet resultSet = null;
    DBConnector obj_DB_Connection = null;
    Connection connection = null;

    // adding a user
    public void addUser(Users user) {

        try {
            obj_DB_Connection = new DBConnector();
            connection = obj_DB_Connection.getConnection();

            String query = "INSERT INTO users (first_name, last_name, username, user_password) VALUES (?, ?, ?, ?)";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, user.getFirst_name());
            preparedstatement.setString(2, user.getLast_name());
            preparedstatement.setString(3, user.getUsername());
            preparedstatement.setString(4, user.getUser_password());

            int rowsAffected = preparedstatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            obj_DB_Connection.closeConnection(obj_DB_Connection, preparedstatement);

        }

    }

    // in case we want to drop a user
    public void deleteUser(Users user) {
        try {
            obj_DB_Connection = new DBConnector();
            connection = obj_DB_Connection.getConnection();

            String query = "DELETE FROM users WHERE username=?";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, user.getUsername());

            int rowsAffected = preparedstatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            obj_DB_Connection.closeConnection(obj_DB_Connection, preparedstatement);
        }

    }

    // only changing name, and family name with this methiod
    public void updateUser(Users user) {
        try {
            obj_DB_Connection = new DBConnector();
            connection = obj_DB_Connection.getConnection();

            String query = "UPDATE users SET first_name=? last_name=? WHERE username=?";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, user.getFirst_name());
            preparedstatement.setString(2, user.getLast_name());
            preparedstatement.setString(3, user.getUsername());

            int rowsAffected = preparedstatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            obj_DB_Connection.closeConnection(obj_DB_Connection, preparedstatement);
        }

    }

    // check if the user exist
    public boolean isUserExist(Users user) {
        try {
            obj_DB_Connection = new DBConnector();
            connection = obj_DB_Connection.getConnection();
            
            String query = "SELECT * from users WHERE username=?";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, user.getUsername());

            resultSet = preparedstatement.executeQuery();
           
            return resultSet.next();
            
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            obj_DB_Connection.closeConnection(obj_DB_Connection, preparedstatement);
        }
        
        return false;

    }
    
    public Users readUser (Users user){
        Users loggedUser = new Users();
        try {
            obj_DB_Connection = new DBConnector();
            connection = obj_DB_Connection.getConnection();
            
            String query = "SELECT * from users WHERE username=? user_password=?";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, user.getUsername());
            preparedstatement.setString(1, user.getUser_password());
            resultSet = preparedstatement.executeQuery();
            
            while (resultSet.next()) {
                loggedUser.setFirst_name(resultSet.getString("first_name"));
                loggedUser.setLast_name(resultSet.getString("last_name"));
                loggedUser.setUsername(resultSet.getString("username"));
                loggedUser.setUser_password(resultSet.getString("user_password"));
                return loggedUser;
	    }
            
        
        }catch (SQLException e) {
            System.out.println(e);
        } finally {
            obj_DB_Connection.closeConnection(obj_DB_Connection, preparedstatement);
        }
        
        return null;
    }

}
