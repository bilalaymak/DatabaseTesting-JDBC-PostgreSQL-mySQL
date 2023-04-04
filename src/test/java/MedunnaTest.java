import jdbc.postgreSqlJdbc.Utils.DatabaseUtils;
import jdbc.postgreSqlJdbc.Utils.JdbcUtils;
import org.junit.Assert;
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
     Verify that there are some rooms created by "john_doe".

   And
     User closes the connection
  */

     @Test
    public void medunnaTest(){

         // User connects to the database
         JdbcUtils.createConnection("medunna.com","medunna_db","medunna_user","medunna_pass_987");
         Statement statement = JdbcUtils.createStatement();
         //we use statement to send SQL commands to the database
         //to send our commands collective we use preparedStatement

         //User sends the query to get the names of created_by column from "room" table
         List<Object> objectList = DatabaseUtils.getColumnList("created_by","room");
         System.out.println("objectList = " + objectList);

         //Verify that there are some rooms created by "john doe".
         objectList.
                 stream().
                 filter(obj -> obj.equals("john_doe")).
                 findAny().
                 ifPresentOrElse(
                 (obj) -> System.out.println("At least one room created by John Doe."),
                 () -> System.out.println("No rooms created by John Doe.")
         );
         Assert.assertTrue("no records found in database",objectList.contains("john_doe"));

         JdbcUtils.closeConnection();//No rooms created by John Doe.




     }




}
