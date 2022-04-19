package webapp;

import java.sql.*;
import java.util.Scanner;

public class SQLConnect {

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;
    public static String result;

    public static String getResult() {return result;}

    // Подключение к БД
    public static void Connect() {
        connection = null;
        System.out.println("...");
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + SQLConnect.class.getResource("/database/anime.db").getPath());
            System.out.println("Успешное подключение!"); }
        catch (ClassNotFoundException e) { result = "1";}
        catch (SQLException e) { result = "2"; }
    }

    // Создание таблицы в БД
    public static void CreateDB() {
        System.out.println("...");

        try {
            statement = connection.createStatement();

            String SQL = "CREATE TABLE IF NOT EXISTS AnimeTitles " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " name text, " +
                    " state text)";

            statement.execute(SQL);

            System.out.println("Таблица создана или уже существует"); }
        catch (SQLException e) { result = "3"; }
    }

    // Добавление данных в БД
    public static void writeDB() {
        if (connection != null) {
            String name;
            String state;
            try {
                statement.execute("INSERT INTO 'AnimeTitles' ('name', 'state') VALUES ('test_name', 'test_state'); ");}
            catch (SQLException e) {result = "4";}
        } else { System.out.println("Ошибка! Подключитесь к базе данных сперва!"); }
    }

    // Чтение данных в БД
    public static void readDB() {
        if (statement != null) {
            try {
                resultSet = statement.executeQuery("SELECT * FROM AnimeTitles");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String state = resultSet.getString("state");
                    result = result + id + " - " + name + " - " + state + "<br>";
                }}
            catch (SQLException e) { result = "5";}
        } else { System.out.println("Ошибка! Подключитесь к базе данных сперва!"); }
    }

    // Проверка на число
    public static boolean isNumeric(String str) {
        try { Double.parseDouble(str); return true; }
        catch (NumberFormatException e) { return false; }
    }
}