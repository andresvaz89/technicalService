package com.technicalService;

public class Client extends User {
    private int id;
    private String nombre;
    private String apellido;

    // Constructor with parameters
    public Client (int id, String nombre, String apellido, int id_usuario, String username, String password) {
        super(id, nombre, apellido);
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters and Setters constructor
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        super.toString();
        return "Person{" +
                "id =" + id +
                ", name ='" + nombre + '\'' +
                ", apellido =" + apellido +
                ", password=" + password +
                '}';
    }
}
