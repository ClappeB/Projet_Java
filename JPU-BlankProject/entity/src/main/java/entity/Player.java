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
	
	public void goUp(Map map) {
		Entity blockUp = map.getEntity(this.getPosX(), this.getPosY()-1);
		if(blockUp instanceof BackgroundDirt) {
			this.goUp(map);
		} else if(blockUp instanceof Dirt) {
			this.goUp(map);
			blockUp.setSprite(new Sprite('B', "backgroundDirt"));
		}
	}
		
	public void goDown(Map map) {
		Entity blockDown = map.getEntity(this.getPosX(), this.getPosY()+1);
		if(blockDown instanceof BackgroundDirt) {
			this.goDown(map);
		} else if(blockDown instanceof Dirt) {
			this.goDown(map);
			blockDown.setSprite(new Sprite('B', "backgroundDirt"));
		}
	}
		
	public void goLeft(Map map) {
		Entity blockLeft = map.getEntity(this.getPosX()-1, this.getPosY());
		if(blockLeft instanceof BackgroundDirt) {
			this.goLeft(map);
		} else if(blockLeft instanceof Dirt) {
			this.goLeft(map);
			blockLeft.setSprite(new Sprite('B', "backgroundDirt"));
		}
	}
		
	public void goRight(Map map) {
		Entity blockRight = map.getEntity(this.getPosX()+1, this.getPosY());
		if(blockRight instanceof BackgroundDirt) {
			this.goRight(map);
		} else if(blockRight instanceof Dirt) {
			this.goRight(map);
			blockRight.setSprite(new Sprite('B', "backgroundDirt"));
		}
	}
}
