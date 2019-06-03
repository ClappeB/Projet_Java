package entity.exceptions;
/**Entity exceptions */
public class NoSuchEntityExists extends RuntimeException {
	/** No such entity exits exceptions
	 * @param String
	 * The message to get on the screen
	 */
	public NoSuchEntityExists(String message) {
		super(message);
	}
}
