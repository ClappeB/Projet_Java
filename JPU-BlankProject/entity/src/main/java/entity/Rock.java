package entity;

public class Rock extends Gravity implements IKill{

		private static Sprite SPRITE = new Sprite('R', "rock.png");
	
		Rock() {
			super(SPRITE, Permeability.BLOCKING);
		}
		
		public void pushedLeft(Map map) {
			Entity blockLeft = map.getEntity(this.getPosX()-1, this.getPosY());
			if(blockLeft instanceof BackgroundDirt) {
				this.goLeft(map);
			}
		}
		
		public void pushedRight(Map map) {
			Entity blockRight = map.getEntity(this.getPosX()+1, this.getPosY());
			if(blockRight instanceof BackgroundDirt) {
				this.goRight(map);
			}
		}
		
		public void kill(Killable killable) {
			killable.setIsAlive(false);
		}
}
