package com.algo.trees;

public class CreateTrees {

	class BinaryTree{
		private int val;
		private BinaryTree left;
		private BinaryTree right;
		
		public BinaryTree(final int val) {
			this.val = val;
		}
	}
	private BinaryTree root;
	
	public BinaryTree createBinaryTree() {
		root = new BinaryTree(10);
		root.left = new BinaryTree(9); 
		root.right = new BinaryTree(8); 
		root.left.left = new BinaryTree(7); 
		root.left.right = new BinaryTree(6);
		root.right.left = new BinaryTree(7); 
		root.right.right = new BinaryTree(7);
		return root;
	}

}
