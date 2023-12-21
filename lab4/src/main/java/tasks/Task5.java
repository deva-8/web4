package tasks;

import connection.JDBC;

import java.sql.Statement;

public class Task5 {
    public static void main(String[] args) {
        Statement stmt = null;

        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();

            String insert = "INSERT authors (firstName, lastName) VALUES ('Новый', 'Автор')";
            stmt.executeUpdate(insert);

            System.out.println("Автор добавлен!");
        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}
