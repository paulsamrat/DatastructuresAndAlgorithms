package com.grind75.questions;

public class StockBuySellOneTime {
	 public static int maxProfit(int[] prices) {
	        int buyPrc = prices[0] , sellPrc = -1 , maxProfit  = -1;
	        for (int i=1 ; i< prices.length ; i++){
	            // look for lesser buy price
	            if (prices[i] < buyPrc){
	                buyPrc = prices[i];
	                sellPrc = -1 ;
	            }else{
	                if (prices[i] > sellPrc){
	                    sellPrc = prices[i];
	                    if ((sellPrc-buyPrc) > maxProfit)
	                        maxProfit = (sellPrc-buyPrc);
	                }
	            }
	        }
	        return  maxProfit != -1 ? maxProfit : 0;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProfit(new int[] {2,1,2,1,0,1,2}));
	}

}
