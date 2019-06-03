package entity;

import entity.exceptions.WrongCoordinates;

/**
 * The Class Entity.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Entity {
	
	private Sprite sprite;
	private Permeability permeability;
	private int posX;
	private int posY;
	
	Entity(Sprite sprite, Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public Permeability getPermeability() {
		return permeability;
	}

	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		if(posX<0) {
			throw new WrongCoordinates("Coordinates can't be negative.");
		} else {
			this.posX = posX;
		}
	}

	public  int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		if(posY<0) {
			throw new WrongCoordinates("Coordinates can't be negative.");
		} else {
			this.posY = posY;
		}
	}
}
