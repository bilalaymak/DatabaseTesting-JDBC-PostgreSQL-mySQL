package jdbc.postgreSqlJdbc.practice03;

import java.sql.*;

public class Practice06 {
    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:postgresql://localhost:5432/DBPractice";
        final String username = "postgres";
        final String password = "12345";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();

        //create a table named as "workers" then add "worker_id,worker_name,worker_salary" columns
        String sqlDropTable ="drop table workers";
        statement.execute(sqlDropTable);
        String sql = "create table workers (worker_id char(2),worker_name varchar(50),worker_salary int)";
        statement.execute(sql);
        ResultSet rs = statement.executeQuery("select * from workers");

        //we use execute() method for DDL operations (create,alter,drop table)

            while (rs.next()){
                String userData =
                        rs.getString(1) + " : " +
                        rs.getString(2) + " : " +
                        rs.getString(3);
                System.out.println(userData);
            }

        //add worker_address column to workers table
        String sql2= "alter table workers add column worker_address varchar(50)";
        statement.execute(sql2);


        statement.close();
        connection.close();










    }
}
