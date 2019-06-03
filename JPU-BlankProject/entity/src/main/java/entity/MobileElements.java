package entity;
/** 
 * The Class MobileElements
 */
public abstract class MobileElements extends Entity {
	
	/** Sprite  */
	MobileElements(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
	}
	/** Go up */
	public void goUp(Map map) {
		map.changeEntityPosition(this, map.getEntity(this.getPosX(), this.getPosY() - 1));
	}
	/** Go Down */
	public void goDown(Map map) {
		map.changeEntityPosition(this, map.getEntity(this.getPosX(), this.getPosY() + 1));
	}
	
	/** Go left */
	public void goLeft(Map map) {
		map.changeEntityPosition(this, map.getEntity(this.getPosX() - 1, this.getPosY()));
	}
	
	/** Go right */
	public void goRight(Map map) {
		map.changeEntityPosition(this, map.getEntity(this.getPosX() + 1, this.getPosY()));
	}
}
