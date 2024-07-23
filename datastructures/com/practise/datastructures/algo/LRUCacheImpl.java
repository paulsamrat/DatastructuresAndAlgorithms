package com.practise.datastructures.algo;

import java.util.HashMap;
import java.util.Map;

class DoubleLinkedListNode{
	private int pageNumber;
	private DoubleLinkedListNode next;
	private DoubleLinkedListNode prev;
	
	public  DoubleLinkedListNode (int pageNumber){
		this.pageNumber = pageNumber;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public DoubleLinkedListNode getNext() {
		return next;
	}

	public void setNext(DoubleLinkedListNode next) {
		this.next = next;
	}

	public DoubleLinkedListNode getPrev() {
		return prev;
	}

	public void setPrev(DoubleLinkedListNode prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubleLinkedListNode [pageNumber=").append(pageNumber).append("]");
		return builder.toString();
	}
	
}
//LRU Cache implemented with double linked list
class DoubleLinkedList{
	private final int size;
	private int currSize;
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode tail;
	
	public DoubleLinkedList(int size) {
		this.size = size;
		currSize = 0 ;
	}
	public void printList(){
		if ( null == head)
				return ;
		DoubleLinkedListNode tmp = head;
		while (null != tmp){
			System.out.println(tmp);
			tmp.getNext();
		}
	}
    public DoubleLinkedListNode addPageToList(int pageNumber) {
    	DoubleLinkedListNode node = new DoubleLinkedListNode(pageNumber);
    	if ( null == head){
    		head = node;
    		tail = node;
    		++currSize;
    		return node;
    	//if there is space
    	}else if ( currSize < size)
    		++currSize;
    	else{
    		tail = tail.getPrev();
    		tail.setNext(null);
    	}
    	//assigning this node to head
    	node.setNext(head);
    	head.setPrev(node);
    	head = node;
    	return head;
    }
    public void movePageToHead(DoubleLinkedListNode pageNode) {
    	if ( null == pageNode || head == pageNode) return;

    	if ( pageNode == tail){
    		tail = tail.getPrev();
    		tail.setNext(null);
    	}
    	DoubleLinkedListNode prev = pageNode.getPrev();
    	DoubleLinkedListNode next = pageNode.getNext();
    	prev.setNext(next);
    	if(next != null) 
    		next.setPrev(prev);

    	pageNode.setPrev(null);
    	pageNode.setNext(head);
    	head.setPrev(pageNode);
    	head = pageNode;   

    }
	public int getCurrSize() {
		return currSize;
	}
	public int getSize() {
		return size;
	}
	public DoubleLinkedListNode getHead() {
		return head;
	}
	public DoubleLinkedListNode getTail() {
		return tail;
	}

}
public class LRUCacheImpl {
	private DoubleLinkedList pageList;
	private Map<Integer,DoubleLinkedListNode> pageMap;
	private final int cacheSize;
	
	public LRUCacheImpl(int cacheSize) {
        this.cacheSize = cacheSize;
        pageList = new DoubleLinkedList(cacheSize);
        pageMap = new HashMap<Integer, DoubleLinkedListNode>();
	}
	
	public void accessPage(int pageNumber) {
		DoubleLinkedListNode pageNode;
		 if(pageMap.containsKey(pageNumber)) {
	            pageNode = pageMap.get(pageNumber);
	            pageList.movePageToHead(pageNode);

		 }else{
			 if(pageList.getCurrSize() == pageList.getSize()) {
	                pageMap.remove(pageList.getTail().getPageNumber());
			 }
			 pageNode = pageList.addPageToList(pageNumber);
			 pageMap.put(pageNumber, pageNode);
		 }
	}
	public void printCacheState() {
		pageList.printList();
		System.out.println();
	}
	public static void main(String[] args) {
		int cacheSize = 4;
		LRUCacheImpl cache = new LRUCacheImpl(cacheSize);
		cache.accessPage(4);
		cache.printCacheState();
		cache.accessPage(2);
		cache.printCacheState();
		cache.accessPage(1);
		cache.printCacheState();
		cache.accessPage(1);
		cache.printCacheState();
		cache.accessPage(4);
		cache.printCacheState();
		cache.accessPage(3);
		cache.printCacheState();
		cache.accessPage(7);
		cache.printCacheState();
		cache.accessPage(8);
		cache.printCacheState();
		cache.accessPage(3);
		cache.printCacheState();
	}
    
}
