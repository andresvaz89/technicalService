package com.technicalService;

import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        
        DatabaseConnection.startServer(); 

        CreateTable.createRequestTable(); 

        // Insertar nuevas solicitudes con diferentes fechas de creación
        RequestCRUD.insertSolicitud(1, 1, "Problema con el aire acondicionado en Factoría f5", "Climatización", new Date(2024 - 1900, 9, 1), null, null, "EN_CURSO", "MEDIO");
        RequestCRUD.insertSolicitud(2, 2, "Problema de conexión a Internet en Factoría f5", "Conectividad", new Date(2024 - 1900, 9, 2), null, null, "EN_CURSO", "MEDIO");
        RequestCRUD.insertSolicitud(3, 1, "Fugas en la tubería de Factoría f5", "Plomería", new Date(2024 - 1900, 9, 3), null, null, "EN_CURSO", "BAJA");
        RequestCRUD.insertSolicitud(4, 2, "Eléctrico no funciona en Factoría f5", "Electricidad", new Date(2024 - 1900, 9, 4), null, null, "EN_CURSO", "BAJA");
        RequestCRUD.insertSolicitud(5, 1, "Problema de calefacción en la oficina", "Calefacción", new Date(2024 - 1900, 9, 5), null, null, "EN_CURSO", "MEDIO");

        // Leer todas las solicitudes
        List<Request> solicitudes = RequestCRUD.getAllSolicitudes();

        System.out.println("Solicitudes ordenadas por fecha:");
        List<Request> solicitudesOrdenadas = RequestCRUD.getSolicitudesOrdenadasPorFecha();
        for (Request solicitud : solicitudesOrdenadas) {
            System.out.println(solicitud);
        }

        // Listar solicitudes en curso
        System.out.println("Solicitudes en curso:");
        List<Request> solicitudesEnCurso = RequestCRUD.getSolicitudesEnCurso();
        for (Request solicitud : solicitudesEnCurso) {
            System.out.println("ID: " + solicitud.getIdSolicitud() + ", Descripción: " + solicitud.getDescripcion() + ", Tema: " + solicitud.getTema() + ", Estado: " + solicitud.getEstado() + ", Prioridad: " + solicitud.getPrioridad());
        }

        // Mirar si hay solicitudes antes de actualizarlas
        if (!solicitudes.isEmpty()) {
            // Obtener el ID de la primera solicitud para actualizar la prioridad
            int idPrioridadAlta = solicitudes.get(0).getIdSolicitud();  
            RequestCRUD.updateSolicitud(idPrioridadAlta, 1, 1, "Problema con el aire acondicionado en Factoría f5", "Climatización", new Date(), null, null, "EN_CURSO", "ALTA");

            // Obtener el ID de la segunda solicitud para actualizar el estado
            int idEstadoCompletado = solicitudes.get(1).getIdSolicitud();
            RequestCRUD.updateSolicitud(idEstadoCompletado, 2, 2, "Problema de conexión a Internet en Factoría f5", "Conectividad", new Date(), null, null, "COMPLETADO", "MEDIO");

            // Leer todas las solicitudes nuevamente para verificar las actualizaciones
            solicitudes = RequestCRUD.getAllSolicitudes();
            System.out.println("Lista de solicitudes después de actualizar:");
            for (Request solicitud : solicitudes) {
                System.out.println("ID: " + solicitud.getIdSolicitud() + ", Descripción: " + solicitud.getDescripcion() + ", Tema: " + solicitud.getTema() + ", Estado: " + solicitud.getEstado() + ", Prioridad: " + solicitud.getPrioridad());
            }

            // Eliminar las solicitudes actualizadas
            RequestCRUD.deleteSolicitud(idPrioridadAlta);
            RequestCRUD.deleteSolicitud(idEstadoCompletado);

            // Listar todas las solicitudes después de las eliminaciones
            solicitudes = RequestCRUD.getAllSolicitudes();
            System.out.println("Lista de solicitudes después de eliminar:");
            for (Request solicitud : solicitudes) {
                System.out.println("ID: " + solicitud.getIdSolicitud() + ", Descripción: " + solicitud.getDescripcion() + ", Tema: " + solicitud.getTema() + ", Estado: " + solicitud.getEstado() + ", Prioridad: " + solicitud.getPrioridad());
            }
        } else {
            System.out.println("No hay solicitudes en la lista.");
        }
    }
}
