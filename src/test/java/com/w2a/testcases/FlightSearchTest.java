package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.w2a.base.Page;
import com.w2a.pages.actions.HomePage;
import com.w2a.utilities.Utilities;

public class FlightSearchTest {
	

	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void flightSearchTest(Hashtable<String,String> data) {
		if(data.get("runmode").equalsIgnoreCase("N")) {
			throw new SkipException("Skipping the test as run mode is N");
		}
	
		Page.initConfiguration();
		
		HomePage home=new HomePage();
		//Assert.assertEquals(home.getTabCount(), 6);
		SoftAssert softAssert=new SoftAssert();
		//softAssert.assertEquals(home.getTabCount(), 8);
		softAssert.assertEquals(home.getTabCount(), 5);

		home.goToFlights().bookAFlight(data.get("fromCity"),data.get("toCity"),data.get("Adults"),data.get("Children"),data.get("Infants"));
		softAssert.assertAll();

	}
	
	@AfterMethod
	public void tearDown() {
		if(Page.driver!=null) {
			Page.quitBrowser();
		}
	}
}
