package testOfTables;

import connection.JDBC;

import java.sql.*;
import java.util.*;

public class GetAllRows {
    public static void main(String[] args) {
        GetAllRows.select();
    }

    public static void select()
    {
        Statement stmt = null;
        try
        {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            String exampleQuery1 = "SELECT * FROM Authors ORDER BY firstName";
            System.out.println("Authors:");
            ResultSet rs1 = stmt.executeQuery(exampleQuery1);
            while (rs1.next())
            {
                int id = rs1.getInt("authorID");
                String firstName = rs1.getString("firstName");
                String lastName = rs1.getString("lastName");
                System.out.println(id + "\t" + firstName + "\t" + lastName);
            }
        }
        catch(SQLException se) { se.printStackTrace(); }
        finally { JDBC.close(); }
    }

    public static void insert()
    {
        Statement stmt = null;
        try
        {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            String exampleQuery1 = "INSERT publishers (publisherName) VALUES ('Анекдот дня')";
            stmt.executeUpdate(exampleQuery1);
        }
        catch(SQLException se) { se.printStackTrace(); }
        finally { JDBC.close(); }
    }

    public static void update()
    {
        Statement stmt = null;
        try
        {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            String exampleQuery1 = "UPDATE authors SET firstName = 'Андрей' WHERE firstName = 'Анатолий'";
            stmt.executeUpdate(exampleQuery1);
        }
        catch(SQLException se) { se.printStackTrace(); }
        finally { JDBC.close(); }
    }

    public static void delete()
    {
        Statement stmt = null;
        try
        {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            String exampleQuery1 = "DELETE FROM authors WHERE firstName = 'Dan'";
            stmt.executeUpdate(exampleQuery1);
        }
        catch(SQLException se) { se.printStackTrace(); }
        finally { JDBC.close(); }
    }
}