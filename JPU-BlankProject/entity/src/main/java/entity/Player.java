package entity;

public class Player extends Killable {
	
	private int diamondNumber=0;
	private static Sprite sprite = new Sprite('P', "face1.png");
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
	
	public void checkMonster(Entity blockUp, Entity blockLeft, Entity blockRight, Entity blockDown) {
		if(blockUp instanceof Monster || blockLeft instanceof Monster || blockRight instanceof Monster || blockDown instanceof Monster) {
			this.setIsAlive(false);
		}
	}
	
	public void goUp(Entity blockUp) {
		if(blockUp instanceof BackgroundDirt) {
			this.goUp();
		} else if(blockUp instanceof Dirt) {
			this.goUp();
			blockUp.setSprite(new Sprite('B', "BackgroundDirt"));
		}
	}
		
	public void goDown(Entity blockDown) {
		if(blockDown instanceof BackgroundDirt) {
			this.goDown();
		} else if(blockDown instanceof Dirt) {
			this.goDown();
			blockDown.setSprite(new Sprite('B', "BackgroundDirt"));
		}
	}
		
	public void goLeft(Entity blockLeft) {
		if(blockLeft instanceof BackgroundDirt) {
			this.goLeft();
		} else if(blockLeft instanceof Dirt) {
			this.goLeft();
			blockLeft.setSprite(new Sprite('B', "BackgroundDirt"));
		}
	}
		
	public void goRight(Entity blockRight) {
		if(blockRight instanceof BackgroundDirt) {
			this.goRight();
		} else if(blockRight instanceof Dirt) {
			this.goRight();
			blockRight.setSprite(new Sprite('B', "BackgroundDirt"));
		}
	}
}
