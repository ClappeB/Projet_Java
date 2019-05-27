package entity;

public class Exit extends MotionLessElements {

	private static final Sprite SPRITE = new Sprite('e', "mur incassable.png");
	private Sprite EXIT = new Sprite('e', "Porte.png");
			
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
