package jdbc.postgreSqlJdbc.practice03;

import java.sql.*;

public class Practice02 {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/DBPractice?serverTimezone=UTC";
        String username = "postgres";
        String password = "12345";
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery("select * from workers");
            while (resultSet.next()){
                System.out.println(
                        resultSet.getString(1) + " : " +
                        resultSet.getString(2) + " : " +
                        resultSet.getString(3)
                );
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        /*
10001 : Ali Can : 12000
10002 : Veli Han : 2000
10003 : Mary Star : 7000
10004 : Angie Ocean : 8500
         */

    }
}
