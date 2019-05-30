package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import entity.Map;

public class DAOMapTest {
	
	private static DAOMap daoMap;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoMap = new DAOMap(DBConnection.getInstance().getConnection());
	}
	
	@Test
	public void testDAOMap() {
		assertNotNull("DAOMap shouldn't be null", daoMap);
	}

	@Test
	public void testGetConnection() {
		assertNotNull("Connection shouldn't be null", daoMap.getConnection());
	}

	@Test
	public void testFind() {
		assertTrue("Map.find() should return a map. Maybe no map could have been found.", (daoMap.find() instanceof Map));
	}

}
