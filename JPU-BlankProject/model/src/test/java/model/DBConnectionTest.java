package model;
/** Test DB connection. */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DBConnectionTest {
	/** Create connection. */
	private DBConnection dbConnection = DBConnection.getInstance();
	
	/** Test DB getInstance.*/
	@Test
	public void testGetInstance() {
		assertEquals("DBConnection should implement singleton pattern", dbConnection, DBConnection.getInstance());
	}
	/** Test DB instance. */
	@Test
	public void testGetInstanceNotNull() {
		assertNotNull("DBConnection shouldn't be null", DBConnection.getInstance());
	}

	/** Test DB connection.*/
	@Test
	public void testGetConnection() {
		assertNotNull("Connection shouldn't be null", dbConnection.getConnection());
	}

}
