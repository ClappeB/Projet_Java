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
}
