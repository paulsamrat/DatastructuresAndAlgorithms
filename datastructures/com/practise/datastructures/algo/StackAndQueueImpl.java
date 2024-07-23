package com.practise.datastructures.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StackAndQueueImpl {
	
	private static Set<Stack> setOfStacks = new HashSet<StackAndQueueImpl.Stack>();
	
	class Stack{
		
		private int[] stack ;
		private int top = -1;
		Stack(int stackSize){
			this.stack = new int[stackSize];
		}
		
		public boolean  push(int element){
			if ( top == stack.length - 1 ) {
				System.out.println(" stack is full");
				return false;
			}else{
			stack[++top] = element;
			return true;
			}
		}
		public void pop(){
			System.out.println(" popped element " + stack[top--]);
		}
		public void peek(){
			System.out.println(" peek element" + stack[top]);
		}
		public void traverse(){
			System.out.println(" displaying stack elements");
			for(int i=0 ; i<stack.length ;i++){
				System.out.print(stack[i]);
			}
		}
		
		/**
		 * @return the stack
		 */
		public int[] getStack() {
			return stack;
		}

		/**
		 * @return the top
		 */
		public int getTop() {
			return top;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + Arrays.hashCode(stack);
			result = prime * result + top;
			return result;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof Stack))
				return false;
			Stack other = (Stack) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (!Arrays.equals(stack, other.stack))
				return false;
			if (top != other.top)
				return false;
			return true;
		}

		private StackAndQueueImpl getOuterType() {
			return StackAndQueueImpl.this;
		}

		
	}
	public static Stack createStack(){
		System.out.println("creating a stack with size 3");
		return new StackAndQueueImpl().new Stack(3);
	}
	
	public static void printStackElements(){
		System.out.println("printing stack elements");
		for ( Iterator<Stack> itr =  setOfStacks.iterator() ; itr.hasNext();){
			Stack stack = itr.next();
			if ( null != stack.getStack()){
				for (int element : stack.getStack()){
					
				}
			}
		}
	}
	public static void main(String args[]){
		StackAndQueueImpl.Stack stackObj  =  createStack(); // creating a stack with size 10
		for (int i=0 ; i<8 ; i++){
			if ( !stackObj.push(i) ){
				System.out.println(" Stack is full creating another stack to push remaining elements");
				StackAndQueueImpl.setOfStacks.add(stackObj);
				stackObj = createStack();
			}
		}
		
		//innerObj.pop();
	}
}
