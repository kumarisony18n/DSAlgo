package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class GetstartedPage extends BaseClass {
	
	WebDriver driver = null;
	
	public GetstartedPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.XPATH,using="//button[@class='btn']")
	 public static WebElement btn_getstarted;
	
	public HomePage click_btngetstarted() throws InterruptedException {
		Thread.sleep(2000);
		btn_getstarted.click();
		return new HomePage(driver);
	}

}
