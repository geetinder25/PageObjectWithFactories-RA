package com.w2a.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {

	@FindBy(css="a[aria-controls='wizard-flight-pwa']")
	public WebElement flightsTab;
	
	@FindBy(css="li[class*='uitk-tab-icon-text']")
	public List<WebElement> tabCount;

	//locators for flight booking
	@FindBy(css="button[aria-label='Leaving from']")
	public WebElement fromCityClick;
	@FindBy(css="input[id='location-field-leg1-origin']")
	public WebElement fromCityType;
	@FindBy(css="ul[data-stid*='leg1'] > li > button:nth-child(1)")
	public WebElement fromCityFinalClick;
	

	@FindBy(css="button[aria-label='Going to']")
	public WebElement toCityClick;
	@FindBy(css="input[id='location-field-leg1-destination']")
	public WebElement toCityType;
	//FindAll chooses either of the locator (just in case one doesn't work, it will take another locator)
	@FindAll({
		@FindBy(xpath="//strong[contains(text(),'Seattle (SEA')]"),
		@FindBy(css="button[data-stid*='leg1-destination'][xpath='1']")
	})
	public WebElement toCityFinalClick;
	
	
	@FindBy(css="button[id='d1-btn']")
	public WebElement departDate;
	@FindBy(css="button[id='d2-btn']")
	public WebElement returnDate;
	
	@FindBy(css="a[data-testid*='travelers'] > svg[class*='uitk-icon-medium']")
	public WebElement travellers;
	@FindBy(css="svg[aria-labelledby*='increase-adults']")
	public WebElement adults;
	@FindBy(css="svg[aria-labelledby*='increase-children']")
	public WebElement children;
	@FindBy(css="svg[aria-labelledby*='increase-infants']")
	public WebElement infants;
	@FindBy(css="button[data-testid*='guests-done']")
	public WebElement doneBtn;
	
	@FindBy(css="a[aria-label*='class'] > svg[class*='uitk']")
	public WebElement classSelect;
	
	@FindBy(css="button[data-testid='submit-button']")
	public WebElement searchBtn;


}
