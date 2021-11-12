package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import co.in.bymat.seleniumTraining.DataCollection;
import co.in.bymat.seleniumTraining.ExcelReader;

public class TestBase_B11 { // Parent Class
	
	public static WebDriver driver;
	public static Properties config;
	public static Properties or;
	public static ExtentTest test;
	public static ExtentReports report;
	public static ExcelReader excel;  
	public static String testCaseName; 
	public static Hashtable<String, String> htRunMode = new Hashtable<String, String>();
	
	@BeforeSuite
	public void initialization() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\files\\config.properties");
		config = new Properties();
		config.load(fis);
		System.out.println("Config file has been loaded");
		
		FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\files\\OR.properties");
		or = new Properties();
		or.load(fis1);
		System.out.println("OR file has been loaded");
		
		excel = new ExcelReader(System.getProperty("user.dir") +"\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		report = new ExtentReports(System.getProperty("user.dir")+"\\src\\test\\resources\\executionReports\\ExtentReportResults_"+timeStamp+".html");
		
		loadRunModeHashtable();
	}
	
	//@BeforeMethod
	public void launchBrowser() throws IOException {
		
		test = report.startTest(testCaseName);
		
		if (config.getProperty("Browser").equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver","D:\\BYMAT-Learn_Automation\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(); // Responsible to launch the browser
			test.log(LogStatus.PASS, "Chrome has been launched");
		} else if (config.getProperty("Browser").equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver","D:\\BYMAT-Learn_Automation\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			test.log(LogStatus.PASS, "FF has been launched");
		} else if (config.getProperty("Browser").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver","D:\\BYMAT-Learn_Automation\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			test.log(LogStatus.PASS, "IE has been launched");
		} else {
			System.setProperty("webdriver.edge.driver","D:\\BYMAT-Learn_Automation\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			test.log(LogStatus.PASS, "Edge has been launched");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.get(config.getProperty("Application_URL"));
		System.out.println("User Navigated to Application_URL");
		test.log(LogStatus.PASS, "User Navigated to Application_URL: " +config.getProperty("Application_URL"));
	}
	
	//@AfterMethod
	public void closeBrowser() throws InterruptedException {
		driver.quit();
		System.out.println("Driver is closed");	
		test.log(LogStatus.PASS, "Driver is closed ");
	}
	
	@AfterSuite
	public void generateReport() {
		report.endTest(test);
		report.flush();
	}
	
	public static void takeaScreenShot() throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenShotPath = System.getProperty("user.dir") +"\\src\\test\\resources\\screenShots\\Passed\\screenshot_"+timeStamp+".png";
		
		File destfile = new File(screenShotPath);
	
		FileHandler.copy(scrFile, destfile);
		
		test.log(LogStatus.PASS, test.addScreenCapture(screenShotPath));
		
	}
	
	
	public static void takeaScreenShot_failed() throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenShotPath = System.getProperty("user.dir") +"\\src\\test\\resources\\screenShots\\Failed\\screenshot_"+timeStamp+".png";
		
		File destfile = new File(screenShotPath);
	
		FileHandler.copy(scrFile, destfile);
		
		test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		
	}
	
	
	@DataProvider
	public Object[][] data_Collection() {
		
		DataCollection dc = new DataCollection(excel, "Test_data", testCaseName);
			
		return dc.dataArray();
		
	}
	
	
	public void loadRunModeHashtable() {
		
		int rows = excel.getRowCount("TestCases");
		
		for(int i = 2; i<=rows ; i++) {
		
		String key = excel.getCellData("TestCases", "TestCaseName", i);
		
		String value = excel.getCellData("TestCases", "Run_Mode", i);
		
		htRunMode.put(key, value);
		}
		
		System.out.println("HashTable Run Mode :- " +htRunMode);
	}
	
	
}
