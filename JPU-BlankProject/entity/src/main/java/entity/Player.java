package entity;

public class Player extends Killable {
	
	private static int diamondNumber;
	
	Player() {
		
	}

	public static int getDiamondNumber() {
		return diamondNumber;
	}

	public void setDiamondNumber(int diamondNumber) {
		this.diamondNumber = diamondNumber;
	}
}
