package pages;

import java.io.IOException;
import java.util.Hashtable;

import testBase.TestBase_B11;
import utility.CommonMethods;

public class PersonalInfoPage extends TestBase_B11 {
	
	public static void enterPersonalInformation(Hashtable<String, String> htData) throws IOException {
		
        CommonMethods.ClickOnButton("MrRadio_btn", "MrRadio");
		
		CommonMethods.enterTextIntoTextBoxFromTestDataSheet("First_Name", htData.get("First_Name"), "First Name");

		CommonMethods.enterTextIntoTextBoxFromTestDataSheet("Last_Name", htData.get("Last_Name"), "Last Name");
		
		CommonMethods.enterTextIntoTextBoxFromTestDataSheet("password", htData.get("Password"), "Password");
		
	}

}
