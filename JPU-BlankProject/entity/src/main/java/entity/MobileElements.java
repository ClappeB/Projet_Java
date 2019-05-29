package entity;

public abstract class MobileElements extends Entity {
	
	MobileElements(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
	}
	
	public void goUp() {
		Map.changeEntityPosition(this, Map.getEntity(this.getPosX(), this.getPosY() - 1));
	}
	
	public void goDown() {
		Map.changeEntityPosition(this, Map.getEntity(this.getPosX(), this.getPosY() +1 ));
	}
	
	public void goLeft() {
		Map.changeEntityPosition(this, Map.getEntity(this.getPosX() - 1, this.getPosY()));
	}
	
	public void goRight() {
		Map.changeEntityPosition(this, Map.getEntity(this.getPosX() + 1, this.getPosY()));
	}
}
