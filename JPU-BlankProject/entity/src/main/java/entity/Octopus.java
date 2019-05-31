package entity;

public class Octopus extends Monster {
	
	private static Sprite sprite = new Sprite('O', "octopus.png");
	
	Octopus() {
		super(sprite, Permeability.UNBLOCKING);
	} 
	
	public void behaviour(Map map) {
		Entity blockRight = map.getEntity(this.getPosX() + 1, this.getPosY());
		Entity blockLeft = map.getEntity(this.getPosX() - 1, this.getPosY());
		
		if(goLeft) {
			this.goLeft(map);
		}
		else {
			this.goRight(map);
		}
		if(!(blockLeft instanceof BackgroundDirt)) {
			goLeft = false;
		}
		if(!(blockRight instanceof BackgroundDirt)) {
			goLeft = true;
		}
	}
}
