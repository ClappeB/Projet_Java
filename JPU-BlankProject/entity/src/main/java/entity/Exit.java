package entity;

public class Exit extends MotionLessElements {
/**
 * The Class Exit
 */
	/** Sprite 
	 *@param E @param unbreakableBlock.png 
	 */
	private static final Sprite SPRITE = new Sprite('E', "unbreakableBlock.png");
	/** Sprite
	 * @param E @param exit.png
	 *  */
	private Sprite EXIT = new Sprite('E', "exit.png");
	/** Exit reach by the player */
	private boolean exitReached;
			
	/** Exit constructor */
	Exit() {
		super(SPRITE, Permeability.BLOCKING);
		this.exitReached=false;
	}
	
	/** Check if the player as enough diamond to unlock the exit. 
	 *@param diamondNumber 
	 */
	public boolean diamondCheck(int diamondNumber) {
		if(diamondNumber >= 5) {
			this.setSprite(EXIT);
			this.setPermeability(Permeability.UNBLOCKING);
			return true;
		}
		return false;
	}
	/** Check if the player has reached the exit
	 * @param Map 
	 */
	public void playerCheck(Map map) {
		Entity entityUp=null;
		Entity entityRight=null;
		Entity entityDown=null;
		Entity entityLeft=null;
		if(this.getPosY()-1>0) {
			entityUp = map.getEntity(this.getPosX(), this.getPosY()-1);
		}
		if(this.getPosX()+1<map.getWidth()) {
			entityRight = map.getEntity(this.getPosX()+1, this.getPosY());
		}
		if(this.getPosY()+1<map.getHeight()) {
			entityDown = map.getEntity(this.getPosX(), this.getPosY()+1);
		}
		if(this.getPosX()-1>0) {
			entityLeft = map.getEntity(this.getPosX()-1, this.getPosY());
		}
		
		if((entityUp!=null || entityRight!=null || entityDown!=null || entityLeft!=null) 
			&& (entityUp instanceof Player || entityRight instanceof Player || entityDown instanceof Player || entityLeft instanceof Player)) {
			this.exitReached=true;
		}
	}
	/** Check the status of the exit */
	public boolean getExitReached() {
		return exitReached;
	}
	
}
