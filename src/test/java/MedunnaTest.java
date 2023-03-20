import jdbc.postgreSqlJdbc.Utils.JDBCUtils;
import org.junit.Test;

import java.sql.Statement;
import java.util.List;

public class MedunnaTest {
    /*
   Given
     User connects to the database
     (Host name: medunna.com, Database name: medunna_db, Usename: medunna_user, Password: medunna_pass_987))

   When
     User sends the query to get the names of created_by column from "room" table

   Then
     Verify that there are some rooms created by "john doe".

   And
     User closes the connection
  */

     @Test
    public void medunnaTest(){

         // User connects to the database
         JDBCUtils.connectToDatabase("medunna.com","medunna_db","medunna_user","medunna_pass_987");
         Statement statement = JDBCUtils.createStatement();

         //User sends the query to get the names of created_by column from "room" table
         List<Object> objectList = JDBCUtils.getColumnList("created_by","room");
         System.out.println("objectList = " + objectList);

         //Verify that there are some rooms created by "john doe".
         objectList.
                 stream().
                 filter(obj -> obj.equals("john doe")).
                 findAny().
                 ifPresentOrElse(
                 (obj) -> System.out.println("At least one room created by John Doe."),
                 () -> System.out.println("No rooms created by John Doe.")

         );
         JDBCUtils.closeConnection();//No rooms created by John Doe.




     }



}
