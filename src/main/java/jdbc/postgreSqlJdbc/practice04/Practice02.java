package jdbc.postgreSqlJdbc.practice04;

import jdbc.postgreSqlJdbc.practice04.pojos.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Practice02 {
    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:postgresql://localhost:5432/DBPractice";
        final String username = "postgres";
        final String password = "12345";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();

        String sqlDrop = "drop table doctors";
        statement.execute(sqlDrop);

        //create "doctors table"
        String sql1 = "create table doctors (id int,name varchar(30),field varchar(30),salary int)";
        statement.execute(sql1);

        //insert datas into the table by using pojo class

        //firstly we created datas in our local
        List<Doctor> recordsDoctors = new ArrayList<>();
        recordsDoctors.add(new Doctor(20,"Ali Can","internal medicine",500));
        recordsDoctors.add(new Doctor(21,"Cem yildiz","internal medicine",600));
        recordsDoctors.add(new Doctor(22,"mahmut Cam","dermatology",400));
        recordsDoctors.add(new Doctor(23,"Ali Kan","internal medicine",800));
        recordsDoctors.add(new Doctor(24,"selma Can","ENT",900));
        recordsDoctors.add(new Doctor(25,"Nermin Tan","internal medicine",660));
        recordsDoctors.add(new Doctor(26,"Veysel Can","psychology",670));
        recordsDoctors.add(new Doctor(27,"Ali Can","dermatology",800));
        recordsDoctors.add(new Doctor(28,"yunus Van","internal medicine",690));
        recordsDoctors.add(new Doctor(29,"Ahmet Yan","dermatology",700));

        //then we sent the datas to database
        PreparedStatement doctorsTable = connection.prepareStatement("insert into doctors values (?,?,?,?)");
        for(Doctor w: recordsDoctors){
            doctorsTable.setInt(1,w.getId()); //20
            doctorsTable.setString(2,w.getName()); //Ali Can
            doctorsTable.setString(3,w.getField()); //Internal medicine
            doctorsTable.setInt(4,w.getSalary()); //500
            doctorsTable.addBatch();
        }
           doctorsTable.executeBatch();

        connection.close();
        statement.close();












    }
}
