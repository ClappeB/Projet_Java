package entity;

public class UnbreakableBlock extends MotionLessElements {

	private static final Sprite SPRITE = new Sprite('U', "unbreakable.png");
	
	UnbreakableBlock() {
		super(SPRITE, Permeability.BLOCKING);
	}
}
