import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBPractice", "postgres", "12345");
        Statement statement = connection.createStatement();

        //--1.Example: Update the number of employees to 9999
        // if the company name is IBM by using prepared statement
        //1. step: create prepared statement query
        String sql1 = "UPDATE companies SET number_of_employees = ? WHERE company = ?";

        //2. step: create prepared statement object
        PreparedStatement ps1 = connection.prepareStatement(sql1);

        //3. step: assign the values by using setInt() setString() methods etc.

        ps1.setInt(1,9999);
        ps1.setString(2,"IBM");

        //4. step: execute the query for update
        int numOfRows = ps1.executeUpdate();
        System.out.println("updated : " + numOfRows);
        String sql2 = "select * from companies";

        //5. step : display the result

        Statement statement1 = connection.createStatement();
        ResultSet rs2 = statement1.executeQuery(sql2);

        while (rs2.next()){
            System.out.println(
                    rs2.getInt(1) + " : " +
                    rs2.getString(2) + " : " +
                    rs2.getInt(3)
            );
        }

          statement1.close();
          statement.close();
          connection.close();












    }
}
