package contract;

/**
 * The Interface IController.
 *
 * 
 */
public interface IController {

	/**
	 * The way the game will run.
	 */
	public void control();

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	public void orderPerform(ControllerOrder controllerOrder);
}
