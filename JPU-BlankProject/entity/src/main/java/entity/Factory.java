package entity;

public abstract class Factory {
	
	private static Player player = null;
	private static Exit exit = null;
	
	public static Entity createDiamond() {
		return new Diamond();
	}
	
	public static Entity createRock() {
		return new Rock();
	}
	
	public static Entity createMonster() {
		return new Monster();
	}
	
	public static Entity createPlayer() {
		
		if(player==null) {
			player = new Player();
		}
		return player;
	}
	
	public static Entity createExit() {
		if(exit==null) {
			exit = new Exit();
		}
		return exit;
	}
	
	public static Entity createDirt() {
		return new Dirt();
	}
	
	public static Entity createUnbreakableBlock() {
		return new UnbreakableBlock();
	}
	
	public static Entity createBackgroundDirt() {
		return new BackgroundDirt();
	}
	
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
			case 'M':
				return createMonster();
			case 'P':
				return createPlayer();
			case 'E':
				return createExit();
			default :
				return null;
		}
		
	}
	
}
