package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {


    // Gönderilen sorgunun sonucunu List olarak geri gönderen
    // bir Reusable bir fonksiyon yazınız.


    private static Connection connection;
    protected static Statement statement;

// extends _JDBCParent yapmamamizin sebebi sadece burada kullanilacak olmasi

    public static void DBConnectionOpen() {
        String url = "jdbc:mysql://test.medis.mersys.io:33306/sakila";
        String user = "technostudy";
        String password = "zhTPis0l9#$&";
        try {
            connection = DriverManager.getConnection(url, user, password);// bağlantı sağlandı.
            statement = connection.createStatement(); // sorgularımı çalıştırabilmek için bir yol oluştur.
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public static void DBConnectionClose() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static List<List<String>> getListData(String str) {

        DBConnectionOpen();
        List<List<String>> columns = new ArrayList<>();

        try {
            ResultSet rs = statement.executeQuery(str);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();


            while (rs.next()) {
                List<String> list = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {

                    list.add(rs.getString(i));

                }
                columns.add(list);
            }


        } catch (Exception ex) {

            System.out.println("ex.getMessage=" + ex.getMessage());
        }

        DBConnectionClose();
        return columns;

    }

    public static String getData(String query){

        DBConnectionOpen();
        //*****************
        //*****************
        //*****************

        DBConnectionClose();
        return "result";

    }


    public static void main(String[] args) {
        List<List<String >> data=(getListData("select * from city"));

        for (List<String> a:data) {

            System.out.println(a);

        }
    }
}
