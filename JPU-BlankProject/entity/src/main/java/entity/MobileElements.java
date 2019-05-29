package entity;

public abstract class MobileElements extends Entity {
	
	MobileElements(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
	}
	
	public void goUp(Map map) {
		map.changeEntityPosition(this, map.getEntity(this.getPosX(), this.getPosY() - 1));
	}
	
	public void goDown(Map map) {
		map.changeEntityPosition(this, map.getEntity(this.getPosX(), this.getPosY() + 1));
	}
	
	public void goLeft(Map map) {
		map.changeEntityPosition(this, map.getEntity(this.getPosX() - 1, this.getPosY()));
	}
	
	public void goRight(Map map) {
		map.changeEntityPosition(this, map.getEntity(this.getPosX() + 1, this.getPosY()));
	}
}
