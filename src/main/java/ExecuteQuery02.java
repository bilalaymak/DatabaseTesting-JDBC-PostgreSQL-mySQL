import java.sql.*;

public class ExecuteQuery02 {
    public static void main(String[] args) throws SQLException {


        //1. Step: get the connection to database
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBPractice", "postgres", "12345");


        //2. Step: send the query
        Statement statement = connection.createStatement();
        String sql1 = "SELECT company, number_of_employees\n" +
                "FROM companies\n" +
                "ORDER BY number_of_employees DESC\n" +
                "OFFSET 1 ROW\n" +
                "LIMIT 1\n";

        //3. Step: receive the resultSet
        //1.Example: Find the company and number_of_employees
        // whose number_of_employees is the second highest from the companies table

        //1. way:
        ResultSet resultSet1 =  statement.executeQuery(sql1);
        while (resultSet1.next()){
            System.out.println(resultSet1.getString(1)+ " - " + resultSet1.getInt(2));
        }
        System.out.println("*************************");
        //2. way:
        String sql2 = "SELECT company, number_of_employees\n" +
                "FROM companies\n" +
                "WHERE number_of_employees= (SELECT MAX(number_of_employees)\n" +
                "FROM companies\n" +
                "WHERE number_of_employees < (SELECT MAX(number_of_employees)\n" +
                "FROM companies));";
        ResultSet resultSet2 =  statement.executeQuery(sql2);
        while (resultSet2.next()){
            System.out.println(resultSet2.getString(1)+ " - " + resultSet2.getInt(2));
        }


        //2.Example: Find the company names and number of employees
        // whose number of employees is less than the average number of employees
        String sql3 = "select company, number_of_employees from companies\n" +
                "where number_of_employees < (select avg(number_of_employees) from companies)";
        ResultSet resultSet3 =  statement.executeQuery(sql3);
        while (resultSet3.next()){
            System.out.println(resultSet3.getString(1)+ " : " + resultSet3.getInt(2));
        }









    }
}
