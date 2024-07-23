package com.practise.datastructures.algo.amazon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;

public class AmazonBinaryTreeQuestions {

	
	/*
	Complete Binary Tree: 
	A Binary Tree is complete Binary Tree if all levels are completely filled
	except possibly the last level and the last level has all keys as left as possible



	Following are examples of Complete Binary Trees

	               18
	           /       \  
	         15         30  
	        /  \        /  \
	      40    50    100   40


	               18
	           /       \  
	         15         30  
	        /  \        /  \
	      40    50    100   40
	     /  \   /
	    8   7  9 
	    
	    
	    
	    Full Binary Tree
	    
	    A Binary Tree is full if every node has 0 or 2 children. Following are examples of full binary tree.
	     We can also say a full binary tree is a binary tree in which all nodes except leaves have two children.

		        18
		    /       \  
		  15         30  
		 /  \        /  \
		40    50    100   40
		
		      18
		    /    \   
		  15     20    
		 /  \       
		40    50   
		/   \
		30   50
		
		        18
		     /     \  
		   40       30  
		            /  \
		          100   40
		In a Full Binary, number of leaf nodes is number of internal nodes plus 1
		L = I + 1
		Where L = Number of leaf nodes, I = Number of internal nodes
		
		
		Perfect Binary Tree 
		
		A Binary tree is Perfect Binary Tree in which all internal nodes have two children 
		and all leaves are at same level.
		Following are examples of Perfect Binaryr Trees.
		
		               18
		           /       \  
		         15         30  
		        /  \        /  \
		      40    50    100   40
		
		
		               18
		           /       \  
		         15         30  
		A Perfect Binary Tree of height h (where height is number of nodes on path from root to leaf) has 2h – 1 node.
		
		Example of Perfect binary tree is ancestors in family. Keep a person at root, parents as children,
		 parents of parents as their children.
		*/
	
	private class BinaryTreeNode{
		
		private BinaryTreeNode left;
		private BinaryTreeNode right;
		private int value;		
		public BinaryTreeNode(final int value)
		{
			this.value = value;
		}
	}
	
	private BinaryTreeNode root;
	
	private BinaryTreeNode createBinaryTree(int[] array)
	{	
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		root = null;
		for ( int element : array)
		{
			create(element,queue);
		}
		return root;
	}
	private void create(final int element , Queue<BinaryTreeNode> queue)
	{		
			BinaryTreeNode nodeToInsert =  new BinaryTreeNode(element);
			if ( null  == root) 
			{
				root = nodeToInsert;
				queue.offer(root);
			}
			else
			{
				BinaryTreeNode currNode = queue.peek();
				while( null != currNode)
				{
					if ( currNode.left == null) 
					{
						currNode.left = nodeToInsert;
						queue.offer(nodeToInsert);
						break;
					}
					else if (currNode.right == null)
					{
						currNode.right = nodeToInsert;
						queue.offer(nodeToInsert);
						break;
					}
					// both the child's are filled
					// remove from queue now
					queue.poll();
					currNode = queue.peek();
				}
				
			}
	}
	
	
	private void levelOrderTraversal(BinaryTreeNode rootNode)
	{
		if ( null == rootNode) return;
		else
		{
			Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
			queue.add(rootNode);
			System.out.println("Level Order Traversal.");
			while ( !queue.isEmpty() ) 
			{
				  BinaryTreeNode poppedNode = queue.poll();
			      if ( null == poppedNode) continue;
			      System.out.print( poppedNode.value + " ---> ");
			      queue.add(null!= poppedNode.left ? poppedNode.left :null);
			      queue.add(null!= poppedNode.right ? poppedNode.right :null);

			}
		}
		System.out.println("\n");
		
	}
	
	//Given a Tree - Convert it into Circular DLL Double Linked List -- In PLACE ?
	//Form the Linked List from Left --> Right 
	//Consider All of Left SubTree First and Then Right SubTree
	
	private void convertTreeToDoublyLinkedList(BinaryTreeNode root)
	{
		
	}
	
	//check if both binary tree's are identical to each other or not
	private boolean isGivenBTIdenticalToEachOther(BinaryTreeNode root1 , BinaryTreeNode root2)
	{
		if ( null == root1 && null == root2) return Boolean.TRUE;
		if ( null != root1 && null != root2)
		{
			if (root1.value == root2.value)
			{
				if ( isGivenBTIdenticalToEachOther(root1.left,root2.left) && isGivenBTIdenticalToEachOther(root1.right,root2.right) )
				{
					return Boolean.TRUE;
				}
			}
		}
		return Boolean.FALSE;
	}
	
	// check is a binary tree is a subtree of another 
	private boolean isBTSubTreeOfAnother(BinaryTreeNode mainTree , BinaryTreeNode subTree)
	{
		if ( null == subTree) return Boolean.TRUE;
		if ( null == mainTree) return  Boolean.FALSE;
		//is both tree pointed at root identical
		if(isGivenBTIdenticalToEachOther(mainTree,subTree)) return Boolean.TRUE;
		//may be the left subtree will match with given subtree OR
		//may be the right subtree will match with given subtree
		return isBTSubTreeOfAnother(mainTree.left , subTree) || isBTSubTreeOfAnother(mainTree.right , subTree);
	}
	
	
	private void printLeftView(BinaryTreeNode node , int currentLevel , AtomicInteger value)
	{
		if ( null == node) return ;
		//is the current level a new level
		//print the left most entry
		if (value.get() < currentLevel)
		{
			System.out.println( "Left View Node Value =" + node.value );
			value.set(currentLevel);
		}
		printLeftView(node.left, currentLevel+1, value);
		printLeftView(node.right, currentLevel+1, value);
 	}
	
	private void printLeftViewHashMap(BinaryTreeNode node , int currentLevel , HashMap<Integer,Integer> map)
	{
		if ( null == node) return ;
		//is the current level a new level i.e map does not have an existing entry 
		//print the leftmost entry 
		if (!map.containsKey(currentLevel))
		{
			System.out.println( "Left View Node Value = " + node.value );
			map.put(currentLevel, node.value);
		}
		printLeftViewHashMap(node.left, currentLevel+1, map);
		printLeftViewHashMap(node.right, currentLevel+1, map);
 	}
	private void build_printLeftView()
	{
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.right = new BinaryTreeNode(4);
		root.right.left = new BinaryTreeNode(5);
		root.right.right = new BinaryTreeNode(6);
		root.right.left.left = new BinaryTreeNode(7);
		root.right.left.right = new BinaryTreeNode(8);
		System.out.println( " -- printLeftView -- AtomicInteger");
		printLeftView(root, 1, new AtomicInteger(0));
		System.out.println( " -- printLeftView -- HashMap");
		printLeftViewHashMap(root, 1, new HashMap<Integer, Integer>());
	}
	
	private void isBinaryTreeABST(BinaryTreeNode root , List<Integer> result)
	{
		// do a in-order traversal - should result in ascending values 
		if (null ==root) return;
		isBinaryTreeABST(root.left,result);
		result.add(root.value);
		isBinaryTreeABST(root.right, result);
	} 
	//https://algorithms.tutorialhorizon.com/determine-whether-given-binary-tree-is-binary-search-treebst-or-not/
	//in place - does not support duplicates
	BinaryTreeNode prevNode =  null;
	private boolean isBinaryTreeABSTInPlace(BinaryTreeNode currNode)
	{
		// do a in-order traversal - should result in ascending values 
		if (null ==currNode) return Boolean.TRUE;
		if (!isBinaryTreeABSTInPlace(currNode.left)) return Boolean.FALSE;
		if ( null != prevNode && prevNode.value > currNode.value) return Boolean.FALSE;
		prevNode = currNode;
		return isBinaryTreeABSTInPlace(currNode.right);
	}
	//https://algorithms.tutorialhorizon.com/determine-whether-given-binary-tree-is-binary-search-treebst-or-not/
	//	Your root value can have any value between -∞ to + ∞. When you validate the right child of 30, 
	//	it can take any value between 30 and + ∞. When you validate the left child of 30, it can take any value between – ∞ and 30. likewsie when you validate the left child of 40, it can take any value between 30 and 40.
	//	So the idea is Pass the minimum and maximum values between which the node’s value must lie.
	private boolean isBinaryTreeABSTInPlace2(BinaryTreeNode currNode , int min , int max)
	{
		// do a in-order traversal - should result in ascending values 
		if (null == currNode) return Boolean.TRUE;
		if (currNode.value > max || currNode.value < min) {
			return Boolean.FALSE;
		}
		return isBinaryTreeABSTInPlace2(currNode.left,min,currNode.value) &&  isBinaryTreeABSTInPlace2(currNode.right,currNode.value,max);
	}
	
	private void build_isBinaryTreeABST()
	{
		BinaryTreeNode root = new BinaryTreeNode(8);
		root.left = new BinaryTreeNode(3);
		root.right = new BinaryTreeNode(10);
		root.left.left = new BinaryTreeNode(1);
		root.left.right = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(14);
		System.out.println( " -- isBinaryTreeABST --");
		List<Integer> result = new ArrayList<Integer>();
		isBinaryTreeABST(root,result);
 		System.out.println(result);
 		System.out.println( " -- isBinaryTreeABSTInPlace -- ");
 		isBinaryTreeABSTInPlace(root);
 		boolean result1 = isBinaryTreeABSTInPlace2(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
 		System.out.println( " -- isBinaryTreeABSTInPlace2 -- " + result1);
	}
	
	//map with key as horizontal distance from currNode  and value as comma separated string height of the node from root , node value
	// can also be done with a queue - do level order traversal and insert values as below in hashmap - the leaves will update above values 
	private void print_bottom_view(BinaryTreeNode currNode , int hdDistFromCurrNode , int heightOfCurrNodeFromRoot , Map<Integer,String> map)
	{
		if (null == currNode) return; //base
		if (map.containsKey(hdDistFromCurrNode))
		{
			//if any two nodes has same horizontal distance and at same height consider later
			String data = map.get(hdDistFromCurrNode);
			//if height of the incoming node is greater than the already persisted node
			//update
			int height = Integer.parseInt(data.split(",")[0]);
			if (height < heightOfCurrNodeFromRoot || height == heightOfCurrNodeFromRoot)
					map.put(hdDistFromCurrNode, String.valueOf(heightOfCurrNodeFromRoot).concat(",").concat(String.valueOf(currNode.value)));
		}
		else
		{
			map.put(hdDistFromCurrNode,String.valueOf(heightOfCurrNodeFromRoot).concat(",").concat(String.valueOf(currNode.value)));
		}
			 
		//do any traversal
		print_bottom_view(currNode.left, hdDistFromCurrNode+1, heightOfCurrNodeFromRoot+1 , map);
		print_bottom_view(currNode.right, hdDistFromCurrNode-1, heightOfCurrNodeFromRoot+1 , map);
	}
	
	//print binary tree in vertical order
    /*			   1
     * 			 /   \
     * 			2	  3
     * 		   / \   / \
     * 		  4	  5 6   7
     * 
     *   o/p: 4 
     *   	  2
     *   	  1 5 6
     *   	  3
     *   	  7
     */
	//pre order traversal
	//https://algorithms.tutorialhorizon.com/print-the-binary-tree-in-vertical-order-path/
     private static TreeMap<Integer, String> printVertically(BinaryTreeNode rootNode, TreeMap<Integer, String> map , int levelValue){
    	 if ( null == rootNode) return null;
    	 if ( map.containsKey(levelValue)){
    		 map.put(levelValue, map.get(levelValue)+","+ String.valueOf(rootNode.value));
    	 }else{
    		 map.put(levelValue, String.valueOf(rootNode.value));
    	 }
    	 printVertically(rootNode.left, map, levelValue-1);
    	 printVertically(rootNode.right, map, levelValue+1);
    	 return map;
     }
   
	private void build_bottom_view(){
		BinaryTreeNode root = new BinaryTreeNode(20);
		root.left = new BinaryTreeNode(8);
		root.right = new BinaryTreeNode(22);
		root.left.left = new BinaryTreeNode(5);
		root.left.right = new BinaryTreeNode(3);
		root.right.right = new BinaryTreeNode(25);
		root.left.right.left = new BinaryTreeNode(10);
		root.left.right.right = new BinaryTreeNode(14);
		System.out.println( " -- bottom view : 1--");
		Map<Integer,String> map = new HashMap<Integer, String>();
		print_bottom_view(root,0,0,map);
		System.out.println(map);
		root = new BinaryTreeNode(20);
		root.left = new BinaryTreeNode(8);
		root.right = new BinaryTreeNode(22);
		root.left.left = new BinaryTreeNode(5);
		root.left.right = new BinaryTreeNode(3);
		root.right.left = new BinaryTreeNode(4);
		root.right.right = new BinaryTreeNode(25);
		root.left.right.left = new BinaryTreeNode(10);
		root.right.left.right = new BinaryTreeNode(14);
		System.out.println( " -- bottom view : 2--");
		map.clear();
		print_bottom_view(root,0,0,map);
		System.out.println(map);
		
		
	}
	
	 //https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1
	//using deque
    private static void print_spirally_using_level_order_traversal(BinaryTreeNode root)
    {

    		if (root == null) {
    			return;
    		}

    		// create an empty double ended queue and enqueue root node
    		Deque<BinaryTreeNode> deque = new ArrayDeque<BinaryTreeNode>();      // or use deque
    		deque.addFirst(root);

    		// flag used to differentiate between odd or even level
    		boolean flag = false;

    		// run till deque is not empty
    		while (!deque.isEmpty())
    		{
    			// calculate number of nodes in current level
    			int nodeCount = deque.size();

    			// print left to right
    			if (flag)
    			{
    				// process each node of current level and enqueue their
    				// non-empty left and right child to deque
    				while (nodeCount > 0)
    				{
    					// pop from front if flag is true
    					BinaryTreeNode curr = deque.pollFirst();
    					System.out.print(curr.value + " ");

    					// push left child to end followed by right child if flag is true

    					if (curr.left != null) {
    						deque.addLast(curr.left);
    					}

    					if (curr.right != null) {
    						deque.addLast(curr.right);
    					}

    					nodeCount--;
    				}
    			}

    			// print right to left
    			else
    			{
    				// process each node of current level and enqueue their
    				// non-empty right and left child to queue
    				while (nodeCount > 0)
    				{
    					// Important - pop from back if flag is false
    					BinaryTreeNode curr = deque.pollLast();
    					System.out.print(curr.value + " ");   // print front node

    					// Important - push right child to front followed by left
    					// child if flag is false

    					if (curr.right != null) {
    						deque.addFirst(curr.right);
    					}

    					if (curr.left != null) {
    						deque.addFirst(curr.left);
    					}

    					nodeCount--;
    				}
    			}

    			// flip the flag for next level
    			flag = !flag;
    			System.out.println();
    		}
    	}
    
    
    private void build_print_spirally_using_level_order_traversal()
    {
    	BinaryTreeNode root = new BinaryTreeNode(15);
		root.left = new BinaryTreeNode(10);
		root.right = new BinaryTreeNode(20);
		root.left.left = new BinaryTreeNode(8);
		root.left.right = new BinaryTreeNode(12);
		root.right.left = new BinaryTreeNode(16);
		root.right.right = new BinaryTreeNode(25);
		System.out.println(" -- print_spirally_using_level_order_traversal -- ");
		print_spirally_using_level_order_traversal(root);
    }
    
  //implementing the same above problem but with single traversal.
  	//hopefully using queue the solution can be acheived.
   // https://www.youtube.com/watch?v=13m9ZCB8gjw
  	public static BinaryTreeNode lowestCommonAncestorRecursion(BinaryTreeNode root , int nodeValue1 , int nodeValue2){

  		if(root == null) {
  			return null;
  		}

  		// If we find p or q, we return the node
  		if(root.value == nodeValue1 || root.value == nodeValue2)
  			return root;

  		// Recursive calls to find LCA in left and right subtrees
  		BinaryTreeNode leftNode = lowestCommonAncestorRecursion(root.left, nodeValue1, nodeValue2);
  		BinaryTreeNode rightNode = lowestCommonAncestorRecursion(root.right, nodeValue1, nodeValue2);

  		// If we found p and q in left or right subtree of the current node, 
  		// this means current node is a common ancestor, so return the node
  		if(leftNode != null && rightNode != null)
  			return root;

  		// If we found p or q in left or right subtree of the current node,
  		// the means current node is an ancestor, return the node
  		return leftNode != null ? leftNode : rightNode;
  	}
  	
  	// LCA of BST
  	//https://www.youtube.com/watch?v=TIoCCStdiFo
  	public  BinaryTreeNode lowestCommonAncestorRecursionBST(BinaryTreeNode root , int nodeValue1 , int nodeValue2)
  	{
  			if (root.value == nodeValue1 || root.value == nodeValue2) return root;
  			if (nodeValue1 < root.value && nodeValue2 > root.value) return root;
  			if (nodeValue1 > root.value && nodeValue2  < root.value) return root;
  			
  			if (nodeValue1 < root.value && nodeValue2 < root.value)
  				return lowestCommonAncestorRecursionBST(root.left,nodeValue1,nodeValue2);
  			
  			if (nodeValue1 > root.value && nodeValue2 > root.value)
  				return lowestCommonAncestorRecursionBST(root.right,nodeValue1,nodeValue2);
  			return null != root ? root: null;

  	}
  	
  	private void build_lowestCommonAncestorRecursionBST()
  	{
  		BinaryTreeNode root = new BinaryTreeNode(10);
		root.left = new BinaryTreeNode(-10);
		root.right = new BinaryTreeNode(30);
		root.right.left = new BinaryTreeNode(25);
		root.right.right = new BinaryTreeNode(60);
		root.right.right.right = new BinaryTreeNode(78);
		root.right.left.right = new BinaryTreeNode(28);
		root.left.right = new BinaryTreeNode(8);
		root.left.right.right = new BinaryTreeNode(9);
		root.left.right.left = new BinaryTreeNode(6);

		System.out.println(" -- lowestCommonAncestorRecursionBST -- ");
		BinaryTreeNode result = lowestCommonAncestorRecursionBST(root,-16,9);
		System.out.println(result.value );
  	}
  	//check-if-binary-tree-is-symmetric-tree
  	//A symmetric tree is defined as a tree which is mirror image of itself about the root node.
  	/*
  	 *  The algorithm is an implementation of a simple idea that - 
  		1. For given two trees, if both trees are empty then they are mirror images of one another.
  		Else they have to satisfy following conditions:
  		2. Root values of both trees have to be same.
  		3. Left sub-tree of tree1 should be mirror image of right sub-tree of tree2.
  		4. Right sub-tree of tree1 should be mirror image of left sub-tree of tree2. 
  	 */
  	private boolean isSymmetric(BinaryTreeNode root1, BinaryTreeNode root2){
  		if (root1 == null && root2 == null) return true;
  		if (root1 == null || root2 == null) return false;
  		return root1.value == root2.value &&  isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
  		//return false;
  	}
  	
  	private void build_isSymmetric()
  	{
  		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(2);
		//root.left.left = new BinaryTreeNode(3);
		root.left.right = new BinaryTreeNode(3);
		//root.right.left = new BinaryTreeNode(4);
		root.right.right = new BinaryTreeNode(3);
		System.out.println(" -- isSymmetric -- ");
		System.out.println( isSymmetric(root,root));
  	}
  	//https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1
  	private int maximum_height(BinaryTreeNode root , int currLevel)
  	{
  		if ( null == root) return currLevel - 1;
  		return Math.max(maximum_height(root.left,currLevel+1) , maximum_height(root.right,currLevel+1));
  	}
  	private void build_maximum_height()
  	{
  		BinaryTreeNode root = new BinaryTreeNode(10);
		root.left = new BinaryTreeNode(20);
		root.right = new BinaryTreeNode(30);
		root.left.left = new BinaryTreeNode(40);
		root.left.right = new BinaryTreeNode(60);
		//root.left.right.left = new BinaryTreeNode(10);
		System.out.println(" -- max_height -- ");
		System.out.println( maximum_height(root,1));
  	}
  	//https://www.youtube.com/watch?v=ey7DYc9OANo
  	private int maximum_diameter(BinaryTreeNode root)
  	{
  		if ( null == root) return 0;
  		int lHeight = maximum_height(root.left, 0) + 1;
  		int rHeight = maximum_height(root.right, 0) + 1;
  		int lDiameter = maximum_diameter(root.left);
  		int rDiameter = maximum_diameter(root.right);
  		
  		int maxDiameter = Math.max(lHeight + rHeight + 1 , Math.max(lDiameter, rDiameter));
  		return maxDiameter;
  	}
  	
  	private void build_diameter()
  	{
  		BinaryTreeNode root = new BinaryTreeNode(10);
		root.left = new BinaryTreeNode(20);
		root.right = new BinaryTreeNode(30);
		root.left.left = new BinaryTreeNode(40);
		root.left.right = new BinaryTreeNode(60);
		root.left.right.left = new BinaryTreeNode(10);
		root.left.right.right = new BinaryTreeNode(10);
		root.right.right = new BinaryTreeNode(30);
		root.right.right.right = new BinaryTreeNode(30);
		root.right.right.right.right = new BinaryTreeNode(30);
		root.right.right.right.left = new BinaryTreeNode(50);
		root.right.right.right.left.right = new BinaryTreeNode(50);
		root.right.right.right.left.left = new BinaryTreeNode(50);
		System.out.println(" -- diameter of a binary tree -- ");
		System.out.println( maximum_diameter(root));
  	}
  	
  	private int count_leaves(BinaryTreeNode node)
  	{
  		if ( node == null ) return 0 ;
  		int leftSubTreeLeaves = count_leaves(node.left );
  		int rightSubTreeLeaves = count_leaves(node.right);
  		if (node.left == null && node.right == null ) return 1;
  		return leftSubTreeLeaves + rightSubTreeLeaves;
  	}
  	
  	private void build_count_leaves()
  	{
  		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(10);
		root.right = new BinaryTreeNode(39);
		root.left.left = new BinaryTreeNode(7);
		System.out.println(" -- count_leaves  -- ");
		//AtomicInteger count = new AtomicInteger(0);
		System.out.println(count_leaves(root));
  	}
  	
  	private void serialize(BinaryTreeNode root , Queue<Integer> queue)
  	{
  		if ( null == root)
  		{
  			queue.offer(-1);
  			return;
  		}
  		queue.offer(root.value);
  		serialize(root.left,queue);
  		serialize(root.right,queue);
  	}
  	
  	private BinaryTreeNode deserialize(Queue<Integer> queue)
  	{
  		Integer nodeVal = queue.poll();
  		if (nodeVal ==  -1 ) return null;
  		BinaryTreeNode node = new BinaryTreeNode(nodeVal);
  		node.left = deserialize(queue);
  		node.right = deserialize(queue);
  		return node;
  	}
  	private void build_serialize_deserialize()
  	{
  		BinaryTreeNode root = new BinaryTreeNode(-10);
		root.left = new BinaryTreeNode(9);
		root.right = new BinaryTreeNode(20);
		root.right.left = new BinaryTreeNode(15);
		root.right.right = new BinaryTreeNode(7);
		root.left.right = new BinaryTreeNode(70);
		root.right.left.left = new BinaryTreeNode(150);
		System.out.println(" -- serialize_deserialize -- ");
		Queue<Integer> queue = new LinkedList<Integer>();
		serialize(root,queue);
		BinaryTreeNode node = deserialize(queue);
		System.out.println(node);
  	}
  	//https://practice.geeksforgeeks.org/problems/maximum-path-sum/1
  	private int max_path_sum(BinaryTreeNode root)
  	{
  		if ( null == root) return 0;
  		int leftSum = root.value + max_path_sum(root.left);
  		int rightSum = root.value + max_path_sum(root.right);
  		return Math.max(leftSum, rightSum);
  	}
	public static boolean print_max_path_sum (BinaryTreeNode root, int sum)
	{
		// base case
		if (sum == 0) {
			return true;
		}

		// base case
		if (root == null) {
			return false;
		}

		// recur for left and right subtree with reduced sum
		boolean left = print_max_path_sum(root.left, sum - root.value);
		boolean right = print_max_path_sum(root.right, sum - root.value);

		// print current node if it lies on path having given sum
		if (left || right) {
			System.out.print(root.value + " ");
		}

		return left || right;
	}
  	private void build_max_path_sum()
  	{
  		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(8);
		root.left.right = new BinaryTreeNode(4);
		root.left.right.left = new BinaryTreeNode(10);
		root.right.right = new BinaryTreeNode(6);
		root.right.right.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(5);
		root.right.left.left = new BinaryTreeNode(7);
		root.right.left.right = new BinaryTreeNode(9);
		System.out.println(" -- max_path_sum -- ");
		int maxSum  = max_path_sum(root);
		System.out.println(maxSum);
		print_max_path_sum(root,maxSum);
  	}
  	private void build_connect_nodes_same_level()
  	{
  		BinaryTreeNode root = new BinaryTreeNode(10);
		root.left = new BinaryTreeNode(20);
		root.right = new BinaryTreeNode(30);
		root.left.left = new BinaryTreeNode(40);
		root.left.right = new BinaryTreeNode(60);
		root.right.right = new BinaryTreeNode(70);
		System.out.println(" -- connect_nodes_same_level -- ");
		connect_nodes_same_level(root);
  	}
	private void connect_nodes_same_level(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		Queue<BinaryTreeNode> queue = new LinkedList<AmazonBinaryTreeQuestions.BinaryTreeNode>();
		queue.add(root);
		List<Integer> result  = new ArrayList<Integer>();
		while (!queue.isEmpty())
		{
			int noOfNodes = queue.size();
			while (noOfNodes != 0 )
			{	
				BinaryTreeNode polledNode = queue.poll();
				result.add(polledNode.value);
				if (polledNode.left != null ) queue.offer(polledNode.left);
				if (polledNode.right != null ) queue.offer(polledNode.right);
				--noOfNodes;
			}
		}
		System.out.println(result);
	}
	//https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1
	private void build_bt_to_dll() {
		// TODO Auto-generated method stub
		BinaryTreeNode root = new BinaryTreeNode(10);
		root.left = new BinaryTreeNode(20);
		root.right = new BinaryTreeNode(30);
		root.left.left = new BinaryTreeNode(40);
		root.left.right = new BinaryTreeNode(60);
		root.right.right = new BinaryTreeNode(70);
		System.out.println( " -- binary tree to DLL -- ");
		bt_to_dll(root);
		
	}
//	Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. 
//	The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. 
//	The order of nodes in DLL must be same as Inorder of the given Binary Tree. 
//	The first node of Inorder traversal (left most node in BT) must be head node of the DLL.

	private class DoubleLinkedList{
		private int value;
		private DoubleLinkedList prev;
		private DoubleLinkedList next;
		
		private DoubleLinkedList(final int data)
		{
			this.value = data;
		}
		
	}
	private void bt_to_dll(BinaryTreeNode root)
	{
		
	}
	
	//given a bt .consisting of 0 and 1 
	//find the largest binary number formed by traversing from root to leaf .
	
	private BinaryTreeNode find_largest_binary_number(BinaryTreeNode root , String currBinaryNumber , List<String> listOfBinaryNumbers)
	{	
		if (root == null) return null ;
		
		currBinaryNumber = currBinaryNumber.concat(String.valueOf(root.value));
		
		BinaryTreeNode left = find_largest_binary_number(root.left , currBinaryNumber , listOfBinaryNumbers);
		
		BinaryTreeNode right = find_largest_binary_number(root.right ,currBinaryNumber , listOfBinaryNumbers);
		
		if ( left == null && right == null)
		{
			listOfBinaryNumbers.add(currBinaryNumber);
			currBinaryNumber = currBinaryNumber.substring(0, currBinaryNumber.length()-1);
		}
			
		return root;
	}
	
	private void find_largest_binary_number(BinaryTreeNode root , Integer sum , int s)
	{	
		     if (root == null) return;
		     s= s<<1 | root.value;
		     if(sum>s) sum=s;
		     find_largest_binary_number(root.left,sum,s);
		     find_largest_binary_number(root.right,sum,s);
		     if(sum>s) sum=s;
		     System.out.println(s);
	}
	
	private void build_find_largest_binary_number()
	{
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(0);
		root.right = new BinaryTreeNode(0);
		root.left.left = new BinaryTreeNode(0);
		root.left.right = new BinaryTreeNode(0);
		root.right.right = new BinaryTreeNode(1);
		//root.right.left = new BinaryTreeNode(0);
		System.out.println();
		System.out.println( " -- find_largest_binary_number -- ");
		List<String> listOfBinaryNumbers = new ArrayList<String>();
		find_largest_binary_number(root , Integer.MAX_VALUE,0);
		System.out.println( " list of binary numbers = " + listOfBinaryNumbers);
		int largestDecNumber = Integer.MIN_VALUE;
		String largestBinaryNumber  = StringUtils.EMPTY;
		for (String binaryNumber : listOfBinaryNumbers)
		{
			int temp = Integer.parseInt(binaryNumber, 2);
			if (temp > largestDecNumber) largestBinaryNumber = binaryNumber;
		}
		System.out.println( " largest  binary number among all above = " + largestBinaryNumber);

	}
	
	public static int findHeight(BinaryTreeNode root){
		BinaryTreeNode currNode = root;
		if ( null == currNode) return 0;
		return Math.max(findHeight(currNode.left) , findHeight(currNode.right)) +1 ;
	}
	// a  binary tree is balanced if each and every sub tree differ by heigh1 @max 1.
	public boolean isBinaryTreeBalanced(BinaryTreeNode root){
		if ( null == root) return true;
		if ( Math.abs(findHeight(root.left) - findHeight(root.right))  > 1 ){
			System.out.println(" binary tree is not balanced");
			return false;
		}else
			return isBinaryTreeBalanced(root.left) && isBinaryTreeBalanced(root.right);
	}
	
	private void build_is_BinaryTreeBalanced()
	{
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(0);
		root.right = new BinaryTreeNode(1);
		root.left.left = new BinaryTreeNode(1);
		root.left.right = new BinaryTreeNode(1);
		root.right.right = new BinaryTreeNode(1);
		root.right.left = new BinaryTreeNode(0);
	}
	//https://www.ideserve.co.in/learn/mirror-a-tree
	public void mirror_tree(BinaryTreeNode btNode)
	{
		if (btNode == null) return;
		mirror_tree(btNode.left);
		mirror_tree(btNode.right);
		
		//we have looked into both left and right child of the current root
		//left swap now
		
		BinaryTreeNode temp = btNode.left;
		btNode.left = btNode.right;
		btNode.right = temp;
	}
	private void build_mirror_tree() {
		
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.right.left = new BinaryTreeNode(4);
		root.right.right = new BinaryTreeNode(5);
		System.out.println( "mirror_tree");
		mirror_tree(root);
		levelOrderTraversal(root);
	}
	//tested right
	private BinaryTreeNode array_to_bst(int[] sortedArray , int startIdx , int endIdx) {
		
		if (startIdx > endIdx) return null;
		int mid = startIdx + (endIdx-startIdx)/2;
		BinaryTreeNode root =  new BinaryTreeNode(sortedArray[mid]);
		root.left = array_to_bst(sortedArray,startIdx,mid-1);
		root.right = array_to_bst(sortedArray,mid+1,endIdx);
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmazonBinaryTreeQuestions obj = new AmazonBinaryTreeQuestions();
		BinaryTreeNode root = obj.createBinaryTree(new int[]{1,2,3,4,5,6,7,9,8});
		obj.levelOrderTraversal(root);
		boolean result = obj.isGivenBTIdenticalToEachOther(obj.createBinaryTree(new int[] { 1, 2, 3}),
				obj.createBinaryTree(new int[] { 1, 3, 2}));
		System.out.println( "isGivenBTIdenticalToEachOther --> " + result);
		boolean result1 = obj.isBTSubTreeOfAnother(
				obj.createBinaryTree(new int[] { 1, 2, 3, 4, 5, 6, 7 }),
				obj.createBinaryTree(new int[] { 6, 6, 7 }));
		System.out.println("isBTSubTreeOfAnother --> " + result1);
		obj.build_printLeftView();
		obj.build_isBinaryTreeABST();
		obj.build_bottom_view();
		obj.build_print_spirally_using_level_order_traversal();
		obj.build_isSymmetric();
		obj.build_maximum_height();
		obj.build_connect_nodes_same_level();
		obj.build_bt_to_dll();
		obj.build_lowestCommonAncestorRecursionBST();
		obj.build_diameter();
		obj.build_count_leaves();
		obj.build_serialize_deserialize();
		obj.build_max_path_sum();
		obj.build_find_largest_binary_number();
		obj.build_mirror_tree();
		obj.array_to_bst(new int[]{1,2,3,4,5,6,7},0,6);
		System.out.println("testing");
		BinaryTreeNode root2 = obj.createBinaryTree(new int[] {15,8,21,6,9,20});
		displayBtm(root2);
		
	}
	
	
	
	public static void displayBtm(BinaryTreeNode root) {
	    
	    if(root.left!=null)
	     {
	         helper( root.left);
	     }
	     if(root.right!=null)
	     {
	         helper( root.right);
	     }
	     System.out.println(root.value);
	}
	
	public static void helper(BinaryTreeNode node)
	 {
	     if(node.left==null && node.right==null)
	     {
	         System.out.println(node.value);
	         return;
	     }
	     if(node.left!=null)
	     {
	         helper( node.left);
	     }
	     if(node.right!=null)
	     {
	         helper( node.right);
	     }
	     
	 }
}
