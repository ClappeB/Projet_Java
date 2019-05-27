package entity;

public class Diamond extends Gravity implements IKill{
	
	private static Sprite SPRITE = new Sprite('D', "diamond.png");
	
	Diamond() {
		super(SPRITE, Permeability.UNBLOCKING);
	}
	
	public void kill(Killable killable) {
		killable.setLifeStatus(false);
	}
}
