package tree;

import java.util.Arrays;

import stack.calc.ArrayList;
import stack.calc.List;

public class LinkedTreeTest {

	public static void main(String[] args) {
		
		LinkedTree<String> tree=new LinkedTree<String>("A");
		
		LinkedTree.TreeNode<String> root=tree.getRoot(); //내부 클래스이기 때문에 클래스 이름으로 참조
		
		LinkedTree.TreeNode<String> nodeB=tree.insertLeft(root, "B");
		LinkedTree.TreeNode<String> nodeC=tree.insertRight(root, "C");
		
		LinkedTree.TreeNode<String> nodeD=tree.insertLeft(nodeB, "D");
		LinkedTree.TreeNode<String> nodeE=tree.insertRight(nodeB, "E");
		LinkedTree.TreeNode<String> nodeF=tree.insertLeft(nodeC, "F");
		LinkedTree.TreeNode<String> nodeG=tree.insertRight(nodeC, "G");
		
		tree.insertLeft( nodeD, "H" );
		tree.insertRight( nodeD, "I" );
				
		tree.insertLeft( nodeE, "J" );

		tree.insertRight( nodeF, "K" );

		tree.insertLeft( nodeG, "L" );
		tree.insertRight( nodeG, "M" );

		
		List<String> list=new ArrayList<String>();
		tree.traversalPostorder(list);
		System.out.println(Arrays.toString(list.toArray()));
		
		
		

	}

}
