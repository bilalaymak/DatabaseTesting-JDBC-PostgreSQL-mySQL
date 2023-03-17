package practice02.practice;

import java.sql.*;

public class P1_ReadData {

    //MySql de day3 de..

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC", "root", "23932393Gc.");

        Statement st = con.createStatement();

        // SORU1: Talebeler tablosundan tum kayitları listeleyiniz.

        //    ResultSet kayitlar = st.executeQuery("SELECT * FROM talebeler");

        //    while(kayitlar.next()) {
        //        System.out.printf("%-6d  %-20.20s  %-8s %-6d\n", kayitlar.getInt(1), kayitlar.getString(2),kayitlar.getString(3), kayitlar.getInt(4));
        //    }
        //
        // SORU2: Talebeler tablosunda notları 90 uzeri olan kayitları listeleyiniz.
        //      ResultSet kayitlarBuyuk90 = st.executeQuery("SELECT * FROM talebeler where yazili_notu>90");
//
        //      while(kayitlarBuyuk90.next()) {
        //          System.out.printf("%-6d  %-20.20s \n",kayitlarBuyuk90.getInt(1),kayitlarBuyuk90.getString(2) );
        //      }

        // SORU3: Talebeler tablosunda id'si 124 olan öğrencilerin tüm bilgilerini listeleyiniz.
        //       ResultSet kayitlarid124 = st.executeQuery("SELECT * FROM talebeler where id=124");
        //     while(kayitlarid124.next()) {
        //         System.out.printf("%-6d  %-20.20s  %-8s %-6d\n", kayitlarid124.getInt(1), kayitlarid124.getString(2),
        //                 kayitlarid124.getString(3), kayitlarid124.getInt(4));
        //     }

        // SORU4: Talebeler tablosunda notu 70 ile 90 arasindaki kisilerin isimlerini listeleyiniz.
        //     ResultSet kayitlarnot7090 = st.executeQuery("SELECT isim,yazili_notu from talebeler where yazili_notu Between '70' and '90'");
        //     while(kayitlarnot7090.next()){
        //         System.out.printf("%-15s  %-16s \n", kayitlarnot7090.getObject(1), kayitlarnot7090.getObject(2));
        //     }

        // SORU5: Talebeler tablosunda isminin 2. harfi e olan kisilerin veli_isimleri ile birlikte listeleyiniz.

        ResultSet isim2E = st.executeQuery("SELECT isim,veli_isim from talebeler where isim LIKE '_e%'");
        System.out.printf("%-15s %-15s \n", "isim", "veli_ismi");

        while (isim2E.next()) {

            System.out.printf("%-15s %-15s \n", isim2E.getObject(1), isim2E.getObject(2));
        }

        con.close();
        st.close();
    }

}


