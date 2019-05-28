package entity;

public class BackgroundDirt extends MotionLessElements {
	
	private static final Sprite sprite = new Sprite('B', "backgroundDirt.png");
	private static final Permeability permeability = Permeability.UNBLOCKING;
	
	BackgroundDirt() {
		super(sprite, permeability);
	}
		
}
