package hero;

public class EquipItemFailedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public String message;
	
	public EquipItemFailedException(String message) {
		this.message = message;
	}
}
