package entity;

public class Bat extends Monster {

	private static Sprite sprite = new Sprite('C',"bat.png");
	
	Bat() {
		super(sprite, Permeability.UNBLOCKING);
	}
	
	public void behaviour(Map map) {
		int random = (int)(Math.random() * 5);
		
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
