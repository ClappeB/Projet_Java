package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DBConnectionTest {
	
	private DBConnection dbConnection = DBConnection.getInstance();
	
	@Test
	public void testGetInstance() {
		assertEquals("DBConnection should implement singleton pattern", dbConnection, DBConnection.getInstance());
	}
	
	@Test
	public void testGetInstanceNotNull() {
		assertNotNull("DBConnection shouldn't be null", DBConnection.getInstance());
	}

	@Test
	public void testGetConnection() {
		assertNotNull("Connection shouldn't be null", dbConnection.getConnection());
	}

}
