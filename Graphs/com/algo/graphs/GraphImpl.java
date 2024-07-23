package com.algo.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphImpl {
	private List<Integer> adjList [];
	
	
	private GraphImpl(final int noOfVertices) {
		adjList = new ArrayList[noOfVertices];
		for (int i = 0 ; i < noOfVertices ; i++)
			adjList[i] = new ArrayList<Integer>();
		
		
	}
	//populate graph
	private void addEdge(final int srcVtx , final int destVtx) {
		adjList[srcVtx].add(destVtx);
	}
	
	//detect cycle in graph - use DFS
	private boolean isCyclic(int srcVtx , boolean[] visited , boolean[] currentlyVisiting) {
		
		visited[srcVtx] = true;
		currentlyVisiting[srcVtx] = true;
		
		//get neighbors and visit them
		List<Integer>[] graph = this.adjList;
		for (Integer neighbour : graph[srcVtx]) {
				if (currentlyVisiting[neighbour])
					return true;
				if (!visited[neighbour])
					if (isCyclic(neighbour,visited ,currentlyVisiting))
						return true;
		}
		currentlyVisiting[srcVtx] = false;
		return false;
	}
	
	//topological sort
	
	private void isGraphCyclic(final GraphImpl cycleGraph) {
		List<Integer>[] vertices = cycleGraph.adjList;
		boolean[] visited = new boolean[vertices.length];
		boolean[] currentlyVisiting = new boolean[vertices.length];
		
		for (int i = 0 ; i < vertices.length ; i++) {
			
			if (!visited[i] && isCyclic(i, visited,currentlyVisiting)) {
				System.out.println("graph having cycles");
				return;
			}
		}
		System.out.println("graph doesn't have any cycles");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final GraphImpl graph = new GraphImpl(5);
		// Building the Graph same as example 1.
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(4, 1);
        graph.addEdge(4, 2);
        
        //graph having cycle
        
        final GraphImpl cyclegraph = new GraphImpl(5);
        cyclegraph.addEdge(0, 1);
        cyclegraph.addEdge(1, 2);
        cyclegraph.addEdge(2, 3);
        cyclegraph.addEdge(3, 4);
        cyclegraph.addEdge(1, 4);
        
        cyclegraph.isGraphCyclic(cyclegraph);
	}

}
