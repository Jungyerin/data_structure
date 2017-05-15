package stack.calc;

import java.util.Arrays;

import tree.LinkedTree;
import tree.LinkedTree.TreeNode;

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
		System.out.println("결과 1 : "+result);
		
		stack.calc.Iterator<String> itt = post.iterator();
		while (itt.hasNext()) {
			String s = itt.next(); // auto unboxing
			System.out.print(s);
		}
		
		System.out.println();
		
		LinkedTree<String> tree=spf.makeExpTree(post);   //후위표현식을 트리노드로 만듦.
		
	/*	List<String> list=new ArrayList<String>();
		tree.traversalPostorder(list);
		System.out.println(Arrays.toString(list.toArray()));*/
						
		Double result2=spf.calcTree(tree.getRoot());
		System.out.println("결과2 : "+result2);
	}

}
