package com.practise.challenge.problems;

public class PyramidPrinting {

	
	public static void print(final String str , final int height , final int direction)
	{	
		int length = height * 2 -1;
		char[][] pyramid = new char[length][length];
		boolean clockWise = Boolean.FALSE;
		char[] strArr = str.toCharArray();
		int lastVisitedIdx = 0 ;
		pyramid[0][0] = strArr[0];
		for (int i = 1; i < pyramid.length ; i++)
		{	
			int j = i*2 + 1;
			
				if (clockWise)
				{
						int k = 0 ;
						int tempIdx;
						if (lastVisitedIdx == strArr.length -1) lastVisitedIdx = 0 ;
						if (lastVisitedIdx == 0) lastVisitedIdx += 1 ;
						do {
							
							tempIdx = lastVisitedIdx;
							pyramid[i][k++] = strArr[lastVisitedIdx++];
							if(lastVisitedIdx == strArr.length ) lastVisitedIdx = 0;
						} while(k < j);
						clockWise = !clockWise;
						lastVisitedIdx = tempIdx;
				}
				else
				{	
					int k = 0 ;
					int tempIdx;
					if (lastVisitedIdx == strArr.length -1) lastVisitedIdx = 0 ;
					if (lastVisitedIdx == 0) lastVisitedIdx += 1 ;
					do {
						tempIdx = lastVisitedIdx;
						pyramid[i][k++] = strArr[lastVisitedIdx--];
						if(lastVisitedIdx == -1 ) lastVisitedIdx = strArr.length - 1 ;
					} while(k < j);
					clockWise = !clockWise;
					lastVisitedIdx = tempIdx;
				}
		}
		
		
		
		//inverse
//		for (int i = 0 ; i < pyramid.length ; i++)
//		{
//			for (int j = 0 + i ; j < pyramid[i].length  - i  ; j++)
//			{	
//				if (leftToRight)
//				{
//					int i = start;
//					do {
//
//						....
//
//						i++;
//						if(i == a.length) i = 0;
//					} while(i != start);
//				}
//				else
//				{
//					
//				}
//				
//			}
//		}
//		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
print("abc" , 6  , 1);
	}

}
