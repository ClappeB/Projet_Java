package entity;
/** Monster bat */
public class Bat extends Monster {
	
	/** Sprite */
	private static Sprite sprite = new Sprite('C',"bat.png");
	
	Bat() {
		super(sprite, Permeability.UNBLOCKING);
	} 
	/**
	 *  Bat's movement 
	 *  @param Map
	 */ 
	public void behaviour(Map map) {
		int random = (int)(Math.random() * 4)+1;
		
		switch(random) {
		case 1:
			this.goLeft(map);
			break;
		case 2:
			this.goDown(map);
			break;
		case 3:
			this.goRight(map);
			break;
		case 4:
			this.goUp(map);
			break;
		default:
			break;
		}
	}
}
