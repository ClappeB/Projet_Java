package entity;

public abstract class Gravity extends MobileElements {

		Gravity(Sprite sprite, Permeability permeability) {
			super(sprite, permeability);
		}
		
		public void fall(Entity blockUnder, Entity blockLeft, Entity blockLeftDown, Entity blockRight, Entity blockRightDown) {
			if(blockUnder instanceof BackgroundDirt) {
				this.goDown();
			} else if(blockUnder instanceof Killable) {
				((Killable) blockUnder).setIsAlive(false);
			} else if(blockLeft instanceof BackgroundDirt && blockLeftDown instanceof BackgroundDirt){
				this.goLeft();
				this.goDown();
			} else if(blockRight instanceof BackgroundDirt && blockRightDown instanceof BackgroundDirt) {
				this.goRight();
				this.goDown();
			}
			
		}
}

