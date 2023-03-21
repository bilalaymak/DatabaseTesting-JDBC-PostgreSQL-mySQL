package jdbc.postgreSqlJdbc.practice03;

import java.sql.*;

public class Practice09 {
    public static void main(String[] args) throws SQLException {
        final String url = "jdbc:postgresql://localhost:5432/DBPractice";
        final String username = "postgres";
        final String password = "12345";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();

        //when we use createStatement(), in every creation database memory allocate a new place for this,
        //so usually using createStatement() is memory-consuming,thus, we use preparedStatement to handle it
        //preparedStatement() allocate just one place in memory for same statements
        PreparedStatement preparedStatement = connection.prepareStatement("insert into students values (?,?,?,?)");
        preparedStatement.setInt(1,1007);
        preparedStatement.setString(2,"Ahmet Yilmaz");
        preparedStatement.setInt(3,25);
        preparedStatement.setString(4,"M");
        //setString() or setInt() methods updates just preparedStatement, not send the datas to database

        preparedStatement.executeUpdate();//it is necessary to send the datas to the table

        preparedStatement.close();
        connection.close();





    }
}
