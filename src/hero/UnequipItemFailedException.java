package hero;

public class UnequipItemFailedException extends Exception {

	private static final long serialVersionUID = 1L;

	public String message;
	
	public UnequipItemFailedException(String message) {
		this.message = message;
	}
}
