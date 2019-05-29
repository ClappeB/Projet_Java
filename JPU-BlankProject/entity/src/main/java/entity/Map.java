package entity;

import java.util.ArrayList;
import java.util.List;

public class Map {
	
	/** The height and width of the map*/
	private int height, width;
	
	/** The map */
	private static Entity[][] map;
	
	/** List of entities */
	private List<Entity> entities = new ArrayList<Entity>();
	
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
	public static Entity getEntity(int x, int y) {
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
		level = level.replaceAll("\r\n", "!");
		int xMap = 0, yMap = 0; //Location in the map
		for(int i = 0; i<level.length(); i++) {
			if(level.charAt(i)=='!') {
				xMap=0;
				yMap++;
			}else {
				this.setEntity(xMap, yMap, Factory.getFromFileSymbol(level.charAt(i)));
				getEntity(xMap, yMap).setPosX(xMap);
				getEntity(xMap, yMap).setPosY(yMap);
				entities.add(getEntity(xMap, yMap));
				xMap++;
			}
			
		}
	}
	
	public void refresh() {
		for(int i = 0; i<entities.size();i++) {
			setEntity(entities.get(i).getPosX(), entities.get(i).getPosY(), entities.get(i));
		}
	}
	
	public void print() {
		
		for(int y = 0; y<this.height;y++) {
			for(int x = 0; x<this.width;x++) {
				System.out.print(this.getEntity(x, y).getSprite().getConsoleImage());
			}
			System.out.println();
		}
	}
	
	public static void changeEntityPosition(Entity firstEntity, Entity secondEntity) {
		int tempPosX, tempPosY;
		tempPosX=firstEntity.getPosX();
		tempPosY=firstEntity.getPosY();
		firstEntity.setPosX(secondEntity.getPosX());
		firstEntity.setPosY(secondEntity.getPosY());
		secondEntity.setPosX(tempPosX);
		secondEntity.setPosY(tempPosY);
	}
}

