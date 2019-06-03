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
	 *  @param Sprite @param permeability
	 */
	Entity(Sprite sprite, Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	/** Get sprite
	 * @return sprite
	*/
	public Sprite getSprite() {
		return sprite;
	}

	/** Set sprite 
	 *@param Sprite 
	 */
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	/** Get permeability 
	 *@return permeability 
	 */
	public Permeability getPermeability() {
		return permeability;
	}

	/** Set permeability 
	 * @param permeability
	 */
	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}

	/** Horizontal position
	 *@return posX 
	 */
	public int getPosX() {
		return posX;
	}
	
	/** Set horizontal position
	 * 
	 *@param posX  
	 */
	public void setPosX(int posX) {
		if(posX<0) {
			throw new WrongCoordinates("Coordinates can't be negative.");
		} else {
			this.posX = posX;
		}
	}

	/** Vertical position 
	 *@return posY 
	 */
	public  int getPosY() {
		return posY;
	}

	/** Set vertical postion 
	 * @param posY
	  */
	public void setPosY(int posY) {
		if(posY<0) {
			throw new WrongCoordinates("Coordinates can't be negative.");
		} else {
			this.posY = posY;
		}
	}
}
