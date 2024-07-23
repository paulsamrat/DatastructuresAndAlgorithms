/**
 * 
 */
package com.practise.datastructures.algo.amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Samrat Paul
 *
 */
public class AmazonSingleLinkedListQuestions {
	
	private class LinkedListNode
	{
		private int nodeVal;
		private LinkedListNode next;
		
		private LinkedListNode(final int nodeValue)
		{
			this.nodeVal = nodeValue;
		}
	}

	//https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
	private class LinkedListNodeFlatten
	{
		private int value;
		private LinkedListNodeFlatten next;
		private LinkedListNodeFlatten bottom;
		
		private LinkedListNodeFlatten(final int value)
		{
			this.value = value;
		}
	}

	private LinkedListNode createSingleLinkedList(int[] array)
	{	
		LinkedListNode head = null;
		for (int element : array)
		{
			if ( null == head) head =  new LinkedListNode(element);
			else
			{	
				LinkedListNode currNode = head;
				while ( null != currNode.next)
				{
					currNode = currNode.next;
				}
				currNode.next = new LinkedListNode(element);
			}
		}
		return head;
	}
	
	private void traverse(LinkedListNode head)
	{
		List<Integer> linkedListValues = new ArrayList<Integer>();
		while (head != null)
		{
			linkedListValues.add(head.nodeVal);
			head = head.next;
		}
		
		System.out.println("single linked list -- > " + linkedListValues);
	}
	
	private void printNthNodeFromLast(LinkedListNode head , int NthNode)
	{	
		System.out.println("printNthNodeFromLast NthNode= " +  NthNode + "-- singleLinkedList -->") ;
		traverse(head);
		if (NthNode < 0 ) return ;
		LinkedListNode firstPtr =  head;
		while (NthNode != 0 && head != null)
		{	
			head = head.next;
			--NthNode;
		}
		LinkedListNode secPtr = head;
		//move both the pointer + 1 . when second reached end first will be at the desired poistion
		while (secPtr.next != null)
		{
			firstPtr = firstPtr.next;
			secPtr = secPtr.next;
		}
		
		System.out.println("printNthNodeFromLast --  NthNode Value " + firstPtr.nodeVal);
	}
	 //Given a linked list and inte­ger ‘k’, write an algo­rithm to reverse 
	 //the linked list in groups of size ‘k’.
	 private void reverseInGroupOfKNodes(LinkedListNode head, int k){
		 LinkedListNode listToReverse = null; 
		 LinkedListNode curr = head;
		 LinkedListNode result = null;
		 int counter = k ;
		 while( null != curr)
		 {
			 while (counter != 0)
			 {
				 if ( null == listToReverse)
					 listToReverse = curr;
				 else
					 listToReverse.next = curr;
				 curr = curr.next;
				 --counter;
			 }
			 counter = k;
			 listToReverse.next = null;
			 if (null == result) result = reverse(listToReverse);
			 else result.next = reverse(listToReverse);
		 }
		 System.out.println("reverseInGroupOfKNodes ---  ");
		 traverse(result);
	 }
	 
	 //https://www.geeksforgeeks.org/reverse-linked-list-groups-given-size-set-2/
	 private void reverseInGroupOfKNodes_Stack(LinkedListNode head, int k){
		 Stack<Integer> stack = new Stack<Integer>(); // max height the stack can gain is K
		 // so extra space is O(K)
		 LinkedListNode reverseList = null;
		 
		 
	 }
		//https://www.educative.io/collection/page/5642554087309312/5679846214598656/70003
		private LinkedListNode reverse(LinkedListNode headNode)
		{
			LinkedListNode curr = headNode;
			LinkedListNode reverseList = null;
			
			System.out.println("\n\nReversing the linked list");
			while( curr != null)
			{
				LinkedListNode tempPointer = curr.next;
				curr.next = reverseList;
				reverseList =  curr;
				curr = tempPointer;
			}
			
			curr = reverseList;
			
			System.out.println("Successfully Reversed the Linked List");
			traverse(curr);
			return reverseList;
		}
		public static LinkedListNode reverse_iterative(
				LinkedListNode head) {
			// no need to reverse if head is null 
			// or there is only 1 node.
			if (head == null || 
					head.next == null) {
				return head;
			}

			LinkedListNode list_to_do = head.next;
			LinkedListNode reversed_list = head;

			reversed_list.next = null;

			while (list_to_do != null) {
				LinkedListNode temp = list_to_do;
				list_to_do = list_to_do.next;

				temp.next = reversed_list;
				reversed_list = temp;
			}

			return reversed_list;
		}

	 //Implement Stack using Linked List
//	 private void implement_stack_using_linked_list(int[] operations)
//	 {
//		 LinkedListNode head = null;
//		 LinkedListNode curr = null;
//		 LinkedListNode prev = null;
//		 
//		 for (int i = 0 ; i < operations.length ; i++)
//		 {
//			 if (operations[i] == 1)
//				  
//		 }
//	 }
//	 
//	 private void push_to_stack(int element ,  LinkedListNode head LinkedListNode curr , LinkedListNode prev;)
//	 {
//		 
//	 }
//	 private void pop_from_stack()
//	 {
//		
//	 }
	
	 
	//https://www.geeksforgeeks.org/sort-a-linked-list-of-0s-1s-or-2s/
	private void sort_linked_list_0s_1s_2s(LinkedListNode head)
	{
		//solution 1
		// counting sort 
		// count no of 1s, 2s and 0s and place accordingly
		
		//solution 2
		//create 3 linked lists - dummy one which will be holding only 0  elements , one  holding 1  elements and one holding 2 elements
		//curr pointer - traverse through original list 
		// if curr val is 0 , attach to 0 dummy list , similarly for 1 and 2
		// at last attach 3 dummy lists into 1 and return 
		
	}
	
	//https://www.youtube.com/watch?v=j_UNYW6Ap0k
	public  LinkedListNode mergeTwoSortedLinkedListsInPlaceV2(LinkedListNode first , LinkedListNode second ){
		System.out.println( "\n--  merge two sorted linked lists in place  -- ");
		LinkedListNode sorting ;
		LinkedListNode head; // points to head of the sorted list
		if (null == first)   return second;
		if (null == second)  return first;
		if (first.nodeVal <= second.nodeVal)
		{
			sorting = first;
			first = first.next;
		}
		else
		{
			sorting = second;
			second = second.next;
		}

		head = sorting ; // we have found the starting point 

		while ( null != first && null != second)
		{
			if ( first.nodeVal <= second.nodeVal)
			{
				sorting.next = first;
				sorting = first;
				first = first.next;
			}
			else
			{
				sorting.next = second;
				sorting = second;
				second = second.next;
			}
		}

		// one of the lists is empty
		if ( null == first ) sorting.next = second;
		if ( null == second) sorting.next = first;

		return head;
	}
	
	//https://practice.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1
	private class LinkedListNode1{
		private int value;
		private int index;
		private LinkedListNode1 next;
		
		private LinkedListNode1(final int value , final int index)
		{
			this.value = value;
			this.index = index;
		}
	}
	private void merge_k_sorted_linked_lists_using_priority_queue(final int[] arr , final int k)
	{
		//create a queue of k length 
		Queue<LinkedListNode1> queue = new PriorityQueue<LinkedListNode1>(k,new Comparator<LinkedListNode1>(){

			@Override
			public int compare(LinkedListNode1 node1, LinkedListNode1 node2) {
				// TODO Auto-generated method stub
				return node1.value - node2.value;
			}
			
		});
		
		//put first element from all linked lists
		for (int i = 0 ; i < arr.length ; i++)
		{
			
		}
	}
	
	private LinkedListNode merge_k_sorted_linked_lists_in_place(List<LinkedListNode> lists , int start , int end)
	{
		if (start >= end ) return lists.get(start);
		int mid = (start + end ) / 2 ; 
		LinkedListNode node1 = merge_k_sorted_linked_lists_in_place(lists,start,mid);
		LinkedListNode node2  = merge_k_sorted_linked_lists_in_place(lists,mid+1,end);
		return mergeTwoSortedLinkedListsInPlaceV2(node1, node2);
	}
	
	private void build_merge_k_sorted_linked_lists_in_place()
	{
		LinkedListNode head = createSingleLinkedList(new int[] { 1,3,6,8,12});
		LinkedListNode head2 = createSingleLinkedList(new int[] { 13,15,20,21,22});
		LinkedListNode head3 = createSingleLinkedList(new int[] { -13,-12,-11,-10,-9});

		LinkedListNode head4 = createSingleLinkedList(new int[] { 25,26,27,29,32});
		LinkedListNode head5 = createSingleLinkedList(new int[] { 35,43,46,51,52});
		LinkedListNode head6 = createSingleLinkedList(new int[] { -35,-33,-32,-30,-29});
		List<LinkedListNode> lists = new ArrayList<AmazonSingleLinkedListQuestions.LinkedListNode>();
		lists.add(head);
		lists.add(head2);
		lists.add(head3);
		lists.add(head4);
		lists.add(head5);
		lists.add(head6);
		LinkedListNode result = merge_k_sorted_linked_lists_in_place(lists , 0 , lists.size()-1);
		traverse(result);
	}
	
	private class FlattenedList
	{
		private int data;
		private FlattenedList next;
		private FlattenedList bottom;
		
		private FlattenedList(final int data)
		{
			this.data = data;
		}
	}
	private void build_flattened_linked_lists()
	{
		FlattenedList list1 = new FlattenedList(1);
		list1.bottom = new FlattenedList(4);
		list1.bottom.bottom = new FlattenedList(6);
		list1.bottom.bottom.bottom = new FlattenedList(8);
		
		FlattenedList list2 = new FlattenedList(2);
		list2.bottom = new FlattenedList(3);
		list2.bottom.bottom = new FlattenedList(7);

		
		FlattenedList list3 = new FlattenedList(5);
		list3.bottom = new FlattenedList(9);
		
		FlattenedList list4 = new FlattenedList(10);
		list4.bottom = new FlattenedList(11);
		list4.bottom.bottom = new FlattenedList(12);
		
		//link
		list1.next = list2;
		list2.next = list3;
		list3.next = list4;
		
		FlattenedList head = list1;
		flattened_linked_lists(head);
		while (head != null)
		{
			System.out.print(head.data + " -- > ");
			head = head.bottom;
		}
	}
	private FlattenedList flattened_linked_lists(FlattenedList node) {
		// TODO Auto-generated method stub
		if ( null == node || node.next == null) return node;
		return mergeTwoSortedLinkedListsInPlaceV2(node, flattened_linked_lists(node.next));
	}

	public  FlattenedList mergeTwoSortedLinkedListsInPlaceV2(FlattenedList first , FlattenedList second ){
		System.out.println( "\n--  merge two FlattenedList sorted linked lists in place  -- ");
		FlattenedList sorting ;
		FlattenedList head; // points to head of the sorted list
		if (null == first)   return second;
		if (null == second)  return first;
		if (first.data <= second.data)
		{
			sorting = first;
			first = first.bottom;
		}
		else
		{
			sorting = second;
			second = second.bottom;
		}

		head = sorting ; // we have found the starting point 

		while ( null != first && null != second)
		{
			if ( first.data <= second.data)
			{
				sorting.bottom = first;
				sorting = first; 	
				first = first.bottom;
			}
			else
			{
				sorting.bottom = second;
				sorting = second;
				second = second.bottom;
			}
		}

		// one of the lists is empty
		if ( null == first ) sorting.bottom = second;
		if ( null == second) sorting.bottom = first;

		return head;
	}
	
	private void add_two_numbers_represented_by_linked_lists(LinkedListNode number1 , LinkedListNode number2)
	{	
		System.out.println( " -- add_two_numbers_represented_by_linked_lists -- " );
		// as we cant go from unit to tens - hunders place in a linked list - reverese direction
		// we will first rev
		//calculate the length of each lists
		int length1 = 0 , length2 = 0 ;
		LinkedListNode curr1 = number1;
		LinkedListNode curr2 = number2;
		while (curr1 != null){++length1;curr1=curr1.next;}
		while (curr2 != null){++length2;curr2=curr2.next;}
		LinkedListNode zeroTrails = null;
		//add zero's to the beginning of the shorter list - to make both lists of equal size
		if (length1 != length2)
		{	
			int diff = Math.abs(length2-length1);
			zeroTrails = new LinkedListNode(0);
			--diff;
			if ( diff > 0 )
			{
				LinkedListNode curr = zeroTrails;
				while (diff > 0){
					curr.next = new LinkedListNode(0);
					curr = curr.next;
					--diff;
				}
				//attach zero's list in front of the shorter list
				if (length1 < length2) { curr.next = number1; number1 = zeroTrails; }
				else  { curr.next = number2; number2 = zeroTrails;}
			}
			
		}
		
		//as we can't traverse from back - reverse both linked lists
		number1 = reverse(number1);
		number2 = reverse(number2);
		
		//start operation
		int additionVal = 0 ;
		int carryVal = 0 ;
		int remainderVal = 0;
		LinkedListNode summationList = null;
		LinkedListNode currSummationList = null;
		while (number1 != null && number2 != null)
		{
			additionVal = carryVal + (number1.nodeVal + number2.nodeVal);
			if ( additionVal / 10 != 0 ) //some remainder is there
			{
				remainderVal = additionVal % 10;
				carryVal = additionVal / 10 ;
			}
			else 
			{
				remainderVal = additionVal;
				carryVal = 0;
			}
			if (summationList == null) summationList =  new LinkedListNode(remainderVal);
			else
			{
				currSummationList = summationList;
				while ( null != currSummationList.next)
				{
					currSummationList = currSummationList.next;
				}
				currSummationList.next = new LinkedListNode(remainderVal);
			}
			number1 = number1.next;
			number2 = number2.next;
			
		}
		//if there exists a carry . then add it to last
		if (carryVal != 0)
		{
			currSummationList = summationList;
			while ( null != currSummationList.next)
			{
				currSummationList = currSummationList.next;
			}
			currSummationList.next = new LinkedListNode(carryVal);
		}
		reverse(summationList);
	}
	
	public void remove_kth_last_element(LinkedListNode head , final int kth)
	{
		
	}
	
	//Intersection of Linked Lists
	//You are given two singly linked lists. The lists intersect at some node. Find, and return the node. Note: the lists are non-cyclical.
	
	/*
	 * Write a function to get the intersection point of two Linked Lists.
	   There are two singly linked lists in a system. By some programming error the END NODE of
	   one of the linked list got linked into the second list, forming a inverted Y shaped list.
 	   Write a program to get the point where two linked list merge.
	 */
	static void findIntersection(LinkedListNode startNodeOne , LinkedListNode startNodeTwo)
	{	
		//ON2
		/*System.out.println("\n\nFind Intersection if exists");
		ListNode tempNodeTwo = startNodeTwo;
		outerloop:
		while (startNodeOne != null)
		{
			while ( tempNodeTwo != null)
			{
				if (startNodeOne.data == tempNodeTwo.data) 
				{
					System.out.println("Intersected at Data Node " + tempNodeTwo.data);
					break outerloop;
				}
				tempNodeTwo = tempNodeTwo.next;
			}
			tempNodeTwo = startNodeTwo;
			startNodeOne = startNodeOne.next;
		}*/
		
		//O(N+M)
		//keep an extra boolean field known as visited . mark all the nodes as visited once the first list is traversed. Then
		//while traversing the second list look for the visited flag in any of the nodes encountered .  first encountered is the intersection point.
		
		//Using hash store the data value of the first list and when traversed for the second look for matching data .
		//
		
		Map<Integer,Boolean> valuesMap = new HashMap<Integer, Boolean>();
		LinkedListNode currNode =  startNodeOne;
		while ( null != currNode){
			valuesMap.put(currNode.nodeVal, true);
			currNode = currNode.next;
		}
		currNode = startNodeTwo;
		Boolean result = null ;
		while( null != currNode){
			result = valuesMap.get(currNode.nodeVal);
			if(null != result) {
				System.out.println(" Intersection found at node value " + currNode.nodeVal);
				break;
			}
			currNode = currNode.next;
		}
		if( null == result)System.out.println(" No Intersection Points Found");
		
		//another : O(N+M) and O(1)
		//find length of first and second list 
		LinkedListNode firstLastNode = null;
		LinkedListNode secondLastNode = null;
		int firstNodeSize = 0,secNodeSize = 0 ;
		while(startNodeOne != null){
			++firstNodeSize;
			firstLastNode = startNodeOne;
			startNodeOne = startNodeOne.next;
		}
		while(startNodeTwo != null){
			++secNodeSize;
			secondLastNode = startNodeTwo;
			startNodeTwo = startNodeTwo.next;
		}
		if (firstLastNode.nodeVal != secondLastNode.nodeVal) System.out.println(" two lists are not intersected");
		//finding the larger list
		if (firstNodeSize  > secNodeSize){}
			 //once done.
		//push the pointers to the starting point of the smaller list . then increment both the pointers by one .and node they meet is the 
		//common point
		
		
//		Method 3(Using difference of node counts)
//		1) Get count of the nodes in the first list, let count be c1.
//		2) Get count of the nodes in the second list, let count be c2.
//		3) Get the difference of counts d = abs(c1 – c2)
//		4) Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have equal no of nodes.
//		5) Then we can traverse both the lists in parallel till we come across a common node. (Note that getting a common node is done by comparing the address of the nodes)
//	
	}
	
	//Given a linked list of integers, remove all consecutive nodes that sum up to 0.

//	Example:
//	Input: 10 -> 5 -> -3 -> -3 -> 1 -> 4 -> -4
//	Output: 10
	
	public static void rem_consecutive_nodes_that_sum_0(LinkedListNode head)
	{
		//make a hashmap 
		//and keep calculating  current sum  - whenever the sum is zero . take a note of index 
		// and keep deleting nodes 
		
	}
	
	public static LinkedListNode removeNodes(LinkedListNode listHead, int x) {
	    // Write your code here
		LinkedListNode curr = listHead;
		LinkedListNode result = null;
		LinkedListNode result1 = null;
	    while ( null != curr)
	    {   
	        if (curr.nodeVal <= x)
	        {
	            if ( result == null)
	            {
	            	result = curr;
	            	result1 = curr;
	            }
	            else
	            {
	            	result.next = new AmazonSingleLinkedListQuestions().new LinkedListNode(curr.nodeVal);
	            	result = result.next;
	            }
	        }
	        curr = curr.next;
	    }
	    return result1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AmazonSingleLinkedListQuestions obj = new AmazonSingleLinkedListQuestions();
		LinkedListNode head = obj.createSingleLinkedList(new int[] { 5,3,6,1,2});
		obj.traverse(head);
		obj.printNthNodeFromLast(head,1);
		head = obj.createSingleLinkedList(new int[] {1,2,3,4,5,6});
		//obj.reverseInGroupOfKNodes(head,2);
   		obj.mergeTwoSortedLinkedListsInPlaceV2(obj.createSingleLinkedList(new int[]{10,50,70,90,100}), obj.createSingleLinkedList(new int[]{20,30,40,60,80}));
		//form a flattened linked list
   		obj.build_merge_k_sorted_linked_lists_in_place();
   		obj.build_flattened_linked_lists();
   		obj.add_two_numbers_represented_by_linked_lists( obj.createSingleLinkedList(new int[] { 1,2,3,4,5}), obj.createSingleLinkedList(new int[] {9,0,9,6,3}));
   		obj.removeNodes(obj.createSingleLinkedList(new int[] {1,2,3,4,5}), 3);
	}

}
