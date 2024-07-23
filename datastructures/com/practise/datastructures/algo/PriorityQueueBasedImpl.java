package com.practise.datastructures.algo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
class TicketPriceComparator implements Comparator<Integer>{

	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o2 - o1 ;
	}
	
}
 
public class PriorityQueueBasedImpl {

/*
 * Generate Maximum revenue by selling K tickets from N windows
   Objec­tive: Given ‘N’ win­dows where each win­dow con­tains cer­tain num­ber of tick­ets at each win­dow. Price of a ticket is equal to num­ber of tick­ets remain­ing at that win­dow. Write an algo­rithm to sell ‘k’ tick­ets from these win­dows in such a man­ner so that it gen­er­ates the max­i­mum revenue.


Exam­ple:

Say we have 6 windows and they have 5, 1, 7, 10, 11, 9 tickets respectively.
Win­dow Number	1	2	3	4	5	6
Tick­ets	5	1	7	10	11	9


Sell the first ticket from win­dow 5, since it has 11 tick­ets so cost will be $11.

Revenue after selling first ticket, MaxRevenue: 11.
Win­dow Number	1	2	3	4	5	6
Tick­ets	5	1	7	10	10	9


Sell the sec­ond ticket from win­dow 4 or win­dow 5, since they have 10 tick­ets each so cost will be $10, assume we sell it from win­dow 5.

Revenue after selling second ticket, MaxRevenue: 21.
Win­dow Number	1	2	3	4	5	6
Tick­ets	5	1	7	10	9	9


Sell the third ticket from win­dow 4, since it has 10 tick­ets so cost will be $10.

Revenue after selling second ticket, MaxRevenue: 31.
Win­dow Number	1	2	3	4	5	6
Tick­ets	5	1	7	9	9	9


Sell the fourth ticket from win­dow 4,5 or 6, since they have 9 tick­ets each so cost will be $10.

Revenue after selling fourth ticket, MaxRevenue: 40.
*/
	private static int generateMaximumRevenue(int[] windowsTickets , int noOfTickets){
			// we will form a max heap out of the passed array
		    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(windowsTickets.length , new TicketPriceComparator());
		    int totalRevenue = 0 ;
		    //insert the tickets count in the queue one by one
		    for(int count : windowsTickets){
		    	pq.offer(count);
		    }
		    //we will poll out @max no of tickets and add it up
		    while ( noOfTickets > 0 && noOfTickets <= windowsTickets.length){
		    	int pickedTktPrice = pq.poll();
		    	totalRevenue += pickedTktPrice;
		    	pq.offer(--pickedTktPrice);
		    	--noOfTickets;
		    }
		    return totalRevenue;
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] windowsTickets = { 5, 1, 7, 10, 11, 9 };
		int noOfTickets = 5;
		PriorityQueueBasedImpl object = new PriorityQueueBasedImpl();
		System.out.println("Max revenue generated by selling " + noOfTickets
				+ " tickets: " + generateMaximumRevenue(windowsTickets, noOfTickets));
	}

}