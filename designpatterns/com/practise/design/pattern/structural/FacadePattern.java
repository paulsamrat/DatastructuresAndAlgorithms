package com.practise.design.pattern.structural;

import java.sql.Connection;

/*
 * Suppose we have an application with set of interfaces to use MySql/Oracle database and to generate different types of reports,
 *  such as HTML report, PDF report etc. So we will have different set of interfaces to work with different types of database. 
 *  Now a client application can use these interfaces to get the required database connection and generate reports. 
 *  But when the complexity increases or the interface behavior names are confusing, 
 *  client application will find it difficult to manage it. 
 *  So we can apply Facade pattern here and provide a wrapper interface on top of the existing interface to help client application.
 */
public class FacadePattern {

	
	private static class MySqlHelper {
	     
	    public static Connection getMySqlDBConnection(){
	        //get MySql DB connection using connection parameters
	        return null;
	    }
	     
	    public void generateMySqlPDFReport(String tableName, Connection con){
	        //get data from table and generate pdf report
	    }
	     
	    public void generateMySqlHTMLReport(String tableName, Connection con){
	        //get data from table and generate pdf report
	    }
	}
	
	private static  class OracleHelper {
		 
	    public static Connection getOracleDBConnection(){
	        //get Oracle DB connection using connection parameters
	        return null;
	    }
	     
	    public void generateOraclePDFReport(String tableName, Connection con){
	        //get data from table and generate pdf report
	    }
	     
	    public void generateOracleHTMLReport(String tableName, Connection con){
	        //get data from table and generate pdf report
	    }
	     
	}
	
	
	private static class HelperFacade {
		 
	    public static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName){
	        Connection con = null;
	        switch (dbType){
	        case MYSQL: 
	            con = MySqlHelper.getMySqlDBConnection();
	            MySqlHelper mySqlHelper = new MySqlHelper();
	            switch(reportType){
	            case HTML:
	                mySqlHelper.generateMySqlHTMLReport(tableName, con);
	                break;
	            case PDF:
	                mySqlHelper.generateMySqlPDFReport(tableName, con);
	                break;
	            }
	            break;
	        case ORACLE: 
	            con = OracleHelper.getOracleDBConnection();
	            OracleHelper oracleHelper = new OracleHelper();
	            switch(reportType){
	            case HTML:
	                oracleHelper.generateOracleHTMLReport(tableName, con);
	                break;
	            case PDF:
	                oracleHelper.generateOraclePDFReport(tableName, con);
	                break;
	            }
	            break;
	        }
	         
	    }
	    public static enum DBTypes{
	        MYSQL,ORACLE;
	    }
	     
	    public static enum ReportTypes{
	        HTML,PDF;
	    }
	}
	
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String tableName="Employee";
        
        //generating MySql HTML report and Oracle PDF report without using Facade
        Connection con = MySqlHelper.getMySqlDBConnection();
        MySqlHelper mySqlHelper = new MySqlHelper();
        mySqlHelper.generateMySqlHTMLReport(tableName, con);
         
        Connection con1 = OracleHelper.getOracleDBConnection();
        OracleHelper oracleHelper = new OracleHelper();
        oracleHelper.generateOraclePDFReport(tableName, con1);
        //generating MySql HTML report and Oracle PDF report using Facade
        HelperFacade.generateReport(FacadePattern.HelperFacade.DBTypes.MYSQL, FacadePattern.HelperFacade.ReportTypes.HTML, tableName);
        HelperFacade.generateReport(FacadePattern.HelperFacade.DBTypes.ORACLE, FacadePattern.HelperFacade.ReportTypes.PDF, tableName);
	}
    
}
