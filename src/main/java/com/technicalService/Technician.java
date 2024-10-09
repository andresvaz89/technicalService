package com.technicalService;

public class Technician {
    public int id;
    public String name;
    public String apellido;

    // Constructor with parameters
    public Technician (int id, String name, String apellido, String Username, String Password) {
        super(Username, Password);
        this.id = id;
        this.name = name;
        
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", password=" + password +
                '}';
    }
}

