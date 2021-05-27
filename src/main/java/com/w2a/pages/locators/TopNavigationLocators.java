package com.w2a.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindBy;

public class TopNavigationLocators {
	//for FindBys, both the conditions should be applicable
	@FindBys({
	@FindBy(css="nav[id='secondaryNav']"),
	@FindBy(xpath="//button[contains(text(),'Sign in')]")
	})
	public WebElement goToSignIn;
	
	@FindBy(css="a[href*='signin?']")
	public WebElement signInBtn;
	
	@FindBy(css="a[href*='createaccount?']")
	public WebElement createAccountBtn;
	

}
