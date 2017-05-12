package stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		DLLStack<String> stack2 = new DLLStack<String>();
		
		stack.push("Hello");
		stack.push("World");
		stack.push("!!!");
		stack.push("java");
		stack.push(".");
		
		

		while( stack.empty() == false ) {
		    String s = stack.pop();
		    System.out.println( s );
		}

	/*	System.out.println("======================================");

		stack = new Stack<String>();
		stack.push("Hello");

		System.out.println( stack.pop() );
		System.out.println( stack.pop() );*/
		
		
		stack2.push("Hello");
		stack2.push("World");
		stack2.push("!!!");
		stack2.push("java");
		stack2.push(".");
		
		

		while( stack2.empty() == false ) {
		    String s = stack2.pop();
		    System.out.println( s );
		}


	}

}
