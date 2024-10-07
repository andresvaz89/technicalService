package com.technicalService;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // Iniciar el servidor H2
        DatabaseConnection.startServer();

        // Crear la tabla de personas
        CreateTable.createRequestTable();

        // Insertar una persona
        RequestCRUD.insertRequest("Ali", 25);
        RequestCRUD.insertRequest("Mick", 22);

        // Leer todas las Requestas
        List<Request> requests = RequestCRUD.getAllRequests();

        // Verificar si hay personas en la lista antes de continuar
        if (!requests.isEmpty()) {
            // Obtener el ID de la primera persona
            int idToUpdate = requests.get(0).getId();  // Obtener el ID de ali y mick

            // Actualizar persona con el ID obtenido
            RequestCRUD.updateRequest(idToUpdate, "Aircon issue", 30);

            // Leer todas las personas nuevamente para verificar la actualización
            requests = RequestCRUD.getAllRequests();
            System.out.println("Requests's list after update:");
            for (Request request : requests) {
                System.out.println("ID: " + request.getId() + ", Name: " + request.getName() + ", Age: " + request.getAge());
            }

            // Eliminar persona con el ID obtenido
            RequestCRUD.deleteRequest(idToUpdate);
        } else {
            System.out.println("No hay requests en la base de datos.");
        }
    }
}

