package tasks;

import connection.JDBC;

import java.sql.ResultSet;
import java.sql.Statement;

public class Task1 {
    public static void main(String[] args) {
        Statement stmt = null;

        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();

            String query2Author = "SELECT * FROM authors ORDER BY firstName, lastName";
            System.out.println("Show all authors");

            ResultSet rs1 = stmt.executeQuery(query2Author);
            while (rs1.next()) {
                int id = rs1.getInt("authorID");
                String name = rs1.getString("firstName");
                System.out.println(id + "\t" + name);
                String lastName = rs1.getString("lasttName");
                System.out.println("\t" + lastName);
            }
        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}
