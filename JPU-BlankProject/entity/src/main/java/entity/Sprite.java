package entity;

import java.awt.Image;

/**
 * <h1>Sprite class<h1>
 * 
 * @author Bruno
 *
 */

public class Sprite {
	
	/** The image of the sprite.*/
	private Image image;
	
	/** The image name to find it.*/
	private String imageName;
	
	/** The image on the console.*/
	private char consoleImage;
	
	/** Is the image loaded ?*/
	private boolean imageLoaded;
	
	/**
	 * Instanciate a new sprite.
	 * 
	 * @param character
	 * 				The character on the console
	 * @param imageName
	 * 				The image name which indicates which image needs to be loaded
	 */
	public Sprite(final char character, final String imageName) {
		 this.setConsoleImage(character);
	     this.setImageName(imageName);
	}
	
	/**
	 * Instanciate a new sprite.
	 * 
	 * @param character
	 * 				The character on the console
	 */
	public Sprite(final char character) {
		this(character, "noimage.jpg");
	}
	
	/**
	 * Returns back the image of the designed sprite.
	 * 
	 * @return Image
	 * 			The image of the sprite
	 */
	public final Image getImage() {
		return image;
	}
	
	/**
	 *  Set the image of the designed sprite
	 *  
	 *  @param image
	 *  		The image to print
	 */
	public void setImage(final Image image) {
		
	}
	
	/**
	 * 	Get the name of the image
	 * @return imageName
	 */
	public final String getImageName() {
		return "";
	}
	
	/**
	 * Set the image name
	 * @param imageName
	 */
	public void setImageName(String imageName) {
		
	}
	
	/**
	 * Get the image of the object in the console
	 * @return consoleImage
	 */
	public final char getConsoleImage() {
		return ' ';
	}
	
	/**
	 * Set the image of the sprite in the console
	 * @param consoleImage
	 */
	public final void setConsoleImage(final char consoleImage) {
		
	}
	
	/**
	 * Check if the image of the sprite is loaded
	 * @return boolean
	 */
	public boolean isImageLoaded() {
		return true;
	}
	
	/**
	 * Set is the image is loaded or not
	 * @param isImageLoaded
	 */
	public void setImageLoaded(final boolean isImageLoaded) {
		
	}
	
	/**
	 * Load the image in the sprite
	 */
	public void loadImage() {
		
	}
	
}
