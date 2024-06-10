package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWorker {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "W7301@jqir#";

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public DBWorker(){
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
             return;
         }

    // Connect to the database
         try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
         }
    }

}
