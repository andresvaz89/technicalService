package com.technicalService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class RequestCRUD {
<<<<<<< HEAD
    // Insertar una request en la base de datos
    public static void insertSolicitud(String name, int age) {
        String sql = "INSERT INTO solicitudes (name, age) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.executeUpdate();
            System.out.println("Solicitud creada correctamente: " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener todas las requests de la base de datos
    public static List<Request> getAllSolicitudes() {
        List<Request> solicitudes = new ArrayList<>();
        String sql = "SELECT * FROM solicitudes";
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int ID_Solicitud = rs.getInt("ID_Solicitud");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                solicitudes.add(new Request(ID_Solicitud, name, age));
            }
            System.out.println("Todas las solicitudes recuperadas: " + solicitudes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return solicitudes;
    }

    // Actualizar una request en la base de datos
    public static void updateSolicitud(int ID_Solicitud, String name, int age) {
        String sql = "UPDATE solicitudes SET name = ?, age = ? WHERE ID_Solicitud = ?";
    
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, ID_Solicitud);
    
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Solicitudes con ID " + ID_Solicitud + " actualizadas correctamente.");
                System.out.println("New values: Name = " + name + ", Age = " + age);
            } else {
                System.out.println("No se encontaron solicitudes con el ID_Solicitud " + ID_Solicitud + " para actualizar.");
=======
    private static List<Request> solicitudes = new ArrayList<>(); // In-memory storage

    // Insertar una solicitud
    public static void insertSolicitud(int ID_Tecnico, int ID_Cliente, String descripcion, String tema, 
                                       Date fechaCreacion, Date fechaCompletado, Date fechaAsistencia, 
                                       String estado, String prioridad) {
        int ID_Solicitud = solicitudes.size() + 1;
        Request newRequest = new Request(ID_Solicitud, ID_Tecnico, ID_Cliente, descripcion, tema, 
                                         fechaCreacion, fechaCompletado, fechaAsistencia, estado, prioridad);
        solicitudes.add(newRequest);
        System.out.println("Solicitud creada correctamente: " + newRequest);
    }

    // Obtener todas las solicitudes
    public static List<Request> getAllSolicitudes() {
        return new ArrayList<>(solicitudes); // Return a copy of the list
    }

    // Obtener las solicitudes del cliente
    public static List<Request> getSolicitudesCliente(int ID_Cliente) {
            
        return solicitudes.stream()
        .filter(request -> request.getIdCliente() == ID_Cliente)
        .collect(Collectors.toList());
    
         
 }

    // Actualizar una solicitud
    public static void updateSolicitud(int ID_Solicitud, int ID_Tecnico, int ID_Cliente, String descripcion, 
                                       String tema, Date fechaCreacion, Date fechaCompletado, Date fechaAsistencia, 
                                       String estado, String prioridad) {
        for (Request request : solicitudes) {
            if (request.getIdSolicitud() == ID_Solicitud) {
                request.setIdTecnico(ID_Tecnico);
                request.setIdCliente(ID_Cliente);
                request.setDescripcion(descripcion);
                request.setTema(tema);

                // Verificar si el estado ha cambiado a "FINALIZADA"
                if (!request.getEstado().equals("FINALIZADA") && estado.equals("FINALIZADA")) {
                    request.setFechaCompletado(new Date()); // Registrar la fecha de completado
                }
                
                // Verificar si la prioridad ha cambiado de "NINGUNA" a "ALTO", "MEDIO" o "BAJA"
                if (request.getPrioridad().equals("NINGUNA") && !prioridad.equals("NINGUNA")) {
                    request.setFechaAsistencia(new Date()); // Registrar la fecha de asistencia
                }

                request.setEstado(estado);
                request.setPrioridad(prioridad);
                System.out.println("Solicitud actualizada correctamente: " + request);
                return;
>>>>>>> dev
            }
        }
        System.out.println("No se encontró la solicitud con ID: " + ID_Solicitud);
    }

<<<<<<< HEAD
    // Eliminar una request de la base de datos
    public static void deleteSolicitud(int ID_Solicitud) {
        String sql = "DELETE FROM solicitudes WHERE ID_Solicitud= ?";
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1,  ID_Solicitud);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Solicitud eliminada: " + ID_Solicitud);
            } else {
                System.out.println("Solicitud no encontrada para el ID_Solicitud: " + ID_Solicitud);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
=======
    // Eliminar una solicitud
    public static void deleteSolicitud(int ID_Solicitud) {
        solicitudes.removeIf(request -> request.getIdSolicitud() == ID_Solicitud);
        System.out.println("Solicitud eliminada con ID: " + ID_Solicitud);
    }

    //Eliminar una solicitud de un cliente
    public static void deleteSolicitud(int ID_Solicitud,int ID_Cliente) {
        solicitudes.removeIf(request -> request.getIdSolicitud() == ID_Solicitud);
        solicitudes.removeIf(request -> request.getIdCliente() == ID_Cliente);

        System.out.println("Solicitud del cliente eliminada con ID "  + ID_Solicitud);
>>>>>>> dev
    }


    // Listar solicitudes ordenadas por fecha de creación de forma ascendente
    public static List<Request> getSolicitudesOrdenadasPorFecha() {
        return solicitudes.stream()
                .sorted((r1, r2) -> r1.getFechaCreacion().compareTo(r2.getFechaCreacion()))
                .collect(Collectors.toList());
    }

    // Listar solicitudes con estado "EN_CURSO"
    public static List<Request> getSolicitudesEnCurso() {
        return solicitudes.stream()
                .filter(request -> request.getEstado().equals("EN_CURSO"))
                .collect(Collectors.toList());
    }
}