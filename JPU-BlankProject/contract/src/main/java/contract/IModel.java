package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

//	/**
//	 * Gets the hello world.
//	 *
//	 * @return the helloworld entity
//	 */
//	Map getMap();

	/**
	 * Load the map.
	 *
	 * @param code
	 *          the code
	 */
	void loadMap(int code);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
