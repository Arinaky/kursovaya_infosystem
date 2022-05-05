package webapp;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

// TODO: Auto-generated Javadoc
/**
 * The Class SQLConnectTest.
 * @author Yunusbaev R.I.
 */
public class SQLConnectTest {

    /**
     * Connect.
     *
     * @throws SQLException the SQL exception
     */
    @Test
    public void connect() throws SQLException {
        SQLConnect sql = new SQLConnect();
        sql.Connect();
        assertTrue(!sql.connection.isClosed());
    }
}