package entity;
/** 
 * The Class Map.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import entity.exceptions.OutOfMapException;

public class Map extends Observable{
	

	
	/** The height and width of the map*/
	private int height, width;
	
	/** The map */
	private Entity[][] map;
	
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
	private void setEntity(int x, int y, Entity e) throws OutOfMapException {
		if(x<0 || x>this.getWidth() || y<0 || y>this.getHeight()) {
			throw new OutOfMapException("Coordinates are out of the map.");
		} else {
			map[x][y]=e;
		}
	}
	
	/**
	 * Get an entity in the map
	 * 
	 * @param x
	 * @param y
	 * @return Entity
	 */
	public Entity getEntity(int x, int y) throws OutOfMapException {
		if(x<0 || x>this.getWidth() || y<0 || y>this.getHeight()) {
			throw new OutOfMapException("Coordinates are out of the map.");
		} else {
			return map[x][y];
		}
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
	/** Load the level's map */
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
	/** Refresh map's entities */
	public void refresh() {
		
		for(int i = 0; i<entities.size();i++) {
			setEntity(entities.get(i).getPosX(), entities.get(i).getPosY(), entities.get(i));
		}
		this.setChanged();
		this.notifyObservers();
	}
	/** Display the map on the console*/
	public void print() {
		for(int y = 0; y<this.height;y++) {
			for(int x = 0; x<this.width;x++) {
				System.out.print(getEntity(x, y).getSprite().getConsoleImage());
			}
			System.out.println();
		}
	}
	/** Change the entities position */
	public void changeEntityPosition(Entity firstEntity, Entity secondEntity) {
		int tempPosX, tempPosY;
		tempPosX=firstEntity.getPosX();
		tempPosY=firstEntity.getPosY();
		firstEntity.setPosX(secondEntity.getPosX());
		firstEntity.setPosY(secondEntity.getPosY());
		secondEntity.setPosX(tempPosX);
		secondEntity.setPosY(tempPosY);
	}
	/** Entities list on the map */
	public List<Entity> getEntityList() {
		return entities;
	}
	/** Entity replacement */
	public void replaceEntityByBackgroundDirtOrDiamond(Entity entityToReplace, String newBlock) {
		Entity newEntity;
		if(newBlock.equals("Diamond")) {
			newEntity = Factory.createDiamond();
		}else {
			newEntity = Factory.createBackgroundDirt();
		}
		this.setEntity(entityToReplace.getPosX(), entityToReplace.getPosY(), newEntity);
		newEntity.setPosX(entityToReplace.getPosX());
		newEntity.setPosY(entityToReplace.getPosY());
		this.entities.remove(entityToReplace);
		this.entities.add(newEntity);
	}

}