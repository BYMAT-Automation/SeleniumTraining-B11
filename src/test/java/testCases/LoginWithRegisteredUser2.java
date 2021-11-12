package testCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AuthenticationPage;
import testBase.TestBase_B11;

public class LoginWithRegisteredUser2 extends TestBase_B11 {

	@BeforeClass
	public void isSkip() {

		testCaseName = this.getClass().getSimpleName();
		System.out.println("testCaseName is :-" + testCaseName);

		if (htRunMode.get(testCaseName).equalsIgnoreCase("Y"))
			System.out.println("Executing Test Case:- " + testCaseName);
		else
			throw new SkipException("Skipping Test case " + testCaseName + " as it's run mode is set to No");
	}

	@Test(dataProvider = "data_Collection")
	public void loginWithRegisteredUser2(Hashtable<String, String> htData) throws IOException, InterruptedException {

//		CommonMethods.verifyPageTitle(htData.get("Page_Title"));
//
//		CommonMethods.ClickOnButton("Sign_In_btn", "Sign In");
//		CommonMethods.enterTextIntoTextBoxFromConfigFile("EmailAdd_regisredUser", "Email_ID",
//				"registered user Email Address");
//		CommonMethods.enterTextIntoTextBoxFromConfigFile("Passwd_regisredUser", "password", "registered user password");
//		CommonMethods.ClickOnButton("Sign_in_btn_regUser", "Sign In");
		
		AuthenticationPage.loginWithAlreadyRegistredUser(htData);

	}

}
