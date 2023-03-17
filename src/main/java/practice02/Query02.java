import java.sql.*;

public class Query02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1) Driver yukle
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2) Baglanti olustur
        Connection con = DriverManager.
                getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC",
                        "root", "23932393Gc.");

        //3) Statement
        Statement st = con.createStatement();

        //soru01: ogrenciler tablosundaki erkek ogrenci bilgileri getirin


        // 4) ResultSet
        ResultSet veri = st.executeQuery("select * from ogrenciler where cinsiyet = 'E'");


        while (veri.next()) {
            System.out.println(veri.getInt(1) + " " + veri.getString(2) + " " +
                    veri.getString(3) + " " + veri.getString(4));
        }

        System.out.println("=======================================================================");


        //soru02: ogrenciler tablosundaki kiz ogrenci bilgileri getirin

        ResultSet veri2 = st.executeQuery("select * from ogrenciler where cinsiyet = 'K'");

        while (veri2.next()) {
            System.out.println(veri2.getInt(1) + " " + veri2.getString(2) + " " +
                    veri2.getString(3) + " " + veri2.getString(4));
        }


    }
}
