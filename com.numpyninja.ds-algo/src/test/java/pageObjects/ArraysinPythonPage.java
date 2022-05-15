package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ArraysinPythonPage extends BaseClass {

	WebDriver driver = null;
	GetstartedPage getStart = new GetstartedPage(getDriver());
		
	public ArraysinPythonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(how=How.LINK_TEXT,using="Try here>>>")
	public static WebElement try_me;
	

	
	
	public void click_try_me_arrays() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", try_me);
		try_me.click();
	}
	
	
}
