package com.technicalService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestCRUD {
    // Insertar una request en la base de datos
    public static void insertRequest(String name, int age) {
        String sql = "INSERT INTO requests (name, age) VALUES (?, ?)";
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
    public static List<Request> getAllRequests() {
        List<Request> requests = new ArrayList<>();
        String sql = "SELECT * FROM requests";
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                requests.add(new Request(id, name, age));
            }
            System.out.println("Todas las personas recuperadas: " + requests);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    // Actualizar una request en la base de datos
    public static void updateRequest(int id, String name, int age) {
        String sql = "UPDATE requests SET name = ?, age = ? WHERE id = ?";
    
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);
    
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Request with ID " + id + " updated successfully.");
                System.out.println("New values: Name = " + name + ", Age = " + age);
            } else {
                System.out.println("No request found with ID " + id + " to update.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar una request de la base de datos
    public static void deleteRequest(int id) {
        String sql = "DELETE FROM requests WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Request eliminada: " + id);
            } else {
                System.out.println("Request no encontrada para el ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


