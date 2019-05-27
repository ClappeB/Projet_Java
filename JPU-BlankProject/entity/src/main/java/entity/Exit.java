package entity;

public class Exit extends MotionLessElements {

	private static final Sprite SPRITE = new Sprite('e', ".png");
	private Sprite EXIT = new Sprite('e', "exit.png");
			
	Exit() {
		super(SPRITE, Permeability.BLOCKING);
	}
	
	public void diamondCheck() {
		if(Player.getDiamondNumber() <= 5) {
			this.setSprite(EXIT);
			this.setPermeability(Permeability.UNBLOCKING);
		}
	}
}
