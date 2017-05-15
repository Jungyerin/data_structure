package tree;

import stack.calc.List;

public class LinkedTree<E> {
	private TreeNode<E> root;
	

	public void setRoot(TreeNode<E> root) {
		this.root = root;
	}

	public LinkedTree() {

	}

	public LinkedTree(E data) {
		root = new TreeNode<E>(data);
	}

	public TreeNode<E> getRoot() {
		return root;
	}

	public TreeNode<E> insertLeft(TreeNode<E> parent, E data) {
		final TreeNode<E> node = new TreeNode<E>(data);
		parent.left = node;
		return node;

	}

	public TreeNode<E> insertRight(TreeNode<E> parent, E data) {

		final TreeNode<E> node = new TreeNode<E>(data);
		parent.right = node;
		return node;
	}

	public void traversalPostorder(List<String> list) {

		traversalPostorder(root, list);
	}
	
	public void traversalPostorder() {

		traversalPostorder(root);
	}
	
	public TreeNode<E> traversalPostorder(TreeNode<E> node) {
		if (node.left != null) {
			traversalPostorder(node.left);
		}

		if (node.right != null) {
			traversalPostorder(node.right);
		}
		
		//System.out.println(node.data);
		return node;		
	}

	public void traversalPostorder(TreeNode<E> node, List<String> list) {
		if (node.left != null) {
			traversalPostorder(node.left, list);
		}

		if (node.right != null) {
			traversalPostorder(node.right, list);
		}

		list.add((String) node.data);
	//	System.out.println(node.data);
	}

	public static class TreeNode<E> {
		private E data;
		private TreeNode<E> left;
		private TreeNode<E> right;

		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}

		public TreeNode<E> getLeft() {
			return left;
		}

		public void setLeft(TreeNode<E> left) {
			this.left = left;
		}

		public TreeNode<E> getRight() {
			return right;
		}

		public void setRight(TreeNode<E> right) {
			this.right = right;
		}

		public TreeNode(E data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

}
