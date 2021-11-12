package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import co.in.bymat.seleniumTraining.DataCollection;
import co.in.bymat.seleniumTraining.ExcelReader;

public class CreateAnAccountToMyStoreDadaDriven { // Data Driven framework

	public static WebDriver driver;
	public static Properties config;
	public static Properties or;
	//public static ExcelReader excel;
	public static ExtentTest test;
	public static ExtentReports report;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") +"\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
	
	String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
	
	@BeforeMethod
	public void launchBrowser() throws IOException, InterruptedException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\files\\config.properties");
		config = new Properties();
		config.load(fis);
		System.out.println("Config file has been loaded");
		
		FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\files\\OR.properties");
		or = new Properties();
		or.load(fis1);
		System.out.println("OR file has been loaded");
		
		report = new ExtentReports(System.getProperty("user.dir")+"\\src\\test\\resources\\executionReports\\ExtentReportResults_"+timeStamp+".html");
		
		test = report.startTest("CreateAnAccountToMyStore");
		
		// excel = new ExcelReader(System.getProperty("user.dir") +"\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
		
		if (config.getProperty("Browser").equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver","D:\\BYMAT-Learn_Automation\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(); // Responsible to launch the browser
		} else if (config.getProperty("Browser").equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver","D:\\BYMAT-Learn_Automation\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (config.getProperty("Browser").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver","D:\\BYMAT-Learn_Automation\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.edge.driver","D:\\BYMAT-Learn_Automation\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.get(config.getProperty("Application_URL"));
		System.out.println("User Navigated to Application_URL");
		test.log(LogStatus.PASS, "User Navigated to Application_URL");
	}
	
		@Test(dataProvider = "data_Collection")
		public void createAnAccountToMyStore(Hashtable<String, String> htData) throws IOException, InterruptedException {	
			
		String page_title = driver.getTitle();	
		
		//Assert.assertEquals(page_title, excel.getCellData("Test_data", "Page_Title", 4));
		Assert.assertEquals(page_title, htData.get("Page_Title"));
		System.out.println("Page title is verified and it is :- " +page_title);
		test.log(LogStatus.PASS , "Page title is verified and it is :- " +page_title);
		takeaScreenShot();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(or.getProperty("Sign_In_btn"))).click();
		System.out.println("User clicked on Sign_In_btn Button");
		test.log(LogStatus.PASS, "User clicked on Sign_In_btn Button");
		takeaScreenShot();
		
		Thread.sleep(3000);
		//driver.findElement(By.xpath(or.getProperty("Email_Add"))).sendKeys(excel.getCellData("Test_data", "Email_ID", 4)); 
		
		driver.findElement(By.xpath(or.getProperty("Email_Add"))).sendKeys(htData.get("Email_ID")); 
		System.out.println("User entered Email Address");
		test.log(LogStatus.PASS, "User entered Email Address");
		takeaScreenShot();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(or.getProperty("CreateAccount_btn"))).click();
		System.out.println("User clicked on Login Button");
		test.log(LogStatus.PASS, "User clicked on Login Button");
		takeaScreenShot();
		
	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		System.out.println("Driver is closed");	
		test.log(LogStatus.PASS, "Driver is closed ");
		
		report.endTest(test);
		report.flush();
	}
	
	public void takeaScreenShot() throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenShotPath = System.getProperty("user.dir") +"\\src\\test\\resources\\screenShots\\screenshot_"+timeStamp+".png";
		
		File destfile = new File(screenShotPath);
	
		FileHandler.copy(scrFile, destfile);
		
		test.log(LogStatus.PASS, test.addScreenCapture(screenShotPath));
		
	}
	
	@DataProvider
	public Object[][] data_Collection() {
		
		DataCollection dc = new DataCollection(excel, "Test_data", "CreateAnAccountToMyStore");
			
		return dc.dataArray();
		
	}


}
