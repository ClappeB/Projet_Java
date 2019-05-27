package entity;

public abstract class Killable extends MobileElements {
		
		private boolean isAlive = true;
		
		Killable(Sprite sprite, Permeability permeability){
			super(sprite, permeability);
		}
		
		public boolean isLifeStatus() {
			return isAlive;
		}

		public void setLifeStatus(boolean isAlive) {
			this.isAlive = isAlive;
		}
}
