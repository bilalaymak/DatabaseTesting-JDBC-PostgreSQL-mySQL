package jdbc.postgreSqlJdbc.practice03;

import java.sql.*;

public class Practice08 {
    public static void main(String[] args) throws SQLException {

        //add a new record to students table (300,'Sena Canturk',21,'K')
        final String url = "jdbc:postgresql://localhost:5432/DBPractice";
        final String username = "postgres";
        final String password = "12345";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();

        // Delete any existing record with name 'Sena Canturk'
        String sqlDelete = "delete from students where name = 'Sena Canturk'";
        statement.execute(sqlDelete);

        //we use executeUpdate() method to update one or more datas in the table

        // Insert a new record with student ID 300, name 'Sena Canturk', age 21, and gender 'F'
        String sqlInsert = "insert into students values (300, 'Sena Canturk', 21, 'F')";
        statement.execute(sqlInsert);

        String sqlUpdate1 = "update students set gender = 'M' where id = '1000' and name not in ('Meltem Can', 'Nazan Yaman')";
        statement.executeUpdate(sqlUpdate1);

        String sqlUpdate2 = "update students set gender = 'F' WHERE gender != 'M'";
        statement.executeUpdate(sqlUpdate2);

        String sqlUpdate3 = "update students set gender = 'F' where name in('Nazan Yaman','Meltem Can')";
        statement.executeUpdate(sqlUpdate3);

        //insert many records into students table

        //1. way:
        String[] newRecords ={
                "insert into students values (1001, 'Eymen Ali', 23, 'M')",
                "insert into students values (1002, 'Furkan Yilmaz', 27, 'M')",
                "insert into students values (1003, 'Ayse Gunduz', 24, 'F')"};
        int count = 0;
        for (String w: newRecords){
           count = count + statement.executeUpdate(w);
        }
        System.out.println(count + " data added to database");

        //2. way:
        String[] newRecords2 ={
                "insert into students values (1004, 'Eymen Yilmaz', 23, 'M')",
                "insert into students values (1005, 'Furkan Guney', 27, 'M')",
                "insert into students values (1006, 'Ayse Kaplan', 24, 'F')"};
        for (String w: newRecords2){
            statement.addBatch(w); //merges all datas above
        }
        statement.executeBatch(); //sends all the datas at once


        //Retrieve all records from the students table and print them out
        ResultSet resultSet = statement.executeQuery("select * from students");
        while (resultSet.next()){
            System.out.println(
                    resultSet.getString(1) + " : "+
                    resultSet.getString(2) + " : "+
                    resultSet.getString(3) + " : "+
                    resultSet.getString(4)
            );
        }

        connection.close();
        statement.close();














    }
}
