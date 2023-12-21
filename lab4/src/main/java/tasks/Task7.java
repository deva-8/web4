package tasks;

import connection.JDBC;

import java.sql.ResultSet;
import java.sql.Statement;

public class Task7 {
    public static void main(String[] args) {
        Statement stmt = null;

        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();

            String insert1 = "INSERT publishers (publisherName) VALUES ('Издатель')";
            stmt.executeUpdate(insert1);
            System.out.println("Издатель добавлен!");

            String insert2 = "INSERT titles (isbn,title,editionNumber,year,publisherID,price) VALUES ('isbn','Тайтл',5638,'2023',(SELECT publisherID FROM publishers WHERE publisherName='Издатель'),12)";
            stmt.executeUpdate(insert2);
            System.out.println("Тайтл добавлен!");

            String insert3 = "INSERT authorisbn (authorID,isbn) VALUES ('isbn',(SELECT authorID FROM authors WHERE firstName='Новый' AND lastName='Автор'))";
            stmt.executeUpdate(insert3);
            System.out.println("Добавлено!");

        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}
