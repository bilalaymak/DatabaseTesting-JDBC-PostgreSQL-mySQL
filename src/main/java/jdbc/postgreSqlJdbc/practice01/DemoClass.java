package jdbc.postgreSqlJdbc.practice01;

import java.sql.*; //1. step import packages

public class DemoClass {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/DBPractice";
        String username = "postgres";
        String password = "12345";
        String query = "SELECT * FROM students";
        String driver = "org.postgresql.Driver";

        try {
            Class.forName(driver); //2. step load and register the driver
            //3. step create and establishing the connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("baglanti basarili");//baglanti basarili


            Statement st = connection.createStatement(); //4. step creating the statement
            ResultSet rs = st.executeQuery(query);//5. step executing the query

            while (rs.next()) {
                String userData = rs.getString(1) + " : " +
                        rs.getString(2) + " : " +rs.getString(3) +
                        " : " +rs.getString(4) + " : " + rs.getString(5 );
                System.out.println(userData); //6. step process the result
            }
            st.close();
            connection.close();//7. step close the connection

            /*
 baglanti basarili
120 : Ali Can : Ankara : 70 : 2023-02-11
121 : Veli Han : Trabzon : 75 : 2022-02-11
122 : Ayşe Tan : Bursa : 85 : 2021-08-11
123 : Mary Star : İstanbul : 95 : 2020-01-01
124 : Terry Star : Ankara : 95 : 2019-09-01
125 : Herry Star : Antalya : 95 : 2018-02-01
126 : Sally Otar : İzmir : 100 : 2017-06-30

             */

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}