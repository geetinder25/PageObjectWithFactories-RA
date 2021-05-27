package com.w2a.base;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.pages.actions.TopNavigation;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {
	
	public static WebDriver driver;
	public static Logger log=Logger.getLogger(Page.class.getName());
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep=ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	public static TopNavigation topNav;
	
	public static void initConfiguration() {
		
		//link the log4j properties file
		Date d =new Date();
		System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));
		PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");
		log.info("Logs started");
		
		//Jenkins browser filter configuration
		if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()) {
			browser=System.getenv("browser");
		}else {
			browser=Constants.browser;
		}
		
		
		if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			log.debug("Firefox Launched");
		} else if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			
			driver=new ChromeDriver(options);
			log.debug("Chrome Launched");
			
		} else if(browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			log.debug("Internet Explorer Launched");
		}
		
		driver.get(Constants.testSiteURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.implicitWait, TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, 10); 
		
		topNav=new TopNavigation(driver);
	}

	public static void quitBrowser() {
		driver.quit();
	}
	
	//common keywords implementation
	public static void click(WebElement element) {
		element.click();
		log.debug("Clicking on element: "+element);
		test.log(LogStatus.INFO, "Clicking on: "+element);
	}
	
	public void type(WebElement element, String value) {
		element.sendKeys(value);
		log.debug("Typing in: "+element+" entered value as: "+value );
		test.log(LogStatus.INFO, "Typing in: "+element+" entered value as: "+value);
	} 

}
