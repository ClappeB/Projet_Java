package entity;
/** Dirt dig by the player   */
public class Dirt extends MotionLessElements {
	/** Sprite */
	private static final Sprite SPRITE = new Sprite('.', "dirt.png");

	Dirt() {
		super(SPRITE, Permeability.UNBLOCKING);
	}
}
