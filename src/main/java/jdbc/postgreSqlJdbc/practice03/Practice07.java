package jdbc.postgreSqlJdbc.practice03;

import java.sql.*;

public class Practice07 {
    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:postgresql://localhost:5432/DBPractice";
        final String username = "postgres";
        final String password = "12345";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from students");

        //we use ResultSetMetaData to get datas about tables not the records

        ResultSetMetaData resultMetaData = resultSet.getMetaData();
        System.out.println("resultMetaData.getColumnName(1) = " + resultMetaData.getColumnName(1));
        //resultMetaData.getColumnName(1) = id
        System.out.println("resultMetaData.getColumnName(2) = " + resultMetaData.getColumnName(2));
        //resultMetaData.getColumnName(2) = name
        System.out.println("resultMetaData.getColumnName(3) = " + resultMetaData.getColumnName(3));
        //resultMetaData.getColumnName(3) = age

        System.out.println("resultMetaData.getTableName(4) = " + resultMetaData.getTableName(3));
        //resultMetaData.getTableName(4) = students

        System.out.println("resultMetaData.getColumnCount(1) = " + resultMetaData.getColumnCount());
        //resultMetaData.getColumnCount(1) = 3
        System.out.println("resultMetaData.getColumnDisplaySize(1) = " + resultMetaData.getColumnDisplaySize(1));
        //resultMetaData.getColumnDisplaySize(1) = 4
        System.out.println("resultMetaData.getColumnTypeName(1) = " + resultMetaData.getColumnTypeName(1));
        //resultMetaData.getColumnTypeName(1) = varchar



    }
}
