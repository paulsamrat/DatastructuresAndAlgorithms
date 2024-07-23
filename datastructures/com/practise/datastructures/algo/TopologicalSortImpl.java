package com.practise.datastructures.algo;

import java.util.LinkedList;
import java.util.List;

public class TopologicalSortImpl {
	/*
	 * Given a list of tickets, find itinerary in order using the given list.

		Example:
		
		Input:
		"Chennai" -> "Banglore"
		"Bombay" -> "Delhi"
		"Goa"    -> "Chennai"
		"Delhi"  -> "Goa"
		
		Output: 
		Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Banglore,
	 */
	
    //building a directed acyclic graph
    private LinkedList<String> adjList[];

	public TopologicalSortImpl(int noOfCities){
		adjList =  new LinkedList[noOfCities];
		for(int i = 0 ; i < noOfCities ; i++)
			adjList[i] = new LinkedList<String>();
    }
		 
    private void buildADAC(String srcCity, String destCity){
    	adjList
        	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
