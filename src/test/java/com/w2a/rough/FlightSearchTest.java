package com.w2a.rough;

import org.testng.Assert;

import com.w2a.base.Page;
import com.w2a.pages.actions.HomePage;

public class FlightSearchTest {

	public static void main(String[] args) {
		
		/*Page.initConfiguration();
		
		HomePage home=new HomePage();
		//Assert.assertEquals(home.getTabCount(), 5);
		home.goToFlights().bookAFlight("DEL","SEA","2","2","2");
		Page.quitBrowser(); */
		String str="2.0";
		String[] itr=str.split("\\.");
		System.out.println(itr[0]);
		
		int noAdults=Integer.parseInt("2.0");
		System.out.println(noAdults);

	}
}
