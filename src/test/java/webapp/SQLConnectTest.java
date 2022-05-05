package webapp;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class SQLConnectTest {

    @Test
    public void connect() throws SQLException {
        SQLConnect sql = new SQLConnect();
        sql.Connect();
        assertTrue(!sql.connection.isClosed());
    }
}