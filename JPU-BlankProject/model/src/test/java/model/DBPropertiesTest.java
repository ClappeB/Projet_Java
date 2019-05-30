package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DBPropertiesTest {
	
	private static DBProperties dbProperties;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dbProperties = new DBProperties();
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDBProperties() {
		assertNotNull("DBProperties should be instantiated and not null", dbProperties);
	}

	@Test
	public void testGetUrl() {		
		Properties props = new Properties();
		try(InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("model.properties")){
			props.load(inputStream);
		} catch (FileNotFoundException e) {
			fail("No file found.");
		} catch (IOException e) {}
		
		String url = props.getProperty("url");
		assertEquals(url, dbProperties.getUrl());
	}

	@Test
	public void testGetLogin() {
		Properties props = new Properties();
		try(InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("model.properties")){
			props.load(inputStream);
		} catch (FileNotFoundException e) {
			fail("No file found.");
		} catch (IOException e) {}
		
		String login = props.getProperty("login");
		assertEquals(login, dbProperties.getLogin());
	}

	@Test
	public void testGetPassword() {		
		Properties props = new Properties();
		try(InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("model.properties")){
			props.load(inputStream);
		} catch (FileNotFoundException e) {
			fail("No file found.");
		} catch (IOException e) {}
		
		String password = props.getProperty("password");
		assertEquals(password, dbProperties.getPassword());
	}

	@Test
	public void testGetGameLevel() {
		Properties props = new Properties();
		try(InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("model.properties")){
			props.load(inputStream);
		} catch (FileNotFoundException e) {
			fail("No file found.");
		} catch (IOException e) {}
		
		int level = Integer.parseInt(props.getProperty("level"));
		assertEquals(level, dbProperties.getGameLevel());
	}

}
