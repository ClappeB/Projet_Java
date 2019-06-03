package view;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.event.KeyEvent;

import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;
import contract.IModel;

public class ViewTest {

	private static IModel model;
    private static View view;
    
	@BeforeClass
    public static void setUpBeforeClass() throws Exception {
        model = new fakeModel();
        view = new View(model);
    }

	@Test
    public void testView() {
        assertNotNull("View is null.", view);
    }
	
	@Test
    public void testKeyCodeToControllerOrder() {
        final ControllerOrder expected = ControllerOrder.z;
        assertEquals(expected, view.keyCodeToControllerOrder(KeyEvent.VK_Z));
    }

}
