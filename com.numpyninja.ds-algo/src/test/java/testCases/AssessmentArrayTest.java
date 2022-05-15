package testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelUtils;
import Utilities.Logs;
import pageObjects.ArrayPage;
import pageObjects.ArraysinPythonPage;
import pageObjects.AssessmentArray;
import pageObjects.AssessmentPage;
import pageObjects.BaseClass;
import pageObjects.HomePage;

public class AssessmentArrayTest extends BaseClass{
	
	HomePage homepg;
	ArraysinPythonPage arraypython;
	ArrayPage arraypg;

	@Test(priority = 11, groups = "Smoke", dataProvider ="ProgramData")
	public void t01_click_runtest(String code) {
		AssessmentArray assessment = new AssessmentArray(getDriver());
		
		assessment.enterCode(code);
		Logs.info("Python code has been entered");
		assessment.click_Run();
		Logs.endTestCase("Run button for Array has been clicked");
		//Assert.assertTrue(false);
	}
	
	@DataProvider(name="ProgramData")
	public String[][] getData() throws IOException{
		
		String file_path = properties.getProperty("file_path");
		//String code_sheet = properties.getProperty("Sheet2");
		int rownum = ExcelUtils.getRowCount(file_path, "Sheet2");
		int colnum = ExcelUtils.getCellCount(file_path, "Sheet2", 1);
		
		String logindata[][] = new String[rownum][colnum];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++) 
			{
				logindata[i-1][j]= ExcelUtils.getCellData(file_path, "Sheet2", i, j);
			}
		}
		return logindata;
	}
}
