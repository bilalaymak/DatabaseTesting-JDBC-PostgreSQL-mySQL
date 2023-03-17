package practice02.practice;

import java.sql.*;

public class P2_ReadData_Different {

    //MySql de day5 de..personel tablosu


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch60_61?serverTimezone=UTC", "root", "elif.12345");

        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        // ilk satirdaki ilk objeyi yazdiralim
        String query = "Select * from personel";
        ResultSet rs = st.executeQuery(query);
        System.out.println(rs.getRow());

        // ikinci satirdaki ilk objeyi yazdiralim

        rs.first();
        Object ilkSatirdakiPbje = rs.getObject(1);
        System.out.println("ilkSatirdakiPbje.toString() = " + ilkSatirdakiPbje.toString());

        // ilk sutundaki 5.degeri yazdiralim

        rs.absolute(5);
        Object besinciDeger = rs.getObject(1);
        System.out.println("besinciDeger.toString() = " + besinciDeger.toString());

        // 0.satira gitmemizin sebebi while sorgusu icerisinde bulunan resultSet.next() in bizi
        // birinci kayda goturmesi icindir. Eger 1.satira gidecek olsak while icindeki kod yuzunden yazdirmaya
        // 2.satirdan baslar, tum listeyi alamayiz

        // Tum listeyi yazdirmak istersek;
        rs.absolute(0);
        while (rs.next()) {
            Object idler = rs.getObject(1);
            System.out.println(idler.toString());
        }

        System.out.println("-----------");

        rs.absolute(0);
        while (rs.next()) {
            Object isimler = rs.getObject("isim");
            System.out.println(isimler.toString());
        }

        System.out.println("-----------");

        rs.absolute(0);
        while (rs.next()) {
            Object sirketler = rs.getObject("sirket");
            System.out.println(sirketler.toString());
        }

        System.out.println("-----------");

        rs.absolute(0);
        while (rs.next()) {
            Object sehirler = rs.getObject("sehir");
            System.out.println(sehirler.toString());
        }

        System.out.println("-----------");

        rs.absolute(0);
        while (rs.next()) {
            Object maaslar = rs.getObject(4);
            System.out.println(maaslar.toString());
        }


    }

}

