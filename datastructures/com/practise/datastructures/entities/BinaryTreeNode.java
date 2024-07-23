package com.practise.datastructures.entities;

public class BinaryTreeNode {
	
	private int data;
	private BinaryTreeNode leftSubTree;
	private BinaryTreeNode rightSubTree;
	
	
	public BinaryTreeNode(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.leftSubTree = null;
		this.rightSubTree = null;
	}


	public int getData() {
		return data;
	}


	public void setData(int data) {
		this.data = data;
	}


	public BinaryTreeNode getLeftSubTree() {
		return leftSubTree;
	}


	public void setLeftSubTree(BinaryTreeNode leftSubTree) {
		this.leftSubTree = leftSubTree;
	}


	public BinaryTreeNode getRightSubTree() {
		return rightSubTree;
	}


	public void setRightSubTree(BinaryTreeNode rightSubTree) {
		this.rightSubTree = rightSubTree;
	}
	
	
	
}
