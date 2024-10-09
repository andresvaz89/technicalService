package com.technicalService;

public class Technician extends User {
    private int id;
    private String name;
    private String apellido;

    // Constructor with parameters
    public Technician (int id, String name, String apellido, int id_usuario, String username, String password) {
        super(id_usuario, username, password);
        this.id = id;
        this.name = name;
        this.apellido = apellido;
        
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "id =" + id +
                ", name ='" + name + '\'' +
                ", apellido =" + apellido + 
                ", password =" + password +
                '}';
    }
}

