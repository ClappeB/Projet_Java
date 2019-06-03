package entity;
/** Diamond */
public class Diamond extends Gravity {
	/** Sprite
	 * @param D
	 * @param diamond.png
	 */
	private static Sprite SPRITE = new Sprite('D', "diamond.png");
	
	Diamond() {
		
		super(SPRITE, Permeability.UNBLOCKING);
	}
	
}
