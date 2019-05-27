package entity;

public class Diamond extends Gravity implements IKill{
	
	private static Sprite SPRITE = new Sprite('P', "diamond.png");
	
	Diamond() {
		super(SPRITE, Permeability.UNBLOCKING);
	}
	
	public void kill() {
		if() {
			Player.isAlive() = False;
		}
	}
}
