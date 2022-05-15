package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	
	WebDriver driver = null;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@CacheLookup
	@FindBy(how=How.XPATH,using="//input[@name='username']")
	 public static WebElement txt_username;
	
	@CacheLookup
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	 public static WebElement txt_password;
	
	@CacheLookup
	@FindBy(how=How.XPATH,using="//input[@type='submit']")
	 public static WebElement btn_login;
	
	public void EnterUsername(String text) {
		txt_username.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		txt_username.sendKeys(text);
	}
	
	public void EnterPassword(String text) {
		txt_password.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		txt_password.sendKeys(text);
	}
	
	public HomePage clickLogin() {
		btn_login.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return new HomePage(driver);
	}
	
	
	
	

}
