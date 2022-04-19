package webapp;

import java.sql.*;
import java.util.Scanner;

public class SQLConnect {

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    // Подключение к БД
    public static void Connect() {
        connection = null;
        System.out.println("...");
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + SQLConnect.class.getResource("/database/anime.db").getPath());
            System.out.println("Успешное подключение!"); }
        catch (ClassNotFoundException e) { System.out.println("Ошибка! JDBC драйвер не найден!"); }
        catch (SQLException e) { System.out.println("Ошибка! База данных не найдена!"); }
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
        catch (SQLException e) { System.out.println("Ошибка! Не удалось создать таблицу!"); }
    }

    // Проверка на число
    public static boolean isNumeric(String str) {
        try { Double.parseDouble(str); return true; }
        catch (NumberFormatException e) { return false; }
    }
}