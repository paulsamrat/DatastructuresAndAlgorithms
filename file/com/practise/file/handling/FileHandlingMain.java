package com.practise.file.handling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileHandlingMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader reader = null; 
		try {
			reader = new BufferedReader(new FileReader("Employee.txt"));
			String presentLine = "";
			Set<EmployeePOJO> setOfEmployeeObjects  = new HashSet<EmployeePOJO>();

			while ((presentLine = reader.readLine()) != null )
			{	
				//StringTokenizer tokenizer = new StringTokenizer(presentLine, ",");
				String []tokens = presentLine.split(",");
				EmployeePOJO employeeObject = new EmployeePOJO(tokens[0], tokens[1], tokens[2]);
				setOfEmployeeObjects.add(employeeObject);
			}
			/*
			 * Sorting based on salary
			 */
			List<EmployeePOJO> listOfEmployeeObjects = new ArrayList<EmployeePOJO>(setOfEmployeeObjects);
			Collections.sort(listOfEmployeeObjects, new Comparator<EmployeePOJO>(){
             
		        public int compare(EmployeePOJO o1, EmployeePOJO o2) {
					// TODO Auto-generated method stub
					EmployeePOJO object1 = (EmployeePOJO)o1;
					EmployeePOJO object2 = (EmployeePOJO)o2;

					return object1.getSalary().compareTo(object2.getSalary());
				}
				
			});
			
			System.out.println(listOfEmployeeObjects);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (reader != null)reader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
