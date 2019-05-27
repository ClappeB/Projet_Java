package entity;

public class Map {
	
	/** The height and width of the map*/
	private int height, width;
	
	/** The map */
	private Entity[][] map;
	
	/**
	 * Instantiate the map
	 * 
	 * @param width
	 * @param height
	 */
	public Map(int width, int height, String level){
		this.width=width;
		this.height=height;
		map = new Entity[width][height];
		loadMap(level);
	}
	
	/**
	 * Set an entity in the map
	 * 
	 * @param x
	 * @param y
	 * @param e
	 */
	public void setEntity(int x, int y, Entity e) {
		map[x][y]=e;
	}
	
	/**
	 * Get an entity in the map
	 * 
	 * @param x
	 * @param y
	 * @return Entity
	 */
	public Entity getEntity(int x, int y) {
		return map[x][y];
	}
	
	/**
	 * Get the height of the map
	 * @return height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Get the width of the map
	 * @return width
	 */
	public int getWidth() {
		return width;
	}
	
	private void loadMap(String level) {
		level.replaceAll("\r\n", "!");
		int xMap = 0, yMap = 0; //Location in the map
		
		for(int i = 0; i<level.length(); i++) {
			if(level.charAt(i)=='!') {
				xMap=0;
				yMap++;
			}else {
				this.setEntity(xMap, yMap, Factory.getFromFileSymbol(level.charAt(i)));
			}
			
		}
	}
}

