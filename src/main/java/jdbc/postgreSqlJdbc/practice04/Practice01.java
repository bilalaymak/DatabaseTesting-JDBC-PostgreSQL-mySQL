package jdbc.postgreSqlJdbc.practice04;

import jdbc.postgreSqlJdbc.practice04.pojos.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Practice01 {

    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:postgresql://localhost:5432/DBPractice";
        final String username = "postgres";
        final String password = "12345";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();

        String sqlDrop = "drop table products";
        statement.execute(sqlDrop);

        //Q1: create a table named "products" (id int, name varchar(20), price int)
        String sql1 = "create table products (id int, name varchar(20), price int)";
        statement.execute(sql1);

        List<Product> records = new ArrayList<>();
        records.add(new Product(100,"Laptop",35000.00));
        records.add(new Product(101,"IPad",25000.00));
        records.add(new Product(102,"MacBook",55000.00));
        records.add(new Product(103,"Motherboard",15000.00));
        records.add(new Product(104,"IMac",15000.00));
        records.add(new Product(105,"IPhone",45000.00));

        //we use PreparedStatement to add multiple data
        PreparedStatement table = connection.prepareStatement("insert into products values (?,?,?)");
        for (Product w: records){
            table.setInt(1,w.getId()); //id: 100
            table.setString(2,w.getName()); // name: Laptop
            table.setDouble(3,w.getPrice()); // 35000
            table.addBatch(); //merges all the data
        }
        table.executeBatch(); //sends all the data to products table




















    }


}
