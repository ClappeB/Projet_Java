package contract;

import java.util.Observable;

import entity.Map;
/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets map.
	 *
	 * @return the map
	 */
	Map getMap();

	/**
	 * Load the map.
	 */
	void loadMap();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
