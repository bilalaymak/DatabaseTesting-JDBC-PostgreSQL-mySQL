package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P3_DDL {
    /*
                 A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet)
                    dondurmeyen metotlar kullanilmalidir. Bunun icin JDBC’de 2 alternatif bulunmaktadir.
                       1) execute() metodu
                       2) excuteUpdate() metodu.

                 B)   - execute() metodu her tur SQL ifadesiyle kullanibilen genel bir komuttur.
                      - execute(), Boolean bir deger dondurur.
                      - DDL islemlerin false dondururken, DML islemlerinde true deger dondurur.(ResultSet olusturur)
                      - Ozellikle hangi tip SQL ifadesinin kullanilmasinin gerektiginin belli olmadigi
                        durumlarda tercih edilmektedir.

                 C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
                    -  bu islemlerde islemden etkilenen satir sayisini dondurur.
                    - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.

                  execute() her turlu SQL komutuyla kullanilir .......  DDL ---> False    DML----> True
                  executeUpdate()  DDL ----> 0           DML ----->etkilenen satir sayisini verir
             */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch60_61?serverTimezone=UTC", "root", "elif.12345");

        Statement st = con.createStatement();

        // SORU: markalar adında bir tablo oluşturunuz. marka_id int, marka_isim VARCHAR(15), calisan_sayisi int

        String query = "create table markalar (marka_id int, marka_isim VARCHAR(15), calisan_sayisi int)";


        //1.yontem : execute () methodu ile

        boolean s1 = st.execute(query);
        System.out.println("markalar tablosu olusturuldu ->" +s1); //markalar tablosu olusturuldu ->false

        // execute(), Boolean bir deger dondurur.
        //- DDL islemlerin false dondururken(ResultSet olusturmadigi icin),  DML islemlerinde true deger dondurur.(ResultSet olusturur)

        //2.yontem : executeUpdate() methodu ile

     //   int s2 = st.executeUpdate(query);
     //   System.out.println("markalar tablosu olusturuldu ->" +s2); //markalar tablosu olusturuldu ->0

        // SORU: markalar tablosunu siliniz

    //    String dropQuery = "Drop table markalar";
    //    st.execute(dropQuery);
    //    System.out.println("marklar tablosu silindi...");


        // SORU : markalar tablosuna yeni bir sutun {sube_sayisi int} ekleyiniz

    //    String alterQuery = "ALTER table markalar ADD sube_sayisi int";
    //    st.execute(alterQuery);

        // SORU : markalar tablosuna yeni bir sutun {sube_sayisi int} ekleyiniz, ancak bu sutunun yeri marka_id den sonra olsun

    //    String alterQuery2 = "ALTER table markalar ADD sube_sayisi int AFTER marka_id";
    //    st.execute(alterQuery2);

        // SORU : markalar tablosunun adini  brands olarak degistiriniz
    //    String alterQuery3 = "ALTER table markalar RENAME TO brands";
    //    System.out.println("tablo ismi brands olarak degistirildi.. " + st.execute(alterQuery3));


        // SORU : markalar tablosunda marka_isim sutununu isim olarak degistiriniz
    //    String alterQuery4 = "ALTER table markalar RENAME column marka_isim to isim";
    //    st.execute(alterQuery4);

        // SORU : markalar tablosunda marka_isim sutununun data type ini char(20) olarak degistiriniz

        st.execute("alter table markalar modify marka_isim char(20)");
        System.out.println("marka isim data type char(20) oldu");

    }
}