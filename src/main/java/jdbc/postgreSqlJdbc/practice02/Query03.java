package jdbc.postgreSqlJdbc.practice02;

import java.sql.*;

public class Query03 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 1) Driver yukle
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2) Baglanti olustur
        Connection con = DriverManager.
                getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC",
                        "root", "23932393Gc.");

        //3) Statement
        Statement st = con.createStatement();

        //Bolumler tablosundan tum kayitlari listeleyiniz
        ResultSet tablo1 = st.executeQuery("select * from bolumler");

        while (tablo1.next()) {

            System.out.println(tablo1.getInt(1) + " " + tablo1.getString(2) + " " +
                    tablo1.getString(3) + " " + tablo1.getString(4));
        }

        System.out.println("=====================================================");

        //satis ve muhasebe bolumlerinde calisan personelin isimlerini ve maaslarini maas ters sirali listeleyiniz

        ResultSet tablo2 = st.executeQuery("select personel_isim,maas from personel," +
                "where bolum_id in(10,30) order by maas desc");

        while (tablo2.next()) {
            System.out.println(tablo2.getString(1) + " " + tablo2.getString(2));

        }

        //Tum bolumlerde calisan personel isimlerini bolum isimlerini ve maaslarini, bolumve maas sirali listeleyiniz
        //Not: Calisani olmasa bile bolum ismi gosterilmelidir

        ResultSet tablo3 = st.executeQuery("select p.personel_isim,b.bolum_isim,p.maas " +
                "from bolumler b left join personel p on p.boolum_id = b.bolum_id order by b.bolum_isim,p.maas");


        while (tablo3.next()) {
            System.out.println(tablo3.getString(1) + "\t" + tablo3.getString(2) + "\t" +
                    tablo3.getString(3) + "\t" + tablo3.getString(4));

        }

        System.out.println("=====================================================");

        //Soru4: Maasi en yuksek 10 kisinin bolumunu, adini ve maasini listeleyiniz.
        ResultSet tablo4 = st.executeQuery("select p.personel_isim, b.bolum_isim,p.maas " +
                "from bolumler b left join personel p on b.bolum_id = p.bolum_id order by maas desc limit 10");


        while (tablo4.next()) {
            System.out.println(tablo4.getString(2) + "\t" + tablo4.getString(1) + "\t" +
                    tablo4.getString(3));


        }
    }
}