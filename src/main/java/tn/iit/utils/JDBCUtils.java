package tn.iit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_prof";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");

            // Establish the database connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Database connection successful");
            System.out.flush(); // Flush the output buffer

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to establish database connection: " + e.getMessage());
            e.printStackTrace();

            System.out.flush(); // Flush the output buffer

        }
        return connection;
    }
   
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
