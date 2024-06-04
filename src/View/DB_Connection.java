package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DB_Connection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/patient_management_system";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";
    
    public static Connection ConnectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public static void main(String[] args) {
        Connection connection = ConnectDB();
        if (connection != null) {
            try {
                // Perform database operations
                // ...

                // Close the connection
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    static Object getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
