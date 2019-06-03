package entity.exceptions;
/** Coordinates exceptions*/
public class WrongCoordinates extends RuntimeException {
	/** Wrong coordinates 
	 * @param String
	 * The message to get on the screen
	 */
	public WrongCoordinates(String message) {
		super(message);
	}

}
