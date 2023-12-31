package querry;

import connection.JDBC;

import java.sql.*;
import java.util.*;

public class Query2 {
    public static void main(String[] args) {
        Statement stmt = null;

        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();

            String query2Author = "SELECT * FROM publishers";
            System.out.println("Show all publishers");

            ResultSet rs1 = stmt.executeQuery(query2Author);
            while (rs1.next()) {
                int id = rs1.getInt("publisherID");
                String pubName = rs1.getString("publisherName");
                System.out.println(id + "\t" + pubName);
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
