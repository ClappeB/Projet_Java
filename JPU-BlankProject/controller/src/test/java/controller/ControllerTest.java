package controller;

import static org.junit.Assert.*;

import java.util.Observable;

import javax.swing.text.View;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import entity.Map;

public class ControllerTest {

	private static Controller controller;
	private static FakeModel model;
	private static FakeView view;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		view = new FakeView(new FakeModel());
		model = new FakeModel();
		controller = new Controller(view, model);
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testController() {
		assertNotNull("The controller shouldn't be null",controller);
	}

	@Test
	public void testControl() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testOrderPerform() {
		final ControllerOrder expected = ControllerOrder.q;
		controller.orderPerform(ControllerOrder.q);
		assertEquals(expected, controller.getOrderPerform()); 
	}
	
	class FakeModel implements IModel {

		FakeModel() {
			
		}
		
		@Override
		public Map getMap() {
			return null;
		}

		@Override
		public void loadMap() {
			
		}

		@Override
		public Observable getObservable() {
			return new Observable();
		}
	}
	
	class FakeView implements IView {
		
		FakeView(FakeModel model) {
			
		}

		@Override
		public void printMessage(String message) {
			
		}
	}
}
