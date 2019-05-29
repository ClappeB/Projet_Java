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
		Entity blockUp = map.getEntity(refPosX, refPosY-1);
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
			this.dig(map, blockUp);
			super.goUp(map);
		} else if(blockUp instanceof Dirt) {
			this.dig(map, blockUp);
			super.goUp(map);
			this.setDiamondNumber(getDiamondNumber()+1);
		}
	}
		
	public void goDown(Map map) {
		Entity blockDown = map.getEntity(this.getPosX(), this.getPosY()+1);
		if(blockDown instanceof BackgroundDirt) {
			super.goDown(map);
		} else if(blockDown instanceof Dirt) {
			this.dig(map, blockDown);
			super.goDown(map);
		} else if(blockDown instanceof Dirt) {
			this.dig(map, blockDown);
			super.goDown(map);
			this.setDiamondNumber(getDiamondNumber()+1);
		}
	}
		
	public void goLeft(Map map) {
		Entity blockLeft = map.getEntity(this.getPosX()-1, this.getPosY());
		if(blockLeft instanceof BackgroundDirt) {
			super.goLeft(map);
		} else if(blockLeft instanceof Dirt) {
			this.dig(map, blockLeft);
			super.goLeft(map);
		} else if(blockLeft instanceof Diamond) {
			this.dig(map, blockLeft);
			super.goLeft(map);
			this.setDiamondNumber(getDiamondNumber()+1);
		}
	}
		
	public void goRight(Map map) {
		Entity blockRight = map.getEntity(this.getPosX()+1, this.getPosY());
		if(blockRight instanceof BackgroundDirt) {
			super.goRight(map);
		} else if(blockRight instanceof Dirt) {
			this.dig(map, blockRight);
			super.goRight(map);
		} else if(blockRight instanceof Diamond) {
			this.dig(map, blockRight);
			super.goRight(map);
			this.setDiamondNumber(getDiamondNumber()+1);
		}
	}
	
	private void dig(Map map, Entity blockToDig) {
		Entity newEntity = Factory.createBackgroundDirt();
		map.setEntity(blockToDig.getPosX(), blockToDig.getPosY(), newEntity);
		newEntity.setPosX(blockToDig.getPosX());
		newEntity.setPosY(blockToDig.getPosY());
		map.getEntityList().remove(blockToDig);
		map.getEntityList().add(newEntity);
	}
}
