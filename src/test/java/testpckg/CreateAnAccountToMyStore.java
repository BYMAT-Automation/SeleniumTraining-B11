package testpckg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import co.in.bymat.seleniumTraining.ExcelReader;

public class CreateAnAccountToMyStore {
	static WebDriver driver;
	public static Properties config;
	public static Properties or;
	public static ExcelReader excel;
	public static ExtentTest test;
	public static ExtentReports report;
	String timeStamp= new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
	
@BeforeMethod
	public void getBrowser() throws IOException {
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\files\\config_properties");
		  config= new Properties();
		  config.load(fis);
		  System.out.println("Config file has been loaded");
		  FileInputStream fis1= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\files\\OR_properties");
		  or= new Properties();
		  or.load(fis1);
		  System.out.println("OR file has been loaded");		  
		  report = new ExtentReports(System.getProperty("user.dir")+"src\\test\\resources\\executionReports\\ExtentReportResults_"+timeStamp+".html");
		  test = report.startTest("CreateAnAccountToMyStore");
		  excel= new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
	
System.setProperty("webdriver.gecko.driver", "D:\\Selenium_Drivers\\GeckoDriver\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.get("http://automationpractice.com/index.php");
	driver.get(config.getProperty("Application_URL"));
	test.log(LogStatus.PASS, "Navigated to specified URL");
}
	public static void takeScreenshot() throws IOException
	{
		//TakesScreenshot screenshot=((TakesScreenshot)driver);
		String timeStamp= new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenShotPath=System.getProperty("user.dir")+"\\src\\test\\resources\\screenShots_"+timeStamp+".png";
		File DestFile= new File(screenShotPath);
		FileHandler.copy(srcFile, DestFile);
		test.log(LogStatus.PASS, test.addScreenCapture(screenShotPath));// copy passed test cases screenshot
	}
  @Test(priority=1)
  public void createAnAccountToMyStore() throws Exception {
	  String page_title= driver.getTitle();
	  Assert.assertEquals(page_title, excel.getCellData("Test_data", "Page_title", 2));
	 // Assert.assertTrue(5>3, "It is not greater");
	 // Assert.assertEquals(page_title, "My Store");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(or.getProperty("SignIn_btn"))).click();
	  test.log(LogStatus.PASS, "Clicked on sign in button successfully");
	  takeScreenshot();
	  Thread.sleep(2000);
		driver.findElement(By.xpath(or.getProperty("Email_Address"))).sendKeys(excel.getCellData("Test_data", "Email", 2));
		test.log(LogStatus.PASS, "Entered data from the excel sheet");
		takeScreenshot();
		Thread.sleep(2000);
		driver.findElement(By.xpath(or.getProperty("Create_Account_btn"))).click();
		test.log(LogStatus.PASS, "Created an account successfully");
		takeScreenshot();
		//call method created above
		CreateAnAccountToMyStore lgn = new CreateAnAccountToMyStore();
		//lgn.takeScreenshot(driver, "D:\\Selenium_Workspace\\MavenProject\\src\\test\\resources\\screenShots\\" +System.currentTimeMillis()+".png");
		// take screenshot method for a single page
//		TakesScreenshot screenshot=((TakesScreenshot)driver);
//		File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
//		File destFile= new File("D:\\Selenium_Workspace\\MavenProject\\src\\test\\resources\\screenShots\\" +System.currentTimeMillis()+".png");
//		FileHandler.copy(srcFile, destFile);
		Thread.sleep(3000);
		//driver.findElement(By.xpath("/html/body/div[1]/section/main/article/div[2]/div[2]/div/p/a/span")).click();
		// call method created above
		//lgn.takeScreenshot(driver, "D:\\Selenium_Workspace\\MavenProject\\src\\test\\resources\\screenShots\\" +System.currentTimeMillis()+".png");
		// take screenshot method for a single page
//		TakesScreenshot screenshot1=((TakesScreenshot)driver);
//		File srcFile1= screenshot1.getScreenshotAs(OutputType.FILE);
//		File destFile1= new File("D:\\Selenium_Workspace\\MavenProject\\src\\test\\resources\\screenShots\\screenShot2.png");
//		FileHandler.copy(srcFile1, destFile1);
		
  }
//  @Test(priority=2)
//  public void loginFunctionality1() throws Exception {
//	  Thread.sleep(2000);
//	  driver.findElement(By.name("username")).sendKeys("bymatautomation.com");
//	  Thread.sleep(2000);
//		driver.findElement(By.name("password")).sendKeys("P@1234567");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[1]/section/main/article/div[2]/div[1]/div/form/div/div[3]")).click();
//		//call method created above
//		LoginToInstaTestNG lgn = new LoginToInstaTestNG();
//		lgn.takeScreenshot(driver, "D:\\Selenium_Workspace\\MavenProject\\src\\test\\resources\\screenShots\\" +System.currentTimeMillis()+".png");
//		// take screenshot method for a single page
////		TakesScreenshot screenshot=((TakesScreenshot)driver);
////		File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
////		File destFile= new File("D:\\Selenium_Workspace\\MavenProject\\src\\test\\resources\\screenShots\\" +System.currentTimeMillis()+".png");
////		FileHandler.copy(srcFile, destFile);
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("/html/body/div[1]/section/main/article/div[2]/div[2]/div/p/a/span")).click();
//		// call method created above
//		lgn.takeScreenshot(driver, "D:\\Selenium_Workspace\\MavenProject\\src\\test\\resources\\screenShots\\" +System.currentTimeMillis()+".png");
//		// take screenshot method for a single page
////		TakesScreenshot screenshot1=((TakesScreenshot)driver);
////		File srcFile1= screenshot1.getScreenshotAs(OutputType.FILE);
////		File destFile1= new File("D:\\Selenium_Workspace\\MavenProject\\src\\test\\resources\\screenShots\\screenShot2.png");
////		FileHandler.copy(srcFile1, destFile1);
//  }
//  
@AfterMethod
	public void closeBrowser() throws InterruptedException {
	Thread.sleep(5000);
	driver.close();
	test.log(LogStatus.PASS, "Driver is closed");
	report.endTest(test);
	report.flush();
	
}

//	@DataProvider
//	public Object[][] data_Collection(){
//		Data_Collection dc= new Data_Collection(excel, "Test_data", "")
//		
//	}


}
