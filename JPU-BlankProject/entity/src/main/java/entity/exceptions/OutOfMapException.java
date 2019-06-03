package entity.exceptions;
/** Map exceptions */
public class OutOfMapException extends RuntimeException {
	/** Out of map exceptions
	 * @param String
	 * The message to get on the screen
	 */
	public OutOfMapException(String message) {
		super(message);
	}

}
