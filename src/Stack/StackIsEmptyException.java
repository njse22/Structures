package Stack;

@SuppressWarnings("serial")
public class StackIsEmptyException extends Exception{

	private String message;

	public StackIsEmptyException(String message) {
		super(message);
		
	}

	public String getMessage() {
		return message;
	} 
	
	
	
	
}
