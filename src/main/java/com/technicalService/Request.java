package com.technicalService;

public class Request {
    private int ID_Solicitud;
    private String name;
    private int age;

    // Constructor with parameters
    public Request(int ID_Solicitud, String name, int age) {
        this.ID_Solicitud = ID_Solicitud;
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public int getIdSolicitud() {
        return ID_Solicitud;
    }

    public void setId(int ID_Solicitud) {
        this.ID_Solicitud = ID_Solicitud;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "ID_Solicitud=" + ID_Solicitud +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}