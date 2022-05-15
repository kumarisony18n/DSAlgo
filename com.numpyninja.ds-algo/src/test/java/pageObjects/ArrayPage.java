package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ArrayPage extends BaseClass {
	
	WebDriver driver = null;
	
	public ArrayPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(getDriver(),this);
		
	}
	
	@FindBy(how=How.XPATH,using="//a[@href='arrays-in-python']")
	public static WebElement array_in_python;
	
	public boolean isPageTitleDisplayed() {
		boolean flag= array_in_python.isDisplayed();
		return flag;
	}
	
	public void verifyPageTitle() {
		String expTitle = "Array";
		Assert.assertEquals(getDriver().getTitle(), expTitle);
	}
		
	public void click_array_in_python() throws InterruptedException {
		Thread.sleep(2000);
		array_in_python.click();
	}

}
