package testCases;

import org.testng.annotations.Test;

import Utilities.Logs;
import pageObjects.BaseClass;
import pageObjects.LinkedListPage;
import pageObjects.TryMePage;

public class LinkedListTest extends BaseClass {

	@Test(priority = 4,groups="Sanity")
	public void t01_create_linked_list() throws InterruptedException {
	Logs.startTestCase("t01_create_linked_list");
	LinkedListPage linkedlstpg = new LinkedListPage(getDriver());
	linkedlstpg.click_create_linked_list();
	Logs.info("Create linked list link for Linked list clicked");
	
	}
}
