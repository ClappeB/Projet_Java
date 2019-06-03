package entity.exceptions;

public class NoSuchEntityExists extends RuntimeException {

	public NoSuchEntityExists(String message) {
		super(message);
	}
}
