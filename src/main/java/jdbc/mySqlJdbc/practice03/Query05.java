package jdbc.mySqlJdbc.practice03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
        CREATE TABLE, DROP TABLE, ALTER TABLE gibi DLL (Data Defination Language – Veri Tanımlama Dili)
        ifadeleri için sonuç (ResultSet) dondurmeyen metotlar kullanılmalıdır.
            1) execute(): boolean bir değer döndürür.
            2) executeUpdate(): INSERT, UPDATE gibi DML (Data Manipulation Language – Veri İşleme Dili )
            işlemlerinde kullanılır. Bu işlemlerde, işlemden etkilenen satır sayısını döndürür.
        */

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch60_61?serverTimezone=UTC", "root", "Murat34+");

        Statement st = con.createStatement();

        // SORU1: Bölümler tablosunda yeni bir kayıt (80, 'ARGE', 'ISTANBUL')
        //int s1 = st.executeUpdate("insert into bolumler values (80, 'ARGE', 'ISTANBUL')");
        //System.out.println(s1 + " SATIR EKLENDi.");

        // SORU2; Bölümler tablosuna birden fazla kayıt ekleyelim.

        // 1. YOL
        /*
        String [] veri1 = { "insert into bolumler values(95, 'YEMEKHANE', 'ISTANBUL')",
                "insert into bolumler values(85, 'OFIS1', 'ANKARA')",
                "insert into bolumler values(75, 'OFIS2', 'VAN')"};

        int count = 0;
        for(String each:veri1){
            count = count + st.executeUpdate(each);
        }
        System.out.println(count + " DATA EKLENDi.");

        // 2. YOL
        // addBatch(): SQL sorgularımızı grupluyor
        // executeBatch(): Veriyi database gönderiyor

        String [] veri2 = {"insert into bolumler values(81, 'YEMEKHANE', 'ISTANBUL')",
                "insert into bolumler values(82, 'OFIS', 'ANKARA')",
                "insert into bolumler values(83, 'OFIS2', 'VAN')"};

        for(String each:veri2){
            st.addBatch(each);  //Yukarıdaki verileri bir arada grupladık.
        }
        st.executeBatch();  //Verileri tek seferde database'e gonderir.

        System.out.println("Veriler Database'e EKLENDi.");

*/
        // SORU3: Bölümler tablosuna birden fazla kayıt ekleyelim.

        String [] veri3 = {"insert into bolumler values(100, 'YEMEKHANE', 'ISTANBUL')",
                "insert into bolumler values(101, 'OFIS', 'ANKARA')",
                "insert into bolumler values(102, 'OFIS', 'ANKARA')",
                "insert into bolumler values(103, 'OFIS2', 'VAN')"};

        for(String each:veri3){
            st.addBatch(each);  //Yukarıdaki verileri bir arada grupladık.
        }
        st.executeBatch();  //Verileri tek seferde database'e gonderir.

        System.out.println("Veriler Database'e EKLENDi.");
    }
}