package com.practise.datastructures.algo.amazon;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AmazonGraphQuestions {
	
	List<Integer> adj[] ;
	private void initialize(final int noOfVertices)
	{
		adj = new LinkedList[noOfVertices];
		for (int i = 0 ; i <noOfVertices ; i++)
			adj[i] = new LinkedList<Integer>();
	}
	private void addEdge(final int startVtx , final int endVtx)
	{
		adj[startVtx].add(endVtx);
	}
	private void build_cycle_in_undirected_graph(final int noOfVertices , final int[] graphData)
	{	
		initialize(noOfVertices);
		for (int i = 0 ; i < graphData.length - 1 ;)
		{
			addEdge(graphData[i], graphData[i+1]);
			addEdge(graphData[i+1], graphData[i]); // add reverse edge 
			i+=2;
		}
		cycle_in_undirected_graph(adj);
	}
	//https://algorithms.tutorialhorizon.com/graph-detect-cycle-in-undirected-graph-using-dfs/
	private void cycle_in_undirected_graph(List<Integer>[] adj)
	{	
		System.out.println( "  -- cycle_in_undirected_graph recursive-- ");
		boolean[] vertices = new boolean[adj.length];
		boolean isCyclePresent = Boolean.FALSE;
		for(int i = 0 ; i < adj.length ; i++)
		{
			//Integer currVtx = adj[i];
			if (!vertices[i]) // if curr vertex is not previously visited . lets check whether a cycle exists from this vertex
				 if (isCyclePresentRecursive(i, -1 , vertices) )
				 {
					isCyclePresent = Boolean.TRUE;
					 break;
				 }
		}
		System.out.println( isCyclePresent ? " Cycle Present "  : " Cycle Not Present");
	}
	
	
	private boolean isCyclePresentRecursive(final int startVtx , final int parentVtx , boolean[] vertices)
	{	
		// lets first mark the start vtx as visited
		vertices[startVtx] = Boolean.TRUE;
		
		for (Iterator<Integer> itr = adj[startVtx].listIterator() ;  itr.hasNext();)
		{
			Integer vertex = itr.next();
            //check the adjacent vertex from current vertex
            if(vertex!=parentVtx) {
                //if destination vertex is not its direct parent then
                if(vertices[vertex]){
                    //if here means this destination vertex is already visited
                    //means cycle has been detected
                    return Boolean.TRUE;
                }
                else{
                    //recursion from destination node
                    if (isCyclePresentRecursive(vertex, startVtx, vertices)) {
                        return Boolean.TRUE;
                    }
                }
            }
			
		}
		return Boolean.FALSE;
	}
	//https://www.youtube.com/watch?v=CGMNePwovA0
	//2d matrix represents a graph 
	//cell value 1 = can be entered 
	//cell value = 0 = can't be entered
	private class VertexCoordinates
	{
		private int xCoordinate;
		private int yCoordinate;
		private int pathDist;
		private VertexCoordinates(final int i , final int j , final int pathDist)
		{
			this.xCoordinate = i;
			this.yCoordinate = j;
			this.pathDist = pathDist;
		}
		
		private VertexCoordinates(final int i , final int j)
		{
			this.xCoordinate = i;
			this.yCoordinate = j;
		}
		/**
		 * @return the xCoordinate
		 */
		public int getxCoordinate() {
			return xCoordinate;
		}
		/**
		 * @return the yCoordinate
		 */
		public int getyCoordinate() {
			return yCoordinate;
		}

		/**
		 * @return the pathDist
		 */
		public int getPathDist() {
			return pathDist;
		}
		
	}
	public void find_connected_components_dfs(final int[][] matrix)
	{
		//creating a similar matrix to track the visited vertices
		boolean [][] visitedVertices = new boolean[matrix.length][matrix[0].length];
		
		//start from each vertex and look for all connected component that can be reachable from the current vertex
		Stack<VertexCoordinates> stack = new Stack<VertexCoordinates>();
		int noOfConnectedComponents = 0 ; 
		System.out.println( " -- find_connected_components_dfs -- " );
		for (int i = 0 ; i < matrix.length ; i++)
		{
			for (int j = 0 ; j < matrix[0].length ; j++)
			{
				if (matrix[i][j] == 1 && !visitedVertices[i][j])
				{
					stack.push(new VertexCoordinates(i, j));
					//visitedVertices[i][j] = Boolean.TRUE;
					
					while (!stack.isEmpty())
					{
						//look for all connected vertices which can be reached from the present vertex
						//there can be 8 possible directions
						VertexCoordinates vertex  = stack.pop();
						final int xCoordinate = vertex.getxCoordinate();
						final int yCoordinate = vertex.getyCoordinate();
						if (!visitedVertices[xCoordinate][yCoordinate])
						{
							if (xCoordinate < matrix.length-1 && isNotVisitedAndConnected(xCoordinate+1,yCoordinate,visitedVertices,matrix))
							{
									stack.push(new VertexCoordinates(xCoordinate+1, yCoordinate));
									//visitedVertices[xCoordinate+1][yCoordinate] = Boolean.TRUE;
							}
							if (xCoordinate != 0 && isNotVisitedAndConnected(xCoordinate-1,yCoordinate,visitedVertices,matrix))
							{
									stack.push(new VertexCoordinates(xCoordinate-1, yCoordinate));
									//visitedVertices[xCoordinate-1][yCoordinate] = Boolean.TRUE;
							}
							if (yCoordinate != 0 && isNotVisitedAndConnected(xCoordinate,yCoordinate-1,visitedVertices,matrix) )
							{
									stack.push(new VertexCoordinates(xCoordinate, yCoordinate-1));
									//visitedVertices[xCoordinate][yCoordinate-1] = Boolean.TRUE;
							}
							if (yCoordinate < matrix[0].length - 1 && isNotVisitedAndConnected(xCoordinate,yCoordinate+1,visitedVertices,matrix) )
							{
									stack.push(new VertexCoordinates(xCoordinate, yCoordinate+1));
									//visitedVertices[xCoordinate][yCoordinate+1] = Boolean.TRUE;
							}
							if (xCoordinate != 0  && yCoordinate!= 0  && isNotVisitedAndConnected(xCoordinate-1,yCoordinate-1,visitedVertices,matrix) )
							{
									stack.push(new VertexCoordinates(xCoordinate-1, yCoordinate-1));
									//visitedVertices[xCoordinate-1][yCoordinate-1] = Boolean.TRUE;
							}
							if (xCoordinate != 0 && yCoordinate < matrix[0].length - 1 && isNotVisitedAndConnected(xCoordinate-1,yCoordinate+1,visitedVertices,matrix))
							{
									stack.push(new VertexCoordinates(xCoordinate-1, yCoordinate+1));
									//visitedVertices[xCoordinate-1][yCoordinate+1] = Boolean.TRUE;
							}
							if ( xCoordinate < matrix.length - 1 &&  yCoordinate != 0 && isNotVisitedAndConnected(xCoordinate+1,yCoordinate-1,visitedVertices,matrix) )
							{
									stack.push(new VertexCoordinates(xCoordinate+1, yCoordinate-1));
									//visitedVertices[xCoordinate+1][yCoordinate-1] = Boolean.TRUE;
							}
							if (xCoordinate < matrix.length -1 && yCoordinate <  matrix[0].length -1 && isNotVisitedAndConnected(xCoordinate+1,yCoordinate+1,visitedVertices,matrix))
							{
									stack.push(new VertexCoordinates(xCoordinate+1, yCoordinate+1));
									//visitedVertices[xCoordinate+1][yCoordinate+1] = Boolean.TRUE;
							}
							visitedVertices[xCoordinate][yCoordinate] = Boolean.TRUE;
						}
						
					}
					//stack is empty 
					// we have found all connected component starting from the initial vertex
					++noOfConnectedComponents;
				}
			}
		}
		
		System.out.println(noOfConnectedComponents);
	}
	private boolean isNotVisitedAndConnected(final int xCoordinate , final int yCoordinate , boolean[][] visitedVertices , int[][] matrix)
	{
		return !visitedVertices[xCoordinate][yCoordinate] && (matrix[xCoordinate][yCoordinate] == 1) ;
	}
	//https://www.techiedelight.com/find-shortest-path-source-destination-matrix-satisfies-given-constraints/
	// a user can move in all directions expect diagonal
	// 1 means that user can go that cell in 1 step
	// 0 means that cell can't be reached from the current cell
	// min steps required to traverse from 0,0 to destination
	
	//Given a MxN matrix where each element can either be 0 or 1. 
	//We need to find the shortest path between a given source cell to a destination cell. 
	//The path can only be created out of a cell if its value is 1.

	//using bfs
	// starting from 0,0
	public void shortest_src_to_destination_path(final int[][] matrix , final int destX , final int destY)
	{
		//tried with dp .
		boolean[][] visitedVertices = new boolean[matrix.length][matrix[0].length];
		int[] xAxis = {0,0,-1,1};
		int[] yAxis = {1,-1,0,0};
		
		if (matrix[0][0] == 0) return; // can't start from current cell.
		Queue<VertexCoordinates> queue =  new ArrayDeque<VertexCoordinates>();
		queue.offer(new VertexCoordinates(0, 0, 0));
		visitedVertices[0][0]=Boolean.TRUE;
		//do bfs
		
		while (!queue.isEmpty())
		{
			VertexCoordinates vtxCoordinates = queue.poll();
			final int xCoorDinate = vtxCoordinates.getxCoordinate();
			final int yCoorDinate = vtxCoordinates.getyCoordinate();
			
			if (xCoorDinate == destX  && yCoorDinate == destY) 
			{
				System.out.println(" -- shortest_src_to_destination_path --  " + vtxCoordinates.getPathDist() );
				break;
			}
			//check for connect vertices from the current vertex
			for (int i = 0 ; i < 4 ; i++)
			{
				if ( isValidMove(xCoorDinate+xAxis[i], yCoorDinate+yAxis[i], matrix.length, matrix[0].length) 
						&& !visitedVertices[xCoorDinate+xAxis[i]][yCoorDinate+yAxis[i]] 
						&& matrix[xCoorDinate+xAxis[i]][yCoorDinate+yAxis[i]] == 1)
				{
					queue.offer(new VertexCoordinates(xCoorDinate+xAxis[i], yCoorDinate+yAxis[i] , vtxCoordinates.getPathDist()+1));
					visitedVertices[xCoorDinate+xAxis[i]][yCoorDinate+yAxis[i]]=Boolean.TRUE;
				}
			}
		}
		
		
	}
	
	private boolean isValidMove(final int xCoordinate , final int yCoordinate , final int rowLength , final int colLength)
	{
		return xCoordinate >= 0 && yCoordinate >= 0 && xCoordinate <= rowLength && yCoordinate <= colLength;
	}
	/*
	 * Given a N X N matrix (M) filled with 1, 0, 2, 3. The task is to find whether there is a path possible from source to destination, while traversing through blank cells only. You can traverse up, down, right and left.

		A value of cell 1 means Source.
		A value of cell 2 means Destination.
		A value of cell 3 means Blank cell.
		A value of cell 0 means Blank Wall.
		Note: there is only single source and single destination.
	 */
	public void find_whether_path_exist(final int[][] matrix , final int srcVtx , final int destVtx)
	{
		// capture source indices first
		int srcX = Integer.MIN_VALUE;
		int srcY = Integer.MIN_VALUE;
		for (int i = 0 ; i < matrix.length ; i++)
		{
			for (int j  = 0 ; j < matrix[0].length ; j++)
			{
				if (matrix[i][j] == 1) {
					srcX = i;
					srcY = j;
					break;
				}
			}
		}
		
		// starting from the source now 
		// doing dfs to look for destination
		boolean isPathExist = Boolean.FALSE;
		//use dfs from src to destination
	}
	//public void find_connected_components_dfs_util(final int i , final int j , boolean[][] vertices)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmazonGraphQuestions obj = new AmazonGraphQuestions();
		obj.build_cycle_in_undirected_graph(6,new int[]{0,1,1,2,2,3,3,4,4,5});
		obj.find_connected_components_dfs(new int[][]{{1,0,1,0,1},{1,1,0,0,0},{0,1,0,1,1}});
		obj.shortest_src_to_destination_path(new int[][]{{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
            {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
            {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }},3,4);
	}

}
