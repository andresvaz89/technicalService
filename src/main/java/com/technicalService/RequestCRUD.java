package com.technicalService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestCRUD {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
    }
}


