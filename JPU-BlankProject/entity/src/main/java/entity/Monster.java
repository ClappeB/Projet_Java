package entity;

public class Monster extends Killable implements IKill{
	
<<<<<<< HEAD
	private static Sprite SPRITE = new Sprite('M', "octopus.png");
=======
	private static Sprite sprite = new Sprite('M', "Image jeu/Monstres/bat.png");
>>>>>>> branch 'master' of https://github.com/ClappeB/Projet_Java.git
	
	Monster() {
<<<<<<< HEAD
		super(SPRITE, Permeability.UNBLOCKING);
=======
		super(sprite, Permeability.UNBLOCKING);
>>>>>>> branch 'master' of https://github.com/ClappeB/Projet_Java.git
	}
	
	public void diamondExplosion() {
		
	}
	
	public void kill() {
		
	}
}
