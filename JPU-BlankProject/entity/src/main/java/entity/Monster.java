package entity;

public class Monster extends Killable implements IKill{
	
	private static Sprite SPRITE = new Sprite('M', "octopus.png");
	
	Monster() {
		super(SPRITE, Permeability.UNBLOCKING);
	}
	
	public void diamondExplosion() {
		
	}
	
	public void kill() {
		
	}
}
