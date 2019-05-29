package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import entity.Entity;
import entity.Exit;
import entity.Factory;
import entity.Gravity;
import entity.Permeability;
import entity.Player;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/**
     * Control.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
		Entity entityWorking;
		int temporizer = 0;
		//this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
		this.model.getMap().print();
		while(((Player)Factory.createPlayer()).isAlive()) {
			if(temporizer==10) {
			for(int y = this.model.getMap().getHeight() - 1; y > 0 ; y--) {
				for(int x = 0; x < this.model.getMap().getWidth(); x++) {
					entityWorking = this.model.getMap().getEntity(x, y);
					if(entityWorking instanceof Gravity) {
						((Gravity)entityWorking).fall(this.model.getMap());
					}
				}
				
			}
			((Exit)Factory.createExit()).diamondCheck(((Player)Factory.createPlayer()).getDiamondNumber());
			Entity blockDown = this.model.getMap().getEntity(((Player)Factory.createPlayer()).getPosX(),((Player)Factory.createPlayer()).getPosY() + 1);
			if(blockDown instanceof Exit) {
				if(((Exit)Factory.createExit()).getPermeability() == Permeability.UNBLOCKING) {
					this.view.printMessage("Vous avez gagné ! BRAVO !");
				}
			}
			
			temporizer=0;
			}
			temporizer++;
			this.model.getMap().refresh();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("You got "+((Player)Factory.createPlayer()).getDiamondNumber()+" diamond(s)");
		System.out.println("-----------------------------------");
		this.model.getMap().print();
		this.view.printMessage("GAME OVER");
	
}

	/**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case z:
				((Player)Factory.createPlayer()).goUp(this.model.getMap());
//				this.model.loadHelloWorld("GB");
				break;
			case s:
				((Player)Factory.createPlayer()).goDown(this.model.getMap());
//				this.model.loadHelloWorld("FR");
				break;
			case q:
				((Player)Factory.createPlayer()).goLeft(this.model.getMap());
//				this.model.loadHelloWorld("DE");
				break;
			case d:
				((Player)Factory.createPlayer()).goRight(this.model.getMap());
//				this.model.loadHelloWorld("ID");
				break;
			default:
				break;
			
			
		}
	}

}
