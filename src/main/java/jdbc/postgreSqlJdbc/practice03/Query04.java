package jdbc.postgreSqlJdbc.practice03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query04 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch60_61?serverTimezone=UTC", "root", "Murat34+");

        Statement st = con.createStatement();

        // SORU: İşçiler adında bir tablo oluşturunuz. id int, birim VARCHAR(10), maas int

        String sorgu = "create table isciler (id int, birim varchar(10), maas int)";

        st.execute(sorgu);
        System.out.println("isciler tablosu olusturuldu");
/*
        // SORU: İşciler tablosunu siliniz.
        st.execute("drop table isciler");
        System.out.println("isciler tablosu silindi");
*/

        // SORU: isciler tablosuna yeni bir sütun ekleyin. (isim varcahar(20)
        st.execute("alter table isciler add isim varchar(20)");
        System.out.println("Sütun eklendi.");

        //SORU: isciler tablosuna soyisim varchar(20), sehir varchar(10) adında 2 tane sutun ekleyiniz.
        st.execute("alter table isciler add soyisim varchar(20)");
        st.execute("alter table isciler add sehir varchar(10)");
        System.out.println("2 sutun eklendi");


        // SORU: İŞCİLER tablosundaki sehir sütunun ismini ulke olarak değiştirin.

        st.execute("alter table isciler rename column sehir to ulke");
        System.out.println("soru isciler tablosundaki sehir sutunun ismini ulke olarak degistirildi");


        //SORU: Tablonun ismini employee olarak değiştirin
        st.execute("alter table isciler rename to employee");
        System.out.println("tablonun ismi değişti");


        //SORU: ulke sütunun data türünü char(30) yapın
        st.execute("alter table employee modify ulke char(30)");
        System.out.println("ulke data typr char(30)");

    }
}
