package entity;

public class Monster extends Killable implements IKill{
	
	private static Sprite sprite = new Sprite('M', "bat.png");
	
	Monster() {
		super(sprite, Permeability.UNBLOCKING);
	}
	
	public void diamondExplosion() {
		
	}
	
	public void kill(Killable killable) {
		if(killable instanceof Player) {
			killable.setIsAlive(false);
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
	
	public void mouvement1(Map map) {
		this.goLeft(map);
		this.goDown(map);
		this.goRight(map);
		this.goUp(map);
	}
}
