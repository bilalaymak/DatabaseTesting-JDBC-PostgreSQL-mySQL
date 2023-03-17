package practice02.query;

import java.sql.*;

public class Query02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC", "root", "Murat34+");

        Statement st = con.createStatement();

        /*
        SORU01: ÖĞRENCİLER TABLOSUNDAKİ ERKEK ÖĞRENCİ BİLGİLERİ GETİRİN
        */

        ResultSet veri = st.executeQuery("select * from ogrenciler where cinsiyet ='E'");

        while(veri.next()) {
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri.getInt(1), veri.getString(2), veri.getString(3), veri.getString(4));
        }


        /*
        SORU02: ÖĞRENCİLER TABLOSUNDAKİ  9 SINIF KIZ ÖĞRENCİ BİLGİLERİ GETİRİN
        */

        System.out.println("===================================================");
        ResultSet veri2 = st.executeQuery("select * from ogrenciler where sinif=9 AND cinsiyet='K'");

        while (veri2.next()) {

            System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri2.getInt("okul_no"), veri2.getString("ogrenci_ismi"), veri2.getString("sinif"), veri2.getString("cinsiyet"));
        }

    }
}
