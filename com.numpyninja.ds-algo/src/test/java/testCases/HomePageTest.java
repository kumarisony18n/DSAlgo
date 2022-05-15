package testCases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.Logs;
import pageObjects.ArrayPage;
import pageObjects.BaseClass;
import pageObjects.HomePage;
import pageObjects.LinkedListPage;

public class HomePageTest extends BaseClass {
	
	BaseClass base = new BaseClass();
	LinkedListPage linkedlistpg = new LinkedListPage(getDriver());
	ArrayPage arraypg = new ArrayPage(getDriver());
	
	@Test(priority = 1,groups="Regression")
	public void t01_sign_in() throws InterruptedException {
		
		HomePage homepg = new HomePage(getDriver());
		Logs.startTestCase("t01_sign_in");
		homepg.click_sign_in();
		
		String expected = "Login";
		String actual = getDriver().getTitle();
		
		if(actual.equals(expected)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		Logs.endTestCase("t01_sign_in");
	}
	
	@Test(priority = 3,groups="Sanity")
	public void t03_press_linked_list() throws InterruptedException{
		HomePage homepg = new HomePage(getDriver());
		Logs.startTestCase("t03_press_linked_list");
		Thread.sleep(2000);
		try {
			//homepg.clickHref();
		linkedlistpg = homepg.click_linked_list();
		Logs.info("Linked list is selected");
		}
		catch(Throwable t) {
			System.out.println("Element not displayed");
		}
		Logs.endTestCase("t03_press_linked_list");
	}
		
	@Test(priority = 8, groups="Smoke")
	public void t04_select_array() throws InterruptedException{
		HomePage homepg = new HomePage(getDriver());
		Logs.startTestCase("t04_select_array");
		Thread.sleep(2000);
		try {
				//homepg.clickHref();
			homepg.selectByArray("Array", HomePage.array);
			Logs.info("Array is selected");
			
		}
		catch(Throwable t) {
			System.out.println("Element not displayed");
		}	
		Logs.endTestCase("t04_select_array");
}
	
	
	
	
}
