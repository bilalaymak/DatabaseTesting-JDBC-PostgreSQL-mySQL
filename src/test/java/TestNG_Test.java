import jdbc.postgreSqlJdbc.Utils.DatabaseUtils;
import jdbc.postgreSqlJdbc.Utils.JdbcUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static jdbc.postgreSqlJdbc.Utils.DatabaseUtils.getColumnData;

public class TestNG_Test {

    @Test
    public void testNG01(){
        //is Omer Asaf registered to the database?

        JdbcUtils.createConnection();
        String sql = "select * from students";
        System.out.println("student names" +getColumnData(sql,2));//studentName

        Assert.assertTrue(DatabaseUtils.getColumnData(sql,2).contains("Omer Asaf"),
                "no records found in database");

        JdbcUtils.closeConnection();
    }


    @Test
    public void testNG02(){
        //is there a record whose age is 34

        JdbcUtils.createConnection();
        JdbcUtils.createStatement();
        String sql = "select * from students";
        Assert.assertTrue(getColumnData(sql,"age").contains(34),
                "no records found in database");
        JdbcUtils.closeConnection();
    }











}
