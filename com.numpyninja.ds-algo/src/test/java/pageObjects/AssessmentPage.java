package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssessmentPage extends BaseClass {
		
		WebDriver driver = null;
		
		public AssessmentPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(getDriver(),this);
		}
		
		@FindBy(how=How.XPATH,using="//textarea[@autocorrect='off']")
		public static WebElement assessment;
		
		@FindBy(how=How.XPATH,using="//button[text()='Run']")
		public static WebElement run;		
		
		public void enterCode(String code) {
			
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			//new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(assessment)).sendKeys(code);
			assessment.sendKeys(code);
		}
		
		public void click_Run() {
			
			run.click();
			getDriver().navigate().to(properties.getProperty("URL")+"/home");
		}
}	
	

