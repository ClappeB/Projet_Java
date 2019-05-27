package entity;

public abstract class Gravity extends MobileElements {

		Gravity(Sprite sprite, Permeability permeability) {
			super(sprite, permeability);
		}
		
		public void fall() {
			if(this.getPosY()-1 instanceof BackgroundDirt ) {
				
			}
		}
}

