package DatabaseObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        Connection connection =null;
        try{
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=students;user=TestAutomation;password=TestAutomation123";
            connection = DriverManager.getConnection(connectionUrl);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
