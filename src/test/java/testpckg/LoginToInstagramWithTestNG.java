package testpckg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.testng.annotations.Test;

import co.in.bymat.seleniumTraining.ExcelReader;

public class LoginToInstagramWithTestNG {

	public static WebDriver driver;
	public static Properties config;
	public static Properties or;
	public static ExcelReader excel;
	//public static String browser = "CHROME";
	
	
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
		
		excel = new ExcelReader(System.getProperty("user.dir") +"\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
		
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
	    
//		driver.get("https://www.instagram.com/");
		driver.get(config.getProperty("Application_URL"));
		System.out.println("User Navigated to Application_URL");
	}
	
		@Test()
		public void loginToInstagramWithTestNG() throws IOException, InterruptedException {	
			
		String page_title = driver.getTitle();	
		
		Assert.assertEquals(page_title, "Instagram");
		System.out.println("Page title is verified and it is :- " +page_title);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(or.getProperty("UserName"))).sendKeys(excel.getCellData("Test_data", "Email_ID", 4)); 
		takeaScreenShot();
		System.out.println("User entered Email Address");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(or.getProperty("Paswd"))).sendKeys(excel.getCellData("Test_data", "Password", 4));
		takeaScreenShot();
		System.out.println("User entered password");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(or.getProperty("Login_btn"))).click();
		takeaScreenShot();
		System.out.println("User clicked on Login Button");
	}

	//  @Test(priority = 3, enabled = false)
		
	  @Test
		public void loginToInstagramWithTestNG2() throws IOException, InterruptedException {	
			
			String page_title = driver.getTitle();	
			
			Assert.assertEquals(page_title, "Instagram");
			System.out.println("Page title is verified and it is :- " +page_title);
			
			Thread.sleep(3000);
			driver.findElement(By.xpath(or.getProperty("UserName"))).sendKeys(excel.getCellData("Test_data", "Email_ID", 5)); 
			takeaScreenShot();
			System.out.println("User entered Email Address");
			
			Thread.sleep(2000);
			driver.findElement(By.xpath(or.getProperty("Paswd"))).sendKeys(excel.getCellData("Test_data", "Password", 5));
			takeaScreenShot();
			System.out.println("User entered password");
			
			Thread.sleep(2000);
			driver.findElement(By.xpath(or.getProperty("Login_btn"))).click();
			takeaScreenShot();
			System.out.println("User clicked on Login Button");
		
	}
		
	//	@Test(priority = 1)
		public void loginToInstagramWithTestNG3() throws IOException, InterruptedException {	
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input")).sendKeys("response@bymat.co.in"); // Absolute Xpath
		//driver.findElement(By.xpath("//*[@name=\"username\"]")).sendKeys("response@bymat.co.in");  // Relative Xpath
		takeaScreenShot();
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input")).sendKeys("MyPassword");
		//driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys("MyPassword");
		takeaScreenShot();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button/div")).click();
		//driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
		takeaScreenShot();
	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		System.out.println("Driver is closed ");	
	}
	
	public void takeaScreenShot() throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenShotPath = System.getProperty("user.dir") +"\\src\\test\\resources\\screenShots\\screenshot_"+timeStamp+".png";
		
		// System.getProperty("user.dir") +"\\src\\test\\resources\\screenShots";
		// Now you can do whatever you need to do with it, for example copy somewhere
		File destfile = new File(screenShotPath);
	
		FileHandler.copy(scrFile, destfile);
		
	}


}
