package entity;

public class Player extends Killable {
	
	private int diamondNumber=0;
	private static Sprite sprite = new Sprite('P', "Image jeu/Personnage/Face/Face 1.png");
	private static final Permeability permeability = Permeability.UNBLOCKING;
	
	Player() {
		super(sprite, permeability);
	}
	
	public Player(Sprite sprite) {
		super(sprite, permeability);
	}

	public int getDiamondNumber() {
		return diamondNumber;
	}

	public void setDiamondNumber(int diamondNumber) {
		this.diamondNumber = diamondNumber;
	}
}
