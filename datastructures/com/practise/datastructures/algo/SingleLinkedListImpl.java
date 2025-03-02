package com.practise.datastructures.algo;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class ListNode{
	int data;
	ListNode next;
	ListNode(int nodeValue)
	{
		this.data = nodeValue;
	}
	ListNode(int nodeValue , ListNode next){
		this.data = nodeValue;
		this.next = next;
	}
	
}
public class SingleLinkedListImpl {
	
	static private ListNode startNodeAnotherList;
	
	static ListNode create(int[] singleLinkedListValues)
	{	
		ListNode startNode = null;
		for(int i=0;i<singleLinkedListValues.length;i++)
		{
			ListNode nodeToAttach = new ListNode(singleLinkedListValues[i]);
			if (null == startNode) startNode = nodeToAttach;
			else{
				ListNode currNode = startNode;
				while (null != currNode.next){
					   currNode = currNode.next;
			    }
				currNode.next = nodeToAttach;
			}
		}
		return startNode;
	}
	//creating another linked list to  solve algo's
	static ListNode createAnotherList(int[] singleLinkedListValues)
	{
		for(int i=0;i<singleLinkedListValues.length;i++)
		{
			ListNode nodeToAttach = new ListNode(singleLinkedListValues[i]);
			if (null == startNodeAnotherList) startNodeAnotherList = nodeToAttach;
			else{
				ListNode currNode = startNodeAnotherList;
				while (null != currNode.next){
					   currNode = currNode.next;
			    }
				currNode.next = nodeToAttach;
			}
		}
		return startNodeAnotherList;
	}
	static void traverse(ListNode startNode)
	{
		ListNode currNode = startNode;
		System.out.println("\nNode Values");
		while (null!= currNode)
		{
			System.out.print(currNode.data + " ---> ");
			currNode = currNode.next;
		}
	}
	//https://www.educative.io/collection/page/5642554087309312/5679846214598656/70003
	static void reverse(ListNode startNode)
	{
		ListNode headPointer = startNode;
		ListNode reverseList = null;
		
		System.out.println("\n\nReversing the linked list");
		while( headPointer != null)
		{
			ListNode tempPointer = headPointer.next;
			headPointer.next = reverseList;
			reverseList =  headPointer;
			headPointer = tempPointer;
		}
		
		headPointer = reverseList;
		
		System.out.println("Successfully Reversed the Linked List");
		traverse(headPointer);
	}
	

	
	private static void findUnionOfTwoLists(ListNode first, ListNode second) {
		// TODO Auto-generated method stub
		System.out.println(" Find Union of two lists  ");
		traverse(first);
		traverse(second);
		//traversing first list 
		ListNode unionLists =  null;
		while (first!= null){
			ListNode nodeToAttach =  new ListNode(first.data);
			if ( null == unionLists) unionLists = nodeToAttach;
			else{
				ListNode currNode = unionLists;
				while ( currNode.next != null ){
					  currNode = currNode.next;
				}
				currNode.next =  nodeToAttach;
			}
			first = first.next;
		}
		System.out.println("\nUnioned First List ");
		traverse(unionLists);
		
	}
	
	/*
	 * Given a Singly linked list with each node containing either 0, 1 or 2. 
	 * Write code to sort the list. Input : 1 -> 1 -> 2 -> 0 -> 2 -> 0 -> 1 -> 0 
	 * Output : 0 -> 0 -> 0 -> 1 -> 1 -> 1 -> 2 -> 2
	 * 
	 */
	public static void sortLinkedList(ListNode unsortedLinkedList){
		//insetion / selection / merge
	}
	
	/*
	 * Given a linked list and two integers M and N. Traverse the linked list such that you retain M nodes then delete next N nodes, continue the same until end of the linked list.

		Input:
		M = 2, N = 2
		Linked List: 1->2->3->4->5->6->7->8
		Output:
		Linked List: 1->2->5->6

	The main part of the problem is to maintain proper links between nodes, make sure that all corner cases are handled.
	 */
	
	public static void toggleSingleLinkedList(ListNode inputList){
		int retainNodes = 2;
		int deleteNodes = 2;
		int count = 0; 
		while(inputList != null){
			ListNode currNode = inputList;
			if (count < retainNodes);
		}
	}
	
	//Implement a stack using linked list.
	//operations pop : push : top :
	static void pop()
	{
		
	}
	static void push(ListNode rootNode)
	{
		
	}
	private static void pairWiseReverseData(ListNode first){
		//initialize pointers
		ListNode firstPointer = first;
		ListNode secondPointer = first.next;
		while ( null != firstPointer && null != secondPointer){
			//swap first and second pointer values
			int firstPointerValue = firstPointer.data;
			firstPointer.data = secondPointer.data;
			secondPointer.data = firstPointerValue;
			
			//increment first and second pointer values by two
			firstPointer = null != firstPointer.next ? firstPointer.next.next : null;
			secondPointer = null != secondPointer.next ? secondPointer.next.next : null;
		}
	}
	
	//delete all occurence of a given key in  the list
	private static void deleteAllOccurenceOfAGivenKey(ListNode first, int keyToDelete){
		if ( null != first){
			ListNode prevNode = first;
			ListNode currNode = first;
			while ( null != currNode){
				if (keyToDelete == currNode.data ){
						//delete the node from the linked list and point the previous node to its next node
					prevNode.next = currNode.next;
				}else{
					prevNode = currNode;
				}
				currNode = currNode.next;
			}
		}
	}
	
	//insert at Nth position
	private static ListNode InsertNth(ListNode head, int data, int position) {
		   // This is a "method-only" submission. 
		    // You only need to complete this method. 
		    int counter  = 1 ;
		    ListNode n = new ListNode(data);
		    n.data = data;
		    if ( 0 != position){
		    	ListNode currNode = head;
		    	ListNode previous = head;
		        while( null != currNode.next){
		               previous =  currNode;
		               currNode = currNode.next;
		            if ( position == ++counter){ break;}
		        }
		        previous.next = n;
		        n.next = currNode;
		        return head;
		    }else{
		        n.next = head;
		        return n;
		    }
		}
	
	//delete a node at a given position
	private static ListNode DeleteNth(ListNode head, int position) {
		  // Complete this method
		  if ( null == head) return null;
		  ListNode currNode = head;
		  ListNode previousNode = null;
		  int counter = 1;
		  if ( 0 != position){
			  while ( null != currNode.next){
				  previousNode = currNode;
				  currNode= currNode.next;
				  if ( position == ++counter) break;
			  }
			  previousNode.next = currNode.next;
			  return head;
		  }else{
			  return head = head.next;
		  }
		}
	//https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1
	private static void isLinkedListPalindromic(ListNode head)
	{
		System.out.println( " input list  : " ); 
		traverse(head);
		ListNode current = head;
		StringBuilder sb = new StringBuilder();
		while ( null != current)
		{
			sb.append(current.data);
			current = current.next;
		}
		int length = sb.toString().length();
		int middle = length / 2 ; 
		for (int i = 1 , j = length ; i <= middle ; i++ , j--)
		{
			if (sb.toString().charAt(i-1) != sb.toString().charAt(j-1))
			{
				System.out.println(" the given list is not palindromic ");
				break;
			}
		}
	}
	public static ListNode reverseRecursion(ListNode head){
		if ( null == head || null ==head.next)
				return head;
		ListNode newHead = reverseRecursion(head.next); // reverse all but first
		head.next.next = head; // make original second point at first
	    head.next = null; // make original first point at nothing

	    return newHead;
	}
	//get the node value from tail
	private static void GetNodeValueFromTail(ListNode head,int n) {
	     // This is a "method-only" submission. 
	     // You only need to complete this method. 
	     //slow pointer
	     ListNode slowPtr =  head;
	     //fast pointer
	     ListNode fastPtr = head;
	     for (int i=n;i>=0;i--){
	         fastPtr = head.next;
	         head = fastPtr;
	     }
	     while (fastPtr != null){
	         fastPtr = fastPtr.next;
	         slowPtr = slowPtr.next;
	     }
	     System.out.println(slowPtr.data);
	    

	}
	
	public static void removeDuplicate(ListNode head){
		Set<Integer> set = new HashSet<Integer>();
		ListNode currNode = head;
		ListNode prevPtr = null;
	      while( null != currNode){
	          if (!set.contains(currNode.data)){
	              set.add(currNode.data);
	              prevPtr = currNode;
	          }else{
	             prevPtr.next = currNode.next;
	          }
	          currNode = currNode.next;

	      }
	       traverse(head);
		
	}

	 static int count = 0; 
	 //print the middle of the given linked list 
	 private static void printMiddle(ListNode headNode)
	 {
		 //Naive approach
		 
		 //traverse the whole linked list and count the no. of nodes
		 //count/2 gives the middle of the list
		 
		 //Another
		 //taking two pointers pointing to head node 
		 // traversing the slower by one and faster by two .
		 //when the first pointer reaches the end node i.e  encounters NULL , the slower is at the middle position.
		 if ( null == headNode) return ;
		 ListNode fasterPointer = headNode;
		 ListNode slowerPointer = headNode;
	     
	     while ( fasterPointer != null && fasterPointer.next != null)
	     {
	    	 fasterPointer = fasterPointer.next.next;
	    	 slowerPointer = slowerPointer.next;
	     }
		 System.out.println("\nMiddle Element in the Single Linked List is " + slowerPointer.data);
	 }
	 //find the Nth Node from the end of the Linked List .
	 private static void findNthNodeFromEndOfList(ListNode headNode, int nodeToFind)
	 {	  
		 
		 //naive approach
		 //base condition
		 if ( null  == headNode) return;
		 /*else
		 {	 
			 int count = 0 ;
			 ListNode currNode = headNode;
			 //count  the length of the linked list.
			 while (currNode != null )
			 {
				 ++count;
				 currNode = currNode.next;
			 }
			 System.out.println("\nLength of the Linked List is "  +  count);
			 int nodeNumber =  count - nodeToFind + 1 ;
			 currNode =  headNode;
			 for (int i=1; i < nodeNumber ; i++)
			 {
				 currNode = currNode.next;
			 }
			 System.out.println("\nPrinting " + nodeToFind + " Node from the End Of linked list " + currNode.data);
		 }*/
		 
		 //recursive approach

		 headNode = headNode.next;
		 if ( headNode == null ) return;
		 findNthNodeFromEndOfList(headNode, 2);
		 if ( ++count == nodeToFind)
			 System.out.println("\nPrinting " + nodeToFind + " Node from the End Of linked list " + headNode.data);
		 
		 //using two pointers.
		 //take two pointers :  faster pointer i.e already advanced to the point the node number to find.
		 //i.e if node to find is 5 out of 10 nodes , faster pointer stays at position 5
		 //slower pointer starts at position 1.
		 //Iterate till the faster pointer reaches end ,, by that time the slower pointer is at the desired location.
		 
	 }
	 
	 //finding loop in the list and thereby removing it .
	 private static void removeLoop(ListNode head)
	 {
		 //taking two pointers : faster and slower. //floyd's cycle detection algorithm
		 ListNode faster = head.next.next;
		 ListNode slower = head.next;
		 
		 while ( null != slower && null != faster && null != faster.next)
		 {
			 if (slower == faster)
			 {
				 System.out.println( " Loop detected at Node " + slower.data );
				 break;
			 }
			 slower = slower.next; //increment by one
			 faster = faster.next.next; // increment by two.
			 
			 
		 }
		 //removing the loop.
		 ListNode headPointer = head;
		 ListNode previousPointer = null; // captures the previous visited value by the slower pointer.
		 while (headPointer != slower)
		 {	 
			 headPointer = headPointer.next;
			 previousPointer = slower;
			 slower = slower.next;
		 }
		 previousPointer.next =  null; // removes the loop over here.
		 /*
		  * 1) Detect Loop using Floyd�s Cycle detection algo and get the pointer to a loop node.
			2) Count the number of nodes in loop. Let the count be k.
			3) Fix one pointer to the head and another to kth node from head.
			4) Move both pointers at the same pace, they will meet at loop starting node.
			5) Get pointer to the last node of loop and make next of it as NULL.
		  */
	 }
	 //Reverse Alternative ‘k’ nodes in a Linked List. if 	K =2  reverse K nodes alternately
	 private static void reverseAlternateKNodes(ListNode head, int swapLevel){
		 if ( null != head && null != head.next){
			 ListNode start = head;
			 ListNode end = start.next;
			 //swap the values
			 int temp = start.data;
			 start.data = end.data;
			 end.data = temp;
			 
			 while (null!= start.next && swapLevel >=-1 ){
				 start = start.next;
				 --swapLevel;
			 }
			 reverseAlternateKNodes(start,2);
		 }
	 }
	 /*
	  * Add two numbers represented by linked lists
		Given two numbers represented by two linked lists, write a function that returns sum list. 
		The sum list is linked list representation of addition of two input numbers. 
		It is not allowed to modify the lists. Also, not allowed to use explicit extra space (Hint: Use Recursion).
	  */
	 //https://www.geeksforgeeks.org/sum-of-two-linked-lists/
	public static void addTwoNumbersRepresentedByLinkedLists()
	{
		
	}
	
	 
	/*
    * How Merge Sort works 
	Merge Sort works by breaking the linked list(or Array) into 2 equal parts say Left half and Right half.
	Again break 2 list that we got in Step 1 in two equal parts each.  
	Repeat above steps until only 1 element remains in Linked list (or Array) because list with only 1 element is always sorted. 
	So in each step we are breaking the list in Left half and Right half.  
	When complete list is divided and contains only Single element in Left and Right half each, Start comparing and sorting each Left and Right half, So that portion of Linked list will be sorted.
	Repeat Step 5 for all the remaining Left and Right half and complete linked list will be sorted.
	*/
	 private static ListNode mergeSort(ListNode root){
		 //divide phase
		 if ( root == null || root.next == null){
			 return null;
		 }
		 //Break the linked list into 2 list.
		 //Finding Middle node and then breaking the Linked list in 2 parts.
		 //Now 2 list are, 1st list from start to middle and 2nd list from middle+1 to last.

		 ListNode middle = getMiddle(root);
		 ListNode nextOfMiddle = middle.next;
		 middle.next = null;//splitting it into two parts
		//Again breaking the List until there is only 1 element in each list.
		 ListNode left = mergeSort(root);
		 ListNode right = mergeSort(nextOfMiddle);
		 
		  //Once complete list is divided and contains only single element, 
		  //Start merging left and right half by sorting them and passing Sorted list further. 
		  ListNode sortedList = mergeTwoListRecursive(left, right);	 
		  
		  //iterative approach
		  ListNode sortedListItr = mergeTwoListIterative(left,right);
		return sortedListItr;
		 
	 }
	 //Recursive Approach for Merging Two Sorted List
	 private static ListNode mergeTwoListRecursive(ListNode leftStart, ListNode rightStart){
	  if(leftStart==null)
	   return rightStart;
	   
	  if(rightStart==null)
	   return leftStart;
	 
	  ListNode temp=null;
	   
	  if(leftStart.data<rightStart.data){
	   temp=leftStart;
	   temp.next = mergeTwoListRecursive(leftStart.next, rightStart);
	  }else{
	   temp=rightStart;
	   temp.next = mergeTwoListRecursive(leftStart, rightStart.next);
	  }
	  return temp;
	 }
	 //Iterative Approach for Merging Two Sorted List
	 private static ListNode mergeTwoListIterative(ListNode leftStart, ListNode rightStart) {

		 ListNode merged=null;
		 ListNode temp=null;

		 //To keep track of last element, so that we don't need to iterate for adding the element at last of 
		 //list when either LeftStart or rightStart is NULL.
		 ListNode lastAddedNode = null;

		 while(leftStart!=null && rightStart!=null){

			 if(leftStart.data>rightStart.data){
				 temp = new ListNode(rightStart.data);
				 rightStart=rightStart.next;

			 }else{
				 temp = new ListNode(leftStart.data);
				 leftStart=leftStart.next;
			 }

			 if(merged==null){
				 merged=temp;
			 }else{
				 lastAddedNode.next = temp ;     
			 }
			 lastAddedNode=temp;
		 }

		 if(leftStart!=null){
			 lastAddedNode.next = leftStart;
		 }else{
			 lastAddedNode.next = rightStart;
		 }

		 return merged;
	 }
	 //iterative merging.
	 private static void mergeTwoSortedLinkedLists(ListNode head1 , ListNode head2){
		 
		 ListNode mergedList =  null;
		 ListNode lastNode = null;
		 while ( head1 != null && head2 !=  null ){
			 ListNode n; 
			 if ( null != head1 && head1.data < head2.data){
				  //create a new node and attach
				   n = new ListNode(head1.data);
				   head1 = head1.next;
			  }else {
				  n = new ListNode(head2.data);
				  head2 =  head2.next;
			  }
			  if (null == mergedList)
				  	mergedList = n;
			  else{
				  lastNode.next = n;
			  }
			  lastNode = n;
		 }
		 //check if any of the linked list is non empty and add all the contents of it to the tail of merged list
		 if(head1 != null){
			 lastNode.next = head1;
		 }else{
			 lastNode.next = head2;
		 }
		 traverse(mergedList);
	 }
	 private static ListNode getMiddle(ListNode startNode) {
		 if(startNode==null){
			 return startNode;
		 }

		 ListNode pointer1=startNode;
		 ListNode pointer2=startNode;

		 while(pointer2!=null && pointer2.next!=null && pointer2.next.next!=null){
			 pointer1 = pointer1.next;
			 pointer2 = pointer2.next.next;

		 }
		 return pointer1;
	 }
	 
	 //Merge two sorted linked lists (in-place) , don’t form third linked list.
	 public static void mergeTwoSortedLinkedListsInPlace(ListNode first , ListNode second){
		 ListNode prevFirst = first;
		 ListNode  mergedNode =  first;
		 while ( null != first &&  null != second){
			 //compare and store .. the first list will contain merged sorted array
			 if (first.data < second.data){
				 prevFirst = first;
				 first = first.next;

			 }
			 else{
				 //creating a temp node.
				 //= prevFirst.next;
			     ListNode tempNode  = prevFirst.next;
				 prevFirst.next = new ListNode(second.data);
				 prevFirst.next.next = tempNode;
				 first = prevFirst.next.next;
				 second = second.next; // incrementing head second by one.				 
			 }

		 }
		 ListNode currNode = mergedNode;
		 while(currNode.next != null )
			 currNode = currNode.next;
		 currNode.next = second;
		 System.out.println(" traversing merged single linked list node ");
		 traverse(mergedNode);
	 }
	 
	 
	 //Given a singly linked list of N nodes. The task is to find middle of the linked list. For example, if given linked list is 1->2->3->4->5 then output should be 3. 
	 //If there are even nodes, then there would be two middle nodes, we need to print second middle element. 
	 //For example, if given linked list is 1->2->3->4->5->6 then output should be 4.

	 public static void findMiddleElement(ListNode start)
	 {
		 
	 }
	 
	 
	 public static void rotateByKElements(ListNode head , int k)
	 {	
		 System.out.println("\noriginal linked list : to be rotated by   " + k + " positions");
		 traverse(head);
		 ListNode current = head;
		 while (null != current && k-1 != 0 )
		 {
			 current = current.next;
			 --k;
		 }
		 ListNode kthNode = current;
		 while (current.next != null)
		 {
			current =  current.next;
		 }
		 current.next =head;
		 head = kthNode.next;
		 kthNode.next = null;
		 System.out.println( "\n linked list after being rotated anti clockwise  : " );
		 traverse(head);
	 }
	 
	 public static void reverseLinkedListInGroups(ListNode head , int groupSize)
	 {
		 System.out.println("\noriginal linked list : to be reversed by group of size :" + groupSize);
		 traverse(head);
	 }
	 //https://www.geeksforgeeks.org/delete-a-node-from-linked-list-without-head-pointer/
	 public static void deleteWithoutHeadPointer(ListNode head , ListNode nonHead)
	 {
		traverse(head);
		final int nodoToDelete = nonHead.data;
		System.out.println( "\nnon Head pointer to delete " + nodoToDelete);
		nonHead.data = nonHead.next.data;
		if ( null != nonHead.next)
		nonHead.next = nonHead.next.next;
		
		System.out.println( "\nlist after deleting non head pointer " +nodoToDelete);
		traverse(head);
	 }
	 
	 //https://www.geeksforgeeks.org/sort-a-linked-list-of-0s-1s-or-2s/
	 public static void sortALinkedListContaining012(ListNode head)
	 {
		 System.out.println("\nList to sort containing 0's 1's and 2's");
		 traverse(head);
		 int countArray[] = new int[]{0,0,0};
		 ListNode current = head;
		 while( null != current)
		 {
			 ++countArray[current.data];
			 current = current.next;
		 }
		 current = head;
		 for ( int i = 0  ; i < countArray .length ; i++)
		 {	
			 int count = countArray[i];
			 while (count != 0 && null != current)
			 {
				 current.data = i;
				 current = current.next;
				 --count;
			 }
		 }
		 System.out.println("\nList after sorting containing 0's 1's and 2's");
		 traverse(head);
	 }
	 
	 //https://practice.geeksforgeeks.org/problems/implement-stack-using-linked-list/1
	 public static void stackUsingLinkedList()
	 {
		 
	 }
	 
	 public static void pushToStack(ListNode current , final int nodeValToPush)
	 {
		 
	 }
	 
	 public static void popFromStack(ListNode head)
	 {
		 
	 }
	/**
	 * @param args
	 */
	 //https://leetcode.com/problems/reorder-list/
	 public static void reorderList(ListNode head) {
		 final Stack<ListNode> stack = new Stack<ListNode>();
		 ListNode curr = head;
		 while(curr!= null) {
			 stack.push(curr);
			 curr = curr.next;
		 }
		 ListNode res = new ListNode(-1);
		 ListNode temp = res;
		 curr = head;
		 while(curr != null && !stack.isEmpty() && curr.data != stack.peek().data) {
			 res.next = new ListNode(curr.data);
			 res.next.next = new ListNode(stack.pop().data);
			 res = res.next.next;
			 curr = curr.next;
		 }
		 if (curr != null)
			 res.next =  new ListNode(curr.data);
		 head = temp.next;
		 traverse(head);
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode first = create(new int[]{1,2,3,4,5,6});
		/*traverse(startNode);
		//another list creation
		ListNode second  = createAnotherList(new int[]{11,22,3,4,5});
		traverse(startNodeAnotherList);
		//reverse(startNode);
		//findIntersection(first, second);
		//findUnionOfTwoLists(first,second);
		System.out.println("\nPair Wise Reverse Single List values");
		//pairWiseReverseData(first);
		//System.out.println("Traversing  the list after reversing the data");
		//traverse(first);
   		System.out.print(" delete all occurences of a given key");
   		deleteAllOccurenceOfAGivenKey(first, 2);
   		System.out.println(" deleted all occurences of key : " + 2);
   		traverse(first);
   		InsertNth(first, 10, 3);
   		DeleteNth(first, 0);*/
   		//reverseRecursion(create(new int[]{1,2,3}));
   		//GetNodeValueFromTail(create(new int[]{1,2,3}),2); 
   		//removeDuplicate(create(new int[]{1,2,3,1}));
		System.out.println(" Reverse alternate K Nodes in a Linked List");
		reverseAlternateKNodes(first,2);
   		traverse(first);
   		mergeTwoSortedLinkedLists(create(new int[]{1,3,5,8}),create(new int[]{2,7,9}));
   		mergeTwoSortedLinkedListsInPlace(create(new int[]{1,3,5,8}),create(new int[]{2,7,9,10}));
   		rotateByKElements(create(new int[]{10,20,30,40,50,60}),2);
   		isLinkedListPalindromic(create(new int[]{1,2,1,2,1}));
   		ListNode head = create(new int[]{1,2,3,4,5});
   		deleteWithoutHeadPointer(head,head.next);
   		sortALinkedListContaining012(create(new int[]{1,0,1,2,1,2,0,1}));
   		reorderList(create(new int[]{1,2,3,4}));
	}
	

}

