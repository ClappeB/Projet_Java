package entity.exceptions;
/**Entity exceptions */
public class NoSuchEntityExists extends RuntimeException {
	/** No such entity exits exceptions*/
	public NoSuchEntityExists(String message) {
		super(message);
	}
}
