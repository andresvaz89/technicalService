package com.technicalService;

public class Client extends User {
    public int id_cliente;
    public int id_solicitud;
    public String nombre;
    public String apellido;

    // Constructor with parameters
    public Client (int id_cliente, int id_solicitud, String nombre, String apellido) {
        super(id_cliente, id_solicitud, nombre, apellido);
        this.id_cliente = id_cliente;
        this.id_solicitud = id_solicitud;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters and Setters constructor
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        super.toString();
        return "Person{" +
                "id_cliente=" + id_cliente +
                "id_solicitud=" + id_solicitud +
                ", name='" + nombre + '\'' +
                ", password=" + apellido +
                '}';
    }
}
