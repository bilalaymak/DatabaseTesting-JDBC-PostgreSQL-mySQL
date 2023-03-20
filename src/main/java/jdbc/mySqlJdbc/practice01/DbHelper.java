package jdbc.mySqlJdbc.practice01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {

    private String username = "root";
    private String password = "12345";
    private String dbUrl = "jdbc:mysql://localhost:3306/practice";




    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, username, password);
    }
    public void showErrorMessage(SQLException e){
        System.out.println("error : " + e.getMessage());
        System.out.println("error code : " + e.getErrorCode());
    }


}
