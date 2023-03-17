package jdbc.postgreSqlJdbc.practice05;

import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws SQLException {

        //1. Step: get the connection to database
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBPractice", "postgres", "12345");

        //2. Step: send the query
        Statement statement = connection.createStatement();
        String sql1 ="UPDATE companies\n" +
                "SET number_of_employees = 16000\n" +
                "WHERE number_of_employees < (SELECT AVG(number_of_employees) FROM companies);";

        //3. Step: receive the resultSet
        int numOfRows =  statement.executeUpdate(sql1);
        System.out.println("number of rows : " + numOfRows);

        String sql2 = "select * from companies";
        ResultSet resultSet1 = statement.executeQuery(sql2);

        while (resultSet1.next()){
            System.out.println(
                    resultSet1.getObject(1) + " " +
                    resultSet1.getObject(2) + " " +
                    resultSet1.getObject(3));
        }











    }
}
