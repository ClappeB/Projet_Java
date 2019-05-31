package entity;

public class Rock extends Gravity {

		private static Sprite SPRITE = new Sprite('R', "rock.png");
	
		Rock() {
			super(SPRITE, Permeability.BLOCKING);
		}
		
		boolean pushedLeft(Map map) {
			if(map.getEntity(this.getPosX()-1, this.getPosY()) instanceof BackgroundDirt) {
				this.goLeft(map);
				return true;
			}
			return false;
		}
		
		boolean pushedRight(Map map) {
			if(map.getEntity(this.getPosX()+1, this.getPosY()) instanceof BackgroundDirt) {
				this.goRight(map);
				return true;
			}
			return false;
		}
		
}
