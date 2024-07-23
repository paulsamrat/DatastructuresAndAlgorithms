package com.practise.programs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class FileInputOutput {

	/**
	 * Maximum repeated word in a file.
	 */
	static Map<String,Integer> getWordCount()
	{
		BufferedReader reader = null;
		Map<String,Integer> mapToStoreToken = new HashMap<String, Integer>();
		try
		{
			 reader = new BufferedReader(new FileReader("E:\\EclipseWorkSpace\\PRACTISE\\FileInputOutput.txt"));
			 String line = null;
			 while ( (line = reader.readLine()) != null)
			 {
				 StringTokenizer stringTokenizer = new StringTokenizer(line ," ");
				 while (stringTokenizer.hasMoreTokens())
				 {
					 String token = stringTokenizer.nextToken().toLowerCase();
					 if ( mapToStoreToken.containsKey(token) )
						 mapToStoreToken.put(token, mapToStoreToken.get(token)+1);
					 else
						 mapToStoreToken.put(token, 1);
				 }
			 }
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try{if(reader != null) reader.close();}catch(Exception ex){}
		}
		
		return mapToStoreToken;
	}
		
	/*
	 * Sort the above map using comparator
	 */
	 public static List sortByValue(Map<String,Integer> mapToSort)
	 {
		 Set<Entry<String,Integer>> mapToSortSet =  mapToSort.entrySet();
		 List<Map.Entry<String, Integer>> mapToSortList = new ArrayList<Map.Entry<String, Integer>>(mapToSortSet);

		 Collections.sort( mapToSortList, new Comparator<Map.Entry<String, Integer>>()
			        {
			            public int compare( Entry<String, Integer> o1, Entry<String, Integer> o2 )
			            {
			                return (o2.getValue()).compareTo( o1.getValue() );
			            }
			        } );
 
		return mapToSortList;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(sortByValue(getWordCount()));
	}

}
