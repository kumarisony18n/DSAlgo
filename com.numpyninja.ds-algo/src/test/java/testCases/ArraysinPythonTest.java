package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.Logs;
import pageObjects.ArraysinPythonPage;
import pageObjects.BaseClass;
import pageObjects.HomePage;


public class ArraysinPythonTest extends BaseClass {
	
	
	@Test(priority = 10, groups="Smoke")
	public void t01_create_arrays() throws InterruptedException {
		Logs.startTestCase("Inside t01_create_arrays");
		ArraysinPythonPage arraypython = new ArraysinPythonPage(getDriver());
		arraypython.click_try_me_arrays();
		Logs.info("Try here button for Arrays has been clicked.");
	}
	
	

}
