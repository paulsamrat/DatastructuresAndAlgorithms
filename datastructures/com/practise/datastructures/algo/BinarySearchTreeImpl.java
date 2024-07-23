package com.practise.datastructures.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

class Node{
	int data;
	Node left;
	Node right;
	int level;
	
	Node(int value)
	{
		this.data = value;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
public class BinarySearchTreeImpl {
	
	//Create a Binary Search Tree.
	private static Node rootNode;
	//create a binary tree 
	private static Node binaryTreeRootNode;
	
	private static void addNodeBinaryTree(int  nodeValue){
		Node n = new Node(nodeValue);
		
	}
	private Node addNode(int nodeValue)
	{
		if (rootNode == null )
			 rootNode = new Node(nodeValue);
		else
		{	
			Node nodeToInsert = new Node(nodeValue);
			Node currNode = rootNode;
			while (currNode !=  null) 
			{
				if (nodeValue > currNode.data) 
				{
					if ( currNode.right == null) 
					{
						currNode.right = nodeToInsert; 
						break;
					}
					 else
						 currNode = currNode.right;
				}
				else 
				{
					 if ( currNode.left == null)
					 {
						 currNode.left =  nodeToInsert;
						 break;
					 }
					 else
						 currNode =  currNode.left;
				}
			}
		}
		
		return rootNode;
	}
	
	private static Node constructBST(int[] values){
		Node root = null;
		for (int val : values){
			if ( null == root)
				root =  new Node(val);			
			else {
				Node currNode = root;
				Node nodeToInsert =  new Node(val);
				Node parentNode =  null;
				boolean isLeft = false;
				while (currNode !=  null){
					parentNode = currNode;
					if ( val < currNode.data){
						 currNode = currNode.left;
						 isLeft = true;
					}
					else
						currNode = currNode.right;					
				}
				if (isLeft) parentNode.left = nodeToInsert;
				else parentNode.right = nodeToInsert;
			}
		}
		return root;
	}
	private Node constructBinaryTree(int[] values){
		Node root = null;
		for (int val : values){
			Node nodeToInsert =  new Node(val);
			if ( null == root )
					root = nodeToInsert;
			else{
				Node currNode = root;
				Node parent =  null;
				boolean isNodeSet = false;
				while ( currNode != null){
					if ( currNode.left == null)
					{
						 currNode.left = nodeToInsert;
						 break;
					}
					if ( currNode.right ==  null)
					{	
						currNode.right = nodeToInsert;
						break;
					}
					if (currNode.left != null)
					{
						currNode = currNode.left;
						isNodeSet = true;
					}
					if ( !isNodeSet && currNode.right != null)
						currNode = currNode.right;
						
				}
			}
		}
		return root;
	}
	
	private static Node constructBTQueue(int[] values){
		Queue<Node> queue = new LinkedList<Node>();
		Node root = null;
		for (int val : values){
			Node nodeToInsert = new Node(val);
			if (queue.isEmpty())
			{
				root = nodeToInsert;
				queue.add(nodeToInsert);
			}
			else{
				Node currNode = queue.peek();
				
				if ( currNode.left == null){
					currNode.left = nodeToInsert;
				}else if (currNode.right == null)
					currNode.right = nodeToInsert;
				
				if (currNode.left != null && currNode.right != null)
					queue.remove();
				
				queue.add(nodeToInsert);
			}
		}
		return root;
	}
	private void levelOrderTraversal(Node rootNode)
	{
		if ( null == rootNode) return;
		else
		{
			Queue<Node> queue = new LinkedList<Node>();
			Node currNode = rootNode;
			queue.add(rootNode);
			System.out.println(" Level Order Traversal.");
			while ( !queue.isEmpty() ) 
			{
			      Node poppedNode = queue.poll();
			      if ( null == poppedNode) continue;
			      System.out.print( poppedNode.data + " ---> ");
			      queue.add(null!= poppedNode.left ? poppedNode.left :null);
			      queue.add(null!= poppedNode.right ? poppedNode.right :null);

			}
		}
		System.out.println("\n");
		
	}
	
	 //same as above // implemented using BFS : Level Order traversal
     private static TreeMap<Integer,String> printVerticallyLOT(Node rootNode, TreeMap<Integer,String> map)
     {
    	 Queue<Node> queue = new LinkedList<Node>();
    	 queue.add(rootNode);
    	 map.put(rootNode.getLevel(), String.valueOf(rootNode.data));
    	 while ( !queue.isEmpty()){
    		 Node n = queue.poll();
    		 int parentLevel = n.getLevel();
    		 if ( null != n.left){
    			 Node left = n.left;
    			 queue.add(left);
    			 if (map.containsKey(parentLevel-1))
    				 	map.put(parentLevel-1, map.get(parentLevel-1) + "," + left.data);
    			 else
    				 map.put(parentLevel-1,String.valueOf(left.data));
    			 left.setLevel(parentLevel-1);
    		 }
    	     if ( null != n.right){
    	    	 Node right = n.right;
    	    	 queue.add(right);
    			 if (map.containsKey(parentLevel+1))
    				 	map.put(parentLevel+1, map.get(parentLevel+1) + "," + String.valueOf(right.data));
    			 else
    				 map.put(parentLevel+1,String.valueOf(right.data));
    			 right.setLevel(parentLevel+1);
    	     }
    		 
    	 }
    	 return map;
     }
     
     //print the vertical sum of the above binary search tree
     //recursion
     private static Map<Integer,Integer> verticalSum(Node root,Map<Integer,Integer> map, int parentLevel){
    	 if ( null == root) return null;
    	 if (map.containsKey(parentLevel)){
    		 map.put(parentLevel,map.get(parentLevel) + root.data);
    	 }else
    		 map.put(parentLevel, root.data);
    	 verticalSum(root.left, map, parentLevel-1);
    	 verticalSum(root.right, map, parentLevel+1);
    	 return map;
     }
	//print right view //BFS
	private static Map<Integer, Integer> rightView(Node root, TreeMap<Integer, Integer> treeMap) {
		// TODO Auto-generated method stub
		return null;
	}
	//print all nodes between given level BFS... both levels are inclusive
	private static void printAllNodesBetweenGivenLevels(Node root, int startLevel, int endLevel){
		Queue<Node> queue = new LinkedList<Node>();
		//Associate level with root Node
		root.setLevel(1);
		queue.add(root);
		while ( !queue.isEmpty()){
			Node tempNode = queue.poll();
			int parentLevel = tempNode.getLevel();
			if ( parentLevel >= startLevel && parentLevel <= endLevel)
					System.out.println(" Node  at Level " + parentLevel + " is " + tempNode.data );
			if ( null != tempNode.left){
					tempNode.left.setLevel(parentLevel+1);
					queue.add(tempNode.left);
			}
			if ( null != tempNode.right){
					tempNode.right.setLevel(parentLevel+1);
					queue.add(tempNode.right);
			}
		}
		
	}
	//print all nodes between given level BFS... both levels are inclusive //another variant of above
	public void levelOrderQueue(Node root, int low, int high){
		Queue<Node> q = new LinkedList<Node>();
		int levelNodes =0;
		if(root==null) return;
		q.add(root);
		int currLevel = 1 ;
		while(!q.isEmpty()){
			levelNodes = q.size();
			while(levelNodes>0){
				Node n = (Node)q.remove();
				if(currLevel>=low && currLevel<=high){
					System.out.print(" " + n.data);
				}
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
				levelNodes--;
			}
			if(currLevel>=low && currLevel<=high){
				System.out.println("");
			}
			currLevel++;
		}

	}
	
	//maximum width of binary tree
	private static int maximumWidth(Node root){

		Queue<Node> queue = new LinkedList<Node>();
		int levelNodes ,maxWidth = 0;
		if(root==null) return 0;
		queue.add(root);

		while(!queue.isEmpty()){
			levelNodes = queue.size();
			if(levelNodes>maxWidth){
				maxWidth = levelNodes;
			}
			while(levelNodes>0){
				Node n = (Node)queue.remove();
				if(n.left!=null) queue.add(n.left);
				if(n.right!=null) queue.add(n.right);
				levelNodes--;
			}
		}
		return maxWidth;
	}
	
	//print a BST in a zig zag fassion or spiral way
	private static void zigZagSpiralTree(Node root){
		if ( null == root) return ;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		List<Integer> list = new ArrayList<Integer>();
		boolean flipIt = false;
		while (!queue.isEmpty()){
			int nodes =  queue.size();
			list.clear();
			while( nodes >0){
				Node currNode = queue.poll();
				list.add(currNode.data);
				if ( null != currNode.left) queue.add(currNode.left);
				if ( null != currNode.right) queue.add(currNode.right);
				--nodes;

			}
			
			if (!flipIt){
				System.out.println(list);
				flipIt = !flipIt;
			}else{
				Collections.reverse(list);
				System.out.println(list);
				flipIt = !flipIt;
			}
		}	
	}
	//print a BST in a zig zag fassion or spiral way STACK Impl
	private static void zigZagSpiralTreeStack(Node root){
		
	}

	// NON Recursive Approach : PreOrder Traversal . Stack Implementation
	
	private static void preOrderTraversalNonRecursive(Node rootNode)
	{
		if ( null != rootNode)
		{
			Node currNode = rootNode;
			Stack<Node> stack = new  Stack<Node>();
			while (true)
			{
				while (currNode != null)
				{
					System.out.println(currNode.data);
					stack.push(currNode);
					if (currNode.left != null)
						   currNode = currNode.left;
									
				}
				currNode = stack.pop();
				currNode = currNode.right;
			}
		}
		else
			return;
	}
	
	//NON Recursive : INORDER Traversal : stack implementation
	private static void inOrderTraversalNonRecursive(Node rootNode)
	{
		if (rootNode != null)
		{	
			Node currNode = rootNode;
			Stack<Node> stack =  new Stack<Node>();
			while (true)
			{
				while ( currNode != null)
				{
					stack.push(currNode);
					currNode = currNode.left;
				}
				if ( stack.isEmpty()) break;
				Node poppedNode = stack.pop();
				System.out.println(poppedNode.data);
				currNode = poppedNode.right;
						
			}		
		}
		else
			return;
	}
	
	//NON Recursive : POSTORDER Traversal : stack implementation
	private static void postOrderTraversalNonRecursive(Node rootNode)
	{
		if (rootNode != null)
		{
			Node currNode = rootNode;
			Stack<Node> stack = new Stack<Node>();
			while (true)
			while (currNode != null)
			{
				stack.push(currNode);
				currNode = currNode.left;
			}
			//if (stack.isEmpty()) break;
			//Node poppedNode = stack.pop();
		}
		else
			return;
	}
	
	//Maximum Element in a Binary Tree : NON Recursive. Level Order Traversal .
	private static int maximumElement(Node rootNode)
	{	
		int maxElementValue = 0;
		Queue<Node> queue = new LinkedList<Node>();
		if (rootNode != null)
		{	
			Node currNode = rootNode;			
			queue.add(currNode);
			while ( !queue.isEmpty())
			{
				Node poppedNode = queue.poll();
				currNode = poppedNode;
				if ( currNode.data > maxElementValue) maxElementValue = currNode.data;
				if ( currNode.left != null) queue.add(currNode.left);
				if ( currNode.right != null)queue.add(currNode.right);
			}
		}
		else
			return -1 ;
		return maxElementValue;
	}
	
	//Insert Element in a Binary Tree. :  NON Recursive : Level Order Traversal.
	//Binary tree , element can be inserted at any point whenever a null left / right subtree is found. 
	
	private static Node insertElement(Node rootNode , int value)
	{
		if ( null != rootNode)
		{
			Queue<Node> queue = new LinkedList<Node>();
			Node currNode = rootNode;
			queue.add(currNode);
			while (!queue.isEmpty())
			{
				Node poppedNode = queue.poll();
				if ( null == poppedNode.left) 
				{
						poppedNode.left = new Node(value);
						queue.clear();
						return poppedNode;
				}
				else
					queue.add(poppedNode.left);
				
				if ( null == poppedNode.right)
				{
						poppedNode.right = new Node(value);
						queue.clear();
						return poppedNode;
				}
				else
					queue.add(poppedNode.right);
			}
		}
		else
			rootNode =  new Node(value);
		return rootNode;
	}
	
	
	//calculate the size of a binary tree. With Recursion.
	
	private static int findSizeOfBinaryTree(Node rootNode)
	{
		if ( rootNode != null)
		{
			return findSizeOfBinaryTree(rootNode.left) + 1  + findSizeOfBinaryTree(rootNode.right);
		}
		else
			return 0;
	}
	
	//calculate size of binary tree : Without Recursion : Level Order Traversal.
	
	private static int findSizeOfBinaryTreeWithoutRecursion(Node rootNode)
	{
		if ( rootNode!= null)
		{
			int count = 1 ;
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(rootNode);
			while ( !queue.isEmpty())
			{
				Node poppedNode = queue.poll();
				if ( poppedNode.left != null) 
				{
					queue.add(poppedNode.left);
					++count;
				}
				if ( poppedNode.right != null) 
				{
					queue.add(poppedNode.right);
					++count;
				}
				
			}
			return count;
		}
		else
			return 0;
	}
	//constructing BST from given pre-order sequence.
	private static int index;
	private static Node constructBSTFromPreOrderSequence(int[] preOrderSequenceArray, int length , int min, int max)
	{
		
		if (index >= length) {
	        return null;
	    }
	    
		Node root = null;	    
	    int currentNode = preOrderSequenceArray[index];	    
	    if (currentNode > min && currentNode < max) {
	        root = new Node(currentNode);
	        index++;
	        
	        if (index < length) {
	            root.left = 
	            	constructBSTFromPreOrderSequence(preOrderSequenceArray, length, min, currentNode);
	        }
	        
	        if (index < length) {
	            root.right = 
	            	constructBSTFromPreOrderSequence(preOrderSequenceArray, length, currentNode, max);
	        }
	    }
	    
	    return root;
	}
	private static void binaryTreeIsASubTree(){
		
	}
	public static void preOrderTraversal(Node rootNode){
		if ( null != rootNode){
			System.out.print( rootNode.data + " --> ");
			preOrderTraversal(rootNode.left);
			preOrderTraversal(rootNode.right);
		}
	}

	
	// w/o recursion // space O(N) //time O(N)
	public static int largestElement(Node root){
		if ( null == root)
			System.out.println( " Maximum Element : " + Integer.MIN_VALUE );
		int maxValue = Integer.MIN_VALUE;
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		while ( !queue.isEmpty()){
			 Node currNode = queue.poll();
				 if ( currNode.data > maxValue)
					 maxValue = currNode.data;
				 if ( null != currNode.left)
					 queue.offer(currNode.left);
				 if ( null != currNode.right)
					 queue.offer(currNode.right);
    	}
		return maxValue;
	}
	
	// w/ recursion // pre -traversal // O(N)
	public static boolean elementSearch( Node root, int elementToSearch){
		//pre - order traversal
		boolean elementFound = false;
		if (  null !=  root){
			if ( root.data == elementToSearch) {
				elementFound = true;
				return elementFound;
			}
			return elementSearch(root.left,elementToSearch) 
					|| elementSearch(root.right,elementToSearch);
			
		}else{
			return elementFound = false;

		}
	}
	
	// w/o recursion // O(N)
	public static void elementInsertion(Node root, int elementToInsert){
		//USING QUEUE
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		// looking for a nullable left or right child .. if found insert
		while(  !queue.isEmpty()){
			Node currNode = queue.poll();
			if ( null == currNode.left){
						currNode.left = new Node(elementToInsert);
						System.out.println(" Element : " + elementToInsert + " inserted at Left Node of Node " + currNode.data);
						break;
			}else
				queue.offer(currNode.left);
			
			if ( null == currNode.right){
				currNode.right = new Node(elementToInsert);
				System.out.println(" Element : " + elementToInsert + " inserted at Right Node of Node " + currNode.data);
				break;
			}else
				queue.offer(currNode.right);
			}		
	}
	
	// w/ recursion 
	public static int calculateSizeOfBinaryTree(Node root){
		int leftCount = ( null == root.left) ? 0 : 
									calculateSizeOfBinaryTree(root.left);
		int rightCount = ( null == root.right) ? 0 : 
									calculateSizeOfBinaryTree(root.right);
		return 1 + leftCount + rightCount;

	}
	//queue impl // w/o recursion 
	public static void calculateSizeOfBinaryTreeQueueImpl(Node root){
		if ( null !=  root ){
			Queue<Node> queue = new LinkedList<Node>();
			int nodeCount = 0 ;
			queue.offer(root);
			while ( !queue.isEmpty()){
				Node currNode = queue.poll();
				nodeCount++;
				if ( null != currNode.left)
						queue.offer(currNode.left);
				if ( null != currNode.right)
						queue.offer(currNode.right);
			}
			System.out.println(" Size of Binary Tree " + nodeCount);
		}else{
			System.out.println( " !!Invalid Binary Tree !!" );
		}
	}
	
	// using pre -order traversal ...and maintaining  two arrays to keep track of the nodes visited
	// i/o will be two nodes whose LCA has to be calculated
	public static void lowestCommonAncestor(Node root , int nodeValue1 , int nodeValue2){
		List<Integer> nodesTraversedForNodeValue1 = new ArrayList<Integer>();
		List<Integer> nodesTraversedForNodeValue2 = new ArrayList<Integer>();

		traverseBinaryTreeToFindCorrespondingNodes(root, nodeValue1, nodesTraversedForNodeValue1);
		traverseBinaryTreeToFindCorrespondingNodes(root, nodeValue2, nodesTraversedForNodeValue2);
		Collections.sort(nodesTraversedForNodeValue1);
		Collections.sort(nodesTraversedForNodeValue2);
	}
	
	
	
	//display left nodes of a binary tree.
	//w/ recursion
	/*          	1
	 *            /	  \
	 *          2	   3	
	 *		  /	 \	   /	
	 *		4     5	  6	
	 *		o/p -- 1,2,4,6
	 */	   	 
	static int max_level = 0 ;
	private static void displayLeftView(Node root , int level){
		//using recursion , will print left nodes only.
		if ( null !=  root){
			 // If this is the first node of its level
	        if (max_level < level)
	        {
	            System.out.print( root.data + " -->");
	            max_level = level;
	        }
			displayLeftView(root.left, level+1);
			displayLeftView(root.right, level+1);
		}
	}
	
	private static boolean traverseBinaryTreeToFindCorrespondingNodes(Node root, int nodeValue1 , List<Integer> nodesTraversedForCorrespondingNodeValue) {
		if( null != root){
			if ( root.data != nodeValue1)
				nodesTraversedForCorrespondingNodeValue.add(root.data);
			else
				return true;
			
			 return traverseBinaryTreeToFindCorrespondingNodes(root.left, nodeValue1, nodesTraversedForCorrespondingNodeValue) ||
					 traverseBinaryTreeToFindCorrespondingNodes(root.right, nodeValue1, nodesTraversedForCorrespondingNodeValue);
					
				
		}
		return false;
		
	}
	private static void inOrderTraversalWithStack(Node root){
		if ( null != root){
			//initializing a stack
			Stack<Node> stack = new Stack<Node>();
			Node currNode = root;
			while ( null != currNode){
				stack.push(currNode);
				currNode = currNode.left;
			}
			while ( !stack.isEmpty()){
				Node poppedNode = stack.pop();
				System.out.print( poppedNode.data + " ---> ");
				if (null!= poppedNode.right){
					poppedNode = poppedNode.right;
				}
				while ( null != poppedNode){
						stack.push(poppedNode);
						poppedNode = poppedNode.left;
				}
			}
			
		}
	}
	
	/*
	 * each node will have the sum of its child nodes
	 */
	private static void parentNodeSumOfChildNodes(Node root){
		//BFS
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while ( !queue.isEmpty()){
			Node poppedNode = queue.poll();
			if ( null != poppedNode.left){
				poppedNode.data+=poppedNode.left.data;
				queue.add(poppedNode.left);					
			}
			if ( null != poppedNode.right){
				poppedNode.data+=poppedNode.right.data;
				queue.add(poppedNode.right);				
			}			
		}
	}
	
	/*
	 * Convert BST to Greater Sum Tree
	   Greater sum tree is a tree in which every node con­tains the sum of all the nodes which are greater than the node
	 */
	static int globalSum = 0 ;
	private static void convertBSTToGreaterSumTreeRecursion(Node root){
		if ( null != root){
			//rightmost node will have the highest data in BST
			convertBSTToGreaterSumTreeRecursion(root.right);
			int tempSum = root.data;
			root.data = globalSum;
			globalSum += tempSum;
			convertBSTToGreaterSumTreeRecursion(root.left);			
		}
	}
	/*
	 * int inOrder[] =   {20, 30, 35, 40, 45, 50, 55, 60, 70};
	   int postOrder[] = {20, 35, 30, 45, 40, 55, 70, 60, 50};
	 */
	private static void constructFromInorderNPostOrder(int[] inOrder, int[] postOrder){
		//in post order the last node is the root node
		
	}
	 
	 //find K-th largest / smallest element in BST
	 // kth largest  = 1st element in ascending order if K=1
	//inorder traversal  sorts the tree in ascending 
	 private static void KthLargestOrSmallestElement(Node root, List<Integer> store){
		 if ( null == root) return;
		 KthLargestOrSmallestElement(root.left,store);
		 store.add(root.data);
		 KthLargestOrSmallestElement(root.right, store);
	 }
	//find K-th largest / smallest element in BST using counter
	static int counter = 0 ;
	private static void KthLargestOrSmallestElementAnother(Node root , int kthElement){
		// we will start from the right most node as its the highest // same from leftmost node for smallest Kth element
		
		if ( null == root) return;
		KthLargestOrSmallestElementAnother(root.right, kthElement);
		if (counter != kthElement)
			 counter++;
		if (counter == kthElement){
			System.out.println(kthElement + " largest element :: " + root.data);
			throw new RuntimeException();
		}
		KthLargestOrSmallestElementAnother(root.left, kthElement);
	}
	
	/*
	 * Boundary Traversal of binary tree in anti-clock wise fashion
	 *  1. Print the left boundary in top-down manner.
		2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
		…..2.1 Print all leaf nodes of left sub-tree from left to right.
		…..2.2 Print all leaf nodes of right subtree from left to right.
		3. Print the right boundary in bottom-up manner.
	 */
	 private static void doBoundaryTraversal(Node root){
		 if ( null != root){
			 //print root node and then move to left subtree
			 System.out.println(" root : " + root.data);
			 //print left sub tree in top down manner
			 printLeftSubTree(root.left);
			 // Print all leaf nodes
			 printLeaves(root.left);
			 printLeaves(root.right);
			 // Print the right boundary in bottom-up manner
			 printRightSubTree(root.right);
	 
		 }
	 }
	static void printLeftSubTree(Node left){
		if ( null != left){
			  if( null != left.left){
				System.out.println(" left :" + left.data);
				printLeftSubTree(left.left);
			  }else if( null != left.right){
				  System.out.println(" left --> right : " + left.right.data);
				  printLeftSubTree(left.right);
			  }
		}
	}
	static void printLeaves(Node leaf){
		if (leaf != null) {
            printLeaves(leaf.left);
 
            // Print it if it is a leaf node
            if (leaf.left == null && leaf.right == null) {
                System.out.print( " leaf :" + leaf.data + " ");
            }
             printLeaves(leaf.right);
        }
	}
	static void printRightSubTree(Node right){
		 if (right != null) {
			 if (right.right != null) {
				 // to ensure bottom up order, first call for right
				 //  subtree, then print this node
				 printRightSubTree(right.right);
				 System.out.print(" right "  +right.data + " ");
			 } else if (right.left != null) {
				 printRightSubTree(right.left);
				 System.out.print(" right --> left " + right.data + " ");
			 }
		 }
	}
	
	//Check a given two Binary Trees are Mirror Image of each other.
	//Two Binary Trees are considered mirror image of each other if there left and right child of every node is inter-exchange. 
	//(Left child moved to Right and Right child moved to Left)
	//taking BFS
	private static boolean isMirror(Node root1, Node root2){
		Queue<Node> queue = new LinkedList<Node>();
		Stack<Node> stack = new Stack<Node>();
		queue.offer(root1);
		stack.push(root2);
		while ( !queue.isEmpty() && !stack.isEmpty()){
			Node poppedRoot1 = queue.poll();
			Node poppedRoot2 = stack.pop();
			if ( null != poppedRoot1 && null !=poppedRoot2 && poppedRoot1.data != poppedRoot2.data)
				return false;
			queue.add(poppedRoot1.left);
			queue.add(poppedRoot1.right);
			stack.add(poppedRoot2.left);
			stack.add(poppedRoot2.right);
		}
		return true;
	}
	//find depth of deepest odd level leaf node.
	//starting   the operation with root  with level 1
	private static int depthDeepestOddLevelLeafNode(Node root, int currLevel) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null && ((currLevel % 2) != 0))
			return currLevel;
		return Math.max(depthDeepestOddLevelLeafNode(root.left, currLevel + 1), depthDeepestOddLevelLeafNode(root.right, currLevel + 1));
	}
	//find-sum-of-all-left-leaves-binary-tree
		
	private static void sumOfAllLeftLeaves(Node root, int[] sum){
		if ( null != root){
			//checking for leaf node and 
			if (root.left != null && (root.left.left == null && root.left.right == null) )
				sum[0]  += root.left.data;
			sumOfAllLeftLeaves(root.left, sum);
			sumOfAllLeftLeaves(root.right, sum);
		}
	}
	
	//check-whether-binary-tree-is-full-binary-tree-or-not
	//A binary tree is a full binary tree if all its nodes have either both children or no children. 
	
	private static boolean checkBTIsFullBT(Node root){
		if ( null == root)
			return false;
		//checking binary tree criteria
		if ( ( root.left != null && root.right == null ) || ( root.left == null && root.right != null ))
			return false;			
		return checkBTIsFullBT(root.left) && checkBTIsFullBT(root.right);

	}
	//Given two nodes in a binary tree, check if they are cousins.
	/*Two nodes are cousins if: 
		1: they are not siblings (children of same parent).
		2: they are on the same level.
	*/
	private static boolean isGivenNodesCousins(Node root, int nodeValue1 , int nodeValue2){
		Queue<Node> queue = new LinkedList<Node>();
		root.setLevel(1);
		queue.add(root);
		while (!queue.isEmpty()){
			int nodes = queue.size();
			while ( nodes > 0 ){
				Node currNode = queue.poll();
				
			}
		}
		return false;
	}
	//Check if two binary trees are identical
	private static boolean isTwoBinaryTreesIdentical(Node rootNodeOne , Node rootNodeTwo){
		if ( ( rootNodeOne !=  null && rootNodeTwo == null ) || ( rootNodeOne ==  null && rootNodeTwo != null ) )
			return false;
		if ( null != rootNodeOne && null != rootNodeTwo ) 
		{
		return rootNodeOne.data  == rootNodeTwo.data && isTwoBinaryTreesIdentical(rootNodeOne.left, rootNodeTwo.left)
				&& isTwoBinaryTreesIdentical(rootNodeOne.right, rootNodeTwo.right);
		}
		else return true;
		
	}
	//convert a tree to its mirror tree
//	public static Node convertTreeToMirrorTree(Node root){
//		if ( null != root)
//		{
//			//swap left and right pointers values
//			
//		}
//	}
	
	
	//check-if-a-binary-tree-is-subtree-of-another-binary-tree-time-optimized
	//root1 is parent and root2 is the subtree root
	private static boolean isBTSubTreeOfAnotherBT(Node root1, Node root2){
		// looking for subtree root value into parent tree
		// doing any traversal
		Node subtreeStartNode = findSubTreeRootIndex(root1, root2.data);
		if ( null == subtreeStartNode){
			System.out.println(" This binary tree doesn't contain the sub tree");
			return false;
		}
		return validateBTSubTreeOfAnotherBT(subtreeStartNode,root2);
	}
	//doing any traversal and matching the data
    private static boolean validateBTSubTreeOfAnotherBT(Node subtreeStartNode, Node root2) {
    	if ( subtreeStartNode == null && root2 == null) return true;
    	if ( subtreeStartNode == null || root2 == null) return false;
    	return subtreeStartNode.data == root2.data
    			&& validateBTSubTreeOfAnotherBT(subtreeStartNode.left,root2.left) 
    			&& validateBTSubTreeOfAnotherBT(subtreeStartNode.right,root2.right); 
		
	}
	private static Node findSubTreeRootIndex(Node root1, int subTreeStartNodeValue) {
		if ( null == root1) return null;
		if (root1.data == subTreeStartNodeValue) return root1;
		findSubTreeRootIndex(root1.left,subTreeStartNodeValue);
		findSubTreeRootIndex(root1.right,subTreeStartNodeValue);
		return null;		
	}
	
	//create-a-balanced-bst-from-a-sorted-array
	//Given a sorted integer array of length n, create a balanced Binary Search Tree using elements of the array.
	private static Node createBalancedBSTSortedArray(int[] array, int start, int end){
		if ( null == array || array.length == 0 || start > end ) return null;
		// doing a binary search 
		int mid =  ( start + end ) / 2 ; 
		Node root = new Node(array[mid]);
		root.left = createBalancedBSTSortedArray(array, start, mid -1 );
		root.right = createBalancedBSTSortedArray(array, mid + 1, end);
		return root;
	}
	
	private static void traverseMap(Map<?,?> map){
    	 for (Map.Entry<?,?> e : map.entrySet()){
 			System.out.println( e.getKey() + " :: " +e.getValue());
 		}
     }
	//construct-binary-tree-from-inorder-and-preorder-traversals
	private static Node constructBTFromInorderPreOrderTraversals(){ return null;}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
		bst.addNode(50);
		bst.addNode(10);
		bst.addNode(60);
		bst.addNode(9);
		bst.addNode(20);
		bst.addNode(70);
		bst.addNode(30);
		bst.addNode(5);
		bst.levelOrderTraversal(rootNode);

		Map<Integer,String> map2 = printVerticallyLOT(rootNode, new TreeMap<Integer,String>());
		System.out.println("prints vertically using BFS");
		traverseMap(map2);
		Map<Integer,Integer> map3 = verticalSum(rootNode,new TreeMap<Integer,Integer>(),0);
		System.out.println("prints vertical sum");
		traverseMap(map3);

		Map<Integer,Integer> map5 = rightView(rootNode, new TreeMap<Integer,Integer>());
		System.out.println("prints right view");
		//traverseMap(map5);	
		printAllNodesBetweenGivenLevels(rootNode, 1, 4);
		System.out.println("Maximum Width ::" + maximumWidth(rootNode));
		System.out.println("zig zag / spiral traversal ");
		zigZagSpiralTree(rootNode);
		System.out.println(" Pre - Order Traversal");
		preOrderTraversal(rootNode);
		
		System.out.println(" Find maximum element ");
		System.out.println( " Maximum Element is  " +  	largestElement(rootNode));
		
		System.out.println(" Search Element in Binary Tree");
		System.out.println(" Searching Element 5 in Binary Tree");
		System.out.println(elementSearch(rootNode, 3) ? " Element Found" : " Element Not Found");
		
		System.out.println(" Recursion :: Calculate Size of Binary Tree");
		System.out.println(" Size of Binary Tree is " + calculateSizeOfBinaryTree(rootNode));
		
		System.out.println(" Finding the LCA between Nodes 4 and 6");
		lowestCommonAncestor(rootNode, 4, 6);
		
		System.out.println(" Display Left View of the Above Binary Tree");
		displayLeftView(rootNode,1);
		System.out.println(" Display Left View of the Above Binary Tree using BFS");
		
		System.out.println( " Inorder Traversal using stack");
		inOrderTraversalWithStack(rootNode);
		parentNodeSumOfChildNodes(rootNode);
		System.out.println( " Convert a BST to a Sum Tree");
		convertBSTToGreaterSumTreeRecursion(rootNode);
		System.out.println("Kth largest /smallest element in BST");
		//List<Integer> ascendingList = new ArrayList<Integer>();
		//KthLargestOrSmallestElement(rootNode,ascendingList);
		//System.out.println(ascendingList);//take out the req. element 
		//KthLargestOrSmallestElementAnother(rootNode,2);
		//int nodeValues[] = new int[]{1,-2,3,4,-5,6,7};
		//System.out.println(" constructing binary tree for node for node values  " + nodeValues);
		//constructBST(nodeValues);
		constructBTQueue(new int[]{1,2,3,4,5,6,7});
        int[] leftLeavesSum = new int[1];
		sumOfAllLeftLeaves(constructBTQueue(new int[]{1,2,3,4,5,6,7}), leftLeavesSum);
		System.out.println("Is Binary tree a Full Binary Tree : "
				+ checkBTIsFullBT(constructBTQueue(new int[] { 1, 2, 3, 4, 5, 6 })));
		System.out.print( "Is TWO Binary Trees Identical ?? ");
		System.out.print(isTwoBinaryTreesIdentical(constructBTQueue(new int[] { 1, 2, 3, 4, 5, 6 }),
				constructBTQueue(new int[] { 1, 2, 3, 4, 5,6 })));
		System.out.println(" create a binary search tree from a sorted array");
		createBalancedBSTSortedArray(new int[] { 1, 2, 3, 4, 5, 6 , 7 }, 0 , 7);
	}



}
