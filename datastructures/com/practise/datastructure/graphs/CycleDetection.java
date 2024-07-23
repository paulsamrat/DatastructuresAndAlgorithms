package com.practise.datastructure.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class CycleDetection {
	//exception class to break recursion
	 class CycleFoundException extends Exception{
		 
		private static final long serialVersionUID = -4562328760668222403L;

		public CycleFoundException(){
			 super();
		 }
	 }
	//Detect cycle in a directed graph
	private int noOfVertices;
	private LinkedList<Integer> adj[];
	boolean visited[];
	
	public CycleDetection(int noOfVtx){
		noOfVertices =  noOfVtx;
		adj = new LinkedList[noOfVertices];
		//initialize
		for ( int i = 0 ; i < noOfVertices ; i++){
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	//add directed edge
	public void addEdge(int srcVtx , int destVtx){
		adj[srcVtx].add(destVtx);
	}
	
	//cycle detection : using DFS
	public boolean isGraphCyclic(){
		boolean cyclePresent = false ; 
		boolean visited[] = new boolean[noOfVertices];
		Stack<Integer> stack = new Stack<Integer>();
		//take each vertex one by one
		//let the vertex number begin from 0
		for (int i = 0 ; i < noOfVertices ; i++){
			try {
			   //isCyclePresentDFS(i , visited); 
				isCyclePresentStack(i, visited, stack);
			}catch(CycleFoundException cfe){
				cyclePresent =  true;
				break;
			}
		}
		
		return  cyclePresent;
	}
    
	//recursive
	public void isCyclePresentDFS(int srcVtx , boolean visited[]) throws CycleFoundException{

			visited[srcVtx] = true;
			for (Iterator<Integer> itr = adj[srcVtx].iterator() ;  itr.hasNext();){
				 int newSrcVtx = itr.next();
				 if ( !visited[newSrcVtx])
					    isCyclePresentDFS(newSrcVtx, visited);
				 else{
					 // there is a cycle 
					 throw new CycleFoundException();
				 }
			}
	}
	
	//stack
	public void isCyclePresentStack(int srcVtx , boolean[] visited , Stack<Integer> stack) throws CycleFoundException{
		stack.push(srcVtx);
		visited[srcVtx] = true;
		while (!stack.isEmpty()){
			int poppedVtx = stack.pop();
			for (Iterator<Integer> itr = adj[poppedVtx].iterator() ; itr.hasNext();){
				   int newVtx = itr.next();
				   if ( !visited[newVtx] ) stack.push(newVtx);
				   else throw new CycleFoundException();
				   
			}
				  
		}
		
	}
	
	//find cycle in graph through union find algorithm
	//Undirected Graph
	public void isCyclePresentDisjointSet(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        CycleDetection cd = new CycleDetection(4);
        
        //setting up graph
        cd.addEdge(0, 1);
        cd.addEdge(1, 2);
        cd.addEdge(2, 0);
        cd.addEdge(0, 2);
        cd.addEdge(2, 3);
        cd.addEdge(3, 3);
        //graph setup done
        
        System.out.println( " Check cycles in the created graph");
        System.out.println( " is the above graph cyclic " + cd.isGraphCyclic());
        
	}

}
