package entity;

public class Exit extends MotionLessElements {

	private static final Sprite SPRITE = new Sprite('E', "unbreakableBlock.png");
	private Sprite EXIT = new Sprite('E', "exit.png");
			
	Exit() {
		super(SPRITE, Permeability.BLOCKING);
	}
	
	public void diamondCheck(int diamondNumber) {
		if(diamondNumber >= 5) {
			this.setSprite(EXIT);
			this.setPermeability(Permeability.UNBLOCKING);
		}
	}
}
