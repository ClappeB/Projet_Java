package entity;

public abstract class Factory {
	
	private static Player player = new Player();	
	
	public MobileElements createDiamond() {
		return null;
	}
	
	public MobileElements createRock() {
		return null;
	}
	
	public MobileElements createMonster() {
		return null;
	}
	
	public MobileElements createPlayer() {
		return null;
	}
	
	public MobileElements createExit() {
		return null;
	}
	
	public MobileElements createDirt() {
		return null;
	}
	
	public MobileElements createUnbreakableBlock() {
		return null;
	}
	
	public MobileElements createBackgroundDirt() {
		return null;
	}
	
	public static Entity getFromFileSymbol(char symbol) {
		switch(symbol) {
			case '.':
				return new Dirt();
			case 'R':
				return new Rock();
			case 'U':
				return new UnbreakableBlock();
			case 'B':
				return new BackgroundDirt();
			case 'D':
				return new Diamond();
			case 'M':
				return new Monster();
			case 'P':
				return player;
			case 'E':
				return new Exit();
			default :
				return null;
		}
	}
	
}
