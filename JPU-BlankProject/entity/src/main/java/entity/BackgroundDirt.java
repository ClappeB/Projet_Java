package entity; 
/** Background after the player dig */
public class BackgroundDirt extends MotionLessElements {
	/** Sprite */
	private static final Sprite sprite = new Sprite('B', "backgroundDirt.png");
	
	BackgroundDirt() {
		/**
		 * Sprite
		 * @param sprite
		 * @param Permeability
		 */
		super(sprite, Permeability.NON_INTERACTING);
	}
		
}
