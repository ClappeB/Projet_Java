package entity;
/**
 * The Class Monster
 */
public abstract class Monster extends Killable implements IKill{
	/** Monster go left  */
	protected boolean goLeft = true;
	
	/** Sprite */
	Monster(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
	}
	/** Diamond explosion at the death of the monster */
	void diamondExplosion(Map map) {
		int refPosX = this.getPosX(), refPosY = this.getPosY();
		Entity[] squareAroundEntity = {
				map.getEntity(refPosX, refPosY), //Center
				map.getEntity(refPosX-1, refPosY-1), //LeftUp
				map.getEntity(refPosX, refPosY-1), //Up
				map.getEntity(refPosX+1, refPosY-1), //RightUp
				map.getEntity(refPosX+1, refPosY), //Right
				map.getEntity(refPosX+1, refPosY+1), //DownRight
				map.getEntity(refPosX, refPosY+1), //Down
				map.getEntity(refPosX-1, refPosY+1), //DownLeft
				map.getEntity(refPosX-1, refPosY)  //Left
			};
		
		map.replaceEntityByBackgroundDirtOrDiamond(this, "Diamond");
		for (Entity entity : squareAroundEntity) {
			if(entity instanceof BackgroundDirt) {
				map.replaceEntityByBackgroundDirtOrDiamond(entity, "Diamond");
			}
		}
	}
	/** Go up */
	public void goUp(Map map) {
		Entity blockUp = map.getEntity(this.getPosX(), this.getPosY()-1);
		if(blockUp instanceof BackgroundDirt) {
			super.goUp(map);
		} 
	}
	/** Go down */
	public void goDown(Map map) {
		Entity blockDown = map.getEntity(this.getPosX(), this.getPosY()+1);
		if(blockDown instanceof BackgroundDirt) {
			super.goDown(map);
		}
	}
	/** Go left */
	public void goLeft(Map map) {
		Entity blockLeft = map.getEntity(this.getPosX()-1, this.getPosY());
		if(blockLeft instanceof BackgroundDirt) {
			super.goLeft(map);
		}
	}
	/** Go right */
	public void goRight(Map map) {
		Entity blockRight = map.getEntity(this.getPosX()+1, this.getPosY());
		if(blockRight instanceof BackgroundDirt) {
			super.goRight(map);
		}
	}	
	/** Monster movement */
	public abstract void behaviour(Map map);
	
	/** Kill the player */
	public void kill(Map map, Killable killable) {
		if(killable instanceof Player) {
			map.replaceEntityByBackgroundDirtOrDiamond(killable, "Dirt");
		}
	}
}
