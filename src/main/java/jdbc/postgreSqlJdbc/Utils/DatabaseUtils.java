package jdbc.postgreSqlJdbc.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jdbc.postgreSqlJdbc.Utils.JdbcUtils.*;


public class DatabaseUtils {


    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;
    public static ResultSetMetaData metaData;

    public static void printResultSet(String query) {
        try {
            statement = createStatement();
            resultSet = statement.executeQuery(query);

            metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(metaData.getColumnName(i) + ": " + resultSet.getObject(i) + ", ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Object> getColumnData(String query, String column) {
        resultSet = executeQuery(query);
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
    public static List<Object> getColumnData(String query, int column) {
        resultSet = executeQuery(query);
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
        resultSet = executeQuery(query);
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

    public static List<Object> getColumnList(String columnName, String tableName) {
        List<Object> columnData = new ArrayList<>();
                         //SELECT        id          FROM      students
        String query = "SELECT " + columnName + " FROM " + tableName;
        resultSet = executeQuery(query);
        try {
            while (resultSet.next()) {
                columnData.add(resultSet.getObject(columnName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columnData;
    }
    public static List<Object> getColumnList( String tableName,int columnIndex) {
        List<Object> columnData = new ArrayList<>();
        //SELECT        id          FROM      students
        String query = "SELECT " + columnIndex + " FROM " + tableName;
         resultSet = executeQuery(query);
        try {
            while (resultSet.next()) {
                columnData.add(resultSet.getObject(columnIndex));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columnData;
    }
    public static void insertDataIntoTable(String tableName, String... columnName_Value) {

        StringBuilder columnNames = new StringBuilder("");
        StringBuilder values = new StringBuilder("");

        for (String w : columnName_Value) {
            columnNames.append(w.split(" ")[0]).append(",");
            values.append(w.split(" ")[1]).append(",");
        }

        columnNames.deleteCharAt(columnNames.lastIndexOf(","));
        values.deleteCharAt(values.lastIndexOf(","));

                       //"INSERT INTO      members     ( id, name, address ) VALUES(123, 'john', 'new york')"
        String query = "INSERT INTO " + tableName + "(" + columnNames + ") VALUES(" + values + ")";

        execute(query);//execute methodu üstte oluşturuldu, query'yi çalıştırıyor.
        System.out.println("Data " + tableName + " tablosuna girildi.");

    }



    public static void createTable(String tableName, String... columnName_dataType) {
        connection = createConnection();
        statement = createStatement();
        StringBuilder columnName_dataValue = new StringBuilder("");
        for (String w : columnName_dataType) {

            columnName_dataValue.append(w).append(",");

        }

        columnName_dataValue.deleteCharAt(columnName_dataValue.length() - 1);

        try {
         statement.execute("CREATE TABLE " + tableName + "(" + columnName_dataValue + ")");
            System.out.println("Table " + tableName + " successfully created!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void dropTable(String tableName){
        execute("drop table " + tableName);
    }







}
