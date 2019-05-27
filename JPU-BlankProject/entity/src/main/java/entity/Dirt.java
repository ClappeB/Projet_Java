package entity;

public class Dirt extends MotionLessElements {
	
	private static final Sprite SPRITE = new Sprite('.', "dirt.png");

	Dirt() {
		super(SPRITE, Permeability.UNBLOCKING);
	}
}
