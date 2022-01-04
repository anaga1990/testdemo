package com.xbank.pageobjectmodle;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xbank.core.BaseCl;

public class OrangeHrmLoginPage extends BaseCl {

	// driver.findElement(By.id("txtUsername")); replaced by below line
	@FindBy(id = "txtUsername")
	WebElement usernameText;

	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement passwordText;
	
	@FindBy (css = "#btnLogin")
	WebElement loginButton;
	
	public OrangeHrmLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void login() {
		usernameText.sendKeys(prs.getProperty("username"));
		passwordText.sendKeys(prs.getProperty("password"));
		loginButton.click();
	}
	
	
	
}
