package entity;

public abstract class Killable extends MobileElements {
		
		private boolean isAlive = true;
		
		Killable(Sprite sprite, Permeability permeability){
			super(sprite, permeability);
		}
		
		public boolean isAlive() {
			return isAlive;
		}

		public void setIsAlive(boolean isAlive) {
			this.isAlive = isAlive;
		}
}
