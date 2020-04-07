package Lesson_2.hw;

import java.sql.*;

public class MainDB {

    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {
        try {
            connect();
            try {
                //createTable("students");
                insertTable("Bob", 50);
                insertTable("Bob", 70);
                insertTable("Ben", 100);
                updateName(3,"Egor", 150);
                insertTable("Bob", 250);
                updateName(5,"Vasya", 150);
                updateName(2,"Vasya", 150);
                selectId(1);   // 1 Egor 150
                selectName("Bob");
                //deleteId(2);
                //deleteName("Bob");

            } catch (SQLException e){
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:mainDB.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable(String tableName) throws SQLException {
        stmt.executeUpdate("CREATE TABLE " + tableName + "(" + "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," + "score INTEGER" + ");");
    }

    public static void insertTable(String name, int score) throws SQLException {
        stmt.executeUpdate("INSERT INTO students VALUES (NULL,'" + name + "', " + score + ")");
    }

    public static void updateName(int id, String name, int score) throws SQLException {
        stmt.executeUpdate("UPDATE students SET name = '" + name + "', score = " + score + " WHERE id = " + id);
    }

    private static void selectId(int id) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT id, name, score  FROM students WHERE id = " + id);
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getString("score"));
        }
    }
    private static void selectName(String name) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT id, name, score  FROM students WHERE name = '" + name + "'");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getString("score"));
        }
    }

    private static void deleteId(int id) throws SQLException {
        stmt.executeUpdate("DELETE FROM students WHERE id = " + id);
    }

    private static void deleteName(String name) throws SQLException {
        stmt.executeUpdate("DELETE FROM students WHERE name = '" + name + "'");
    }
}
