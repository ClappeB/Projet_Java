package entity;

public class Diamond extends Gravity implements IKill{
	
	private static Sprite sprite = new Sprite('P', "Image jeu/Diamand/Diamand.png");
	private static final Permeability permeability = Permeability.UNBLOCKING;
	
	Diamond() {
		super(sprite, permeability);
	}
	
	public void kill() {
		
	}
}
