package jdbc.postgreSqlJdbc.Utils;

import java.sql.*;

public class JdbcUtils {

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    //create connection 1
    public static Connection createConnection() {
        String url = "jdbc:postgresql://localhost:5432/DBPractice";
        String username = "postgres";
        String password = "12345";
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //create connection 2
    public static Connection createConnection(String hostName, String dbName, String username, String password) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://" + hostName + ":5432/" + dbName, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (connection != null) {
            System.out.println("Connection Success");
        } else {
            System.out.println("Connection Fail");
        }
        return connection;
    }

    //create statement
    public static Statement createStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }

    //execute
    public static boolean execute(String sql) {
        boolean isExecute;
        try {
            isExecute = statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isExecute;
    }
    //execute query
    public static ResultSet executeQuery(String query) {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return resultSet;
    }

    //executeUpdate
    public static int executeUpdate(String query) {
        int updatedRows;

        try {
            updatedRows = statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return updatedRows;
    }


    //close connection
    public static void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }













}
