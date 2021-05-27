package com.w2a.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.w2a.base.Page;
import com.w2a.pages.locators.HomePageLocators;

public class HomePage extends Page {
	
	public HomePageLocators home;

	public HomePage() {
		this.home= new HomePageLocators();
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.home);
	}
	public int getTabCount() {
		return home.tabCount.size();
	}

	public HomePage goToFlights() {
		click(home.flightsTab);
		return this;
	}

	public void goToCars() {

	}

	public void goToPackages() {

	}

	public void goToThingsToDo() {

	}

	public void bookAStay() {

	}
	
	public void bookAFlight(String from, String to, String adults, String children, String infants) {
		// String dDate, String rDate, String classFlight) 
		click(home.fromCityClick);
		type(home.fromCityType,from);
		wait.until(ExpectedConditions.elementToBeClickable(home.fromCityFinalClick));
		click(home.fromCityFinalClick);
		
		click(home.toCityClick);
		type(home.toCityType,to);
		wait.until(ExpectedConditions.elementToBeClickable(home.toCityFinalClick));
		click(home.toCityFinalClick);
		
		//home.departDate.sendKeys(dDate);
		//home.returnDate.sendKeys(rDate);
		
		click(home.travellers);
		
		String[] adultStr=adults.split("\\.");  //adults=2.0
		int noAdults=Integer.parseInt(adultStr[0]);
		for(int i=1;i<noAdults;i++) {
			click(home.adults);
		}
		String[] childStr=children.split("\\.");
		int noChild=Integer.parseInt(childStr[0]);
		for(int j=0;j<noChild;j++) {
			click(home.children);
		}
		String[] infantStr=infants.split("\\.");
		int noInfants=Integer.parseInt(infantStr[0]);
		for(int k=0;k<noInfants;k++) {
			click(home.infants);
		}
		click(home.doneBtn);

		click(home.searchBtn);
		
	}

}
