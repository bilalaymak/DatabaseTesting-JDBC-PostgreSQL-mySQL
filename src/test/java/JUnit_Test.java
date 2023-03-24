import jdbc.postgreSqlJdbc.Utils.DatabaseUtils;
import jdbc.postgreSqlJdbc.Utils.JdbcUtils;
import org.junit.Assert;
import org.junit.Test;


import static jdbc.postgreSqlJdbc.Utils.DatabaseUtils.*;

public class JUnit_Test {


    @Test
    public void test01() {
        //verify that "Nazan Yaman" and "Omer Asaf" students are registered in the database

        JdbcUtils.createConnection();
        JdbcUtils.createStatement();

        String sql = "select * from students";
        System.out.println("student names" +getColumnData(sql,2));//studentName

        Assert.assertTrue("no records found in database",
                getColumnData(sql, "name").contains("Omer Asaf"));
        //this method is case-sensitive
        Assert.assertTrue("no records found in database",
                getColumnData(sql, "name").contains("Nazan Yaman"));

        //getColumnData(sql, "name") returns student names in the table

        System.out.println("********************");
        System.out.println(getColumnData(sql, "name"));


        JdbcUtils.closeConnection();

    }
    @Test
    public void test02(){
          //is there a record whose age is 24

        JdbcUtils.createConnection();
        JdbcUtils.createStatement();
        String sql = "select * from students";
        Assert.assertTrue("no records found in database",
                getColumnData(sql,"age").contains(24));
        System.out.println("******************");

   //     DatabaseUtils.printResultSet(sql);




        JdbcUtils.closeConnection();









    }







}
