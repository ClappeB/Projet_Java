package model;
/** Model Test. */
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.Observable;

import org.junit.BeforeClass;
import org.junit.Test;

import entity.Map;

public class ModelTest {
	
	private static Model model;
	/** New model. 
	 * 
	 * @throws Exception
	 *           the Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		model = new Model();
	}

	/** Test model instaciation. */
	@Test
	public void testModel() {
		assertNotNull("Model shouldn't be null and should be instanciated.", model);
	}
	
	/** Test Map getting. */
	@Test
	public void testGetMap() {
		assertTrue("Should return a map.", model.getMap() instanceof Map);
	}

	/** Test Map Loading. */
	@Test
	public void testLoadMap() {
		model.loadMap();
		assertNotNull("Map shouldn't be null.", model.getMap());
	}

	/** Test returning of model's observable.*/
	@Test
	public void testGetObservable() {
		assertTrue("Should return an observable.", model.getObservable() instanceof Observable);
	}
	
	/** Test model returning itself as observable. */
	@Test
	public void testGetItselfAsObservable() {
		assertTrue("Should return itself as an Observable.", model.getObservable()==model);
	}

}
