package jdbc.postgreSqlJdbc.practice04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Practice02 {
    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:postgresql://localhost:5432/DBPractice";
        final String username = "postgres";
        final String password = "12345";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();

        String sqlDrop = "drop table doctors";
        statement.execute(sqlDrop);














    }
}
