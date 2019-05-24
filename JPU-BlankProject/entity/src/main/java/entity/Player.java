package entity;

public class Player extends Killable {
	
	private int diamondNumber;
	
	Player() {
		
	}

	public int getDiamondNumber() {
		return diamondNumber;
	}

	public void setDiamondNumber(int diamondNumber) {
		this.diamondNumber = diamondNumber;
	}
}
