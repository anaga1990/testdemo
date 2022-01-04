package com.xbank.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xbank.core.BaseCl;

public class OrangeHrmHomePageV2 extends BaseCl {

	@FindBy(xpath = "//b[normalize-space()='Admin']")
	WebElement adminMenu;

	@FindBy(xpath = "//b[normalize-space()='PIM']")
	WebElement pimMenu;

	@FindBy(xpath = "//b[normalize-space()='Leave']")
	WebElement LeaveMenu;

	@FindBy(xpath = "//b[normalize-space()='Time']")
	WebElement timeMenu;
	
	
	
	
	// Admin Menu actions END

	public OrangeHrmHomePageV2() {
		PageFactory.initElements(driver, this);
	}

	public AdminMenuPageV2 clickOnAdmin() {
		adminMenu.click();
		return new AdminMenuPageV2();
	}

	public void clickOnPim() {
		pimMenu.click();
	}

	public void clickOnLeave() {
		LeaveMenu.click();
	}

	public void clickOnTime() {
		timeMenu.click();
	}

	

}
