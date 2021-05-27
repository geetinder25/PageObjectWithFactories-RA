package com.w2a.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.Page;
import com.w2a.utilities.MonitoringMail;
import com.w2a.utilities.TestConfig;
import com.w2a.utilities.Utilities;

public class CustomListeners extends Page implements ITestListener, ISuiteListener {
	public String msgBody;
	public void onFinish(ITestContext context) {
	 /*
		try {
			msgBody = "http://"+InetAddress.getLocalHost().getHostAddress()+":8085/job/PageObjectWithFactoriesLiveProjectRA/Extent_20Report/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MonitoringMail mail=new MonitoringMail();
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, msgBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    */

	} 

	public void onStart(ITestContext context) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			Utilities.captureScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+" Failed with exception: "+result.getThrowable());
		test.log(LogStatus.INFO, test.addScreenCapture(Utilities.screenshotName));
		
		Reporter.log("Click to see screenshot");
		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+"><img src="+Utilities.screenshotName+" height=200 width=200></img></a>");
		
		rep.endTest(test);
		rep.flush();
	}

	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, result.getName().toUpperCase()+" Skipped the test as the runmode is NO");
		rep.endTest(test);
		rep.flush();
	}

	public void onTestStart(ITestResult result) {
		test=rep.startTest(result.getName().toUpperCase());
		//runmodes=Y
		if(!Utilities.isTestRunnable(result.getName(), excel)) {
			throw new SkipException(" Skipping the test: "+result.getName().toUpperCase()+" as the Run mode is NO");
		}
	}

	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getName().toUpperCase()+" PASS");
		rep.endTest(test);
		rep.flush();
	}
}
