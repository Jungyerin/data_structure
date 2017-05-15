package stack.calc;

import java.util.Scanner;
import java.util.StringTokenizer;

import tree.LinkedTree;
import tree.LinkedTree.TreeNode;

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

	public LinkedTree<String> makeExpTree(Stack<String> post) {

		LinkedTree<String> tree = new LinkedTree<String>();
		Stack<TreeNode<String>> temp = new Stack<TreeNode<String>>();

		Iterator<String> p = post.iterator();
		int i = 1;

		while (p.hasNext()) {

			String s = p.next();
			TreeNode<String> node = new TreeNode<String>(s);
			//System.out.println("i=" + i + "s=" + s + "post size=" + post.size());
			if (i == post.size()) {

				node.setRight(temp.pop());
				node.setLeft(temp.pop());
				tree.setRoot(node);

				break;
			}
			if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
				TreeNode<String> num2 = temp.pop();
				TreeNode<String> num1 = temp.pop();

				node.setLeft(num1);
				node.setRight(num2);

				temp.push(node);

			} else {
				temp.push(node);
			}
			i++;
		}

		return tree;

	}

	public Double calcTree(TreeNode<E> node) {

		double num1 = 0.0;
		double num2 = 0.0;
		double result = 0.0;

		if (node.getLeft() != null) {
			num1=calcTree(node.getLeft());
		}

		if (node.getRight() != null) {
			num2=calcTree(node.getRight());
		}
	
		switch (String.valueOf(node.getData())) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		default:
			result = Double.valueOf(String.valueOf(node.getData()));
		}

		return result;
	}
}
