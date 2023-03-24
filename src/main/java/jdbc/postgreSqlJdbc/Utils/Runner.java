package jdbc.postgreSqlJdbc.Utils;

import java.sql.SQLException;


import static jdbc.postgreSqlJdbc.Utils.DatabaseUtils.dropTable;


public class Runner {
    public static void main(String[] args) throws SQLException {

//1. step: create the connection with the database
        JdbcUtils.createConnection("localhost","DBPractice","postgres","12345");

        //2. step: create statement
        JdbcUtils.createStatement();

        //3. step: execute query

        JdbcUtils.execute("CREATE TABLE workers(worker_id VARCHAR(10), worker_name VARCHAR(50), worker_salary INT)");
        JdbcUtils.execute("CREATE TABLE employees(worker_id VARCHAR(10), worker_name VARCHAR(50), worker_salary INT)");
        JdbcUtils.execute("ALTER TABLE workers ADD worker_address VARCHAR(100)");
        dropTable("workers");
        dropTable("employees");

        //4. step: close the connection
        JdbcUtils.closeConnection();









    }
}
