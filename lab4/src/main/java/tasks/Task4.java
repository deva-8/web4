package tasks;

import connection.JDBC;

import java.sql.ResultSet;
import java.sql.Statement;

public class Task4 {
    public static void main(String[] args) {
        Statement stmt = null;

        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();

            String select = "SELECT * FROM titles WHERE publisherID = 1 ORDER BY year";
            System.out.println("Show titles");

            ResultSet rs1 = stmt.executeQuery(select);
            while (rs1.next()) {
                int id = rs1.getInt("isbn");
                String title = rs1.getString("title");
                System.out.println(id + "\t" + title);
            }
        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            JDBC.close();
        }
    }
}
