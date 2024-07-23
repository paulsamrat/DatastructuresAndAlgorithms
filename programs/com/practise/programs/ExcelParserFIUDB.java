package com.practise.programs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.SAXException;

public class ExcelParserFIUDB {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		final String passwordLengthsExcel = "/Users/sp250521/Documents/LEARNING/AIMS/FI_Password_Lengths_180307_Corrected2.xlsx";
		final String udbFISchemaNamesExcel = "/Users/sp250521/Documents/LEARNING/AIMS/UDB_FI_schema_names.xlsx";
		parseExcel(passwordLengthsExcel,udbFISchemaNamesExcel);
		
	}
	private static void parseExcel(final String passwordLengthsExcel , final String udbFISchemaNamesExcel) throws ParserConfigurationException, SAXException, IOException
	{
		FileInputStream passwordLengthsExcelFIS = new FileInputStream(new File(passwordLengthsExcel));
		FileInputStream udbFISchemaNamesExcelFIS = new FileInputStream(new File(udbFISchemaNamesExcel));

        Workbook passwordLengthsExcelWorkBook = new XSSFWorkbook(passwordLengthsExcelFIS);
        
        Workbook udbFISchemaNamesExcelWorkBook = new XSSFWorkbook(udbFISchemaNamesExcelFIS);

        Sheet dataSheet = passwordLengthsExcelWorkBook.getSheetAt(0);
        
        Sheet envDataSheet  = udbFISchemaNamesExcelWorkBook.getSheetAt(5);
        
        Iterator<Row> envDataSheetItr = envDataSheet.iterator();
        
        Queue<Integer> minPwdLengthPQ = new PriorityQueue<Integer>(new Comparator<Integer>(
        		) {

					public int compare(Integer o1, Integer o2) {
						// TODO Auto-generated method stub
						return o2-o1;
					}
		});
        Queue<Integer> maxPwdLengthPQ = new PriorityQueue<Integer>();
        
        PrintStream printStreamToFile = new PrintStream(new FileOutputStream("PRDSL1DataSheet.txt", true));
        System.setOut(printStreamToFile);
        
        while(envDataSheetItr.hasNext())
        {
        	Row envcurrentRow = envDataSheetItr.next();
        	Cell envCell = envcurrentRow.getCell(0);
        	final String envCellValue = envCell.getStringCellValue();
        	final String envCellValueFIId = envCellValue.substring(7);  
            Iterator<Row> iterator = dataSheet.iterator();
            iterator.next();
		while (iterator.hasNext())
		{
			Row currentRow = iterator.next();
			
			int diId  = (int)currentRow.getCell(0).getNumericCellValue();
			if ( diId != Integer.parseInt(envCellValueFIId)) continue;
            Iterator<Cell> cellIterator = currentRow.iterator();
            
            while (cellIterator.hasNext())
            {
            	Cell cell = cellIterator.next();
            	switch (cell.getColumnIndex()) {
				case 0:
					diId = (int)cell.getNumericCellValue();
					break;
	           
				//collect pwd min lengths across apps

				case 3:
				case 6:
				case 8:
				case 10:
				case 12:
					minPwdLengthPQ.add((int)cell.getNumericCellValue());
					break;
					
				// collect pwd max lengths across apps
				case 4:
				case 5:
				case 7:
				case 9:
				case 11:
				case 13:
					maxPwdLengthPQ.add((int)cell.getNumericCellValue());
					break;
				default:
					break;
				}
            }
            final int DEFAULT_MIN_LENGTH = minPwdLengthPQ.isEmpty() ? 6 : minPwdLengthPQ.peek() ;
            final int DEFAULT_MAX_LENGTH = maxPwdLengthPQ.isEmpty() ? 32 : maxPwdLengthPQ.peek();
            System.out.println("UPDATE USP_FI0"+diId+".FI_PASSWORD_POLICY SET DEFAULT_MIN_LENGTH="+DEFAULT_MIN_LENGTH+", DEFAULT_MAX_LENGTH="+DEFAULT_MAX_LENGTH+ " WHERE FI_ID=0"+diId+";");
            diId = 0;
            minPwdLengthPQ.clear();
            maxPwdLengthPQ.clear();
		}
       }
	}
	
}
