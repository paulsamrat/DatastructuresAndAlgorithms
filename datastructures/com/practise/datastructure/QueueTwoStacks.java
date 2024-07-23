package com.practise.datastructure;

interface Stack {
    void push( Object x );
    Object pop( );
    Object top( );
    boolean isEmpty( );
    void makeEmpty( );
}

 class ArrayStack implements Stack {
    private Object [ ] theArray;
    private int topOfStack;
    private static final int DEFAULT_CAPACITY = 10;
    public ArrayStack( ) {
            theArray = new Object[ DEFAULT_CAPACITY ];
            topOfStack = -1;
    }
    public boolean isEmpty() {
            return topOfStack==-1;
    }
    public void makeEmpty() {
            topOfStack= -1;
    }
    public Object pop() {
            if(!isEmpty())
            	return theArray[topOfStack--];
            else
            	return null;
    }
    public void push(Object x) {

            if(!isFull())
            theArray[++topOfStack] = x;
    }
    public Object top() {
            return theArray[topOfStack];
    }
    public boolean isFull()
    {
            return (topOfStack == theArray.length);

    }
}
public class QueueTwoStacks {
	ArrayStack inStack = new ArrayStack();
    ArrayStack outStack = new ArrayStack();
	public void enqueue(Object value){
            inStack.push(value);
    }
    public Object dequeue(){
            if(outStack.isEmpty()){
                    while( ! inStack.isEmpty()){
                            outStack.push(inStack.pop());
                    }
            }
            return outStack.pop();
    }
    

    public static void main(String[] args){
    	QueueTwoStacks queue = new QueueTwoStacks();
            queue.enqueue(new String("first"));
            queue.enqueue(new String("second"));
            System.out.println("1. " + queue.dequeue());
            System.out.println("2. " + queue.dequeue()); 
            queue.enqueue(new String("third"));
            queue.enqueue(new String("fourth"));
            queue.enqueue(new String("fifth"));            
            System.out.println("3. " + queue.dequeue());
            System.out.println("4. " + queue.dequeue());
            System.out.println("5. " + queue.dequeue());
    }
}
