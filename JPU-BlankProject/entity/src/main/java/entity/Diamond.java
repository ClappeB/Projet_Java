package entity;
/** Diamond */
public class Diamond extends Gravity {
	/** Sprite */
	private static Sprite SPRITE = new Sprite('D', "diamond.png");
	
	Diamond() {
		super(SPRITE, Permeability.UNBLOCKING);
	}
	
}
