package entity;

public class BackgroundDirt extends MotionLessElements {

	private static final Sprite SPRITE = new Sprite('B', "backgroundDirt.png");
	
	BackgroundDirt() {
		super(SPRITE, Permeability.UNBLOCKING);
	}
}
