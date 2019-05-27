package entity;

public class Exit extends MotionLessElements {

	private static final Sprite SPRITE = new Sprite('e', "exit.jpg");
			
	Exit() {
		
		super(SPRITE, Permeability.BLOCKING);
	}
	
	public void diamondCheck() {
		
	}
}
