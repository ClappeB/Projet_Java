package entity;

public abstract class Monster extends Killable implements IKill{
	
	protected boolean goLeft = true;
	
	Monster(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
	}
	
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
		
		for (Entity entity : squareAroundEntity) {
			if(entity instanceof BackgroundDirt || entity instanceof Monster) {
				map.replaceEntityByBackgroundDirtOrDiamond(entity, "Diamond");
			}
		}
	}
	
	public void goUp(Map map) {
		Entity blockUp = map.getEntity(this.getPosX(), this.getPosY()-1);
		if(blockUp instanceof BackgroundDirt) {
			super.goUp(map);
		} 
	}
		
	public void goDown(Map map) {
		Entity blockDown = map.getEntity(this.getPosX(), this.getPosY()+1);
		if(blockDown instanceof BackgroundDirt) {
			super.goDown(map);
		}
	}
	public void goLeft(Map map) {
		Entity blockLeft = map.getEntity(this.getPosX()-1, this.getPosY());
		if(blockLeft instanceof BackgroundDirt) {
			super.goLeft(map);
		}
	}
	public void goRight(Map map) {
		Entity blockRight = map.getEntity(this.getPosX()+1, this.getPosY());
		if(blockRight instanceof BackgroundDirt) {
			super.goRight(map);
		}
	}	
	
	public void behaviour(Map map) {
	}
	
	public void kill(Map map, Killable killable) {
		if(killable instanceof Player) {
			map.replaceEntityByBackgroundDirtOrDiamond(killable, "Dirt");
		}
	}
}
