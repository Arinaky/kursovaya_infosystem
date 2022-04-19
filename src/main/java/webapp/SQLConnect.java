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

    // Добавление данных в БД
    public static void writeDB() {
        if (connection != null) {
            String name;
            String state;
            input.nextLine();
            System.out.print("Введите название аниме: ");
            name = input.nextLine();
            System.out.print("Введите статус аниме: ");
            state = input.nextLine();
            try {
                statement.execute("INSERT INTO 'AnimeTitles' ('name', 'state') VALUES ('" + name + "', '" + state + "'); ");
                System.out.println("Аниме добавлено!"); }
            catch (SQLException e) { System.out.println("Ошибка! Не удалось добавить данные в базу данных!"); }
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
                    System.out.println(id + " - " + name + " - " + state);
                }
                System.out.println("Таблица выведена!"); }
            catch (SQLException e) { System.out.println("Ошибка! Не удалось прочесть данные в базе данных!"); }
        } else { System.out.println("Ошибка! Подключитесь к базе данных сперва!"); }
    }

    // Проверка на число
    public static boolean isNumeric(String str) {
        try { Double.parseDouble(str); return true; }
        catch (NumberFormatException e) { return false; }
    }
}