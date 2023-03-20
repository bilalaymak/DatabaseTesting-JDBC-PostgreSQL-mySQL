import jdbc.postgreSqlJdbc.Utils.JDBCUtils;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class CountriesTestJunit {


       /*
 Given
   User connects to the database
 When
   User sends the query to get the region ids from "countries" table
 Then
   Verify that the number of region ids greater than 1 is 17.
 And
   User closes the connection
*/


    @Test
    public void countryTest(){
        // User connects to the database
        JDBCUtils.connectToDatabase("localhost","DBPractice","postgres","12345");
        JDBCUtils.createStatement();

        // User sends the query to get the region ids from "countries" table
        List<Object> list = JDBCUtils.getColumnList("region_id","countries");
        System.out.println("the list is " + list);
        //Verify that the number of region ids greater than 1 is 17.
        int listSize = list.stream().filter(t-> (int) t>1).collect(Collectors.toList()).size();
        System.out.println("the list size is : " + listSize);

        assertEquals(17,listSize);

        //user closes the connection
        JDBCUtils.closeConnection();

    }





}