import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {



    public static Connection connection;
    public static Statement statement;


    //1. step: create the connection with the database
   public static Connection connectToDatabase() {
       try {
          connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBPractice", "postgres", "12345");
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
    public static void closeConnectionStatement(){
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












}
