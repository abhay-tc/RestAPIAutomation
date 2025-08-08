package api.utilities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	
//	@DataProvider(name = "AllData")
//	public String[][] AllDataProviders() {
//	    String fName = System.getProperty("user.dir") + "//TestData//Data Driven Testing.xlsx";
//
//	    int ttRowCnt = ReadExcelFile.getRowCount(fName, "Sheet1");
//	    int ttColCnt = ReadExcelFile.getColCount(fName, "Sheet1");
//
//	    String[][] userData = new String[ttRowCnt][ttColCnt];
//
//	    for (int rowNo = 1; rowNo < ttRowCnt; rowNo++) {
//	        for (int colNo = 0; colNo < ttColCnt; colNo++) {
//	            userData[rowNo - 1][colNo] = ReadExcelFile.getCellValue(fName, "Sheet1", rowNo, colNo);
//	        }
//	    }
//
//	    return userData;
//	}

	@DataProvider(name = "AllData")
	public String[][] AllDataProviders() {
	    String fName = System.getProperty("user.dir") + "//TestData//Data Driven Testing.xlsx";

	    int ttRowCnt = ReadExcelFile.getRowCount(fName, "Sheet1");
	    int ttColCnt = ReadExcelFile.getColCount(fName, "Sheet1");

	    String[][] userData = new String[ttRowCnt][ttColCnt];

	    for (int rowNo = 1; rowNo <= ttRowCnt; rowNo++) {
	        for (int colNo = 0; colNo < ttColCnt; colNo++) {
	            userData[rowNo - 1][colNo] = ReadExcelFile.getCellValue(fName, "Sheet1", rowNo, colNo);
	        }
	    }

	    return userData;
	}

	
	@DataProvider(name="UserNamesData")
	public String [] UserNamesDataProviders()
	{
		String fName = System.getProperty("user.dir")+"//TestData//Data Driven Testing.xlsx";
		
		int ttRowCnt = ReadExcelFile.getRowCount(fName, "Sheet1");
	
		
		String UserNamesData[] = new String[ttRowCnt];
		
		for(int rowNo=1; rowNo<=ttRowCnt; rowNo++)
		{
			UserNamesData[rowNo-1] = ReadExcelFile.getCellValue(fName, "Sheet1", rowNo, 1);
		}
		
		return UserNamesData;
	}
	
	
	
}
