package model;
/** DB properties Test. */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

public class DBPropertiesTest {
	
	private static DBProperties dbProperties;
	/** New DB Properties. */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dbProperties = new DBProperties();
	}

	/** Test DBproperties instance and existence. */
	@Test
	public void testDBProperties() {
		assertNotNull("DBProperties should be instantiated and not null", dbProperties);
	}

	/** Test the url getting. */
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

	/** Test the login. */
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

	/** Test the password confirmation. */
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

	/**Test the game loading. */
	@Test
	public void testGetGameLevel() {
		Properties props = new Properties();
		try(InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("model.properties")){
			props.load(inputStream);
		} catch (FileNotFoundException e) {
			fail("No file found.");
		} catch (IOException e) {}
		
		int level = Integer.parseInt(props.getProperty("level"));
		assertEquals(level, DBProperties.getGameLevel());
	}

}
