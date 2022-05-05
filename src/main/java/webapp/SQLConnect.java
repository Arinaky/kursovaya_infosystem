package webapp;

import java.sql.*;

// TODO: Auto-generated Javadoc
/**
 * The Class SQLConnect.
 * @author Yunusbaev R.I.
 */
public class SQLConnect {

    /** The connection. */
    public static Connection connection;
    
    /** The statement. */
    public static Statement statement;
    
    /** The result set. */
    public static ResultSet resultSet;

    /**
     * Gets the result.
     *
     * @return the result
     */
    public static String getResult() {
        return result;
    }

    /** The result. */
    public static String result;
    
    /** The connect. */
    public static boolean connect = false;

    /**
     * Connect.
     */
    // Подключение к БД
    public static void Connect() {
        if (connect == false) {
            connection = null;
            System.out.println("...");
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:" + SQLConnect.class.getResource("/database/anime.db").getPath());
                System.out.println("Успешное подключение!");
            } catch (ClassNotFoundException | SQLException ignored) {}
            connect = true;
        }
    }

    /**
     * Close.
     */
    public static void Close() {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
            if (!statement.isClosed()) {
                statement.close();
            }
        } catch (SQLException ignored) {}
    }

    /**
     * Creates the DB.
     */
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
                    " promo_code text, " +
                    " cost INTEGER)";

            statement.executeUpdate(SQL);

            SQL = "CREATE TABLE IF NOT EXISTS CleanArea " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " clean_area text, " +
                    " cost INTEGER)";

            statement.executeUpdate(SQL);
        } catch (SQLException e) { result = "1. " + e.getMessage(); }
    }

    /**
     * Insert order.
     *
     * @param surname the surname
     * @param name the name
     * @param patronymic the patronymic
     * @param address the address
     * @param date the date
     * @param time the time
     * @param clean_area the clean area
     * @param clean_type the clean type
     * @param clean_services the clean services
     * @param price the price
     */
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
            } catch (SQLException e) {result = "2. " + e.getMessage(); }}
    }

    /**
     * Change DB value.
     *
     * @param table the table
     * @param column the column
     * @param columnName the column name
     * @param value the value
     */
    public static void changeDBValue(String table, String column, String columnName, String value) {
        if (connection != null) {
            String sql = "UPDATE " + table + " SET cost = " + value + " WHERE " + column + " = '" + columnName + "';";
            try {
                statement.executeUpdate(sql);
            } catch (SQLException e) { result = "3. " + e.getMessage(); }}
    }

    /**
     * Gets the value from DB.
     *
     * @param table the table
     * @param columnName the column name
     * @param name the name
     * @return the value from DB
     */
    public static int getValueFromDB(String table, String columnName, String name) {
        if (statement != null) {
            try {
                resultSet = statement.executeQuery("SELECT cost FROM " + table + " WHERE " + columnName + "='" + name+"';");
                if (columnName.equals("clean_area")) {
                    return resultSet.getInt(1);
                } else {
                    while (resultSet.next()) {
                        return resultSet.getInt("cost");
                    }
                }
                } catch (SQLException e) {result = "4. " + e.getMessage();  }}
        return 0;
    }

    /**
     * Gets the last order.
     *
     * @return the last order
     */
    public static int getLastOrder() {
        if (statement != null) {
            try {
                resultSet = statement.executeQuery("SELECT MAX(id) FROM Orders;");
                return resultSet.getInt(1);
            } catch (SQLException e) { result = "5. " + e.getMessage(); }}
        return 0;
    }
}