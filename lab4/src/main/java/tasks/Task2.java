package tasks;

import connection.JDBC;

import java.sql.ResultSet;
import java.sql.Statement;

public class Task2 {
    public static void main(String[] args) {
        Statement stmt = null;

        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();

            String insert = "INSERT publishers (publisherName) VALUES ('Новый издатель')";
            stmt.executeUpdate(insert);

            System.out.println("Издатель добавлен!");
        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}
