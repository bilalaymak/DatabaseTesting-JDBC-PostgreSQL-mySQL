package jdbc.postgreSqlJdbc.practice05;

import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/DBPractice", "postgres", "12345");
        Statement statement = connection.createStatement();

        String sql1 = "SELECT country_name FROM countries WHERE region_id = 1";
        boolean r1 = statement.execute(sql1);
        System.out.println("r1 = " + r1);//true
        //in dql it returns true
        //in dml it returns false

        //to see the records we have another method which is called executeQuery();


        ResultSet resultSet1 = statement.executeQuery(sql1);
//        resultSet1.next();
//        resultSet1.next();
//        resultSet1.next();
//        resultSet1.next();
//        System.out.println(resultSet1.getString("country_name"));//Denmark

        while (resultSet1.next()){
            System.out.println(resultSet1.getString(1));
        }

        System.out.println("********************");
        //2.Example: Select the country_id and country_name whose region_id's are greater than 2

        String sql2 = "select country_id, country_name from countries where region_id > 2";

        ResultSet resultSet2 = statement.executeQuery(sql2);
        while (resultSet2.next()){
            System.out.println(resultSet2.getString(1) + " : " + resultSet2.getString(2) );
        }

        System.out.println("*-********************************");

        //3.Example: Select all columns whose number_of_employees is the lowest from companies table
        String sql3 = "select * from companies where number_of_employees = (select min(number_of_employees) from companies)";
        ResultSet resultSet3 = statement.executeQuery(sql3);
        while (resultSet3.next()){
            System.out.println(
                    resultSet3.getObject(1) + " : " +
                    resultSet3.getObject(2) + " : " +
                    resultSet3.getObject(3) );
        }








    }
}
