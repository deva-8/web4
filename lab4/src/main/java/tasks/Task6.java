package tasks;

import connection.JDBC;

import java.sql.ResultSet;
import java.sql.Statement;

public class Task6 {
    public static void main(String[] args) {
        Statement stmt = null;

        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();

            String update = "UPDATE authors SET firstName = 'Старый' WHERE authorID = 1";
            stmt.executeUpdate(update);
        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            JDBC.close();
        }
    }
}
