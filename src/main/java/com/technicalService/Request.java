package com.technicalService;

import java.sql.Date;

public class Request {
    public int id;
    public String tema;
    public String descripcion;
    public Date fecha_Creacion;
    public Date fecha_Completado;
    public Date fecha_Asistencia;
    public String estado;
    public String prioridad; 
  


    // Constructor with parameters
    public Request (int id, String tema, String descripcion, Date fecha_Creacion, Date fecha_Completado, Date fecha_Asistencia, String estado, String prioridad) {
        this.id = id;
        this.tema = tema;
        this.descripcion = descripcion;
        this.fecha_Creacion = fecha_Creacion;
        this.fecha_Completado = fecha_Completado;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getTema() {
        return tema;
    }

    public void setTema(String tema){
        this.tema = tema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String description) {
        this.descripcion = description;
    }

    public Date getFechaCreacion() {
        return fecha_Creacion;
    }

    public void setFechaCreacion(Date fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }

    public Date getFechaAsistencia(){
        return fecha_Asistencia;
    }
    public void setFechaAsistencia(Date fecha_Asistencia){
        this.fecha_Asistencia = fecha_Asistencia;
    }

    @Override
    public String toString() {
        return "Solicitud {" +
                "id=" + id +
                ", tema ='" +tema + '\'' +
                ", descripción = " + descripcion +
                ", fecha de creación = " + fecha_Creacion +
                ", fecha de completado = " + fecha_Completado +
                ", fecha de asistencia = " + fecha_Asistencia +
                ", estado= " + estado +
                ", prioridad= " + prioridad + " ." +
                '}';
    }
}

