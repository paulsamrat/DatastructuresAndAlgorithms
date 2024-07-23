package com.practise.interview.experience;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Test {
	
	
	public static void main(String args[]) throws IOException{
	Scanner sc = new Scanner(System.in);
		int noOfItems = Integer.parseInt(sc.nextLine());
		int noOfNodes = noOfItems;
		LinkedList<String> adj[] = new LinkedList[noOfItems+1];
		for (int i = 0 ; i < noOfItems+1 ;i++)
			//creating an array of adjacency lists
			adj[i] = new LinkedList<String>();	
		
		String[] arr = sc.nextLine().split(" ");
		//Map<String,List<String>> map = new HashMap<String,List<String>>();
		//List<String> tempList = new ArrayList<String>();
		while (noOfItems -1 > 0 ){
			String [] edgeArr = sc.nextLine().split(" ");
			adj[Integer.parseInt(edgeArr[0])].add(edgeArr[1]);
			adj[Integer.parseInt(edgeArr[1])].add(edgeArr[0]);
			--noOfItems;
		}
		int queryCount = Integer.parseInt(sc.nextLine());
		while (queryCount > 0 ){
			String str[] = sc.nextLine().split(" ");
			int startNode =  Integer.parseInt(str[0]);
			int endNode =  Integer.parseInt(str[1]);
			boolean visited[] = new boolean[noOfNodes+1];
			visited[startNode] = true;
			Integer count = 0 ; 
			DFSUtil(startNode,endNode, visited, adj,count);
			
			--queryCount;
		}
		
	}

	private static void DFSUtil(int start, int end , boolean[] visited, LinkedList<String> adj[] , Integer count) {
		// TODO Auto-generated method stub
		if ( start != end) { 
			for (Iterator<String> itr =  adj[start].listIterator(); itr.hasNext();){
				int n = Integer.parseInt(itr.next());
				if (!visited[n]){
					++count;
					DFSUtil(n, end, visited, adj , count);
				}
					
			}

		}else{
			System.out.println(count);
			return;
		}
	}}
	
	

