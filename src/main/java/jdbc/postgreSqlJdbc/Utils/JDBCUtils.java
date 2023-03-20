package jdbc.postgreSqlJdbc.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtils {


    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;


    //1. step: create the connection with the database
    public static Connection connectToDatabase(String hostName,String databaseName,String userName,String password) {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://" + hostName + ":5432/" + databaseName, userName, password);
            System.out.println("connection is successful");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    //2. step: create statement
    public static Statement createStatement(){

        try {
            statement = connection.createStatement();
            System.out.println("statement created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;

    }

    //3. step: execute query

    public static boolean execute(String query){

        boolean result = false;
        try {
            statement.execute(query);
            System.out.println("statement executed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    //4. step: close connection and statement
    public static void closeConnection(){
        try {
            statement.close();
            connection.close();
            System.out.println("connection closed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //5. step:  Method to drop table
    public static  void dropTable(String tableName){
        try {
            statement.execute("DROP TABLE " + tableName);
            System.out.println(tableName + " dropped");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //the method to put column data into a list
    public static List<Object> getColumnList(String columnName, String tableName){
        List<Object> list = new ArrayList<>();

        String sql = "SELECT " + columnName + " FROM " + tableName;
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){

                list.add(resultSet.getObject(1));
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }










}
