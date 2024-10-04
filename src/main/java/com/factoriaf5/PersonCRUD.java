package com.factoriaf5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonCRUD {
    // Insertar una persona en la base de datos
    public static void insertPerson(String name, int age) {
        String sql = "INSERT INTO persons (name, age) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.executeUpdate();
            System.out.println("Persona insertada: " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener todas las personas de la base de datos
    public static List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        String sql = "SELECT * FROM persons";
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                persons.add(new Person(id, name, age));
            }
            System.out.println("Todas las personas recuperadas: " + persons);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    // Actualizar una persona en la base de datos
    public static void updatePerson(int id, String name, int age) {
        String sql = "UPDATE persons SET name = ?, age = ? WHERE id = ?";
    
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);
    
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Person with ID " + id + " updated successfully.");
                System.out.println("New values: Name = " + name + ", Age = " + age);
            } else {
                System.out.println("No person found with ID " + id + " to update.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar una persona de la base de datos
    public static void deletePerson(int id) {
        String sql = "DELETE FROM persons WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Persona eliminada: " + id);
            } else {
                System.out.println("Persona no encontrada para el ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


