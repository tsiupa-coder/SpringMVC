package com.crunchify.coonectDB;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class MyAppConfig {

    @Bean
    public DataSource dataSource(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setURL("jdbc:mysql://localhost:3306/usersofmysite?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setPassword("123ivan");
        return dataSource;
    }

    @Bean
    public UserDao userDao(){
        return new UserDao(dataSource());
    }
    
    
}

