package com.practise.hacker.earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/*
 * problems related to linear search
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/
 */
public class LinearSearch {
    private static Queue<Integer> connectedComponents ; 
    public static void findConnectedComponents(List adjList[] , int srcVtx , boolean[] visited , Queue<Integer> connectedComponents){
        visited[srcVtx] = true;
        connectedComponents.offer(srcVtx);
        for (Iterator<Integer> itr = adjList[srcVtx].iterator() ; itr.hasNext();){
            int newSrcVtx = itr.next();
            if (!visited[newSrcVtx])
                findConnectedComponents(adjList,newSrcVtx,visited,connectedComponents);
        }
        
        
    }
    public static void main(String args[] ) throws Exception {
        
    	Map<String,Integer> map = new HashMap<String, Integer>();
    	map.put("ABC", 1);
    	map.put("abc", 2);
    	System.out.println(map);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int noOfVertices = Integer.parseInt(line[0]);
        int noOfEdges = Integer.parseInt(line[1]);
        List adjList[] = new LinkedList[noOfVertices+1];
        int noOfHappyVertices  = 0 ;
        boolean visited[] = new boolean[noOfVertices+1];
        for (int j = 0 ; j<=noOfVertices ; j++)
        	adjList[j] = new LinkedList<Integer>();
        for (int i = 0 ; i < noOfEdges; i++){
            String[] vertices = br.readLine().split(" ");
            int srcVtx = Integer.parseInt(vertices[0]);
            int destVtx = Integer.parseInt(vertices[1]);
            adjList[srcVtx].add(destVtx);
        }
        for (int i1 = 1 ; i1 <= noOfVertices ; i1++){
            if (!visited[i1])
            {
                connectedComponents = new PriorityQueue<Integer>();
                findConnectedComponents(adjList , i1 , visited,connectedComponents);
                //find parent from connected component
                int parentVtx = connectedComponents.poll();
                int noOfParentChilds = adjList[parentVtx].size();
                while (!connectedComponents.isEmpty()){
                       int connectedVtx = connectedComponents.poll();
                       if (null != adjList[connectedVtx] && adjList[connectedVtx].size() > noOfParentChilds)
                                ++noOfHappyVertices;
                }
            }
            
            
        }
        System.out.println(noOfHappyVertices);
    }
        
    }
    	
    



    

