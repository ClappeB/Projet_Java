package entity;

public class Diamond extends Gravity {
	
	private static Sprite SPRITE = new Sprite('D', "diamond.png");
	
	Diamond() {
		super(SPRITE, Permeability.UNBLOCKING);
	}
	
}
