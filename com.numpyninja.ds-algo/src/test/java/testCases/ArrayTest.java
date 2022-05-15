package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageObjects.ArrayPage;
import pageObjects.BaseClass;
import pageObjects.LinkedListPage;

public class ArrayTest extends BaseClass{
	
	@Test(priority = 9, groups="Smoke")
	public void t01_click_array_in_python() throws InterruptedException {
		ArrayPage arraypg = new ArrayPage(getDriver());
		boolean flag =arraypg.isPageTitleDisplayed();
		arraypg.verifyPageTitle();
		arraypg.click_array_in_python();
		assertEquals(getDriver().getTitle(), "Login");
	}
}
