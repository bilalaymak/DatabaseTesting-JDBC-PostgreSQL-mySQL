package jdbc.postgreSqlJdbc.Utils;

public class Main {
    public static void main(String[] args) {

        JdbcUtils.createConnection();
        JdbcUtils.createStatement();

    //    JdbcUtilsA.execute("ALTER TABLE workers ADD worker_gend VARCHAR(2)");
  //      String sql1 ="UPDATE companies\n" +
    //            "SET number_of_employees = 16000\n" +
    //            "WHERE number_of_employees < (SELECT AVG(number_of_employees) FROM companies);";

    //    JdbcUtilsA.executeUpdate(sql1);
   //     DatabaseUtilsA.dropTable("parents");

       JdbcUtils.executeQuery("select * from students");

   //     String sql2 = "UPDATE companies SET number_of_employees = ? WHERE company = ?";

     DatabaseUtils.getColumnData("select * from companies","company");


        JdbcUtils.closeConnection();
    }



}
