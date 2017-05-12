package stack.calc;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StackPostFix<E> extends Stack<E> {

	Stack<String> stack = new Stack<String>();
	Stack<Double> calcstack = new Stack<Double>();
	List<String> insert = new ArrayList<String>();
	Stack<String> post = new Stack<String>();

	public List<String> scansusik() {
		String susik;

		System.out.println("수식을 입력하세요\n");

		Scanner scan = new Scanner(System.in);
		susik = scan.nextLine();
		StringTokenizer ex = new StringTokenizer(susik, "+-*/()", true);

		System.out.print("입력된 식 : ");

		while (ex.hasMoreTokens()) {
			insert.add(ex.nextToken());
		}

		return insert;
	}

	public Stack<String> postfix(List<String> insert) {

		Iterator<String> it = insert.iterator();

		while (it.hasNext()) {
			String s = it.next();

			if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("(")) {
				if (stack.empty()) {
					stack.push(s);

				} else {
					String topstr = stack.peek();
					if (priority(s) <= priority(topstr)) {
						post.push(stack.pop());
						stack.push(s);
					} else if (priority(s) > priority(topstr)) {
						stack.push(s);
					}
				}
			} else if (s.equals(")")) {
				while (!stack.peek().equals("(")) {
					post.push(stack.pop());
				}
				stack.pop();
			} else {
				post.push(s);
			}
		}

		while (!stack.empty()) {
			post.push(stack.pop());
		}

		return post;
	}

	private int priority(String topstr) {

		int prior = 0;

		if (topstr.equals("(")) {
			prior = 1;
		} else if (topstr.equals("+") || topstr.equals("-")) {
			prior = 2;
		} else if (topstr.equals("*") || topstr.equals("/")) {
			prior = 3;
		} else if (topstr.equals(")")) {
			prior = 4;
		}

		return prior;

	}

	public Double calc(Stack<String> post) {

		Double result = 0.0;

		Iterator<String> p = post.iterator();

		while (p.hasNext()) {
			String s = p.next();
			if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
				Double num1 = Double.valueOf(calcstack.pop());
				Double num2 = Double.valueOf(calcstack.pop());
				switch (s) {
				case "+":
					calcstack.push(num1 + num2);
					break;
				case "-":
					calcstack.push(num1 - num2);
					break;
				case "*":
					calcstack.push(num1 * num2);
					break;
				case "/":
					calcstack.push(num2 / num1);
					break;
				}
			} else {
				Double a = Double.valueOf(s);
				calcstack.push(a);
			}

		}

		result = calcstack.peek();

		return result;
	}

}
