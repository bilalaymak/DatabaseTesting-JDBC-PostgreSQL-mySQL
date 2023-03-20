package jdbc.postgreSqlJdbc.practice03;

import java.sql.*;

public class Practice03 {
    public static void main(String[] args) {
        final String url = "jdbc:postgresql://localhost:5432/DBPractice?serverTimezone=UTC";
        final String username = "postgres";
        final String password = "12345";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from school");

            //example 1:
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString(1) + " \t " +//\t add one tab space between returns
                                resultSet.getString(2) + " \t " +
                                resultSet.getString(3)
                );
            }
/*
120 	 Male    	 Ahmet Yaman
121 	 Male    	 Mehmet Can
122 	 Female  	 Meltem Atalay
123 	 Male    	 Bilal Aymak
124 	 Female  	 Meryem Yildiz
********************
*/
            System.out.println("********************");

            //example2:
            //get the male studentNames in the school table
            ResultSet resultSet1 = statement.executeQuery("select * from school " +
                    "where gender = 'Male'");
            while (resultSet1.next()) {
/* %-6d: A left-justified integer with a width of 6 characters.
   %-15s: A left-justified string with a minimum width of 15 characters
  and a maximum width of 15 characters.
  %-8s: A left-justified string with a width of 8 characters.
  %-8s: Another left-justified string with a width of 8 characters.
*/
                System.out.printf("%-6s %-10s %-12s %-12s %-12s\n",
                        resultSet1.getInt(1),
                        resultSet1.getString(2),
                        resultSet1.getString(3),
                        resultSet1.getString(4),
                        resultSet1.getString(5)
                );
            }

/*
120    Male       Ahmet Yaman  Istanbul     59
121    Male       Mehmet Can   Ankara       57
123    Male       Bilal Aymak  Izmir        76
 */

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }




    }
}
