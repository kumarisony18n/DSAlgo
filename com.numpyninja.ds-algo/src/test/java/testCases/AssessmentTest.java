package testCases;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelUtils;
import Utilities.Logs;
import pageObjects.AssessmentPage;
import pageObjects.BaseClass;


public class AssessmentTest extends BaseClass {
	
	@Test(priority = 6, groups = "Sanity", dataProvider ="ProgramData")
	public void t01_click_runtest(String code) {
		
		Logs.startTestCase("t01_click_runtest");
		AssessmentPage assessment = new AssessmentPage(getDriver());
		Logs.info("This is t01_click_runtest");
		assessment.enterCode(code);
		Logs.info("Python code has been entered.");
		assessment.click_Run();
		Logs.info("Run button has been clicked.");
		Logs.endTestCase("t01_click_runtest");
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
