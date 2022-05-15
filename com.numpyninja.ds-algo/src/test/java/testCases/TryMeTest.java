package testCases;

import org.testng.annotations.Test;

import Utilities.Logs;
import pageObjects.BaseClass;
import pageObjects.LinkedListPage;
import pageObjects.TryMePage;

public class TryMeTest extends BaseClass {
	
	@Test(priority = 5,groups="Sanity")
	public void t01_try_here() throws InterruptedException {
		Logs.startTestCase("t01_try_here");
		
		TryMePage tryme = new TryMePage(getDriver());
		tryme.click_try_me_linkedlist();
		Logs.info("Try Here button for Linked list clicked");
	}

	

}
