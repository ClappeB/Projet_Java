package entity;

public class Rock extends Gravity implements IKill{

		private static Sprite SPRITE = new Sprite('R', "rock.png");
	
		Rock() {
			super(SPRITE, Permeability.BLOCKING);
		}
		
		public void pushedLeft() {
			
		}
		
		public void pushedRight() {
			
		}
		
		public void kill() {
			
		}
}
