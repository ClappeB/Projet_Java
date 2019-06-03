package entity;
/** 
 * The Class MobileElements
 */
public abstract class MobileElements extends Entity {
	
	/** Sprite 
	 *@param Sprite
	 *@param Permeability 
	 */
	MobileElements(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
	}
	/** Go up 
	 * @param Map
	 * */
	public void goUp(Map map) {
		map.changeEntityPosition(this, map.getEntity(this.getPosX(), this.getPosY() - 1));
	}
	/** Go Down 
	 *  @param Map
	 */
	public void goDown(Map map) {
		map.changeEntityPosition(this, map.getEntity(this.getPosX(), this.getPosY() + 1));
	}
	
	/** Go left 
	 * @param Map
	  */
	public void goLeft(Map map) {
		map.changeEntityPosition(this, map.getEntity(this.getPosX() - 1, this.getPosY()));
	}
	
	/** Go right 
	 *@param Map
	 */
	public void goRight(Map map) {
		map.changeEntityPosition(this, map.getEntity(this.getPosX() + 1, this.getPosY()));
	}
}
