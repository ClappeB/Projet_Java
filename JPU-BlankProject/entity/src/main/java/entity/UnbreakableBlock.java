package entity;
/**
 * The class UnbreakableBlocks
 */
public class UnbreakableBlock extends MotionLessElements {

	/** Sprite */
	private static final Sprite SPRITE = new Sprite('U', "unbreakableBlock.png");
	
	/** Instantiate a new UnbreakableBlock */
	UnbreakableBlock() {
		super(SPRITE, Permeability.BLOCKING);
	}
}
