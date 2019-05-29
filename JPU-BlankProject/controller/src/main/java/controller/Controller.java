package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import entity.Entity;
import entity.Factory;
import entity.Gravity;
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
		//this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
		this.model.getMap().print();
		while(((Player)Factory.createPlayer()).isAlive()) {
			for(int y = this.model.getMap().getHeight() - 1; y > 0 ; y--) {
				for(int x = 0; x < this.model.getMap().getWidth(); x++) {
					entityWorking = this.model.getMap().getEntity(x, y);
					if(entityWorking instanceof Gravity) {
						((Gravity)entityWorking).fall(this.model.getMap().getEntity(x, y + 1),
								this.model.getMap().getEntity(x - 1, y),
								this.model.getMap().getEntity(x - 1, y + 1),
								this.model.getMap().getEntity(x + 1, y),
								this.model.getMap().getEntity(x + 1, y + 1));
						this.model.getMap().refresh();
					}
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
			case English:
//				this.model.loadHelloWorld("GB");
				break;
			case Francais:
//				this.model.loadHelloWorld("FR");
				break;
			case Deutsch:
//				this.model.loadHelloWorld("DE");
				break;
			case Indonesia:
//				this.model.loadHelloWorld("ID");
				break;
			default:
				break;
				
			
		}
	}

}
