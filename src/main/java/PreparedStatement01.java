import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBPractice", "postgres", "12345");
        Statement statement = connection.createStatement();

        //--1.Example: Update the number of employees to 9999
        // if the company name is IBM by using prepared statement
        //1. step: create prepared statement query
        String sql1 = " update companies\n" +
                " set number_of_employees =?/\n" +
                " where company = ?";

        //2. step: create prepared statement object
        PreparedStatement ps1 = connection.prepareStatement(sql1);

        //3. step: assign the values by using setInt() setString() methods etc.

        ps1.setInt(1,9999);
        ps1.setString(2,"IBM");













    }
}
