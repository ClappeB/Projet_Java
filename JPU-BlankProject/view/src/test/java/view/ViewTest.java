package view;
/** 
 * View test
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.event.KeyEvent;

import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;
import contract.IModel;

public class ViewTest {
	/** an IModel */
	private static IModel model;
	/** a View */
    private static View view;
    
    /** New Fake model, new View */
	@BeforeClass
    public static void setUpBeforeClass() throws Exception {
        model = new fakeModel();
        view = new View(model);
    }

	/** Test view existence */
	@Test
    public void testView() {
        assertNotNull("View is null.", view);
    }
	
	/**  Test key control*/
	@Test
    public void testKeyCodeToControllerOrder() {
        final ControllerOrder expected = ControllerOrder.z;
        assertEquals(expected, view.keyCodeToControllerOrder(KeyEvent.VK_Z));
    }

}
