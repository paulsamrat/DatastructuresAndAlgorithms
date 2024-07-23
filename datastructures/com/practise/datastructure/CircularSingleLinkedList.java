package com.practise.datastructure;

public class CircularSingleLinkedList {
	
	 private int data;
	   private CircularSingleLinkedList next;
	 
	 
	   public CircularSingleLinkedList()
	   {
	      data = 0;
	      next = this;
	   }
	 
	   public CircularSingleLinkedList(int value)
	   {
	      data = value;
	      next = this;
	   }
	 
	   public CircularSingleLinkedList InsertNext(int value)
	   {
		   CircularSingleLinkedList node = new CircularSingleLinkedList(value);
	      if (this.next == this) // only one node in the circular list
	      {
	         // Easy to handle, after the two lines of executions,
	         // there will be two nodes in the circular list
	         node.next = this;
	         this.next = node;
	      }
	      else
	      {
	         // Insert in the middle
	 
	    	  CircularSingleLinkedList temp = this.next;
	         node.next = temp;
	         this.next = node;
	      }
	      return node;
	 
	   }
	 
	   public int DeleteNext()
	   {
	      if (this.next == this)
	      {
	         System.out.println("\nThe node can not be deleted as there is only one node in the circular list");
	         return 0;
	      }
	 
	      CircularSingleLinkedList node = this.next;
	      this.next = this.next.next;
	      node = null;
	      return 1;
	   }
	 
	   public void Traverse()
	   {
	      Traverse(this);
	   }
	 
	   public void Traverse(CircularSingleLinkedList node)
	   {
	      if (node == null)
	         node = this;
	      System.out.println("\n\nTraversing in Forward Direction\n\n");
	      CircularSingleLinkedList startnode = node;
	 
	      do
	      {
	         System.out.println(node.data);
	         node = node.next;
	      }
	      while (node != startnode);
	   }
	 
	   public int GetNumberOfNodes()
	   {
	      return GetNumberOfNodes(this);
	   }
	 
	   public int GetNumberOfNodes(CircularSingleLinkedList node)
	   {
	      if (node == null)
	         node = this;
	 
	      int count = 0;
	      CircularSingleLinkedList startnode = node;
	      do
	      {
	         count++;
	         node = node.next;
	      }
	      while (node != startnode);
	 
	      System.out.println("\nCurrent Node Value: " + node.data);
	      System.out.println("\nTotal nodes in Circular List: " + count);
	 
	      return count;
	   }
	 
	   private static boolean isCircular(CircularSingleLinkedList head)
	   {
		   CircularSingleLinkedList slowerPointer = head;
		   CircularSingleLinkedList fasterPointer = head;
		   
		   while (fasterPointer != null && fasterPointer.next != null)
		   {
			   slowerPointer = slowerPointer.next;
			   fasterPointer = fasterPointer.next.next;
			   
			   if (slowerPointer == fasterPointer)
				   return true;
			   
		   }
		   return false;
	   }
	   public static void main(String[] args)
	   {
	 
		  CircularSingleLinkedList node1 = new CircularSingleLinkedList(1);
	      node1.DeleteNext(); // Delete will fail in this case.
	 
	      CircularSingleLinkedList node2 = node1.InsertNext(2);
	      node1.DeleteNext(); // It will delete the node2.
	 
	      node2 = node1.InsertNext(2); // Insert it again
	 
	      CircularSingleLinkedList node3 = node2.InsertNext(3);
	      CircularSingleLinkedList node4 = node3.InsertNext(4);
	      CircularSingleLinkedList node5 = node4.InsertNext(3);
	 
	      node1.GetNumberOfNodes();
	      node3.GetNumberOfNodes();
	      node5.GetNumberOfNodes();
	 
	      //node1.Traverse();
	      //node3.DeleteNext(); // delete the node "4"
	      //node2.Traverse();
	 
	      node1.GetNumberOfNodes();
	      node3.GetNumberOfNodes();
	      node5.GetNumberOfNodes();
	      System.out.println(isCircular(node1));
	   }
}
