package practice02.query;

import java.sql.*;

public class Query03 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch60_61?serverTimezone=UTC", "root", "Murat34+");

        Statement st = con.createStatement();

        // SORU1: Bölümler tablosundan tüm kayıtları listeleyiniz.

        ResultSet tablo1 = st.executeQuery("select * from bolumler");

        while (tablo1.next()){
            System.out.println(tablo1.getInt(1) + "\t" + tablo1.getString(2)  + "\t" + tablo1.getString(3));
        }

        System.out.println("==================================================================");

        // SORU2:SATIS ve MUHASEBE bolumlerinde calişan personelin isimlerini ve maaşlarını,
        // maaş ters sıralı listeleyiniz.

        ResultSet tablo2 = st.executeQuery("select personel_isim, maas from personel " +
                "where bolum_id in(10,30) " +
                "order by maas desc");

        while(tablo2.next()){
            System.out.println(tablo2.getString(1)  + "\t"+ tablo2.getInt(2));

        }
        System.out.println("==================================================================");
        // Soru3: Tüm bölümlerde çalışan personel isimlerini, bölüm isimlerini ve maaşlarını,
        // bölüm ve maas sıralı listeleyiniz.
        // NOT: Çalışanı olamasa bile bölüm ismi gösterilmelidir.
/*
        ResultSet tablo3 = st.executeQuery("select p.personel_isim, b.bolum_isim, p.maas from bolumler b " +
                "left join personel p " +
                "on p.bolum_id = b.bolum_id " +
                "order by b.bolum_isim, p.maas");
*/
        ResultSet tablo3 = st.executeQuery("select p.personel_isim, b.bolum_isim, p.maas from personel p " +
                "right join bolumler b " +
                "on p.bolum_id = b.bolum_id " +
                "order by b.bolum_isim, p.maas");

        while (tablo3.next()){
            System.out.println(tablo3.getString(1) + "\t" + tablo3.getString(2) + "\t" + tablo3.getInt(3));
        }

        System.out.println("==================================================================");
        // SORU4: Maaşı en yüksek 10 kişinin bolümünü, adını ve maaşını listeleyiniz.


        System.out.printf("%-16s %-16s %-8s\n", "Bolum Ismi", "Personel Ismi", "Maas");

        ResultSet tablo4=st.executeQuery("select p.personel_isim, b.bolum_isim, p.maas " +
                "" +
                "from bolumler b left join personel p on b.bolum_id=p.bolum_id order by maas desc limit 10");

        while (tablo4.next()) {


            System.out.printf("%-16s %-16s %-8s\n", tablo4.getString(2), tablo4.getString(1), tablo4.getInt(3));
        }
    }
}








