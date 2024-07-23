package com.practise.programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidString
{
	
    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String string) {
        //for (int i = 0 ; i < strArray.length ; i++)
        //{
            int smallestIdx =  -1; 
            final char[] str = string.toCharArray();
            for ( int j = str.length - 1 ; j > 0 ; j--)
            {
                if (str[j-1] < str[j])
                {
                    smallestIdx = j-1;
                    break;
                }
            }
            if (smallestIdx == -1) { System.out.println( "no answer"); }
            // find the next bigger char from the smallestidx 
            char min = str[smallestIdx+1]; 
            int minIdx = smallestIdx+1;
            for (int k = smallestIdx+2 ; k < str.length ; k++)
            {
                if (str[k] > str[smallestIdx] && str[k]  < min)
                {
                    min = str[k];
                    minIdx = k;
                }    
                
            }
            
            char temp = str[minIdx];
            str[minIdx] = str[smallestIdx] ;
            str[smallestIdx] = temp;
            
            Arrays.sort(str,smallestIdx+1,str.length);
            //System.out.println(Arrays.toString(str));
            StringBuilder sb = new StringBuilder();
            for (char c1  : str)
             sb.append(c1);
            return sb.toString();
    }
    static int beautifulDays(int i, int j, int k) {
        int result = 0 ;
        for (int i1=i ; i1 <=j ; i1++)
        {
//           StringBuilder sb = new StringBuilder(); sb.setLe
//           String rev = sb.append(i1).reverse().toString();
//            result += ((i1-Integer.parseInt(rev)) % k == 0 ) ? 1 : 0 ;
        }
        return result;
        }
    static int birthday(List<Integer> s, int d, int m) {
        int totalWays = 0 ;
        //first sliding window
        int totalVal=0;
        for ( int i = 0 ; i < m ; i++)
        {
            totalval=totalval + s.get(i);
        }
        if (totalVal == d) ++totalWays;
        for ( int i = m ; i < s.size() ; i++)
        {
            totalval-=s.get(i-m);
            totalval+=s.get(i);
            if (totalVal == d) ++totalWays;
        }
        return totalWays;
}
	public static void main(String[] args)  {
		//biggerIsGreater("dcba");
		int i = 10;
		while ( i != 2)
		{
			System.out.println(i);
			--i;
		}
		
		beautifulDays(20, 23, 6);
		Map<Student,Integer> map = new HashMap<Student,Integer>();
		Student s1 = new ValidString().new Student("samrat");
		map.put(s1, 1);
		map.put( new ValidString().new Student("samrat1"),2);
		
		s1.setName("test");
		System.out.println(map.get(new ValidString().new Student("samrat")));
		
	}
	
	private class Student{
		private String name;
		private Student(final String name){this.name = name;}
		public void setName(final String name){this.name = name;}
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		private ValidString getOuterType() {
			return ValidString.this;
		}
		
		
	}
} 