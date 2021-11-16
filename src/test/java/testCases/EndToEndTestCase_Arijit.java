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

public class EndToEndTestCase_Arijit extends TestBase_B11 {
	
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
		
		AuthenticationPage.createAnAccount(htData);
		PersonalInfoPage.enterPersonalInformation(htData);
		AuthenticationPage.loginWithAlreadyRegistredUser(htData);

		HomePage.contactUs(htData);
		
	}
}
