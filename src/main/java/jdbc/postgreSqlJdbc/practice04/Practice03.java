package jdbc.postgreSqlJdbc.practice04;

import static jdbc.postgreSqlJdbc.Utils.JDBCUtils.closeConnection;
import static jdbc.postgreSqlJdbc.Utils.JDBCUtils.createConnection;
//when we import the method as static,
// there is no need of reference to the class name to access

public class Practice03 {
    public static void main(String[] args) {

      createConnection();
      /*
      public static Connection connectToDatabase(){
        String url = "jdbc:postgresql://localhost:5432/DBPractice";
        String userName = "postgres";
        String password = "12345";
        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("connection is successful");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
       */
        String sql1= "select * from students";









        closeConnection();
        /*
          try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         */











    }
}
