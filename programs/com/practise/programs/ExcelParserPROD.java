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

public class ExcelParserPROD {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		final String passwordLengthsExcel = "/Users/sp250521/Documents/LEARNING/AIMS/FI_Password_Lengths_180307_Corrected2.xlsx";
		final String udbFISchemaNamesExcel = "/Users/sp250521/Documents/LEARNING/AIMS/UDB FI schema names.xlsx";
		parseExcel(passwordLengthsExcel,udbFISchemaNamesExcel);
		
	}
	private static void parseExcel(final String passwordLengthsExcel , final String udbFISchemaNamesExcel) throws ParserConfigurationException, SAXException, IOException
	{
		FileInputStream passwordLengthsExcelFIS = new FileInputStream(new File(passwordLengthsExcel));
		//FileInputStream udbFISchemaNamesExcelFIS = new FileInputStream(new File(udbFISchemaNamesExcel));

        Workbook passwordLengthsExcelWorkBook = new XSSFWorkbook(passwordLengthsExcelFIS);
        
        //Workbook udbFISchemaNamesExcelWorkBook = new XSSFWorkbook(udbFISchemaNamesExcelFIS);

        Sheet dataSheet = passwordLengthsExcelWorkBook.getSheetAt(0);
        
       // Sheet pteDataSheet  = udbFISchemaNamesExcelWorkBook.getSheetAt(4);
        Iterator<Row> iterator = dataSheet.iterator();
        //Iterator<Row> pteDataSheetItr = pteDataSheet.iterator();
        Queue<Integer> minPwdLengthPQ = new PriorityQueue<Integer>(new Comparator<Integer>(
        		) {

					public int compare(Integer o1, Integer o2) { //highest min
						// TODO Auto-generated method stub
						return o2-o1;
					}
		});
        Queue<Integer> maxPwdLengthPQ = new PriorityQueue<Integer>(); //lowest max
        iterator.next();
        PrintStream printStreamToFile = new PrintStream(new FileOutputStream("migration.txt", true));
        System.setOut(printStreamToFile);
		while (iterator.hasNext())
		{
			Row currentRow = iterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();
            int diId = 0 ;
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
