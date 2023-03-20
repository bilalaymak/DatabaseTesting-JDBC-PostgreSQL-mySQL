package jdbc.postgreSqlJdbc.practice03;

import java.sql.*;

public class Practice05 {
    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:postgresql://localhost:5432/DBPractice";
        final String username = "postgres";
        final String password = "12345";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();

        //get "country_name"s whose id is 1
        String sql = "select country_name from countries where region_id = 1";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        System.out.println("************************");
        //get "country_id" and "country_name" whose region_id is greater than 2
        String sql2 = "select country_id,country_name from countries where region_id >2";
        ResultSet rs2 = statement.executeQuery(sql2);
        while (rs2.next()) {
            System.out.println(
                    rs2.getString(1) + " : " +
                    rs2.getString(2)
            );
        }



        statement.close();
        connection.close();













    }
}
