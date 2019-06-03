package entity;
/**
 * The Class MotionLessElements
 */
public abstract class MotionLessElements extends Entity {

	/** Instantiate a new MotionlessElement
	 * 
	 *  @param Sprite
	 *  		The sprite
	 *  @param Permeability
	 *  		The permability
	 * 	
	 */
	MotionLessElements(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
	}
}
