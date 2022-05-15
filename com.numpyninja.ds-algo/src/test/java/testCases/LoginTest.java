package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import Utilities.ExcelUtils;
import Utilities.Logs;
import pageObjects.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginTest extends BaseClass {
	
	HomePage homepg;
	
	@Test(priority = 2,groups="Regression", dataProvider="LoginData")
	public void t02_LoginTest(String username, String password) {
		Logs.info("This is loginTest");
		LoginPage loginpg = new LoginPage(getDriver());
		loginpg.EnterUsername(username);
		loginpg.EnterPassword(password);
		homepg=loginpg.clickLogin();
		
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		Logs.info("gettting data from excel for Login");
		String file_path = properties.getProperty("file_path");
		//String login_sheet = properties.getProperty("login_sheet");
		int rownum = ExcelUtils.getRowCount(file_path, "Sheet1");
		int colnum = ExcelUtils.getCellCount(file_path, "Sheet1", 1);
		
		String logindata[][] = new String[rownum][colnum];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++) 
			{
				logindata[i-1][j]= ExcelUtils.getCellData(file_path, "Sheet1", i, j);
			}
		}
		return logindata;
	}

}
