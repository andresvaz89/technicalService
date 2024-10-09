package com.technicalService;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // Iniciar el servidor H2
        DatabaseConnection.startServer();

        // Crear la tabla de personas
        CreateTable.createRequestTable();

        // Insertar una persona
        RequestCRUD.insertSolicitud("Ali", 25);
        RequestCRUD.insertSolicitud("Mick", 22);

        // Leer todas las Requestas
        List<Request> solicitudes = RequestCRUD.getAllSolicitudes();

        // Verificar si hay personas en la lista antes de continuar
        if (!solicitudes.isEmpty()) {
            // Obtener el ID de la primera persona
            int idToUpdate = solicitudes.get(0).getIdSolicitud();  // Obtener el ID de ali y mick

            // Actualizar persona con el ID obtenido
            RequestCRUD.updateSolicitud(idToUpdate, "Aircon issue", 30);

            // Leer todas las personas nuevamente para verificar la actualización
            solicitudes = RequestCRUD.getAllSolicitudes();
            System.out.println("Lista de solicitudes después de actualizar:");
            for (Request solicitud : solicitudes) {
                System.out.println("ID: " + solicitud.getIdSolicitud() + ", Name: " + solicitud.getName() + ", Age: " + solicitud.getAge());
            }

            // Eliminar persona con el ID obtenido
            RequestCRUD.deleteSolicitud(idToUpdate);
        } else {
            System.out.println("No hay solicitudes en la base de datos.");
        }
    }
}