package entity;

/**
 * The Class Entity.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Entity {
	
	private Sprite sprite;
	private Permeability permeability;
	private int posX;
	private int posY;
	
	Entity() {
		
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public Permeability getPermeability() {
		return permeability;
	}

	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}
