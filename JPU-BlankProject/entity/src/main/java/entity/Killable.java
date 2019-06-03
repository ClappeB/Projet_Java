package entity;
/** Killable entity */
public abstract class Killable extends MobileElements {
		/** Life status */
		private boolean isAlive = true;
		
		/** Sprite */
		Killable(Sprite sprite, Permeability permeability){
			super(sprite, permeability);
		}
		/** Check life status */
		public boolean isAlive() {
			return isAlive;
		}
		
		/** Set life status */
		public void setIsAlive(boolean isAlive) {
			this.isAlive = isAlive;
		}
}
