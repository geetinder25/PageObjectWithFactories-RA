package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.w2a.base.Page;
import com.w2a.pages.actions.SignInPage;
import com.w2a.utilities.Utilities;

public class SignInTest {
	
	
	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void signInTest(Hashtable<String,String> data) {	
		if(data.get("runmode").equalsIgnoreCase("N")) {
			throw new SkipException("Skipping the test as run mode is N");
		}
		
		Page.initConfiguration();
		
		SignInPage signIn=Page.topNav.goToSignIn();
		signIn.doLogin(data.get("username"),data.get("password"));	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown() {
		if(Page.driver!=null) {
			Page.quitBrowser();
		}
	}
}

