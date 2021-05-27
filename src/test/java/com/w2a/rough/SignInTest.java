package com.w2a.rough;

import com.w2a.base.Page;
import com.w2a.pages.actions.SignInPage;

public class SignInTest {

	public static void main(String[] args) {	
		Page.initConfiguration();	
		SignInPage signIn=Page.topNav.goToSignIn();
		signIn.doLogin("abc@gmail.com", "12345d");	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Page.quitBrowser();
	}
}

/*new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.id("checkoutLink")));
driver.findElement(By.id("checkoutLink")).click(); */
