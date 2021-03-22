package com.crunchify.coonectDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class UserDao {

    private DataSource dataSource;
    
    @Autowired
    UserDao(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    // додаваня нового користвача
    public void setUser(User user){

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO `usersofmysite`.`users` (`user_nickname`, `user_password`, `email`) VALUES ('" + user.getUser_name() + "', '" + user.getUser_password() + "', '" + user.getUser_email()+ "');");
            statement.close();

        } catch (SQLException e) {
          e.printStackTrace();
        }

    }
    
    // пошук за id
    public User findbyId(int i) {
        User user = new User();
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usersofmysite.users where id_user = " + i + ";");

            while (resultSet.next()) {
                user.setId_user(resultSet.getInt("id_user"));
                user.setUser_name(resultSet.getString("user_nickname"));
                user.setUser_password(resultSet.getString("user_password"));
                user.setUser_email(resultSet.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    //пошук за імям
    public User findByName(String name) {
    	User user = new User();
    	
    	try {
    		Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usersofmysite.users where 'user_nickname' = '" + name + "' ;");
    		
            while (resultSet.next()) {
                user.setId_user(resultSet.getInt("id_user"));
                user.setUser_name(resultSet.getString("user_nickname"));
                user.setUser_password(resultSet.getString("user_password"));
                user.setUser_email(resultSet.getString("email"));
            }
    	}catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return user;
    	
    }
}