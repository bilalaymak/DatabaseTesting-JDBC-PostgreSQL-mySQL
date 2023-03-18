package jdbc.postgreSqlJdbc.practice07;

import java.sql.*;

public class Practice04 {
    public static void main(String[] args) throws SQLException {
        final String url = "jdbc:postgresql://localhost:5432/DBPractice?serverTimezone=UTC";
        final String username = "postgres";
        final String password = "12345";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();

        //question 1:
        String sql1 = "create table workers(id smallint,field varchar(20), salary int)";
        statement.execute(sql1);
        System.out.println("workers table created");





        ResultSet resultSet = statement.executeQuery("select * from school");
        while (resultSet.next()) {
            System.out.printf("%-6s %-10s %-12s %-12s %-12s\n",
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
        }

















    }
}
