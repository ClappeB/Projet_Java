package entity;
/** Pattern Factory */
public abstract class Factory {
	
	private static Player player = null;
	private static Exit exit = null;
	
	/** New Diamond */
	public static Entity createDiamond() {
		return new Diamond();
	}
	
	/** New Rock */
	public static Entity createRock() {
		return new Rock();
	}
	
	/** New bat */
	public static Entity createBat() {
		return new Bat();
	}
	
	/** New octopus */
	public static Entity createOctopus() {
		return new Octopus();
	}
	
	/** New Player */
	public static Entity createPlayer() {
		
		if(player==null) {
			player = new Player();
		}
		return player;
	}
	/** New Exit */
	public static Entity createExit() {
		if(exit==null) {
			exit = new Exit();
		}
		return exit;
	} 
	
	/** New Dirt */
	public static Entity createDirt() {
		return new Dirt();
	}
	
	/** New UnbreakableBlock */
	public static Entity createUnbreakableBlock() {
		return new UnbreakableBlock();
	}
	
	/** New BackgroundDrit*/
	public static Entity createBackgroundDirt() {
		return new BackgroundDirt();
	}
	
	/** Choise of the object */
	public static Entity getFromFileSymbol(char symbol) {
		switch(symbol) {
			case '.':
				return createDirt();
			case 'R':
				return createRock();
			case 'U':
				return createUnbreakableBlock();
			case 'B':
				return createBackgroundDirt();
			case 'D':
				return createDiamond();
			case 'C':
				return createBat();
			case 'O':
				return createOctopus();
			case 'P':
				return createPlayer();
			case 'E':
				return createExit();
			default :
				return null;
		}
		
	}
	
}
