package com.practise.datastructures.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class MinimumSpanningTree {
    
	//Lets design following algo
	
	//https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/tutorial/
	//1. Kruskals -- Follows path optimality theorem
	//2. Prims    -- Follows Cut optimality theorem
	
	//design an edge
	//http://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-spanning-tree-mst/
	private List<Edge> listOfEdges;
	private int arrayOfDisjointSets[];
	private List<Edge> minSpanningTreeEdges;
	private int totalCostOfMinSpanningTree;
	private PriorityQueue<Edge> edgesQueue;
	class Edge { 
		private int srcVtx;
		private int destVtx;
		private int weight;
		
		public Edge(int srcVtx, int destVtx , int weight){
			this.srcVtx = srcVtx;
			this.destVtx = destVtx;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [srcVtx=" + srcVtx + ", destVtx=" + destVtx + ", weight=" + weight + "]";
		}
		
		
	}
	class EdgeWeightComparator implements Comparator<Edge>{

		public int compare(Edge edge1, Edge edge2) {
			// TODO Auto-generated method stub
			return edge1.weight - edge2.weight;
		}
		
	}
	public MinimumSpanningTree(){
		listOfEdges = new ArrayList<MinimumSpanningTree.Edge>();
		totalCostOfMinSpanningTree = 0 ;
		//setting the priority queue based on edge weights in ascending order
		edgesQueue = new PriorityQueue<MinimumSpanningTree.Edge>(10 , new Comparator<Edge>() {

			public int compare(Edge edge1, Edge edge2) {
				return edge1.weight - edge2.weight;
			}
			
		});
	}
    //getting the graph in place	
	public void addEdge(int srcVtx , int destVtx , int weight){
		 Edge edge = new Edge(srcVtx,destVtx,weight);
	     listOfEdges.add(edge);
	     edgesQueue.add(edge);
	}
	
	//initialize the array of disjoint sets
	public void initializeOfDisjointSets(int noOfVertices){
		arrayOfDisjointSets = new int[noOfVertices];
		for (int i = 0 ; i< noOfVertices ; i++)
			  arrayOfDisjointSets[i] = i ; // every vertex is the parent of itself
		// we will point out to vertex by array indexes.
	}
	
	//parent util
	public int findParentIdx(int vertexIdx){
		 while (arrayOfDisjointSets[vertexIdx] != vertexIdx){
			 vertexIdx = arrayOfDisjointSets[vertexIdx] ;
		 }
		 return vertexIdx;
	}
	//implementing union find algo to detect cycle in the minimum spanning tree
	// parent (root) technique is being used
	public void doUnion(int srcVtxIdx , int destVtxIdx){
		arrayOfDisjointSets[findParentIdx(srcVtxIdx)] = 
				arrayOfDisjointSets[findParentIdx(destVtxIdx)];
	}
	
	//check if both vertices lies on the same component/subset i.e they should have the same parent value 
	public boolean doFind(int srcVtxIdx , int destVtxIdx){
		return findParentIdx(srcVtxIdx) == findParentIdx(destVtxIdx);
	}
	
	
	//sort the edges in ascending or descending order
	public void sorting(){
		//ascending
		Collections.sort(listOfEdges, new Comparator<Edge>() {

			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
			  
		});
	}
	
	public void formMSTUsingKruskalsAlgo(int noOfVertices) {
		// list of edges are already sorted in ascending order
		if (!listOfEdges.isEmpty() && listOfEdges.size() > 1) {

			minSpanningTreeEdges = new ArrayList<MinimumSpanningTree.Edge>();
			for (Edge edge : listOfEdges) {

				// check if adding the edge forms a cycle or not
				// both vertex forming the edge should not be in the same
				// component
				if (!doFind(edge.srcVtx, edge.destVtx)) {
					// add to spanning tree edge list
					minSpanningTreeEdges.add(edge);
					totalCostOfMinSpanningTree += edge.weight;
					// update the disjoint set structure
					// connect src vertex to dest vertex
					doUnion(edge.srcVtx, edge.destVtx);
				} else // attaching this edge would form a cycle hence ignore
				{
					// do nothing
				}
				// the moment (V-1) edges are added to MST , algo will terminate
				if (noOfVertices == (minSpanningTreeEdges.size() - 1))
					break;
			}
		}
	}
	
	//prims algo
	/*
	 * Prim’s Algorithm also use Greedy approach to find the minimum spanning tree. 
	 * In Prim’s Algorithm we grow the spanning tree from a starting position.
	 * Unlike an edge in Kruskal's, we add vertex to the growing spanning tree in Prim's.
	 */
	//using priority queue
	public void formMSTUsingPrimsAlgo(){
		//creating two disjoint sets  of vertices
		// set1 will have the current vertices of the minimum spanning tree
		//set2 will have all other vertices not contained in set1
		Set<Integer> s1  = new HashSet<Integer>();
		Set<Integer> s2  = new HashSet<Integer>();
		//taking the least weight edge from queue and adding to s1
		Edge edge = edgesQueue.poll();
		s1.add(edge.srcVtx); 
		s1.add(edge.destVtx);
		minSpanningTreeEdges.clear();
		minSpanningTreeEdges.add(edge);
		//adding all other to s2
		for ( Edge tmpEdge : listOfEdges)
		{
			if ((!s1.contains(tmpEdge.srcVtx) && !s1.contains(tmpEdge.destVtx)))
			{
				if ( !s2.contains(tmpEdge.srcVtx) ) s2.add(tmpEdge.srcVtx);
				if ( !s2.contains(tmpEdge.destVtx) ) s2.add(tmpEdge.destVtx);
			}
			  
		}
		//algo starts
		while ( !s2.isEmpty()){ // or s1.size is equal to no of vertices
			for ( Edge tmpEdge : edgesQueue){
				//check if there is any possible combination of the least(weight) edge in between s1 and s2
				if ( ( s1.contains(tmpEdge.srcVtx) || s1.contains(tmpEdge.destVtx) ) &&
						( s2.contains(tmpEdge.srcVtx) || s2.contains(tmpEdge.destVtx)) ){ // as undirected
					//adding this edge to the mst 
					minSpanningTreeEdges.add(tmpEdge);
					//remove this edge from priority queue
					edgesQueue.remove(tmpEdge);
					//check and remove the desired vertex from s2
					s2.add(tmpEdge.srcVtx); //as its an undirected graph
					s2.add(tmpEdge.destVtx);
					//check and add the desired vertex from s2
					s1.add(tmpEdge.srcVtx); //as its an undirected graph
					s1.add(tmpEdge.destVtx);
					break; // dont go further . // we need again start from beginning as a new vertex is being added tp s1
			    }
			}
		}		
	}
	public void printTheMinSpanningTree(List<MinimumSpanningTree.Edge> minSpanningTreeEdges , String algoName){
		System.out.println("Printing minimum spanning tree formed by " + algoName +"\n");
		for (MinimumSpanningTree.Edge edge : minSpanningTreeEdges){
			 System.out.println(edge);
		}
		System.out.println("\nTotal Weight of Minimum Spanning Tree is " + totalCostOfMinSpanningTree);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumSpanningTree mst = new MinimumSpanningTree();
		//design as per 
		//https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/tutorial/
		mst.addEdge(0, 1, 4);
		mst.addEdge(1, 2, 8);
		mst.addEdge(2, 3, 7);
		mst.addEdge(3, 4, 9);
		mst.addEdge(4, 5, 10);
		mst.addEdge(6, 5, 2);
		mst.addEdge(7, 6, 1);
		mst.addEdge(0, 7, 8);
		mst.addEdge(1, 7, 11);
		mst.addEdge(7, 8, 7);
		mst.addEdge(8, 6, 6);
		mst.addEdge(2, 8, 2);
		mst.addEdge(2, 5, 4);
		mst.addEdge(3, 5, 14);
      
		//lets sort the edges in increasing order
		mst.sorting();
		//initialize
		mst.initializeOfDisjointSets(9);
		mst.formMSTUsingKruskalsAlgo(9);
		
		//print
		mst.printTheMinSpanningTree(mst.minSpanningTreeEdges, "KrusKals Algorithm!");
		
		mst.formMSTUsingPrimsAlgo();
		mst.printTheMinSpanningTree(mst.minSpanningTreeEdges, "Prim's Algorithm!" );
	}

}
