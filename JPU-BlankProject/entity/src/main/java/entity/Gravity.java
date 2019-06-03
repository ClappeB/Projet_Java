package entity;

public abstract class Gravity extends MobileElements implements IKill {
	
		/** Object's status*/
		private boolean isFalling;
	
		/** Sprite
		 *@param Sprite 
		 *@param Permeability
		 */
		Gravity(Sprite sprite, Permeability permeability) {
			super(sprite, permeability);
		}
		
		/** Falling comportements 
		 *@param Map 
		 */
		public void fall(Map map) {
			int refPosX = this.getPosX(), refPosY = this.getPosY();
			Entity blockUnder = map.getEntity(refPosX, refPosY+1);
			Entity blockLeft = map.getEntity(refPosX-1, refPosY);
			Entity blockLeftDown = map.getEntity(refPosX-1, refPosY+1);
			Entity blockRight = map.getEntity(refPosX+1, refPosY);
			Entity blockRightDown = map.getEntity(refPosX+1, refPosY+1);
			
			if(blockUnder instanceof BackgroundDirt) {
				this.goDown(map);
				this.isFalling=true;
			} else if(blockUnder instanceof Killable && this.isFalling==true) {
				this.kill(map, (Killable)blockUnder);
				this.goDown(map);
			} else if((blockUnder instanceof Rock || blockUnder instanceof UnbreakableBlock || blockUnder instanceof Diamond )){
				if(blockLeft instanceof BackgroundDirt) {
					if(blockLeftDown instanceof BackgroundDirt) {
						this.goLeft(map);
						this.goDown(map);
						this.isFalling=true;
					}
					
					if(blockLeftDown instanceof Killable) {
						this.goLeft(map);
						this.goDown(map);
						this.kill(map, (Killable)blockLeftDown);
					}
				} else if(blockRight instanceof BackgroundDirt) {
					
					if(blockRightDown instanceof BackgroundDirt) {
						this.goRight(map);
						this.goDown(map);
						this.isFalling=true;
					}
					
					if(blockRightDown instanceof Killable) {
						this.goRight(map);
						this.goDown(map);
						this.kill(map, (Killable)blockRightDown);
					}
				} else {
					this.isFalling=false;
				}
			} else {
				this.isFalling=false;
			}
			
		}
		/** Can kill killable 
		 *@param Map
		 *@param Killable 
		 */
		public void kill(Map map, Killable killable) {
			if(killable instanceof Monster) {
				((Monster) killable).diamondExplosion(map);
			} else {
				map.replaceEntityByBackgroundDirtOrDiamond(killable, "Dirt");
				killable.setIsAlive(false);
			}
		}
}