package com.xbank.pageobjectmodle;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xbank.core.BaseCl;
import com.xbank.utill.Reuse;

public class OrangeHrmHomePage extends BaseCl {

	@FindBy(xpath = "//b[normalize-space()='Admin']")
	WebElement adminMenu;

	@FindBy(xpath = "//b[normalize-space()='PIM']")
	WebElement pimMenu;

	@FindBy(xpath = "//b[normalize-space()='Leave']")
	WebElement LeaveMenu;

	@FindBy(xpath = "//b[normalize-space()='Time']")
	WebElement timeMenu;

	// Admin Menu actions Started

	@FindBy(xpath = "//a[@id='menu_admin_UserManagement']")
	WebElement userManagementMenu;

	@FindBy(xpath = "//a[@id='menu_admin_viewSystemUsers']")
	WebElement usersSubMenu;

	@FindBy(xpath = "//input[@id='searchSystemUser_userName']")
	WebElement usernameText;

	@FindBy(xpath = "//select[@id='searchSystemUser_userType']")
	WebElement userRoleDropdown;

	@FindBy(xpath = "//select[@id='searchSystemUser_status']")
	WebElement statusDropDown;

	@FindBy(xpath = "//input[@id='searchSystemUser_employeeName_empName']")
	WebElement employeeNameText;

	@FindBy(xpath = "//input[@id='searchBtn']")
	WebElement searchButton;

	@FindBy(xpath = "//table[@id='resultTable']/tbody//td[2]/a")
	WebElement verifyUsername;

	@FindBy(xpath = "//table[@id='resultTable']/tbody//td[3]")
	WebElement verifyUserRole;

	@FindBy(xpath = "//table[@id='resultTable']/tbody//td[4]")
	WebElement verifyEmployeeName;

	@FindBy(xpath = "//table[@id='resultTable']/tbody//td[5]")
	WebElement verifyStatus;
	
	@FindBy(xpath = "//a[@id='menu_admin_Job']")
	WebElement jobsSubMenu;
	
	// Admin Menu actions END

	public OrangeHrmHomePage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnAdmin() {
		adminMenu.click();
	}
	
	public void clickOnAdminAndJobsSubMenu() {
		adminMenu.click();
		jobsSubMenu.click();
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

	public String serachUserInUsersSubMenuAndGetUsersDetails(String username, String enabledOrDisabled) {
		userManagementMenu.click();
		usersSubMenu.click();
		usernameText.sendKeys(username);
		Reuse.selectByVisibleText(statusDropDown, "Enabled");
		Reuse.selectByIndex(userRoleDropdown, 1);
		searchButton.click();
		String userDetailsFromPage = verifyUsername.getText().trim();
		String statusDetailsFromPage = verifyStatus.getText().trim();
		String userRoleDetailsFromPage = verifyUserRole.getText().trim();
		String employeeDetailsFromPage = verifyEmployeeName.getText().trim();
		return userDetailsFromPage + ":" + userRoleDetailsFromPage + ":" + employeeDetailsFromPage + ":"
				+ statusDetailsFromPage;

	}

}
