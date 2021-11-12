package utility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import testBase.TestBase_B11;

public class CommonMethods extends TestBase_B11 {
	
	public static void ClickOnButton(String Xpath_Key, String ButtonName) throws IOException {
		
		driver.findElement(By.xpath(or.getProperty(Xpath_Key))).click();
		System.out.println("User clicked on "+ButtonName+" Button");
		test.log(LogStatus.PASS, "User clicked on "+ButtonName+" Button");
		takeaScreenShot();
	}
	
	public static void enterTextIntoTextBoxFromConfigFile(String Xpath_Key,String input_Key, String TextBoxName) throws IOException {
	
		driver.findElement(By.xpath(or.getProperty(Xpath_Key))).sendKeys(config.getProperty(input_Key)); 
		System.out.println("User entered "+TextBoxName+" Address");
		test.log(LogStatus.PASS, "User entered "+TextBoxName+" Address");
		takeaScreenShot();
		
	}
	
	public static void enterTextIntoTextBoxFromTestDataSheet(String Xpath_Key, String input_Data, String TextBoxName) throws IOException {
		
		driver.findElement(By.xpath(or.getProperty(Xpath_Key))).sendKeys(input_Data); 
		System.out.println("User entered "+TextBoxName+" Address");
		test.log(LogStatus.PASS, "User entered "+TextBoxName+" Address");
		takeaScreenShot();
		
	}
	
	public static void verifyPageTitle(String expectedResult) throws IOException {
		String page_title = driver.getTitle();
		Assert.assertEquals(page_title, expectedResult);
		System.out.println("Page title is verified and it is :- " +page_title);
		test.log(LogStatus.PASS , "Page title is verified and it is :- " +page_title);
		takeaScreenShot();
	}

	
	public static void selectByVisibleText() {
		
		test.log(LogStatus.PASS , "Select value from dropDown Box");	
		
	}
	
	
}
