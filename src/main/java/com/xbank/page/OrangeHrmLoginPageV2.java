package com.xbank.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xbank.core.BaseCl;

public class OrangeHrmLoginPageV2 extends BaseCl {

	// driver.findElement(By.id("txtUsername")); replaced by below line
	@FindBy(id = "txtUsername")
	WebElement usernameText;

	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement passwordText;
	
	@FindBy (css = "#btnLogin")
	WebElement loginButton;
	
	public OrangeHrmLoginPageV2() {
		PageFactory.initElements(driver, this);
	}
	
	public OrangeHrmHomePageV2 login() {
		usernameText.sendKeys(prs.getProperty("username"));
		passwordText.sendKeys(prs.getProperty("password"));
		loginButton.click();
		return new OrangeHrmHomePageV2();
	}
	
	
	
}
