package com.technicalService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TechnicianTable {
    public static void createTechnicianTable() {
        String sql = "CREATE TABLE IF NOT EXISTS tecnico ("
                + "ID_tecnico INT AUTO_INCREMENT PRIMARY KEY,"
                + "ID_solicitud INT FOREIGN KEY"
                + "name VARCHAR(255) NOT NULL,"
                + "apellido INT NOT NULL)";

        try (Connection connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'tecnico' creado exitosamente :)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkTableExists() {
        String sql = "SELECT * FROM tecnico";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet result = pstmt.executeQuery();
            System.out.println("La tabla 'tecnico' existe y contiene datos:");
            while (result.next()) {
                System.out.println("ID_Solicitud: " + result.getInt("ID_Solcitud") +
                                    "Descripción: " + result.getString("Descripcion") +
                                    "Tema: " + result.getString("tema") +
                                    "Fecha de creacion: " + result.getDate("Fecha_Creacion") +
                                    "Fecha de completado: " + result.getDate("Fecha_Completado") +
                                    "Prioridad: " + result.getString("Prioridad"));
            }
        } catch (SQLException e) {
            System.out.println("La tabla 'persons' no existe.");
        }
    }
}
