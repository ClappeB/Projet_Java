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
	
	public void checkMonster(Map map) {
		int refPosX = this.getPosX(), refPosY = this.getPosY();
		Entity blockUp = map.getEntity(this.getPosX(), this.getPosY()-1);
		Entity blockLeft = map.getEntity(refPosX-1, refPosY);
		Entity blockRight = map.getEntity(refPosX+1, refPosY);
		Entity blockDown = map.getEntity(refPosX, refPosY+1);
		if(blockUp instanceof Monster || blockLeft instanceof Monster || blockRight instanceof Monster || blockDown instanceof Monster) {
			this.setIsAlive(false);
		}
	}
	
	public void goUp(Map map) {
		Entity blockUp = map.getEntity(this.getPosX(), this.getPosY()-1);
		if(blockUp instanceof BackgroundDirt) {
			super.goUp(map);
		} else if(blockUp instanceof Dirt) {
			super.goUp(map);
		}
	}
		
	public void goDown(Map map) {
		Entity blockDown = map.getEntity(this.getPosX(), this.getPosY()+1);
		if(blockDown instanceof BackgroundDirt) {
			super.goDown(map);
		} else if(blockDown instanceof Dirt) {
			super.goDown(map);
		}
	}
		
	public void goLeft(Map map) {
		Entity blockLeft = map.getEntity(this.getPosX()-1, this.getPosY());
		if(blockLeft instanceof BackgroundDirt) {
			super.goLeft(map);
		} else if(blockLeft instanceof Dirt) {
			super.goLeft(map);
		}
	}
		
	public void goRight(Map map) {
		Entity blockRight = map.getEntity(this.getPosX()+1, this.getPosY());
		if(blockRight instanceof BackgroundDirt) {
			super.goRight(map);
		} else if(blockRight instanceof Dirt) {
			super.goRight(map);
		}
	}
}
