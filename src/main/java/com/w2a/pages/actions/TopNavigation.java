package com.w2a.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.w2a.base.Page;
import com.w2a.pages.locators.TopNavigationLocators;

public class TopNavigation {

	public TopNavigationLocators topNavigation;
	public TopNavigation(WebDriver driver) {
		this.topNavigation=new TopNavigationLocators();
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.topNavigation);
	}

	public SignInPage goToSignIn() {
		Page.wait.until(ExpectedConditions.elementToBeClickable(topNavigation.goToSignIn));
		/*try {
		Page.wait.until(ExpectedConditions.elementToBeClickable(topNavigation.goToSignIn));
		} catch (Exception e) {
		Page.wait.until(ExpectedConditions.stalenessOf(topNavigation.goToSignIn));
		} */

		Page.click(topNavigation.goToSignIn);
		Page.click(topNavigation.signInBtn);

		return new SignInPage();

	}

	public void goToCreateFreeAccount() {


	}

	public void goToSupport() {

	}

	public void goToTrips() {

	}

	public void goToStays() {

	}

	public void goToFlights() {

	}

}
