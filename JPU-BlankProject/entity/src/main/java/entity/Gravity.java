package entity;

public abstract class Gravity extends MobileElements {

		Gravity(Sprite sprite, Permeability permeability) {
			super(sprite, permeability);
		}
		
		public void fall() {
			if(this.getPosY() == UnbreakableBlock.getPosY()) {
				this.goRight();
				this.goDown();
			}
			else if(this.getPosY() == BackgroundDirt.getPosY()) {
				
			}
		}
}

