package com.grind75.questions;

public class MergeTwoSortedLists {
	private class SingleLinkedListNode{
		private int val;
		private SingleLinkedListNode next;
		
		private SingleLinkedListNode(final int data) {
			this.val = data;
		}
	}
	
	private SingleLinkedListNode merge(SingleLinkedListNode list1 , SingleLinkedListNode list2) {
		
		SingleLinkedListNode head = new SingleLinkedListNode(-1);
		SingleLinkedListNode currNode = head;
        while(list1 != null && list2 != null){
              if (list1.val == list2.val){
                    currNode.next = new SingleLinkedListNode(list1.val);
                    currNode.next.next = new SingleLinkedListNode(list1.val);
                    currNode =  currNode.next.next;
                    list1 = list1.next;
                    list2 = list2.next;
              }else if (list1.val < list2.val){
                    currNode.next = new SingleLinkedListNode(list1.val);;
                    currNode = currNode.next;
                    list1 = list1.next;
              }else{
                    currNode.next = new SingleLinkedListNode(list2.val);;
                    currNode = currNode.next;
                    list2 = list2.next;
              }
              
        }

        while(list1 != null){
              currNode.next = new SingleLinkedListNode(list1.val);;
              currNode =  currNode.next;
              list1 = list1.next;  
        }

        while(list2 != null){
            currNode.next = new SingleLinkedListNode(list2.val);;
            currNode = currNode.next;
            list2 = list2.next;
        }
        return head.next;
	}
	
	
	private SingleLinkedListNode merge1(SingleLinkedListNode list1 , SingleLinkedListNode list2) {
			
			SingleLinkedListNode head = new SingleLinkedListNode(-1);
			SingleLinkedListNode currNode = head;
	        while(list1 != null && list2 != null){
	             if (list1.val < list2.val){
	                    currNode.next = list1;
	                    list1 = list1.next;
	              }else{
	                    currNode.next = list2;
	                    list2 = list2.next;
	              }
	             currNode = currNode.next;
	        }
	
	        while(list1 != null){
	              currNode.next = list1;
	              currNode =  currNode.next;
	              list1 = list1.next;  
	        }
	
	        while(list2 != null){
	            currNode.next = list2;
	            currNode = currNode.next;
	            list2 = list2.next;
	        }
	        return head.next;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLinkedListNode n1 = new MergeTwoSortedLists().new SingleLinkedListNode(1);
		n1.next = new MergeTwoSortedLists().new SingleLinkedListNode(2);
		n1.next.next = new MergeTwoSortedLists().new SingleLinkedListNode(3);
		SingleLinkedListNode n2 = new MergeTwoSortedLists().new SingleLinkedListNode(1);
		n2.next = new MergeTwoSortedLists().new SingleLinkedListNode(3);
		n2.next.next = new MergeTwoSortedLists().new SingleLinkedListNode(4);
		
		MergeTwoSortedLists obj = new MergeTwoSortedLists();
		obj.merge1(n1, n2);
	}

}
