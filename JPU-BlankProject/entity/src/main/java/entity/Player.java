package entity; 
/**
 * The Class Player
 */
public class Player extends Killable {
	/** Diamond number at the start */
	private int diamondNumber=0;
	/** Sprite  */
	private static Sprite sprite = new Sprite('P', "face1.png");
	/** Sprite */
	Player() {
		super(sprite, Permeability.UNBLOCKING);
	}

	/** Get a diamond */
	public int getDiamondNumber() {
		return diamondNumber;
	}
	/** Set diamond number */
	public void setDiamondNumber(int diamondNumber) {
		this.diamondNumber = diamondNumber;
	}
	/** Check if there is a monster beside*/
	public void checkMonster(Map map) {
		int refPosX = this.getPosX(), refPosY = this.getPosY();
		if(map.getEntity(refPosX, refPosY-1) instanceof Monster || map.getEntity(refPosX-1, refPosY) instanceof Monster 
		   || map.getEntity(refPosX+1, refPosY) instanceof Monster || map.getEntity(refPosX, refPosY+1) instanceof Monster) {
			this.setIsAlive(false);
		}
	}
	/** Go up and dig*/
	public void goUp(Map map) {
		Entity blockUp = map.getEntity(this.getPosX(), this.getPosY()-1);
		if(blockUp instanceof BackgroundDirt) {
			super.goUp(map);
		} else if(blockUp instanceof Dirt) {
			this.dig(map, blockUp);
			super.goUp(map);
		} else if(blockUp instanceof Diamond) {
			this.dig(map, blockUp);
			super.goUp(map);
			this.setDiamondNumber(getDiamondNumber()+1);
		}
	}
	/** Go down and dig */
	public void goDown(Map map) {
		Entity blockDown = map.getEntity(this.getPosX(), this.getPosY()+1);
		if(blockDown instanceof BackgroundDirt) {
			super.goDown(map);
		} else if(blockDown instanceof Dirt) {
			this.dig(map, blockDown);
			super.goDown(map);
		} else if(blockDown instanceof Diamond) {
			this.dig(map, blockDown);
			super.goDown(map);
			this.setDiamondNumber(getDiamondNumber()+1);
		} 
	}
	/** Go left and dig */
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
		} else if(blockLeft instanceof Rock) {
			if(((Rock)blockLeft).pushedLeft(map)) {
				map.refresh();
				super.goLeft(map);
			}
		}
	}
	/** Go right and dig */
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
		} else if(blockRight instanceof Rock) {
			if(((Rock)blockRight).pushedRight(map)) {
				map.refresh();
				super.goRight(map);
			}
		}
	}
	/** Dig the dirt */
	private void dig(Map map, Entity blockToDig) {
		map.replaceEntityByBackgroundDirtOrDiamond(blockToDig, "Dirt");
	}
	
}
