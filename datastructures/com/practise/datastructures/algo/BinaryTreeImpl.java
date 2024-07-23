package com.practise.datastructures.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import sun.font.CreatedFontTracker;

class BinaryTreeNode{
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	private List<String> subSets;
	private int value;
	
	public BinaryTreeNode(String c){
		this.subSets = new ArrayList<String>();
		this.subSets.add(c);
	}
	public BinaryTreeNode(int value){
		this.value = value;
	}
	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public List<String> getSubSets() {
		return subSets;
	}

	public void setSubSets(List<String> subSets) {
		this.subSets = subSets;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
public class BinaryTreeImpl {
	private BinaryTreeNode root;
	private Queue<BinaryTreeNode> q;
	//all-subsets-of-set-powerset
	//In mathematics, the power set (or powerset) of any set S, written P(S), 
	//is the set of all subsets of S, including the empty set and S itself.
	//2n power sets
	public BinaryTreeImpl() {
		this.root = new BinaryTreeNode(""); //empty character to start with
		this.q = new LinkedList<BinaryTreeNode>();
		q.add(root);
	}
	//http://javabypatel.blogspot.in/2015/10/all-subsets-of-set-powerset.html
	public void createPowerSetTree(String str){
		// for any character there are two options either to include or exclude
		for (int i = 0 ; i < str.length() ; i++)
		{
			if (!q.isEmpty() ){
				int noOfNodes = q.size();
				while ( noOfNodes >  0 ){
					BinaryTreeNode poppedNode = q.poll();
					List<String> sets = poppedNode.getSubSets();
					//include
					BinaryTreeNode btnLeft = new BinaryTreeNode(String.valueOf(str.charAt(i)));
					btnLeft.getSubSets().addAll(sets);
					poppedNode.setLeft(btnLeft);
					q.offer(btnLeft);
					//exclude
					BinaryTreeNode btnRight = new BinaryTreeNode("");
					btnRight.getSubSets().addAll(sets);
					poppedNode.setRight(btnRight);
					q.offer(btnRight);
					--noOfNodes;
				}
			}
		}
		
		//do any traversal and print all leaf nodez array list
		doPreorderTraversal(this.root);
	}
	void doPreorderTraversal(BinaryTreeNode root){
		if ( null == root) return;
		if (root.getLeft() ==  null && root.getRight() ==  null)
			System.out.println(root.getSubSets());
		doPreorderTraversal(root.getLeft());
		doPreorderTraversal(root.getRight());
	}
	
	//make-a-binary-tree-from-given-inorder-and-preorder-traveral
	static int preOrderRootIndex = 0 ;
	public static BinaryTreeNode formBTInorderPreOrder(int[] inorder, int[] preorder, int startIndex , int endIndex){
		if (startIndex > endIndex) return null;

		
		BinaryTreeNode root = new BinaryTreeNode(preorder[preOrderRootIndex]);
		preOrderRootIndex+=1;
		int inOrderIndex = findInOrderIndex(inorder,startIndex,endIndex,root.getValue());
		if (startIndex == endIndex) return root;
		//left(inOrderIndex-1) forms the left subtree 
		//right(inOrderIndex+1) forms the right subtree
		root.setLeft(formBTInorderPreOrder(inorder, preorder, startIndex, inOrderIndex-1));
		root.setRight(formBTInorderPreOrder(inorder, preorder, inOrderIndex + 1 , endIndex));
		return root;	
		
	}
	private static int findInOrderIndex(int[] inorder, int startIndex, int endIndex, int value) {
		for (int i = startIndex ; i <=endIndex ; i++)
		{
			if (inorder[i] == value) return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeImpl btImpl = new BinaryTreeImpl();
		btImpl.createPowerSetTree("ABC");
		
	}

}
