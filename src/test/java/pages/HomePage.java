package pages;

import java.io.IOException;
import java.util.Hashtable;

import testBase.TestBase_B11;
import utility.CommonMethods;

public class HomePage extends TestBase_B11 {

	public static void contactUs(Hashtable<String, String> htData) throws IOException {
		
		CommonMethods.selectByVisibleText();
		
//		CommonMethods.enterTextIntoTextBoxFromTestDataSheet("Xpath_Key", htData.get("Email_ID"), "TextBoxName");
//		
//		CommonMethods.enterTextIntoTextBoxFromTestDataSheet("Xpath_Key", htData.get("OrderRef"), "OrderRef");
//		
//		CommonMethods.enterTextIntoTextBoxFromTestDataSheet("Xpath_Key", htData.get("OrderRef"), "OrderRef");
//		
//		CommonMethods.ClickOnButton("Xpath_Key", "ButtonName");
		
	}
}
