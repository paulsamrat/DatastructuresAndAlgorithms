package com.practise.programs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParserMain2 {
	
	private final static String DOC_TO_UPDATE = "/Users/sp250521/Documents/LEARNING/AIMS/FI_Password_Lengths_DEV_QA_PTE.xlsx";
	private final static String CAPS_VALUE_XML_LOC= "/Users/sp250521/Documents/LEARNING/AIMS/com.intuit.ifs.usp.maxPasswordLength.xml";
	private final static String CAS_DIRECTORY_LOC= "/Users/sp250521/Documents/WORKSPACE/CAPS/tmptob/environment/prod/cas/configs/fi/";
	private final static int SHEET_NO_TO_UPDATE = 3;
	
	class PasswordMinMaxData
	{
		private int pwdMinLength;
		private int pwdMaxLength;
		
		PasswordMinMaxData(int minLength , int maxLength)
		{
			this.pwdMinLength = minLength;
			this.pwdMaxLength = maxLength;
		}

		/**
		 * @return the pwdMinLength
		 */
		public int getPwdMinLength() {
			return pwdMinLength;
		}

		/**
		 * @return the pwdMaxLength
		 */
		public int getPwdMaxLength() {
			return pwdMaxLength;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//PrintStream printStreamToFile = new PrintStream(new FileOutputStream("prod.com.intuit.ifs.usp.minPasswordLength.text", true));
        //System.setOut(printStreamToFile);
		parseCAPSXml(new File(CAPS_VALUE_XML_LOC));
		findAndParseCASXml(CAS_DIRECTORY_LOC);
	}
	//pre process caps xml
	private static void parseCAPSXml(File file) {
		try 
		{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		doc.getDocumentElement().normalize();
		NodeList nodeList = doc.getElementsByTagName("preference");
		if ( null != nodeList && nodeList.getLength() > 0 )
		{	
			Map<Integer,Integer> fiValuesMap =  new HashMap<Integer,Integer>();
			for (int i = 0; i < nodeList.getLength(); i++) 
			{
	            Node node = nodeList.item(i);
	            Element eElement = (Element) node;
	            final Integer fiId = Integer.valueOf(eElement.getElementsByTagName("fiId").item(0).getTextContent());
	            final Integer value = Integer.valueOf(eElement.getElementsByTagName("values").item(0).getTextContent());
	            fiValuesMap.put(fiId, value);
			}
			updateSheetForCAPSValue(DOC_TO_UPDATE,SHEET_NO_TO_UPDATE,4,fiValuesMap); //3--prod sheet 
        }
		}
		catch (ParserConfigurationException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void findAndParseCASXml(String directoryName) throws IOException
	{	
		File directory = new File(directoryName);
		File[] files = directory.listFiles();
		Map<Integer,PasswordMinMaxData> fiPwdMinMaxDataMap =  new HashMap<Integer,PasswordMinMaxData>();
		for (File file : files)
		{
			if (file.isDirectory())
			{
				findAndParseCASXml(file.getAbsolutePath());
			}
			else if (file.isFile() && ( file.getName().contains("cas.xml") || file.getName().contains("env.xml")))
			{
				parseCASXml(file,fiPwdMinMaxDataMap);
			}
		}
		updateSheetForXMLValue(DOC_TO_UPDATE,SHEET_NO_TO_UPDATE,4,5,fiPwdMinMaxDataMap);

	}

	private static void parseCASXml(File file , Map<Integer,PasswordMinMaxData> fiPwdDataMap) {
		try 
		{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		doc.getDocumentElement().normalize();
		NodeList nodeList = null;
		if ( file.getName().contains("cas.xml"))
		{
			nodeList = doc.getElementsByTagName("authentication");
		}
		else if (file.getName().contains("env.xml"))
		{
			nodeList = doc.getElementsByTagName("fiUDB");
		}
				if ( null != nodeList && nodeList.getLength() > 0 )
				{
					for (int i = 0 ; i <  nodeList.getLength() ; i++)
					{
						Node node = nodeList.item(i);
						if (node.getNodeType() == Node.ELEMENT_NODE)
				         {
							Element eElement = (Element) node;
							if ( file.getName().contains("cas.xml"))
							{
							final String pwdMinLength = (null != eElement.getElementsByTagName("minPasswordLength").item(0)) ? eElement.getElementsByTagName("minPasswordLength").item(0).getTextContent() : null;
							final String pwdMaxLength = ( null != eElement.getElementsByTagName("maxPasswordLength").item(0)) ? eElement.getElementsByTagName("maxPasswordLength").item(0).getTextContent() : null;
							final String fiId = file.getName().substring(0, 5);
							if ( null != pwdMinLength || null != pwdMaxLength)
							{
								PasswordMinMaxData pwdData = new XMLParserMain2().new PasswordMinMaxData(Integer.parseInt(pwdMinLength), Integer.parseInt(pwdMaxLength));
								fiPwdDataMap.put(Integer.parseInt(fiId), pwdData);
							}
								//System.out.println("UPDATE &SCHEMAOWNER."+fiId+".FI_PASSWORD_POLICY SET DEFAULT_MIN_LENGTH="
										//+ pwdMinLength + ", DEFAULT_MAX_LENGTH=" + pwdMaxLength + " WHERE FI_ID=" + fiId);
							}
//							else if (file.getName().contains("env.xml"))
//							{
//								final String schemaName = eElement.getElementsByTagName("schemaName").item(0).getTextContent();
//								System.out.println("&SCHEMAOWNER."+file.getName().substring(0, 5)+"="+schemaName);
//							}
							
					      }
					}
					
				}
			
		}
		catch (ParserConfigurationException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void updateSheetForCAPSValue(final String docLocation , final Integer sheetNumber , final Integer cellNumber , Map<Integer,Integer> fiValuesMap) throws IOException
	{
		FileInputStream passwordLengthsExcelFIS = new FileInputStream(new File(docLocation));
        Workbook passwordLengthsExcelWorkBook = new XSSFWorkbook(passwordLengthsExcelFIS);

        Sheet dataSheet = passwordLengthsExcelWorkBook.getSheetAt(sheetNumber);
        Iterator<Row> iterator = dataSheet.iterator();
        iterator.next();
        while(iterator.hasNext())
        {
        	Row currentRow = iterator.next();
        	final Integer diId = (int)currentRow.getCell(0).getNumericCellValue();
        	if (null != diId && fiValuesMap.containsKey(diId))
        	{
        		Cell cellToUpdate = currentRow.getCell(cellNumber);
        		if ( null == cellToUpdate) 
        		{
        			currentRow.createCell(cellNumber).setCellValue(fiValuesMap.get(diId));
        		}
        		else
        		{
        			cellToUpdate.setCellValue(fiValuesMap.get(diId));
        		}
        	}
        }
        passwordLengthsExcelFIS.close();
        FileOutputStream passwordLengthsExcelFOS = new FileOutputStream(new File(docLocation));
        passwordLengthsExcelWorkBook.write(passwordLengthsExcelFOS);
        passwordLengthsExcelWorkBook.close();
        passwordLengthsExcelFOS.close();

	}
	
	private static void updateSheetForXMLValue(final String docLocation , final Integer sheetNumber , final Integer minPwdLengthCellNumber , final Integer maxPwdLengthCellNumber , Map<Integer,PasswordMinMaxData> pwdMinMaxDataMap) throws IOException
	{
		FileInputStream passwordLengthsExcelFIS = new FileInputStream(new File(docLocation));
        Workbook passwordLengthsExcelWorkBook = new XSSFWorkbook(passwordLengthsExcelFIS);

        Sheet dataSheet = passwordLengthsExcelWorkBook.getSheetAt(sheetNumber);
        Iterator<Row> iterator = dataSheet.iterator();
        iterator.next();
        while(iterator.hasNext())
        {
        	Row currentRow = iterator.next();
        	final Integer diId = (int)currentRow.getCell(0).getNumericCellValue();
        	if (null != diId && pwdMinMaxDataMap.containsKey(diId))
        	{	
        		PasswordMinMaxData pwdMinMaxData = pwdMinMaxDataMap.get(diId);

        		Cell cellToUpdateForMinLength  = currentRow.getCell(minPwdLengthCellNumber);
        		Cell cellToUpdateForMaxLength  = currentRow.getCell(maxPwdLengthCellNumber);

        		if ( null == cellToUpdateForMinLength) 
        		{	
        			currentRow.createCell(minPwdLengthCellNumber).setCellValue(pwdMinMaxData.getPwdMinLength());
        		}
        		else
        		{
        			cellToUpdateForMinLength.setCellValue(pwdMinMaxData.getPwdMinLength());
        		}
        		if ( null == cellToUpdateForMaxLength) 
        		{	
        			currentRow.createCell(maxPwdLengthCellNumber).setCellValue(pwdMinMaxData.getPwdMaxLength());
        		}
        		else
        		{
        			cellToUpdateForMaxLength.setCellValue(pwdMinMaxData.getPwdMaxLength());
        		}
        	}
        }
        passwordLengthsExcelFIS.close();
        FileOutputStream passwordLengthsExcelFOS = new FileOutputStream(new File(docLocation));
        passwordLengthsExcelWorkBook.write(passwordLengthsExcelFOS);
        passwordLengthsExcelWorkBook.close();
        passwordLengthsExcelFOS.close();

	}
}
