package treeAVL;

public class ElementNoFoundException extends Exception{
	
	private String message;
	
	public ElementNoFoundException(String message) {
		super(message);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
