package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import entity.Entity;
import entity.Exit;
import entity.Factory;
import entity.Gravity;
import entity.Monster;
import entity.Player;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	private ControllerOrder playerOrder;
	
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
		playerOrder = ControllerOrder.noMove;
		
		while(((Player)Factory.createPlayer()).isAlive() && !((Exit)Factory.createExit()).getExitReached()) {
				for(int y = this.model.getMap().getHeight() - 1; y > 0 ; y--) {
					for(int x = 0; x < this.model.getMap().getWidth(); x++) {
						entityWorking = this.model.getMap().getEntity(x, y);
						if(entityWorking instanceof Gravity) {
							((Gravity)entityWorking).fall(this.model.getMap());
						}
						if(entityWorking instanceof Monster) {
							((Monster)entityWorking).behaviour(this.model.getMap());
						}
					}
				
				}
				
				if(((Exit)Factory.createExit()).diamondCheck(((Player)Factory.createPlayer()).getDiamondNumber())) {
					((Exit)Factory.createExit()).playerCheck(this.model.getMap());
				}
			
				((Player)Factory.createPlayer()).checkMonster(this.model.getMap());
				
				switch(playerOrder) {
				case z:
					((Player)Factory.createPlayer()).goUp(this.model.getMap());
					playerOrder=ControllerOrder.noMove;
					break;
				case s:
					((Player)Factory.createPlayer()).goDown(this.model.getMap());
					playerOrder=ControllerOrder.noMove;
					break;
				case q:
					((Player)Factory.createPlayer()).goLeft(this.model.getMap());
					playerOrder=ControllerOrder.noMove;
					break;
				case d:
					((Player)Factory.createPlayer()).goRight(this.model.getMap());
					playerOrder=ControllerOrder.noMove;
					break;
				default:
					break;
			}
			
			this.model.getMap().refresh();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(((Exit)Factory.createExit()).getExitReached()) {
			this.view.printMessage("Vous avez gagné ! BRAVO !");
		} else {
			this.view.printMessage("GAME OVER");
		}
		System.out.println("You got "+((Player)Factory.createPlayer()).getDiamondNumber()+" diamond(s)");
	
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
				playerOrder=ControllerOrder.z;
				break;
			case s:
				playerOrder=ControllerOrder.s;
				break;
			case q:
				playerOrder=ControllerOrder.q;
				break;
			case d:
				playerOrder=ControllerOrder.d;
				break;
			default:
				break;
			
			
		}
	}

}
