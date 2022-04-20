package webapp;

import java.sql.*;

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
        try {
            statement = connection.createStatement();

            String SQL = "CREATE TABLE IF NOT EXISTS Orders " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " surname text, " +
                    " name text, " +
                    " patronymic text, " +
                    " address text, " +
                    " date text, " +
                    " time text, " +
                    " clean_area INTEGER, " +
                    " clean_type text, " +
                    " clean_services text, " +
                    " price INTEGER)";

            statement.executeUpdate(SQL);

            SQL = "CREATE TABLE IF NOT EXISTS CleanTypes " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " clean_type text, " +
                    " cost INTEGER)";

            statement.executeUpdate(SQL);

            SQL = "CREATE TABLE IF NOT EXISTS CleanServices " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " clean_service text, " +
                    " cost INTEGER)";

            statement.executeUpdate(SQL);

            SQL = "CREATE TABLE IF NOT EXISTS Promocodes " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " promo-code text, " +
                    " cost INTEGER)";

            statement.executeUpdate(SQL);
        } catch (SQLException e) { result = "3"; }
    }

    public static void insertOrder(String surname, String name, String patronymic, String address, String date, String time, int clean_area, String clean_type, String clean_services, int price) {
        if (connection != null) {
            String sql = "INSERT INTO Orders(surname, name, patronymic,address,date,time,clean_area,clean_type,clean_services,price) VALUES(?,?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, surname);
                statement.setString(2, name);
                statement.setString(3, patronymic);
                statement.setString(4, address);
                statement.setString(5, date);
                statement.setString(6, time);
                statement.setInt(7, clean_area);
                statement.setString(8, clean_type);
                statement.setString(9, clean_services);
                statement.setInt(10, price);
                statement.executeUpdate();
            } catch (SQLException e) {
                result = e.getMessage();
            }
        } else { result = "Ошибка добавления заказа в БД"; }
    }

    public static void changeDBValue(String table, String column, String columnName, String value) {
        if (connection != null) {
            String sql = "UPDATE " + table + " SET cost = " + value + " WHERE " + column + " = " + columnName + ";";

            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.executeUpdate();
            } catch (SQLException e) {
                result = e.getMessage();
            }
        } else { result = "Ошибка изменения значения"; }
    }

    public static int getValueFromDB(String table, String columnName, String name) {
        if (statement != null) {
            try {
                resultSet = statement.executeQuery("SELECT cost FROM " + table + "WHERE " + columnName + "= " + name);
                while (resultSet.next()) {
                    result = String.valueOf(resultSet.getInt("cost"));
                    return Integer.parseInt(result);
                }}
            catch (SQLException e) { result = "5";}
        } else { System.out.println("Ошибка! Подключитесь к базе данных сперва!"); }
        return 0;
    }

    // Проверка на число
    public static boolean isNumeric(String str) {
        try { Double.parseDouble(str); return true; }
        catch (NumberFormatException e) { return false; }
    }
}