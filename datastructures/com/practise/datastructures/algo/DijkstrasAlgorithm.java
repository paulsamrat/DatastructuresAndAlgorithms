package com.practise.datastructures.algo;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class DijkstrasAlgorithm {
	 
	 class Edge{
		 private int srcVtx;
		 private int destVtx;
		 private int weight;
		 
		 public Edge(int srcVtx, int destVtx, int weight){
			 this.srcVtx = srcVtx;
			 this.destVtx = destVtx;
			 this.weight = weight;
		 }

		@Override
		public String toString() {
			return "Edge [srcVtx=" + srcVtx + ", destVtx=" + destVtx + ", weight=" + weight + "]";
		}
		 
		 
	 }
	 
	 //this subclass will be stored in priority queue for shortest path route
	 class Vertex{
		 private int edgeWeight;
		 private int parentVtx;
		 private int presentVtx;

		 public Vertex(int edgeWeight, int parentVtx , int presentVtx) {
			super();
			this.edgeWeight = edgeWeight;
			this.parentVtx = parentVtx;
			this.presentVtx = presentVtx;
		}

		@Override
		public String toString() {
			return "Vertex [edgeWeight=" + edgeWeight + ", presentVtx=" + presentVtx + ", parentVtx=" + parentVtx + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + presentVtx;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof Vertex))
				return false;
			Vertex other = (Vertex) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (presentVtx != other.presentVtx)
				return false;
			return true;
		}

		private DijkstrasAlgorithm getOuterType() {
			return DijkstrasAlgorithm.this;
		}

		
	 }
	/*
	 * http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
	 * Algorithm
	1) Create a set sptSet (shortest path tree set) that keeps track of vertices included in shortest path tree, 
	   i.e., whose minimum distance from source is calculated and finalized. 
	   Initially, this set is empty.
	2) Assign a distance value to all vertices in the input graph. Initialize all distance values as INFINITE. 
	   Assign distance value as 0 for the source vertex so that it is picked first.
	3) While sptSet doesn’t include all vertices
	….a) Pick a vertex u which is not there in sptSetand has minimum distance value.
	….b) Include u to sptSet.
	….c) Update distance value of all adjacent vertices of u. 
	To update the distance values, iterate through all adjacent vertices. For every adjacent vertex v, if sum of distance value of u (from source) 
	and weight of edge u-v, is less than the distance value of v, then update the distance value of v.
	 */
	private Set<Integer> sptVertices;
	private Queue<Vertex> distValPQueue; // priority queue
	private int totalNoOfVertices;
	private LinkedList<Edge> adjList[];
	public DijkstrasAlgorithm(int noOfVertices){
		
		sptVertices = new HashSet<Integer>();
		totalNoOfVertices = noOfVertices;
		distValPQueue = new PriorityQueue<Vertex>(totalNoOfVertices, new Comparator<Vertex>() {

			public int compare(Vertex vertex1, Vertex vertex2) {
				return vertex1.edgeWeight - vertex2.edgeWeight; // ascending sorting
			}
		});
		adjList = new LinkedList[totalNoOfVertices];
		for (int i = 0 ; i < totalNoOfVertices ; i++)
			 adjList[i] = new LinkedList<DijkstrasAlgorithm.Edge>();
	}
	
	void addEdge(int srcVtx, int destVtx , int weight){
		adjList[srcVtx].add(new Edge(srcVtx, destVtx , weight));
	}
	void initializeDistQueue(int srcVtx){
		//assign distance value for src vertex as zero
		distValPQueue.add(new Vertex(0,srcVtx,srcVtx));
	}
	
	//algo
	void evaluateShortestPath(int srcVtx , int destVtx){
		//add the src vertex to queue
		initializeDistQueue(srcVtx);
		int polledVtxNo = Integer.MAX_VALUE;
		while (!distValPQueue.isEmpty() || polledVtxNo != destVtx){ // loop until we have visited all vertices or we have reached the destination vertex
			Vertex currvertex  = distValPQueue.poll();
			polledVtxNo = currvertex.presentVtx; 
			//look for all adjacent vertices of the polled vertex and 
			//1.update their weights accordingly
			//2.add them to the priority queue
			for (Iterator<Edge> itr = adjList[polledVtxNo].iterator() ; itr.hasNext();){
				Edge edge = itr.next();
				//look whether destination vertex of this  current edge is already added to the queue or not 
				// if yes . compare the previous edge weight with this  edge weight and store / replace the lowest of two.
				// if not . blindly add the destination vertex of this edge.
				Vertex newVtx = new Vertex((currvertex.edgeWeight + edge.weight),edge.srcVtx,edge.destVtx);
				if (distValPQueue.contains(newVtx)){ // checks for only vertex no.
					for (Iterator<Vertex> itr1 = distValPQueue.iterator() ; itr.hasNext();)
					{	
						Vertex distValPQueueVtx = itr1.next();
						if (newVtx.presentVtx == distValPQueueVtx.presentVtx
								&& distValPQueueVtx.edgeWeight > newVtx.edgeWeight) {
							// replace
							distValPQueue.remove(distValPQueueVtx);
							distValPQueue.offer(newVtx);
						}
					}
				}else
				{
					distValPQueue.offer(newVtx);
				}
			}
		}
	}
	public static void main(String[] args) {
		
		DijkstrasAlgorithm algo = new DijkstrasAlgorithm(7);
		
		//forming the graph
		algo.addEdge(1, 2, 15);
		algo.addEdge(1, 3, 20);
		algo.addEdge(2, 5, 25);
		algo.addEdge(2, 4, 10);
		algo.addEdge(3, 4, 15);
		algo.addEdge(4, 5, 20);
		algo.addEdge(5, 7, 10);
		algo.addEdge(4, 7, 30);
		algo.addEdge(4, 6, 15);
		algo.addEdge(6, 7, 20);
		algo.addEdge(3, 6, 20);
		
		algo.evaluateShortestPath(1, 7);
		
	}

}
