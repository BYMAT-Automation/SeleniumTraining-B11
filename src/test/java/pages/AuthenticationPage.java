package pages;

import java.io.IOException;
import java.util.Hashtable;

import testBase.TestBase_B11;
import utility.CommonMethods;

public class AuthenticationPage extends TestBase_B11 {
	
	public static void createAnAccount(Hashtable<String, String> htData) throws IOException {
		
		CommonMethods.verifyPageTitle(htData.get("Page_Title"));
		
		CommonMethods.ClickOnButton("Sign_In_btn", "Sign In");
	
		CommonMethods.enterTextIntoTextBoxFromTestDataSheet("Email_Add", htData.get("Email_ID"), "Email");
		
		CommonMethods.ClickOnButton("CreateAccount_btn", "Create An Account");
	}
	
	public static void loginWithAlreadyRegistredUser(Hashtable<String, String> htData) throws IOException {
		
		CommonMethods.verifyPageTitle(htData.get("Page_Title"));

		CommonMethods.ClickOnButton("Sign_In_btn", "Sign In");
		
		CommonMethods.enterTextIntoTextBoxFromConfigFile("EmailAdd_regisredUser", "Email_ID",
				"registered user Email Address");
		CommonMethods.enterTextIntoTextBoxFromConfigFile("Passwd_regisredUser", "password", "registered user password");
		
		CommonMethods.ClickOnButton("Sign_in_btn_regUser", "Sign In");
		
	}
	
}
