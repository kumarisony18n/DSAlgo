package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LinkedListPage extends BaseClass {

	WebDriver driver = null;
	
	public LinkedListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(getDriver(),this);
	}
	
	@FindBy(how=How.XPATH,using="//a[@href='creating-linked-list']")
	public static WebElement create_linked_list;
		
	public void click_create_linked_list() throws InterruptedException {
		Thread.sleep(2000);
		create_linked_list.click();
	}
}
