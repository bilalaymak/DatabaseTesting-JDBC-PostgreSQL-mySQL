package jdbc.postgreSqlJdbc.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jdbc.postgreSqlJdbc.Utils.JDBCUtils.execute;
import static jdbc.postgreSqlJdbc.Utils.JDBCUtils.executeQuery;

public class DatabaseUtils {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static String query;
    private static PreparedStatement preparedStatement;

    //Method to drop table
    public static  void dropTable(String tableName){
        try {
            statement.execute("DROP TABLE " + tableName);
            System.out.println(tableName + " dropped");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //create table
    public static void createTable(String tableName, String... columnName_dataType) {
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
    //ExecuteUpdate() method
    public static int executeUpdate(String query) {
        int updatedRowCount = 0;

        try {
            updatedRowCount = statement.executeUpdate(query);
            System.out.println(updatedRowCount + " row(s) updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return updatedRowCount;
    }

    //insert into table
    public static void insertDataIntoTable(String tableName, String... columnName_Value) {

        StringBuilder columnNames = new StringBuilder("");
        StringBuilder values = new StringBuilder("");
        for (String w : columnName_Value) {
            //I split a String value and get first column name and second column value.
            columnNames.append(w.split(" ")[0]).append(",");
            values.append(w.split(" ")[1]).append(",");
        }
        columnNames.deleteCharAt(columnNames.lastIndexOf(","));//deletes the last comma(,)
        values.deleteCharAt(values.lastIndexOf(","));
        //"insert into members ( id, name, address ) values(123, 'john', 'new york')"
        String query = "INSERT INTO " + tableName + "(" + columnNames + ") VALUES(" + values + ")";
        execute(query);
        System.out.println("Data added to " + tableName);
    }

    //delete data from table
    public static void deleteData(int id){
        try {
            String sq1 = "delete from workers where id = ?;";
            connection.prepareStatement(sq1);
            preparedStatement.setInt(1, id);

            int resultOfUpdate = preparedStatement.executeUpdate();
            System.out.println("data is deleted : " + resultOfUpdate);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    //Method that takes Column Values into List
    public static List<Object> getColumnList( String tableName,String columnName) {

        List<Object> columnData = new ArrayList<>();//List to put data from ResultSet.

                      //select        id          FROM      students
        String query = "SELECT " + columnName + " FROM " + tableName;

        executeQuery(query);// we called our JDBCUtils executeQuery() method

        try {
            while (resultSet.next()) {
                columnData.add(resultSet.getObject(columnName));
                //It adds the column values received with the add method to the List.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return columnData;
    }

    //get results in a map
    public static List<Map<String, Object>> getQueryResultMap(String query) {
        executeQuery(query);
        List<Map<String, Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> colNameValueMap = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    colNameValueMap.put(rsmd.getColumnName(i), resultSet.getObject(i));
                }
                rowList.add(colNameValueMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowList;
    }

    public static List<List<Object>> getQueryResultList(String query) {
        executeQuery(query);
        List<List<Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                List<Object> row = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row.add(resultSet.getObject(i));
                }
                rowList.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowList;
    }

    public static Object getCellValue(String query) {
        return getQueryResultList(query).get(0).get(0);
    }

    public static List<Object> getRowList(String query) {
        return getQueryResultList(query).get(0);
    }


    public static Map<String, Object> getRowMap(String query) {
        return getQueryResultMap(query).get(0);
    }

    //How many rows are in the table
    public static int getRowCount() throws Exception {
        resultSet.last();
        int rowCount = resultSet.getRow();
        return rowCount;
    }


















}
