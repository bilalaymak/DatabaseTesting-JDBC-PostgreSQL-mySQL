package practice02.query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query06 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch60_61?serverTimezone=UTC", "root", "Murat34+");

        Statement st = con.createStatement();

        // SORU1: Urunler adında bir tablo olusturalım (id int, isim varchar(10), fiyat int)

        //st.execute("create table urunler (id int, isim varchar(10), fiyat int)");
        //System.out.println("Tablo Olusturuldu");


        // SORU2: urunler tablosuna aşağıdaki verileri toplu bir şekilde etkileyin
        // Çok miktarda kayıt eklemek için PreparedStatement metodu kullanılır.
        // 1) Veri girişine uygun bir POJO (Plain Old Java Object) class oluşturulur
        // 2) POJO class ta nesneleri saklayacak bir collection oluşturulur
        // 3) Bir döngü ile kayıtlar eklenir.

        /*
        List<Urun> kayitlar = new ArrayList<>();

        kayitlar.add(new Urun(101, "Laptop", 6500));
        kayitlar.add(new Urun(102, "PC", 4500));
        kayitlar.add(new Urun(103, "Telefon", 4500));
        kayitlar.add(new Urun(104, "Anakart", 1500));
        kayitlar.add(new Urun(105, "Klavye", 200));
        kayitlar.add(new Urun(106, "Fare", 100));

        PreparedStatement tablo = con.prepareStatement("insert into urunler values(?,?,?)");

        for(Urun each:kayitlar){
            tablo.setInt(1, each.getId());
            tablo.setString(2, each.getIsim());
            tablo.setDouble(3, each.getFiyat());

            tablo.addBatch();
        }
        tablo.executeBatch();
        System.out.println("Veriler Eklendi");



        //SORU3: urunler tablosundaki   PC'nin fiyatına %10 zam yapınız.

        int s1 = st.executeUpdate("UPDATE urunler SET fiyat = fiyat*1.1 where isim='PC'");
        System.out.println(s1 + " SATIR GUNCELLENDi.");

        // SORU4: urunler tablosunda Marka adında, Default değeri ASUS olan, bir sütun ekleyin.

        st.executeUpdate("alter table urunler add marka varchar(10) DEFAULT 'ASUS'");
        System.out.println("Yeni Sutun Eklendi.");
*/
        // SORU5: Urunler tablosunu siliniz.
        st.executeUpdate("drop table urunler");
        System.out.println("TABLO SILINDI");

    }
}
