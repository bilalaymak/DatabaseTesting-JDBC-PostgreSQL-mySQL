package jdbc.postgreSqlJdbc.practice04;

import static jdbc.postgreSqlJdbc.Utils.DatabaseUtils.*;//when we import the method as static,
import static jdbc.postgreSqlJdbc.Utils.JdbcUtils.closeConnection;
import static jdbc.postgreSqlJdbc.Utils.JdbcUtils.createConnection;
// there is no need of reference to the class name to access

public class Practice03 {
    public static void main(String[] args) {

      createConnection();

        String sql1= "select * from students";

        //get column names
        System.out.println("Column names: " + getColumnNames(sql1));
        //getColumnNames(sql1) method returns a list, so we have to print it

        //get column data
        System.out.println("id data: " +getColumnData(sql1,1));
        System.out.println("id data: " +getColumnData(sql1, "id"));//I overloaded this method in Utils
        System.out.println("name data: " +getColumnData(sql1, 2));
        System.out.println("age data: " +getColumnData(sql1, 3));
        System.out.println("gender data: " +getColumnData(sql1, 4));



        closeConnection();











    }
}
