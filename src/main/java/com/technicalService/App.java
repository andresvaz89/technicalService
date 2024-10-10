package com.technicalService;

import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        
         DatabaseConnection.startServer(); 

        
         CreateTable.createRequestTable(); 

<<<<<<< HEAD
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
=======
        // Insertar nuevas solicitudes
        RequestCRUD.insertSolicitud(1, 1, "Problema con el aire acondicionado en Factoría f5", "Climatización", new Date(), null, null, "EN_CURSO", "ALTO");
        RequestCRUD.insertSolicitud(2, 2, "Problema de conexión a Internet en Factoría f5", "Conectividad", new Date(), null, null, "EN_CURSO", "MEDIO");

        // Leer todas las solicitudes
        List<Request> solicitudes = RequestCRUD.getAllSolicitudes();

        System.out.println("Solicitudes en ordenadas por fecha");// Obtener solicitudes en curso
        List<Request> solicitudesOrdenadas = RequestCRUD.getSolicitudesOrdenadasPorFecha();
for (Request solicitud : solicitudesOrdenadas) {
    System.out.println(solicitud);
}

System.out.println("Solicitudes en curso");// Listar las solicitudes que estén en curso
List<Request> solicitudesEnCurso = RequestCRUD.getSolicitudesEnCurso();
for (Request solicitud : solicitudesEnCurso) {
    System.out.println(solicitud);
}

        // Mirar si hay solicitudes antes de ordenarla
        if (!solicitudes.isEmpty()) {
            // Obtener el ID de la primera solicitud
            int idToUpdate = solicitudes.get(0).getIdSolicitud();  // Obtener el ID de la primera solicitud

            // Actualizar la solicitud con el ID obtenido
            RequestCRUD.updateSolicitud(idToUpdate, 1, 1, "Problema de calefacción", "Calefacción", new Date(), null, null, "FINALIZADA", "BAJA");

            // Leer todas las solicitudes nuevamente para verificar la actualización
            solicitudes = RequestCRUD.getAllSolicitudes();
            System.out.println("Lista de solicitudes después de actualizar:");
            for (Request solicitud : solicitudes) {
                System.out.println("ID: " + solicitud.getIdSolicitud() + ", Descripción: " + solicitud.getDescripcion() + ", Tema: " + solicitud.getTema());
            }

            // Eliminar la solicitud con el ID obtenido
            RequestCRUD.deleteSolicitud(idToUpdate);
        } else {
            System.out.println("No hay solicitudes en la lista.");
        }
    }
}
>>>>>>> 56edef34842e574d5ceff1b08f1061d33dca7c39
