package stack.calc;

public class StackMain {

	public static void main(String[] args) {

		List<String> insert = new ArrayList<String>();
		Stack<String> post = new Stack<String>();
		StackPostFix spf = new StackPostFix();

		insert = spf.scansusik();

		stack.calc.Iterator<String> it = insert.iterator();
		while (it.hasNext()) {
			String s = it.next(); // auto unboxing
			System.out.print(s);
		}

		System.out.println();

		post = spf.postfix(insert);
		Double result=spf.calc(post);

		System.out.println("결과 : "+result);
	}

}
