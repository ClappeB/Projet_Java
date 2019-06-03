package entity;
/** Killable entity */
public abstract class Killable extends MobileElements {
		/** Life status */
		private boolean isAlive = true;
		
		/** Sprite 
		 *@param sprite 
		 *@param permeability 
		 */
		Killable(Sprite sprite, Permeability permeability){
			super(sprite, permeability);
		}
		/** Check life status 
		 * 
		 *@return isAlive 
		 */
		public boolean isAlive() {
			return isAlive;
		}
		
		/** Set life status 
		 *@param isAlive 
		 */
		public void setIsAlive(boolean isAlive) {
			this.isAlive = isAlive;
		}
}
