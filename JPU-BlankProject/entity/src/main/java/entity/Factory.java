package entity;

import entity.exceptions.NoSuchEntityExists;

/** Pattern Factory */
public abstract class Factory {
	
	private static Player player = null;
	private static Exit exit = null;
	
	/** New Diamond 
	 *@return Diamond 
	 */
	public static Entity createDiamond() {
		return new Diamond();
	}
	
	/** New Rock 
	 * 
	 *@return Rock 
	 */
	public static Entity createRock() {
		return new Rock();
	}
	
	/** New bat 
	 * 
	 *@return Bat 
	 */
	public static Entity createBat() {
		return new Bat();
	}
	
	/** New octopus 
	 * 
	 *@return Octopus 
	 */
	public static Entity createOctopus() {
		return new Octopus();
	}
	
	/** New Player with singleton
	 * @return player
	 */
	public static Entity createPlayer() {
		
		if(player==null) {
			player = new Player();
		}
		return player;
	}
	/** New Exit with singleton
	 *@return exit 
	 */
	public static Entity createExit() {
		if(exit==null) {
			exit = new Exit();
		}
		return exit;
	} 
	
	/** New Dirt 
	 *@return Dirt 
	 */
	public static Entity createDirt() {
		return new Dirt();
	}
	
	/** New UnbreakableBlock 
	 * 
	 * @return UnbreakableBlock
	 */
	public static Entity createUnbreakableBlock() {
		return new UnbreakableBlock();
	}
	
	/** New BackgroundDirt
	 *@return BackgroundDirt 
	 */
	public static Entity createBackgroundDirt() {
		return new BackgroundDirt();
	}
	
	/** Choice of the object 
	 *@param symbol
	 *@return entity 
	 */
	public static Entity getFromFileSymbol(char symbol) throws NoSuchEntityExists {
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
				throw new NoSuchEntityExists("No entity with the symbol \'"+symbol+"\'  exists.");
		}
		
	}
	
}
