package entity;

public class BackgroundDirt extends MotionLessElements {
	
	private static Sprite sprite = new Sprite('P', "Image jeu/Mur/Mur cassé.png");
	private static final Permeability permeability = Permeability.UNBLOCKING;
	
	BackgroundDirt() {
		super(sprite, permeability);
	}
		
}
