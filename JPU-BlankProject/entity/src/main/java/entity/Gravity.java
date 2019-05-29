package entity;

public abstract class Gravity extends MobileElements {

		Gravity(Sprite sprite, Permeability permeability) {
			super(sprite, permeability);
		}
		
		public void fall(Map map) {
			int refPosX = this.getPosX(), refPosY = this.getPosY();
			Entity blockUnder = map.getEntity(refPosX, refPosY+1);
			Entity blockLeft = map.getEntity(refPosX-1, refPosY);
			Entity blockLeftDown = map.getEntity(refPosX-1, refPosY+1);
			Entity blockRight = map.getEntity(refPosX+1, refPosY);
			Entity blockRightDown = map.getEntity(refPosX+1, refPosY+1);
			
			if(blockUnder instanceof BackgroundDirt) {
				this.goDown(map);
			} else if(blockUnder instanceof Killable) {
				((Killable) blockUnder).setIsAlive(false);
			} else if((blockUnder instanceof Rock || blockUnder instanceof UnbreakableBlock) && blockLeft instanceof BackgroundDirt && blockLeftDown instanceof BackgroundDirt){
				this.goLeft(map);
				this.goDown(map);
			} else if((blockUnder instanceof Rock || blockUnder instanceof UnbreakableBlock) && blockRight instanceof BackgroundDirt && blockRightDown instanceof BackgroundDirt) {
				this.goRight(map);
				this.goDown(map);
			}
			
		}
}