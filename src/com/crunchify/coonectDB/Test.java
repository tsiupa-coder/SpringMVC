package com.crunchify.coonectDB;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyAppConfig.class);
        UserDao userDao = ctx.getBean(UserDao.class);
        User user = new User("super_admin", " 1234", " superAdmin@gmail.com");
        userDao.setUser(user);
        user = userDao.findbyId(1);
        System.out.println(user.toString());
    }
}
