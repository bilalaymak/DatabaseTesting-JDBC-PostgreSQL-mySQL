package jdbc.postgreSqlJdbc.practice03;

import jdbc.postgreSqlJdbc.Utils.DatabaseUtils;
import jdbc.postgreSqlJdbc.Utils.JdbcUtils;

public class Practice10 {
    public static void main(String[] args) {

        JdbcUtils.createConnection();
        JdbcUtils.createStatement();

        JdbcUtils.execute("ALTER TABLE workers ADD worker_gend VARCHAR(2)");
        String sql1 ="UPDATE companies\n" +
                "SET number_of_employees = 16000\n" +
                "WHERE number_of_employees < (SELECT AVG(number_of_employees) FROM companies);";

        JdbcUtils.executeUpdate(sql1);
        DatabaseUtils.dropTable("parents");

       JdbcUtils.executeQuery("select * from students");
       DatabaseUtils.printResultSet("select * from students");

        String sql2 = "UPDATE companies SET number_of_employees = ? WHERE company = ?";

     DatabaseUtils.getColumnData("select * from companies","company");

    DatabaseUtils.createTable("workers","id char(5)","name varchar(50)","salary int");

        JdbcUtils.closeConnection();
    }



}
