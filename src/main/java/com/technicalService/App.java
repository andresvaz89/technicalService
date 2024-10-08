package com.technicalService;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // Iniciar el servidor H2
        DatabaseConnection.startServer();

        // Crear la tabla de personas
        CreateTable.createSolicitudTable();

        // Insertar una persona
        SolicitudCRUD.insertSolicitud("Ali", 25);
        SolicitudCRUD.insertSolicitud("Mick", 22);

        // Leer todas las Requestas
        List<Solicitud> solicitudes = SolicitudCRUD.getAllSolicitudes();

        // Verificar si hay personas en la lista antes de continuar
        if (!solicitudes.isEmpty()) {
            // Obtener el ID de la primera persona
            int idToUpdate = solicitudes.get(0).getIdSolicitud();  // Obtener el ID de ali y mick

            // Actualizar persona con el ID obtenido
            SolicitudCRUD.updateSolicitud(idToUpdate, "Aircon issue", 30);

            // Leer todas las personas nuevamente para verificar la actualización
            solicitudes = SolicitudCRUD.getAllSolicitudes();
            System.out.println("Lista de solicitudes después de actualizar:");
            for (Solicitud solicitud : solicitudes) {
                System.out.println("ID: " + solicitud.getIdSolicitud() + ", Name: " + solicitud.getName() + ", Age: " + solicitud.getAge());
            }

            // Eliminar persona con el ID obtenido
            SolicitudCRUD.deleteSolicitud(idToUpdate);
        } else {
            System.out.println("No hay solicitudes en la base de datos.");
        }
    }
}