package com.crunchify.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crunchify.coonectDB.MyAppConfig;
import com.crunchify.coonectDB.User;
import com.crunchify.coonectDB.UserDao;


@Controller
public class HelloController {
	 ApplicationContext ctx = new AnnotationConfigApplicationContext(MyAppConfig.class);
	
    @GetMapping("/login")
    public String FromIndextoLogin(@RequestParam(value = "firstname", required= false) String name, @RequestParam(value = "password", required= false) String password) {
    	if(name != null && password != null) {
    		UserDao userDao = ctx.getBean(UserDao.class);
    		User user = userDao.findByName(name);
    		user.toString();
    	}
        return "login";
    }
    
    @GetMapping("/registration")
    public String FromIndexToRegistration(@RequestParam(value = "firstname", required= false) String name, @RequestParam(value = "password", required= false) String password, @RequestParam(value = "email", required= false) String email) {
    	if(name != null && password != null && email != null) {
    		UserDao userDao = ctx.getBean(UserDao.class);
            User user = new User(name, password, email);
            userDao.setUser(user);
    	}
        return "registration";
    }
   
    
    
    
}