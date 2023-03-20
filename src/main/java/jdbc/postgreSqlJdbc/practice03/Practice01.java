package jdbc.postgreSqlJdbc.practice03;

import java.sql.*;
import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args)  {

        Scanner input = new Scanner(System.in);
        String url = "jdbc:postgresql://localhost:5432/DBPractice?serverTimezone=UTC";
        String username = "postgres";
        String password = "12345";
        System.out.println("enter your query");
        String sqlcode = input.nextLine();
       final String driver = "org.postgresql.Driver";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url,username,password);

            System.out.println("connection is successful!");

            Statement statement = connection.createStatement();
            boolean result = statement.execute(sqlcode);
            System.out.println("result = " + result);

            ResultSet resultSet = statement.executeQuery(sqlcode);
            while (resultSet.next()){
                String userData = resultSet.getString(1) + " : " +
                        resultSet.getString(2) + " : " +
                        resultSet.getString(3);
                System.out.println(userData);
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*
        connection is successful!
result = true
10001 : Ali Can : 12000
10002 : Veli Han : 2000
10003 : Mary Star : 7000
10004 : Angie Ocean : 8500

         */


    }
}
