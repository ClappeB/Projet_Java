package entity;
/**
 * The class Rock
 */
public class Rock extends Gravity {

		/** Sprite */
		private static Sprite SPRITE = new Sprite('R', "rock.png");
	
		/** Sprite */
		Rock() {
			super(SPRITE, Permeability.BLOCKING);
		}
		/** Can be pushed to the left */
		boolean pushedLeft(Map map) {
			if(map.getEntity(this.getPosX()-1, this.getPosY()) instanceof BackgroundDirt) {
				this.goLeft(map);
				return true;
			}
			return false;
		}
		/** Can be pushed to the right */
		boolean pushedRight(Map map) {
			if(map.getEntity(this.getPosX()+1, this.getPosY()) instanceof BackgroundDirt) {
				this.goRight(map);
				return true;
			}
			return false;
		}
		
}
