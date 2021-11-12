package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import testBase.TestBase_B11;

public class Listeners_B11 extends TestBase_B11 implements ITestListener {

	public void onTestStart(ITestResult result) {

		try {
			if(htRunMode.get(testCaseName).equalsIgnoreCase("Y")) 
			launchBrowser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void onTestSuccess(ITestResult result) {

		try {
			closeBrowser();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.log(LogStatus.PASS, "Test case " + testCaseName + " execution is completred and is passed");
	}

	public void onTestFailure(ITestResult result) {

		test.log(LogStatus.FAIL, result.getThrowable().getMessage());
		try {
			takeaScreenShot_failed();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			closeBrowser();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.log(LogStatus.FAIL, "Test case " + testCaseName + " execution is Failed");

	}

	public void onTestSkipped(ITestResult result) {
//		 throw new SkipException("Skipping Test case "+testCaseName+" as it's run mode
//		 is set to No");
//		test.log(LogStatus.SKIP , "Test case " + testCaseName + " execution is Skipped as Run mode is set to No");
//		try {
//			closeBrowser();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
