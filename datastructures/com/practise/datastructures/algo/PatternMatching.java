package com.practise.datastructures.algo;

public class PatternMatching {
	
	int prime = 31;

	//naive approach.
	//taking the input string and search the pattern out  of it. 
	//go till the point of input string where pattern length is there.
	
	//O(inputStringlength*patternLength)
	private static void searchPattern(String inputString, String patternToSearch)
	{
		//if the input string has spaces in between.
		int inputStringlength = inputString.length();
		int patternLength = patternToSearch.length();
		
		for (int i=0 ;i <= inputStringlength - patternLength  ; i++ )
		{
			for (int j=0 ; j < patternLength; j++)
			{
				if ( inputString.charAt(i+j) != patternToSearch.charAt(j)) break;
				if ( j ==  patternLength-1) 
				{
					System.out.println(" Pattern Found Starting at index " + i);
				}

			}
		}
	}
	
	//KMP Pattern Matching
	//https://www.youtube.com/watch?v=GTJr8OvyEVQ&t=2s
	//O(length(Text) + length(Pattern))
	public static boolean doKMPSearch(String text , String pattern){
		int[] prefix = buildPrefixArray(pattern);
		//using the above prefix info we will start the algo
		//char[]  charPattern = pattern.toCharArray();
		int patternPointer = 0 ;
		for ( int i = 0 ; i < text.length() ;){
			//start matching character by character
			if (text.charAt(i) == pattern.charAt(patternPointer)) { ++i; ++patternPointer; }
			else{
				//you have matched the pattern this far
				//it also means there may or may out  be a proper suffix which is also a proper prefix.
				//match from the current pattern character
				if ( patternPointer != 0 ) patternPointer = prefix[patternPointer-1] ;
				else ++i; //start matching from next text character
			}
			//base case
			if (patternPointer == pattern.length() ) return true; //pattern found
		}
		return false;
	}
	
	static int[] buildPrefixArray(String pattern){
		//build the prefix array same as pattern length
		int prefix[] = new int[pattern.length()];
		//set first index to zero
		boolean properPrefixFound = false;
		prefix[0] = 0 ;
		//setting indexes which will point to prefix table
		//point i to first character index and j to next

		int i = 0 ; 
		//int j = i+1;
		char[] charInPattern = pattern.toCharArray();
//		while ( j <= pattern.length()-1){
//			if ( isExactMatch(charInPattern,i,j,prefix) ) i++;
//			else{ // on mismatch
//				while ( i != 0 && !properPrefixFound){ // if i doesn't points to leftmost index , so there's still some characters available for comparison.
//					//assign i to the value of ( previous ith value ) 
//					i = prefix[i-1];
//					//check if the ith value matches with the jth value
//					if ( isExactMatch(charInPattern,i,j,prefix) ){
//						++i;
//						properPrefixFound = true;
//					}
//				}
//				if (!properPrefixFound) prefix[j] = 0  ;
//			}
//			++j;
//		}
		
		//another approach
		for (int j = i+1 ; j < pattern.length() ; ){ //trick here
			if(isExactMatch(charInPattern, i, j, prefix)){  ++i; ++j;}
			else{
				if ( i != 0) i = prefix[i-1];
				else{
					prefix[j] = 0 ;
					j++;
				}
			}
		}
		return prefix;
	}
	
	public static  boolean isExactMatch(char[] charInPattern,  int i , int j  , int[] prefix){
		if (charInPattern[i] == charInPattern[j]){
			prefix[j] = i + 1;
			return true;
		}
		return false;
	}
	static void printPrefixArray(int[] prefixArray){
		for (int i = 0 ; i < prefixArray.length ; i++ )
			System.out.print("[" + i + "]-" + prefixArray[i] + " ");
	}
	
	/* Time complexity in worst case O(n^2)(depends on hash function)
	 * Space complexity O(1)
	 */
	boolean doRobinKarpPatternSearch(String text , String pattern){
		int textL = text.length();
		int patternL = pattern.length();
		long patternHash = buildHashForPattern(pattern);
		String oldSubString = "";
		String currSubString = "";
		long oldHash = 0;
		//keep rolling
		for ( int i = 0 ; i < textL - patternL ; i++ ){
			currSubString = text.substring(i, i + patternL);
			long subStringHash = i==0 ? buildHashForPattern(currSubString) : buildHashForSubString(currSubString , oldSubString, oldHash);
			oldSubString = currSubString;
			oldHash = subStringHash;
			if ( subStringHash == patternHash ) return true ;
		}
		return false;
	}
	
	long buildHashForPattern(String pattern){
		//building hash with ascii
		long hashVal = 0;
		for (int i = 0 ; i < pattern.length() ; i++)
			 hashVal += pattern.charAt(i) * Math.pow(this.prime, i+1);
		return hashVal;
	}
	
	//using rolling hash algo
    long buildHashForSubString(String newSubString , String oldSubString , long oldHash ){
		long newHash = oldHash / this.prime;
		newHash = newHash - oldSubString.charAt(0);
		newHash += newSubString.charAt(newSubString.length() - 1) * Math.pow(this.prime, newSubString.length());
		return newHash;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PatternMatching pm = new PatternMatching();
		String str  = "abc";
		if (str.contains(new StringBuffer('x'))) System.out.println("s");
		searchPattern("samrat", "at");
		//test prefix array creation
		int []result = buildPrefixArray("abcaby"); //acacabacacabacacac -- correct
		printPrefixArray(result);
		System.out.println( "\n pattern found " + doKMPSearch("abxabcabcabyzxc","abcaby"));
		System.out.println( "\n Pattern Found " + pm.doRobinKarpPatternSearch("abxabcabcabxzxc","abcaby"));
		
	}

}
