package testCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AuthenticationPage;
import pages.HomePage;
import pages.PersonalInfoPage;
import testBase.TestBase_B11;

public class EndToEndTestCase_ABhi extends TestBase_B11 {
	
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
		public void endToEndTestCase_Arijit(Hashtable<String, String> htData) throws IOException, InterruptedException {	
		
//			// Create an account
//			CommonMethods.verifyPageTitle(htData.get("Page_Title"));
//			
//			CommonMethods.ClickOnButton("Sign_In_btn", "Sign In");
//		
//			CommonMethods.enterTextIntoTextBoxFromTestDataSheet("Email_Add", htData.get("Email_ID"), "Email");
//			
//			CommonMethods.ClickOnButton("CreateAccount_btn", "Create An Account");
//			
//			CommonMethods.ClickOnButton("MrRadio_btn", "MrRadio");
//			
//			CommonMethods.enterTextIntoTextBoxFromTestDataSheet("First_Name1", htData.get("First_Name"), "First Name");
//
//			CommonMethods.enterTextIntoTextBoxFromTestDataSheet("Last_Name", htData.get("Last_Name"), "Last Name");
//			
//			CommonMethods.enterTextIntoTextBoxFromTestDataSheet("password", htData.get("Password"), "Password");
//			
//			
//			// login with created account
//			
//		CommonMethods.verifyPageTitle(htData.get("Page_Title"));
//		CommonMethods.ClickOnButton("Sign_In_btn", "Sign In");
//		CommonMethods.enterTextIntoTextBoxFromConfigFile("EmailAdd_regisredUser", "Email_ID", "registered user Email Address");
//		CommonMethods.enterTextIntoTextBoxFromConfigFile("Passwd_regisredUser", "password", "registered user password");
//		CommonMethods.ClickOnButton("Sign_in_btn_regUser", "Sign In");
//		
//		// shopping with registered user
		
		AuthenticationPage.createAnAccount(htData);
		PersonalInfoPage.enterPersonalInformation(htData);
		AuthenticationPage.loginWithAlreadyRegistredUser(htData);

		HomePage.contactUs(htData);
		
		//XYZpage.shopping()
	}
}
