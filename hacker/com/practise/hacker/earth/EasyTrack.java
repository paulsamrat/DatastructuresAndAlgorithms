package com.practise.hacker.earth;

import java.util.Arrays;

public class EasyTrack {

	/*
	 * As we all know RK loves his name very much especially the character 'R' so this time task for you is based on his awesome name. 
	 * RK gives you a string S consisting of characters 'R' and 'K' only. 
	 * Now you are allowed to do exactly one move that is you have to choose two indices i and j (1<=i<=j<=|S| where |S| is string length ) 
	 * and flip all the characters at position X where i<=X<=j. Flipping the character means :

		 if S[X]='R' :  //If character at position X is 'R' then change it to 'K'
		      S[X]='K'  
		 else :          //else if character at position X is 'K' then change it to 'R'
		      S[X]='R'
		Now your goal is that after exactly one move you have to obtain the maximum number of R's as RK loves this character very much. So help RK with maximum R's.
	 */
	
	//Input : RKKR : O/P : 4
	//Note	: Only one flip  at max.
	
	static void noOfRs(String stringToFlip)
	{
		int startIndex = 0 ;
		int endIndex = stringToFlip.length()-1;
		int countNoOfRs = 0 ; 
		StringBuilder sb = new StringBuilder(stringToFlip);
		
		System.out.println("Fliping the characters to R to maximize the character R");
		while (startIndex  <  endIndex)
		{
			if ( "R".equalsIgnoreCase(String.valueOf(stringToFlip.charAt(startIndex))) && 
					"R".equalsIgnoreCase(String.valueOf(stringToFlip.charAt(endIndex))))
			{
					startIndex ++ ;
					endIndex --;
			}
			else
			{
				
				sb.setCharAt(startIndex, 'R');
				sb.setCharAt(endIndex, 'R');
				break; // only one flip is permitted.
			}
				
		}
		
		for (int i = 0 ; i < sb.length(); i++)
		{
			if (sb.charAt(i) == 'R') countNoOfRs++;
		}
		
		System.out.println("After Flipping the maximum no. of R's found  in the input string is " + countNoOfRs);
	}
	/*
	 * The Hexagon University of India will be hosting its Prom Night tonight.
	 * There would be M boys and N girls at the prom tonight.
	 *  Each boy wants a girl who is strictly shorter than him. 
	 *  A girl can dance with only one boy and vice-versa.
	 *  Given the heights of all the boys and girls tell whether it is possible for all boys to get a girl.
	 */
	
	static void findCompatibleHeight(int[] heightOfBoys , int[] heightOfGirls)
	{
		Arrays.sort(heightOfBoys);
		Arrays.sort(heightOfGirls);
		boolean allOccupied = false;
		for (int i=0 ; i < heightOfBoys.length ; i++)
		{
			if (heightOfBoys[i] < heightOfGirls[i]){ 
				allOccupied = false;
				break;
			 }
			else
				allOccupied = true;
		}
		
		if (allOccupied) System.out.println(" All Boys got their Girls");
		else 			 System.out.println(" All Boys didnt got their Girls");
	}
	
	/*
	 * we will take an array of N Keys : the hacker has his own key denoted by "X" and "N" no's of different keys . with minimum time he has to crack the key of the locker .
	 * Once  the hacker merges his key with another key : he has to do the following operation his (key * other key) % 100000.
	 * 
	 * Dynamic programming approach : find the minimum jump to reach end from start.
	 * https://www.hackerearth.com/tracks/pledge-2015-easy/dhoom-4/
	 */
	static int findtheMinimumSecondsToCrackTheKey(int[] arrayOfNKeys, int hackerKeyValue , int keyOfTheLocker)
	{
		//we will make an array of keys.
		int[] arrayOfAllKeys = new int[2+arrayOfNKeys.length];
		//filling values
		arrayOfAllKeys[0] = hackerKeyValue;
		for (int i =1 ; i < arrayOfNKeys.length ; i++)
				arrayOfAllKeys[i] = arrayOfNKeys[i-1];
		arrayOfAllKeys[arrayOfAllKeys.length] = keyOfTheLocker;
		
		int[] timeConsumed = new int[arrayOfAllKeys.length];
		for (int i=1 ; i < arrayOfAllKeys.length ; i++ )
		{
			for (int j=0 ; j<i ; j++ )
			{
				if (arrayOfAllKeys[j] + j >= i)
				{
					if (timeConsumed[i] < timeConsumed[j] + 1)
							timeConsumed[i] = timeConsumed[j]+1;
				}
			}
		}
		
		return timeConsumed[arrayOfAllKeys.length-1];
	}
	
	/*
	 * if there are n number of students in total, and he is supposed to divide them in camps of k students - 
	 * it has to  be arranged in such a way that the length of names of all the students in a camp is equal.
	 */
	static void campsAndCandidates(int[] candidates, int noOfcamps)
	{
		//Map<String,Integer>
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//noOfRs("RKKRK");
		//findCompatibleHeight(new int[]{2,5,0,6,8}, new int[]{3,8,5,1,7});
		Integer i =new Integer(100);
		int m = i;
		System.out.println(i == m);
		
	}

}
