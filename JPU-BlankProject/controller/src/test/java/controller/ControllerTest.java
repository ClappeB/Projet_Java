package controller;
/**
 * Controller Test
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Observable;

import org.junit.Before;
import org.junit.Test;

import contract.ControllerOrder;
import contract.IModel;
import contract.IView;
import entity.Map;

public class ControllerTest {
	/** a Controler */
	private Controller controller;
	/** a Fake model */
	private FakeModel model;
	/** a Fake view */
	private FakeView view;
	
	/** New FakeView, new fakeModel, new controller*/
	@Before
	public void setUp() throws Exception {
		view = new FakeView(new FakeModel());
		model = new FakeModel();
		controller = new Controller(view, model);
	}

	/** Test the controller */
	@Test
	public void testController() {
		assertNotNull("The controller shouldn't be null",controller);
	}
	
	/** Test the oder perform */
	@Test
	public void testOrderPerform() {
		final ControllerOrder expected = ControllerOrder.q;
		controller.orderPerform(ControllerOrder.q);
		assertEquals(expected, controller.getOrderPerform()); 
	}
	
	class FakeModel implements IModel {

		FakeModel() {
			
		}
		/** Fake model get map */
		@Override
		public Map getMap() {
			return null;
		}
		/** Fake model load map*/
		@Override
		public void loadMap() {
			
		}
		/** Get an obervable */
		@Override
		public Observable getObservable() {
			return new Observable();
		}
	}
	
	class FakeView implements IView {
		
		FakeView(FakeModel model) {
			
		}
		/** Fake view print message */
		@Override
		public void printMessage(String message) {
			
		}
	}
}
