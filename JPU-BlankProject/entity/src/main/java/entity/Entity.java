package entity;

import entity.exceptions.WrongCoordinates;

/**
 * The Class Entity.
 *
 * 
 */
public abstract class Entity {
	
	/** Sprite */
	private Sprite sprite;
	/** Permeability */
	private Permeability permeability;
	/** Horizontal position */
	private int posX;
	/** Vertical position */
	private int posY;
	/**
	 * Entity constructor
	 *  
	 */
	Entity(Sprite sprite, Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	/** Get gprite */
	public Sprite getSprite() {
		return sprite;
	}

	/** Set sprite */
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	/** Get permeability */
	public Permeability getPermeability() {
		return permeability;
	}

	/** Set permeability */
	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}

	/** Horizontal position */
	public int getPosX() {
		return posX;
	}
	
	/** Set horizontal position */
	public void setPosX(int posX) {
		if(posX<0) {
			throw new WrongCoordinates("Coordinates can't be negative.");
		} else {
			this.posX = posX;
		}
	}

	/** Vertical position */
	public  int getPosY() {
		return posY;
	}

	/** Set vertical postion */
	public void setPosY(int posY) {
		if(posY<0) {
			throw new WrongCoordinates("Coordinates can't be negative.");
		} else {
			this.posY = posY;
		}
	}
}
