package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import entity.Map;

/**
 * The Class Model.
 *
 * 
 */
public final class Model extends Observable implements IModel {

	/** The game's map */
	private Map map;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.loadMap();
	}

	/**
	 * Get the map
	 * @return Map
	 */
	public Map getMap() {
		return this.map;
	}

	/**
     * Sets the map.
     *
     * @param map
     *            the new map
     */
	private void setMap(final Map map) {
		this.map = map;
		this.setChanged();
		this.notifyObservers();
	}

	/**
     * Load Map.
     *
     */
	public void loadMap() {
		try {
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
			this.setMap(daoMap.find());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
}
