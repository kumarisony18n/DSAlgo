package pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.*;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.ExtentManager;
import Utilities.Logs;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
 //public  WebDriver driver = null;
 
 public static Properties properties = null;
 public HomePage homepg;
 
//Declare ThreadLocal Driver
 public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
 	public Properties loadPropertyFile() throws IOException {
 		ExtentManager.extentTest();
 		FileInputStream fileInputStream = new FileInputStream("./src/test/resources/Configuration_files/Config.properties");
 		properties = new Properties();
 		properties.load(fileInputStream);
 		return properties;
 		
 	}
 	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

 	@BeforeSuite(groups= {"Regression","Sanity"})
 	public void SetUp() throws IOException {
 		loadPropertyFile();
 		DOMConfigurator.configure("log4j.xml");
 		String browser = properties.getProperty("browser");
 		String url = properties.getProperty("URL");
 		
 		if(browser.equalsIgnoreCase("Chrome")) {
 			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
 			
 			
 		}
 		else if(browser.equalsIgnoreCase("Firefox")) {
 			WebDriverManager.firefoxdriver().setup();
 			driver.set(new FirefoxDriver());
 	}
 		
 	// To maximize browser
 		getDriver().manage().window().maximize();
 		getDriver().manage().deleteAllCookies();
 		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
 		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 		getDriver().get(url);
        //homepg = new HomePage(driver);
        
 	}
 	
 	
 	public String screenShot(WebDriver driver, String filename) throws Exception {
 		Logs.info("This is screenShot method");
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		//File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}
 	
 	
	@AfterSuite(groups= {"Regression","Sanity"})
	public void tearDown()
	{
		ExtentManager.endReport();
		getDriver().quit();
	}


}
