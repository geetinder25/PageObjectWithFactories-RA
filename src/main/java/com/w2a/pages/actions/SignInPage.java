package com.w2a.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.w2a.base.Page;
import com.w2a.pages.locators.SignInPageLocators;

public class SignInPage extends Page {
	public SignInPageLocators signInPage;
	
	public SignInPage() {
		this.signInPage=new SignInPageLocators();
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.signInPage);
	}
	
	public void doLogin(String username, String password) {
		type(signInPage.email,username);
		type(signInPage.password,password);
		click(signInPage.submit);
	}

}
