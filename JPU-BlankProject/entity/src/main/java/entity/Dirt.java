package entity;
/** Dirt thta the player dig */
public class Dirt extends MotionLessElements {
	/** Sprite */
	private static final Sprite SPRITE = new Sprite('.', "dirt.png");

	Dirt() {
		super(SPRITE, Permeability.UNBLOCKING);
	}
}
