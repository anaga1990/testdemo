package com.xbank.pageobjectmodle;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xbank.core.BaseCl;

public class OrangeHrmLoginPageDiffeentWaysToCallMethods extends BaseCl {

	// driver.findElement(By.id("txtUsername")); replaced by below line
	@FindBy(id = "txtUsername")
	WebElement usernameText;

	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement passwordText;
	
	@FindBy (css = "#btnLogin")
	WebElement loginButton;
	
	public OrangeHrmLoginPageDiffeentWaysToCallMethods() {
		PageFactory.initElements(driver, this);
	}
	
	
	//1st way started
	public void enterTheUsername() {
		usernameText.sendKeys(prs.getProperty("username"));
	}
	
	public void enterThePassword() {
		passwordText.sendKeys(prs.getProperty("password"));
	}
	
	public void enterlogin() {
		loginButton.click();
	}
	
	//1st way END
	
	//2nd way started
	public void login() {
		usernameText.sendKeys(prs.getProperty("username"));
		passwordText.sendKeys(prs.getProperty("password"));
		loginButton.click();
	}
	
	//3rd way
	public void loginWithUserProvidedDetails(String userName, String password) {
		usernameText.sendKeys(userName);
		passwordText.sendKeys(password);
		loginButton.click();
	}
	
	
}
