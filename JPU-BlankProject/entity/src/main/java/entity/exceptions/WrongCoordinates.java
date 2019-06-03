package entity.exceptions;
/** Coordinates exceptions*/
public class WrongCoordinates extends RuntimeException {
	/** Wrong coordinates */
	public WrongCoordinates(String message) {
		super(message);
	}

}
