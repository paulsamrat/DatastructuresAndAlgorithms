package com.practise.datastructures.algo.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AmazonGreedyQuestions {
	
	/*
	 * there are n = 5 companies that will arrive at times arrival = [1, 3, 3, 5, 7] and will stay for duration = [2, 2, 1, 2, 1].  The first company arrives at time 1 and stays for 2 hours. At time 3, two companies arrive, but only 1 can stay for either 1 or 2 hours. The next companies arrive at times 5 and 7 and do not conflict with each other. In total, there can be a maximum of 4 promotional events.
	Complete the function maxEvents in the editor below. It must return an integer that represents the maximum number of promotional events that can be hosted
	 */
	//with 1 stage find the max number of events that can be accomodated
	
	//logic
	//sort all the pairs based on the finishing time 
	// pick the least finishing time and traverse right and look for the next starting time which is >= previous finishing time 
	
	private class Event
	{
		private int arrivalTime;
		private int departureTime;
		
		private Event(final int arrivalTime , final int departureTime)
		{
			this.arrivalTime = arrivalTime;
			this.departureTime = departureTime;
		}
		
	}
	public void maxEvents(int[] arrivals , int[] durations)
	{	
		List<Event> eventsList = new ArrayList<Event>();
		for ( int i = 0 ; i < arrivals.length ; i++)
		{
			eventsList.add(new AmazonGreedyQuestions(). new Event(arrivals[i],arrivals[i]+durations[i]));
		}
		
		Collections.sort(eventsList, new Comparator<Event>() {

			@Override
			public int compare(Event e1, Event e2) {
				// TODO Auto-generated method stub
				return e1.departureTime - e2.departureTime;
			}
		});
		int maxEventsPossible = 1 ;
		int lastDepartureTime = eventsList.get(0).departureTime;
		for (int i = 1 ; i < eventsList.size();i++)
		{
			if (eventsList.get(i).arrivalTime >= lastDepartureTime)
			{
				++maxEventsPossible;
				lastDepartureTime = eventsList.get(i).departureTime;
			}
			
		}
		
		System.out.println(" max Events Possible = " + maxEventsPossible);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmazonGreedyQuestions obj = new AmazonGreedyQuestions();
		obj.maxEvents(new int[]{1,3,5} , new int[]{2,2,2});
	}

}
