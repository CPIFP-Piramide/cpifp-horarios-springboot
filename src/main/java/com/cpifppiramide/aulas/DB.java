package com.cpifppiramide.aulas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DB {
    public static Connection connect() throws SQLException {

        try {
            // Get database credentials from DatabaseConfig class
            var jdbcUrl = "jdbc:postgresql://localhost:5432/cpifp-aulas";
            var user = "postgres";
            var password = "postgres";

            // Open a connection
            return DriverManager.getConnection(jdbcUrl, user, password);

        } catch (SQLException  e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}