package entity;

public class Exit extends MotionLessElements {

	private static final Sprite SPRITE = new Sprite('e', "mur incassable.png");
			
	Exit() {
		
		super(SPRITE, Permeability.BLOCKING);
	}
	
	public void diamondCheck() {
		
	}
}
