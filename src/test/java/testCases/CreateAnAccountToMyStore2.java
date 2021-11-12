package testCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.TestBase_B11;
import utility.CommonMethods;

public class CreateAnAccountToMyStore2 extends TestBase_B11 { 
	
	@BeforeClass
	public void isSkip() {
		
		testCaseName = this.getClass().getSimpleName();
		System.out.println("testCaseName is :-" +testCaseName);
		
		if(htRunMode.get(testCaseName).equalsIgnoreCase("Y")) 
			System.out.println("Executing Test Case:- " +testCaseName);
		 else
			throw new SkipException("Skipping Test case "+testCaseName+" as it's run mode is set to No");
	}
	
		@Test(dataProvider = "data_Collection")
		public void createAnAccountToMyStore2(Hashtable<String, String> htData) throws IOException, InterruptedException {	
			
		CommonMethods.verifyPageTitle(htData.get("Page_Title"));
		
		CommonMethods.ClickOnButton("Sign_In_btn", "Sign In");
	
		CommonMethods.enterTextIntoTextBoxFromTestDataSheet("Email_Add", htData.get("Email_ID"), "Email");
		
		CommonMethods.ClickOnButton("CreateAccount_btn", "Create An Account");
		
		CommonMethods.ClickOnButton("MrRadio_btn", "MrRadio");
		
		CommonMethods.enterTextIntoTextBoxFromTestDataSheet("First_Name1", htData.get("First_Name"), "First Name");

		CommonMethods.enterTextIntoTextBoxFromTestDataSheet("Last_Name", htData.get("Last_Name"), "Last Name");
		
		CommonMethods.enterTextIntoTextBoxFromTestDataSheet("password", htData.get("Password"), "Password");
			
	}

}
