import jdbc.postgreSqlJdbc.Utils.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountriesTest {



    public static void main(String[] args) throws SQLException {


  //      User connects to the database
        JdbcUtils.createConnection();
        JdbcUtils.createStatement();
 //      User sends the query to get the region ids from "countries" table
        String sql1 = "select region_id from countries";
        ResultSet resultSet = JdbcUtils.statement.executeQuery(sql1);

        List<Integer> list = new ArrayList<>();
        while (resultSet.next()){
            list.add(resultSet.getInt(1));
        }
        System.out.println("list of region ids : " + list);

//        Verify that the number of region ids greater than 1 is 17.

        int counter = 0;
        for (int w: list){
            if (w>1){
                counter++;
            }
        }

        System.out.println("counter value is " + counter);//counter value is 17

//        User closes the connection

        JdbcUtils.closeConnection();



    }






}
