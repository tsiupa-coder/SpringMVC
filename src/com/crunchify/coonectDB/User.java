package com.crunchify.coonectDB;

public class User {
    private int Id_user;
    private String user_name;
    private String user_password;
    private String user_email;

    public User(String user_name, String user_password, String user_email) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_email = user_email;
    }

    public User(){
        super();
    }
    public int getId_user() {
        return Id_user;
    }

    public void setId_user(int id_user) {
        Id_user = id_user;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    @Override
    public String toString() {
        return "----------------------------------------------------" + "\n" +
                "User{" + " \n " +
                "Id_user=" + Id_user + " \n " +
                ", user_name='" + user_name + " \n " +
                ", user_password='" + user_password+ " \n " +
                ", user_email='" + user_email+ " \n " +
                '}' + " \n " +
                "--------------------------------------------------" + " \n ";
    }
}
