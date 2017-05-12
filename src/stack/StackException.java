package stack;

public class StackException extends Exception {

	private static final long serialVersionID = 1L;
	
	public StackException(){
		super("Stack Exception Occurs");
	}
	
	public StackException(String message){
		super(message);
	}

}
