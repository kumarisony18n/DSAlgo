package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.Logs;
import pageObjects.BaseClass;
import pageObjects.GetstartedPage;


@Test
public class GetStartedTest extends BaseClass{
	
	//WebDriver driver = null;
	@Test(priority = 0, groups = "Regression")
	public void t01_clickGetStartedBtn() throws InterruptedException {
	Logs.startTestCase("t01_clickGetStartedBtn");
	GetstartedPage startedpg = new GetstartedPage(getDriver());
	homepg = startedpg.click_btngetstarted();
	Logs.info("Clicked GetStarted button");
	 
	
	}

}
