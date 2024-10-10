package com.technicalService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RequestTable {
    public static void createRequestTable() {
        String sql = "CREATE TABLE IF NOT EXISTS solicitudes ("
                + "ID_Solicitud INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(255) NOT NULL,"
                + "age INT NOT NULL)";

        try (Connection connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'solicitudes' created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkTableExists() {
        String sql = "SELECT * FROM solicitudes";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            System.out.println("La tabla 'solicitudes' existe y contiene datos:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID_Solicitud") + ", Name: " + rs.getString("name") + ", Age: " + rs.getInt("age"));
            }
        } catch (SQLException e) {
            System.out.println("La tabla 'solicitudes' no existe.");
        }
    }
}

