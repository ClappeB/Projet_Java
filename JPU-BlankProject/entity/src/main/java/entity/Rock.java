package entity;
/**
 * The class Rock
 */
public class Rock extends Gravity {

		/** Sprite */
		private static Sprite SPRITE = new Sprite('R', "rock.png");
	
		/** Instantiate a new Rock */
		Rock() {
			super(SPRITE, Permeability.BLOCKING);
		}
		/** Can be pushed to the left 
		 * 
		 * @param Map
		 * 			The map
		 * @return boolean
		 * 
		 */
		boolean pushedLeft(Map map) {
			if(map.getEntity(this.getPosX()-1, this.getPosY()) instanceof BackgroundDirt) {
				this.goLeft(map);
				return true;
			}
			return false;
		}
		/** Can be pushed to the right 
		 * 
		 * @param Map
		 * 			The map
		 * @return boolean
		 * 
		 */
		boolean pushedRight(Map map) {
			if(map.getEntity(this.getPosX()+1, this.getPosY()) instanceof BackgroundDirt) {
				this.goRight(map);
				return true;
			}
			return false;
		}
		
}
