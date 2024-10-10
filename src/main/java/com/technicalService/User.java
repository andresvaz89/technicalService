package com.technicalService;

public class User {
    protected int id_usuario;
    protected String username;
    protected String password;

    //constructor vacio para incializar sin que pida parámetro
    public User (){

    }

    // Constructor with parameters constructor y sus parámetros
    public User (int id_usuario, String username, String password) {
        this.id_usuario = id_usuario;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario= id_usuario;
    }

    public String getUserame() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id_usuario +
                ", name='" + username + '\'' +
                ", password=" + password +
                '}';
    }
}