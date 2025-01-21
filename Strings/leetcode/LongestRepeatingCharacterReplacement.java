package leetcode;

public class LongestRepeatingCharacterReplacement {
	//https://leetcode.com/problems/longest-repeating-character-replacement/description/
	
	public static int characterReplacement(String s, int k) {
        
		int startIdx = 0 ;
		int endIdx = 1 ;
		
		char c[] = s.toCharArray();
		
		while(endIdx < c.length) {
			if (c[endIdx-1] != c[endIdx])
			{
				if (k != 0 ) 
				{
					c[endIdx] = c[endIdx-1];
					--k;
				}else
					break;
			}
			++endIdx;
		}
		
		return ((endIdx-1)-startIdx)+1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(characterReplacement("ABAA",0));
	}

}
