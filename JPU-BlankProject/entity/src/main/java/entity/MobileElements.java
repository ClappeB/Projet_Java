package entity;

public abstract class MobileElements extends Entity {
	
	MobileElements(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
	}
	
	public void goUp() {
		this.setPosY(this.getPosY() - 1);
	}
	
	public void goDown() {
//		this.setPosY(this.getPosY() + 1);
//		System.out.println(this);
//		System.out.println(this.getPosX());
//		System.out.println(this.getPosY());
		Map.changeEntityPosition(this, Map.getEntity(this.getPosX(), this.getPosY()+1));
	}
	
	public void goLeft() {
		this.setPosX(this.getPosX() - 1);
	}
	
	public void goRight() {
		this.setPosX(this.getPosX() + 1);
	}
}
