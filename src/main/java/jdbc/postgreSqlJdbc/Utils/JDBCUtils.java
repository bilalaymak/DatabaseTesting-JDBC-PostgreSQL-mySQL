package jdbc.postgreSqlJdbc.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class JDBCUtils {


    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static String query;


    //1. step: create the connection with the database
    public static Connection createConnection(String hostName, String databaseName, String userName, String password) {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://" + hostName + ":5432/" + databaseName, userName, password);
            System.out.println("connection is successful");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    //I overloaded the connectToDatabase() method
    public static Connection createConnection(){
        String url = "jdbc:postgresql://localhost:5432/DBPractice";
        String userName = "postgres";
        String password = "12345";
        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("connection is successful");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    //getConnection method To create the Connection object.
    //Unlike createConnection, this method returns a connection object.
    public static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/DBPractice";
        String username = "postgres";
        String password = "12345";
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //2. step: create statement
    public static Statement createStatement(){

        try {
            connection.createStatement();
            System.out.println("statement created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;

    }
    public static Statement getStatement() {
        try {
            connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    //3. step: execute query

    public static boolean execute(String query){

        boolean isExecute = false;
        try {
            statement.execute(query);
            System.out.println("statement executed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isExecute;
    }
    public static void executeQuery(String query) {
        try {
            connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //getResultset method To create the Resultset object.
    public static ResultSet getResultset() {
        try {
            connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    //4. step: close connection and statement

    public static void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
                System.out.println("resultSet closed");
            }
            if (statement != null) {
                statement.close();
                System.out.println("statement closed");
            }
            if (connection != null) {
                connection.close();
                System.out.println("connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    public static void closeConnection(){
        try {
            statement.close();
            connection.close();
            System.out.println("connection closed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
     */



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

    public static List<Object> getColumnData(String query, String column) {
        executeQuery(query);
        List<Object> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                rowList.add(resultSet.getObject(column));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowList;
    }
    public static List<String> getColumnNames(String query) {
        executeQuery(query);
        List<String> columns = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columns.add(rsmd.getColumnName(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columns;
    }








}
