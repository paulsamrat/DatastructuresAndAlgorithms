package com.practise.programs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParserMain {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		String directoryName = "/Users/sp250521/Documents/WORKSPACE/CAPS/tmptob/environment/pte1/cas/configs/fi/";
		//PrintStream printStreamToFile = new PrintStream(new FileOutputStream("prodcasDataSheet.txt", true));
        //System.setOut(printStreamToFile);
		findXml(directoryName);
		
	}
	
	private static void findXml(String directoryName)
	{	
		File directory = new File(directoryName);
		File[] files = directory.listFiles();
		for (File file : files)
		{
			if (file.isDirectory())
			{
				findXml(file.getAbsolutePath());
			}
			else if (file.isFile() && ( file.getName().contains("cas.xml") || file.getName().contains("env.xml")))
			{
				parseXml(file);
			}
		}
	}

	private static void parseXml(File file) {
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
//							if ( file.getName().contains("cas.xml"))
//							{
//							final String pwdMinLength = (null != eElement.getElementsByTagName("minPasswordLength").item(0)) ? eElement.getElementsByTagName("minPasswordLength").item(0).getTextContent() : null;
//							final String pwdMaxLength = ( null != eElement.getElementsByTagName("maxPasswordLength").item(0)) ? eElement.getElementsByTagName("maxPasswordLength").item(0).getTextContent() : null;
//							final String fiId = file.getName().substring(0, 5);
//							if ( null != pwdMinLength && null != pwdMaxLength)
//								System.out.println("UPDATE &SCHEMAOWNER."+fiId+".FI_PASSWORD_POLICY SET DEFAULT_MIN_LENGTH="
//										+ pwdMinLength + ", DEFAULT_MAX_LENGTH=" + pwdMaxLength + " WHERE FI_ID=" + fiId);
//							}
							if (file.getName().contains("env.xml"))
							{
								final String schemaName = eElement.getElementsByTagName("schemaName").item(0).getTextContent();
								System.out.println("&SCHEMAOWNER."+file.getName().substring(0, 5)+"="+schemaName);
							}
							
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

}
