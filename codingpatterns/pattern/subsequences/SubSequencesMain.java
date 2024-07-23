package pattern.subsequences;

import java.util.ArrayList;
import java.util.List;

public class SubSequencesMain {
	//Given a string, find all the possible subsequences of the string.
	private void findAllPossibleSubsequences(final String str) {
		final List<Character> subsequences = new ArrayList<Character>();
		recursionAllSubsequences(str,0,subsequences);
	}
	
	private void recursionAllSubsequences(final String str, int currCharIdx , List<Character> subsequences) {
		if (currCharIdx >= str.length()) {
			System.out.println(subsequences);
			return;
		}
		subsequences.add(str.charAt(currCharIdx)); // add step
		recursionAllSubsequences(str,currCharIdx+1,subsequences);
		subsequences.remove((Character)str.charAt(currCharIdx));
		recursionAllSubsequences(str,currCharIdx+1,subsequences);
		
	}
	//longest increasing subsequences
	private void longestIncreasingSubsequence(final int[] arr) {
		final List<Integer> subsequences = new ArrayList<Integer>();
		recLongIncreSubSequence(arr ,0,subsequences);
	}
	int maxLengthIncreasingSubSequence = Integer.MIN_VALUE;
	private void recLongIncreSubSequence(final int[] arr , int currIdx , List<Integer> subsequences) {
		if ((currIdx >= arr.length) || (subsequences.size() > 0 && arr[currIdx] < subsequences.get(subsequences.size()-1))) {
			return;
		}
		subsequences.add(arr[currIdx]);
		recLongIncreSubSequence(arr ,currIdx+1 ,subsequences);
		System.out.println(subsequences+ " size = " + subsequences.size()); //curr longest increasing subsequence
		//subsequences.remove((Integer)arr[currIdx]); //remove the added element
		recLongIncreSubSequence(arr ,currIdx+1 ,subsequences);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final SubSequencesMain obj = new SubSequencesMain();
		obj.findAllPossibleSubsequences("ABC");
		//obj.longestIncreasingSubsequence(new int[] {3, 10, 2, 1, 20});
	}

}
