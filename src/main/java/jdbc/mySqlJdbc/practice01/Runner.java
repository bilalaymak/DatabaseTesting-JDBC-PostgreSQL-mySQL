package jdbc.mySqlJdbc.practice01;

import java.sql.*;
import java.util.ArrayList;


public class Runner {


    public static void main(String[] args) throws SQLException {
//
//          updateData(120,"Veli Yildiz",69,"Diyarbakir","2023-04-19");
//        System.out.println("***************");
//          insertData(119,"Mahmut Tan","Izmir",89,"2023-06-29");
//        System.out.println("***************");
//          deleteData(119);
//          System.out.println("***************");
          selectData("select * from practice.workers");

    }


        /*
       connection success
Number of workers: 8
Workers{id='120', name='Veli Yildiz', address='Diyarbakir', exam_grade='69', registration_date='2023-04-19'}
Workers{id='121', name='Veli Han', address='Trabzon', exam_grade='75', registration_date='2023-03-14'}
Workers{id='122', name='Ayşe Tan', address='Bursa', exam_grade='85', registration_date='2023-02-27'}
Workers{id='123', name='Mary Star', address='İstanbul', exam_grade='95', registration_date='2023-09-12'}
Workers{id='124', name='Terry Star', address='Ankara', exam_grade='95', registration_date='2023-01-30'}
Workers{id='125', name='Herry Star', address='Antalya', exam_grade='95', registration_date='2023-07-24'}
Workers{id='126', name='Sally Otar', address='İzmir', exam_grade='100', registration_date='2023-12-19'}
Workers{id='127', name='Bilal Aymak', address='Bingol', exam_grade='80', registration_date='2023-03-05'}
         */

    public static void selectData(String query) throws SQLException {
        DbHelper dbHelper = new DbHelper();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;

        try {
            connection = dbHelper.getConnection();
            if (connection == null) {
                System.out.println("connection failed");
            } else {
                System.out.println("connection success");
            }

            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);//"select * from practice.workers;"
            ArrayList<Workers> workers = new ArrayList<>();

            while (resultSet.next()) {
                workers.add(new Workers(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)));
            }
            System.out.println("Number of workers: " + workers.size());
            //write the result as a list showing its values
            for (Workers worker : workers) {
                System.out.println(worker.toString());
            }

        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            connection.close();
        }

    }
    public static void insertData(int id, String name, String address, int examGrade, String registrationDate) throws SQLException {
        DbHelper dbHelper = new DbHelper();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dbHelper.getConnection();
            if (connection == null) {
                System.out.println("connection failed");
            } else {
                System.out.println("connection success");
            }
            String sqlcode = "INSERT INTO practice.workers (id, name, address, exam_grade, registration_date) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sqlcode);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, address);
            statement.setInt(4, examGrade);
            statement.setString(5, registrationDate);

            int resultOfUpdate = statement.executeUpdate();
            System.out.println("data is added : " + resultOfUpdate);

        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    public static void updateData ( int id, String name,int examGrade, String address, String registrationDate) throws
        SQLException {
            DbHelper dbHelper = new DbHelper();
            Connection connection = null;
            PreparedStatement statement = null;

            try {
                connection = dbHelper.getConnection();
                if (connection == null) {
                    System.out.println("connection failed");
                } else {
                    System.out.println("connection success");
                }
                String sqlcode = "UPDATE practice.workers SET name = ?, address = ?, exam_grade = ?, registration_date = ? WHERE id = ?";
                statement = connection.prepareStatement(sqlcode);
                statement.setString(1, name);
                statement.setString(2, address);
                statement.setInt(3, examGrade);
                statement.setString(4, registrationDate);
                statement.setInt(5, id);

                int resultOfUpdate = statement.executeUpdate();
                System.out.println("data is updated : " + resultOfUpdate);

            } catch (SQLException exception) {
                dbHelper.showErrorMessage(exception);
            } finally {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
        }
    public static void deleteData ( int id) throws SQLException {
            DbHelper dbHelper = new DbHelper();
            Connection connection = null;
            PreparedStatement preparedStatement = null;


            try {
                connection = dbHelper.getConnection();
                if (connection == null) {
                    System.out.println("connection failed");
                } else {
                    System.out.println("connection success");
                }
                String sq1 = "delete from workers where id = ?;";
                preparedStatement = connection.prepareStatement(sq1);
                preparedStatement.setInt(1, id);

                int resultOfUpdate = preparedStatement.executeUpdate();
                System.out.println("data is deleted : " + resultOfUpdate);


            } catch (SQLException exception) {
                dbHelper.showErrorMessage(exception);
            } finally {
                preparedStatement.close();
                connection.close();
            }
        }

    }

