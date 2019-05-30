package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Observable;

import org.junit.BeforeClass;
import org.junit.Test;

import entity.Map;

public class ModelTest {
	
	private static Model model;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		model = new Model();
	}

	@Test
	public void testModel() {
		assertNotNull("Model shouldn't be null and should be instanciated.", model);
	}
	
	@Test
	public void testGetMap() {
		assertTrue("Should return a map.", model.getMap() instanceof Map);
	}

	@Test
	public void testLoadMap() {
		model.loadMap();
		assertNotNull("Map shouldn't be null.", model.getMap());
	}

	@Test
	public void testGetObservable() {
		assertTrue("Should return an observable.", model.getObservable() instanceof Observable);
	}
	
	@Test
	public void testGetItselfAsObservable() {
		assertTrue("Should return itself as an Observable.", model.getObservable()==model);
	}

}
