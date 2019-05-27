package entity;

public class BackgroundDirt extends MotionLessElements {
	
	private static final Sprite sprite = new Sprite('B', "Image jeu/Mur/backgroundDirt.png");
	private static final Permeability permeability = Permeability.UNBLOCKING;
	
	BackgroundDirt() {
		super(sprite, permeability);
	}
		
}
