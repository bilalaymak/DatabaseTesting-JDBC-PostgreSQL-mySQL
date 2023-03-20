package jdbc.mySqlJdbc.practice02;

import java.sql.*;

public class Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1) Driver yukle
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2) Baglanti olustur
        Connection con = DriverManager.
                getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC",
                        "root", "23932393Gc.");

        //3) Statement
        Statement st = con.createStatement();

        // 4) ResultSet
        ResultSet veri = st.executeQuery("select * from ogrenciler");

        // sonuclari yazdir
        while (veri.next()) {
            System.out.println(veri.getInt("okul_no") + " " + veri.getString("ogrenci_ismi") + " " +
                    veri.getString("sinif") + " " + veri.getString("cinsiyet"));


        }

        //6)kapatma
        con.close();
        st.close();
        veri.close();


    }


}
