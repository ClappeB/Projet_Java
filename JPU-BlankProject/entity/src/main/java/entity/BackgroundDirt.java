package entity;

public class BackgroundDirt extends MotionLessElements {
	
	private static final Sprite sprite = new Sprite('B', "backgroundDirt.png");
	
	BackgroundDirt() {
		super(sprite, Permeability.NON_INTERACTING);
	}
		
}
