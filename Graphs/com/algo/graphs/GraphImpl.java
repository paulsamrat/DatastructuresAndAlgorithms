package com.algo.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
class GraphNode{
	
	private String nodeValue;
	private int distanceFromSource;
	
	public GraphNode(String nodeValue, int distanceFromSource){
		this.nodeValue = nodeValue;
		this.distanceFromSource = distanceFromSource;
	}

	public String getNodeValue() {
		return nodeValue;
	}

	public int getDistanceFromSource() {
		return distanceFromSource;
	}
}
public class GraphImpl {
	
	private int V; //no. of vertices
	public static LinkedList<Integer> adj[]; // array of linked list representations
	public static LinkedList<GraphNode> adjOfGraphNodes[];
	public GraphImpl(int v) {
		// TODO Auto-generated constructor stub
		this.V = v;
		this.adj  =  new LinkedList[v];
		this.adjOfGraphNodes = new LinkedList[v];
		for (int i = 0 ; i < v ;i++){
			//creating an array of adjacency lists
			adj[i] = new LinkedList<Integer>();	
			adjOfGraphNodes[i] = new LinkedList<GraphNode>();
		}
	}
	
	//adding the edge to the graph
	void addEdge(int v , int w){
		// add w to v's list
		adj[v].add(w);
	}
	// A function used by DFS
    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");
 
      // Recur for all the vertices adjacent to this vertex
        for (Iterator<Integer> itr =  adj[v].listIterator(); itr.hasNext();){
        	int n = itr.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
 
    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
 
        // Call the recursive helper function to print DFS traversal
        //DFSUtil(v, visited);
        //Call DFS with stack implementation
        DFSUtilStack(v,visited);
    }
    //DFS using adjacency matrix
    public static void DFSAdjacencyMatrix(boolean[][] adjMatrix , int source){
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	boolean[] visited =  new boolean[adjMatrix.length];
    	visited[source] = true;
    	stack.push(source);
    	while (!stack.isEmpty()){
    		int newSource = stack.pop();
    		System.out.println( newSource + " ");
    		Stack<Integer> tempStack = new Stack<Integer>();
        		for ( int j = 0 ; j <  adjMatrix[newSource].length ; j++){
        			if (adjMatrix[newSource][j] && !visited[j]){
        			    visited[j] = true;
        				tempStack.push(j);

        			}
        		}
        	while (!tempStack.isEmpty())
        		 stack.push(tempStack.pop());
    	}
    	
    }
    
    private void DFSUtilStack(int v2, boolean[] visited) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(v2);
		while ( !stack.isEmpty()){
			     Integer nodeValue = stack.pop();
			     visited[nodeValue] = true;
			     System.out.println( nodeValue + " ");
			     Stack<Integer> tempStack = new Stack<Integer>();
			     for (Iterator<Integer> itr = adj[nodeValue].iterator(); itr.hasNext();){
			    	 int val = itr.next();
			    	 if ( !visited[val]) 
			    		 tempStack.push(val);

			     }
			     while (!tempStack.isEmpty())
			    	     stack.push(tempStack.pop());
		}
	}

    /*
     *  topological sort
     *  Compute the indegrees of all vertices
		Find a vertex U with indegree 0 and print it (store it in the ordering)
		If there is no such vertex then there is a cycle 
		and the vertices cannot be ordered. Stop.

		Remove U and all its edges (U,V) from the graph.
		Update the indegrees of the remaining vertices.
		Repeat steps 2 through 4 while there are vertices to be processed.
     */

	private  static void doTopologicalSort(LinkedList<Integer> adjacencyList[]){
    	
    	//loop for the no. of vertices
    	for (int i=0;i<5;i++){
    		boolean visited[] = new boolean[6];
    		computeIndegreeVertex(adjacencyList,visited);
    	}
    	
    }
    
    //starting vertex will the vertex with in degree 0  i,e no incoming edges
    private static int computeIndegreeVertex(LinkedList<Integer> adjacencyList[], boolean visited[]){
    	//finding in degree = 0 vertex
    	for (int i = 0 ; i < adjacencyList.length ; i++){
    		 //visit  the starting vertex
    		visited[i] = true;
    		for (Iterator<Integer> itr = adjacencyList[i].iterator(); itr.hasNext();){
    			   //visit all chained vertices // as its DAG so its not needed to scan the chained vertices list
    			   visited[itr.next()] = true;
    		}
    		//look for non visited vertices whether there is an in degree edge between those vertices and the current vertex under process.
    		for (int j=0;j< visited.length ;j++){
    			 if (!visited[j]){
    				 //look for an in degree edge
    				 for (Iterator<Integer> itr = adjacencyList[i].iterator(); itr.hasNext();){
    					 
    				 }
    			 }
    		}
    		
    	}
		return -1;    	
    }
    /*
     * Given a directed graph, design an algorithm to find out whether there is a route between two nodes
     */
    
   /*
    * There are n students in a class. Every student can have 0 or more friends. 
    * If A is a friend of B and B is a friend of C then A and C are also friends.
    *  So we define a friend circle as a group of students who are friends as given by above definition. 
    *  Given an nXn-matrix friends which consists of characters Y or N. 
    *  If friends[i][j]=Y, then ith and jth students are friends, friends[i][j]=N,
    *  then i and j are not friends. Find the total number of such friend circles in the class.
    */
   private static int startingStudent = Integer.MIN_VALUE;
   public static  void findFriendCircles(int[][] friends){
	   boolean visited[] = new boolean[friends.length];
	   int noOfCircles = 0 ;
	   //map for friends .
	   Map<Integer,Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
	   for (int student = 0 ; student < friends.length ; student++){
		   if (!visited[student]){ 
			   visited[student] = true;
			   noOfCircles++;
			   startingStudent = student;
			   //find friend circles of the student i.e 0
			   // print the friend circles also
			   map.put(startingStudent, new HashSet<Integer>());
			   countFriendCircles(friends,visited,student,map);
		   }
	   }
	   System.out.println("NO. of friend Circles " + noOfCircles + " Friends List " + map);
	   
   }
	private static void countFriendCircles(int[][] friends, boolean[] visited, int student, Map<Integer,Set<Integer>> map) {
		for (int friend = 0 ; friend < friends[0].length ; friend++){
			//looking for a friend 
			//if friend is not visited .. student != friend && there exists a path from student to his friend
			if (!visited[friend] && student != friend && friends[student][friend] == 1)
			{
				visited[friend] = true;
				//start finding friends of the current student
				map.get(startingStudent).add(friend);
				countFriendCircles(friends, visited, friend ,map);
			}
		}
		
	}
	//Check whether given degrees of vertices represent a Graph or Tree
	/*
	 * The degree of a vertex is given by the number of edges incident or leaving from it.
	This can simply be done using the properties of trees like –
	
	Tree is connected and has no cycles while graphs can have cycles.
	Tree has exactly n-1 edges while there is no such constraint for graph.
	It is given that the input graph is connected. We need at least n-1 edges to connect n nodes.
	If we take the sum of all the degrees, each edge will be counted twice. Hence, for a tree with n vertices and n – 1 edges, sum of all degrees should be 2 * (n – 1).
	 */
	
	public static boolean isGraphATree(String str){
		//find sum of all edges
		String []strA = str.split(" ");
		int totalInDegreeValues = 0 ;
		for (String s : strA){
			totalInDegreeValues += Integer.valueOf(s);
		}
		//sum of all degress
		return totalInDegreeValues == 2*(strA.length);
	}
	
	/*
	 * The Monk wants to buy some cities. To buy two cities, he needs to buy the road connecting those two cities. Now, you are given a list of roads, bought by the Monk. You need to tell how many cities did the Monk buy.

		Input:
		First line contains an integer T, denoting the number of test cases. 
		The first line of each test case contains an integer E, denoting the number of roads. The next E lines contain two space separated integers X and Y, denoting that there is an road between city X and city Y.
		
		Output:
		For each test case, you need to print the number of cities the Monk bought.
		
		Constraint:
		1 <= T <= 100
		1 <= E <= 1000
		1 <= X, Y <= 10000
	 */
	public static int NoOfRoadsBrought() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
	}
	
	/*
	 * https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/aryas-stunt-63b3da17/
	 * Arya Stark is now a trained assassin, and her aim is to destroy and kill Queen Cersei to avenge her father’s death. Being a trained assassin, Arya can easily sneak into enemy’s territory.

	She uses this ability to enter the area where Cersei’s army is residing into their tents. There are ‘N’ number of tents in this area having ID 1,2,3..N . Some tents may be connected to each other via ropes. Arya wants to kill and injure as many warriors of Cersei’s army by burning the tents.
	
	If there are ‘c’ no. of tents which are connected to each other via ropes, then Arya can light any one of these connected tents as warriors/soldiers of other ‘c-1’ tents will be alarmed by this activity. Suppose, Arya lights tent ‘X’ out of these c tents, then all the warriors of the tent ‘X’ will get killed and the warriors which are in the rest of the connected tents i.e. c-1 tents will get injured.
	
	See sample explanation for more details.
	
	Note –
	
	If tent 1 is connected to tent 2, the tent 2 is also connected to tent 1.
	If tent 1 is connected to tent 2 and tent 2 is connected to tent 3, then tent 1 is also connected with tent 3.
	Now, Arya Stark wants to kill maximum no. of soldiers of Cersei’s army. Can you tell in advance how many soldiers will be killed and how many will get injured by this act of Arya Stark? Also output the number (ID) of tents which will be lighten by Arya. 
	If more than one connected tents can be lighten then Arya will choose to light the tent whose ID will be minimum.
	
	Input:
	
	First line will contain two space separated integers N and M, i.e. the total number of tents and total number of connections between the tents.
	
	Second line will contain ‘N’ space separated integers denoting the number of soldiers in i’th tent 1<=i<=N.
	
	Next ‘M’ lines contains two spaced separated ‘a’ and ‘b’ denoting Tent ‘a’ and Tent ‘b’ are connected to each other via rope.
	
	Output:
	
	Two space separated integers denoting number of soldiers killed and number of soldiers injured respectively.
	
	Next line contains the space separated ID of the lighten tents in increasing order of their ID’s.
	
	Constraints:
	
	1<= N<= 10000
	1<= M<= 10000
	1<= No. of soldiers in each tent <=10000
	SAMPLE INPUT 
	6 4
	3 4 3 2 4 5
	1 3
	3 5
	5 2
	4 6
	SAMPLE OUTPUT 
	9 12
	2 6
	Explanation
	In the given case, there are 6 Tents numbered 1 to 6, which have 3,4,3,2,4,5 soldiers in respective tents.
	
	Tents 1,2,3,5 are connected and Tents 4,6 are connected.
	
	Arya will light tents numbered 2 and 6, lighting of tent 2 will result in killing of 4 soldiers in it and injuring soldiers of tents 1,3,5 and lighting of tent 6 will result in killing of 5 soldiers in it and injuring soldiers of tent 4. So, this will result in killing 9 soldiers and causing injury to 12 soldiers.
	*/
	
	
	public static solution(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] vals = br.readLine().toCharArray();
		int noOfTents  = vals[0];
		int connections = vals[2];
		List<Integer> adjList[] = new LinkedList[noOfTents];
		String[] soldiersPresent = br.readLine().split(" ");
		//form adjacency matrix 
		while (connections != 0 ){
			String[] connection = br.readLine().split(" ");
			//undirected 
			adjList[Integer.parseInt(connection[0])].add(Integer.parseInt(connection[2]));
			adjList[Integer.parseInt(connection[2])].add(Integer.parseInt(connection[0]));
		}
		
		//each tents number will be considered as a vertex of a graph
		boolean visited[] = new boolean[noOfTents];
		for (int i = 1 ; i <= noOfTents ; i++){
			if ( !visited[i]) //if the current tent is not visited
				findConnectedComponents(i,visited,adjList);
		}
	}
	public static void findConnectedComponents(int tentNo , boolean visited[] ,List<Integer> adjList[] ){
		visited[tentNo] = true;
		System.out.print("tent no : " + tentNo + "--");
		for (Iterator<Integer> itr = adjList[tentNo].iterator() ; itr.hasNext();){
			int newTent = itr.next();
			if (!visited[newTent])
				findConnectedComponents(newTent,visited,adjList);
		}
		
	}
	//given a graph find the distance from the src vertex to the destination vertex using bfs.
	//consider each edge of length 1 unit
	
	public static int findPathDistanceUsingBFS(List<Integer> adjList[] , int src , int dest , boolean[] visited){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(src);
		queue.add(Integer.MAX_VALUE);//level indication
		visited[src] = true;
		int pathDist = 0 ; 
		while (!queue.isEmpty()){
			int polledVtx = queue.poll();
			if (dest == polledVtx) return pathDist;
			else if (Integer.MAX_VALUE == polledVtx) ++pathDist;
			else{
				// push all unvisited vertices of the current polled vertex to queue
				for (Iterator<Integer> itr = adjList[polledVtx].iterator() ; itr.hasNext();){
				     int neighbour = itr.next();
				     if (!visited[neighbour])
				    	  queue.offer(neighbour);
				}
				//add level when all current level vertices have been processed
				if (queue.peek() == Integer.MAX_VALUE)queue.add(Integer.MAX_VALUE);
			}
		}
		return -1;
	}
	
		/*
		 * Golu loves travelling. So this time he has planned to go to Europe. He will write down the place he is going to visit and amount of money spent on that trip. Each of the move was written on a card in the order he visits the cities. If we visits the cities A,B,C,D in this order then he will write it down like this on his cards with the money he spent on that trip:
	A B 10
	B C 20
	C D 5 
	D A 100
	As he was a great planner he would never visit a place twice. Before starting his journey his cards got shuffled. Now he cannot remember the actual order of cards. Can you help him to do so?
	
	Input
	The first line contains an integer T, the number of test cases. Each case starts with the value of N the number of cities he is going to visit. The next lines N-1 lines are of the form
	A B C
	Where A,B are the cities and C the amount spent on the that trip 
	
	Output
	For each test case output N lines. The first N-1 lines contains the cards in their actual order with the amount spent on that trip and in last line the total amount spent on the whole trip.
	
	The names of the cities are in uppercase and lowercase. No two cities will have same name.
	The names of cities are case-sensitive. So "Chelsea" and "chelsea" should be considered as different cities.
	
	Note :Use fast I/O
	
	SAMPLE INPUT 
	1
	5
	Chelsea Tottenham 10
	Liverpool Manchester 100
	Manchester Paris 25
	Paris Chelsea 50
	
	SAMPLE OUTPUT 
	Liverpool Manchester 100
	Manchester Paris 25
	Paris Chelsea 50
	Chelsea Tottenham 10
	185
	
	*/
	public static void solutionVisitCities() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Map<String,String>,Integer> graph = new HashMap<Map<String,String>, Integer>();
        for (int i = 0; i < N; i++) {
           
        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 GraphImpl g = new GraphImpl(4);
		 
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);
	 
	        System.out.println("Following is Depth First Traversal "+
	                           "(starting from vertex 2)");
	 
	        g.DFS(2);
	   //building adjacency matrix
	   boolean[][] adjacencyMatrix = new boolean[][]{{false,true,true,false},
													   {false,false,true,false},
													   {true,false,false,true},
													   {false,false,false,true},
													   };
	   //DFSAdjacencyMatrix(adjacencyMatrix,2);
	   //building a graph for topological sort // linear ordering of elements i.e subjects taken by a student during a university
	   //has to be DAG
	   //maintaining a hashMap of edges
	   GraphImpl topologicalSortGraph = new GraphImpl(6);
	   topologicalSortGraph.addEdge(5, 2);
	   topologicalSortGraph.addEdge(5, 0);
	   topologicalSortGraph.addEdge(4, 0);
	   topologicalSortGraph.addEdge(4, 1);
	   topologicalSortGraph.addEdge(2, 3);
	   topologicalSortGraph.addEdge(3, 1);
	   //call topological sort for the no. of vertices
	   //doTopologicalSort(adj);
	   
	   //friend circles data
	   int[][] friendsConnections = new int[][]{{1,1,0,0},{1,1,1,0},{0,1,1,0},{0,0,0,1}};
	   findFriendCircles(friendsConnections);
	   //create a new graph.
	   GraphImpl g1 = new GraphImpl(4);
	   //add edges
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(2, 3);
		g1.addEdge(2, 4);
		
		System.out.println("find path distance from given src to dest vertex is : "
				+ g1.findPathDistanceUsingBFS(g1.adj, 0, 4, new boolean[5]));
	   
	}

}
