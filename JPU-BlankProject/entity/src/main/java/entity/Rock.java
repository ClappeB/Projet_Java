package entity;

public class Rock extends Gravity implements IKill{

		private static Sprite SPRITE = new Sprite('R', "rock.png");
	
		Rock() {
			super(SPRITE, Permeability.BLOCKING);
		}
		
		public void pushedLeft(Entity blockLeft) {
			if(blockLeft instanceof BackgroundDirt) {
				this.goLeft();
			}
		}
		
		public void pushedRight(Entity blockRight) {
			if(blockRight instanceof BackgroundDirt) {
				this.goRight();
			}
		}
		
		public void kill(Killable killable) {
			killable.setIsAlive(false);
		}
}
