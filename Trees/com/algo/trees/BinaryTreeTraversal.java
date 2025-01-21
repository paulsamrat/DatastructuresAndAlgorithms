package com.algo.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTraversal {
	/**
	 * 
	 * 1. Full Binary Tree
		A full Binary tree is a special type of binary tree in which every parent node/internal node has either two or no children.
       2. Perfect Binary Tree
		A perfect binary tree is a type of binary tree in which every internal node has exactly two child nodes 
		and all the leaf nodes are at the same level.
	 */
	
	private class BTNode{
		private int data;
		private BTNode left;
		private BTNode right;
		
		private BTNode(final int data) {
			this.data = data;
		}
	}
	
	private BTNode root;
	// traversals - DFS
	//visit all left subtrees then print and then all right subtrees
	//provides sorted order
	private void  inorderTraversal(BTNode node) {
		if (node == null) return;
		inorderTraversal(node.left);
		System.out.println(node.data);
		inorderTraversal(node.right);
	}
	//vist all left first then all rights and then the print
	private void  postorderTraversal(BTNode node) {
		if (node == null) return;
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.println(node.data);
	}
	
		//print and then all lefts and then all rights
	private void  preorderTraversal(BTNode node) {
		if (node == null) return;
		System.out.println(node.data);
		preorderTraversal(node.left);
		preorderTraversal(node.right);
			
	}
	
	//level order traversal
	private void levelOrderTraversal(final BTNode node) {
		final Queue<BTNode> q = new LinkedList<BTNode>();
		final List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp1 = new ArrayList<Integer>();
		q.add(node); // add the root node
		q.add(null);
		while(!q.isEmpty()) {
			final BTNode temp = q.poll();
			if (temp == null) {
				if(temp1.size() > 0)
					result.add(new ArrayList<Integer>(temp1));
				else
					break;
				temp1.clear();
				q.add(null);
				continue;
			}
			//System.out.println(temp.data);
			temp1.add(temp.data);
			if (null != temp.left)
					q.add(temp.left);
			if (null != temp.right)
				q.add(temp.right);
			
		}
		System.out.println(result);
	}
	
	//invert or mirror image of binary tree
	//Mirror of a Binary Tree T is another Binary Tree M(T) 
	//with left and right children of all non-leaf nodes interchanged. 


	private void invert(final BTNode node,final BTNode invert) {
//		if (node == null) return;
//		invert.left = invert(node.right,invert);
//		invert.right = node.left;
		
	}
	
	
	public static void main(String[] args) {
		BinaryTreeTraversal tree = new BinaryTreeTraversal();
		tree.root = tree.new BTNode(10);
		tree.root.left = tree.new BTNode(5);
		tree.root.right = tree.new BTNode(20);
		tree.root.left.left = tree.new BTNode(3);
		tree.root.left.right = tree.new BTNode(9);
		tree.root.right.left = tree.new BTNode(15);
		tree.root.right.right = tree.new BTNode(25);
		//inorder travsersal
		//tree.inorderTraversal(tree.root);
		//tree.postorderTraversal(tree.root);
		//tree.preorderTraversal(tree.root);
		System.out.println("level order traversal");
		tree.levelOrderTraversal(tree.root);
		System.out.println("inverting the binary tree");		
		//tree.invert(tree.root,);
	}

}
