package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprovider {
	
// DataProvider
	
	@DataProvider(name = "Logindata")
	public String [][] getData() throws IOException
	{
		String path =".\\Testdata\\Testdataresult.xlsx";  //taking xl file from test data
		
		ExcelUtility xlutill = new ExcelUtility(path); // creating an object for xlutility
		int totalrows = xlutill.getRowCount("Sheet1");
	    int totalcols=xlutill.getCellCount("Sheet1", 1);
	    
	    System.out.println("totalrows="+totalrows);
	    System.out.println("totalcols="+totalcols);
	    
	    String loginData [][] = new String[totalrows][totalcols]; //created for two dimensional array for storing
	    
	    for(int i=1; i<=totalrows; i++)  //1 read the data from xl storing in two dimensional array 
	    {
	    	for(int j=0; j<totalcols; j++) //0 i=rows j =cols
	    	{
	    		loginData[i-1][j]= xlutill.getCellData("Sheet1", i, j); //1,0
	    		
	    	}
	    }
	  	return loginData ;	
		
	}

}
