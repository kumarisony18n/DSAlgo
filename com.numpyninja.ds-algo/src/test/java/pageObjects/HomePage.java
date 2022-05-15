package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HomePage extends BaseClass {
	
	WebDriver driver = null;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(getDriver(),this);
	}
	@CacheLookup
	@FindBy(how=How.LINK_TEXT,using="Sign in")
	 public static WebElement sign_in;
	
	@FindBy(how=How.XPATH,using="//a[@href='linked-list']")
	 public static WebElement linked_list;
	
	@FindBy(how=How.XPATH,using="//a[@data-toggle='dropdown']")
	 public static List<WebElement> dropdown;
	
	@FindBy(how=How.XPATH,using="//a[@href='array']")
	 public static WebElement array;
	
	/*@FindBy(how=How.LINK_TEXT,using="Sign out")
	 public static WebElement sign_out;*/
	
	public void click_sign_in() throws InterruptedException{
		
		sign_in.click();
		
	}
	
	public LinkedListPage click_linked_list() throws InterruptedException {
		
		boolean editStatus = driver.findElement(By.xpath("//a[@href='linked-list']"))
			      .isDisplayed();
		if(editStatus) {
		linked_list.click();
		
		}	
		
		return new LinkedListPage(driver);
	}
	
	public void selectByArray(String visibletext, WebElement array) {
		/*driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/div[1]/div/div/a")).click();
		List<WebElement> dropdown = driver.findElements(By.xpath("//div[@class='dropdown-menu show']/a"));
		System.out.println("Number of options: " + dropdown.size());
		for(WebElement ds:dropdown)
		{
			if(ds.getText().equals("Array"))
			{
				ds.click();
				break;
			}
		}*/
		boolean editStatus = driver.findElement(By.xpath("//a[@href='array']"))
			      .isDisplayed();
		if(editStatus) {
		
			array.click();
		}
		//return new ArrayPage(getDriver());
	}
	
	/*public void click_sign_out() throws InterruptedException{
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", sign_out);
		sign_out.click();
		getDriver().navigate().to(properties.getProperty("URL"));
	}*/
	
		
}
