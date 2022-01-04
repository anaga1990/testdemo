package com.xbank.scenarios;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xbank.core.BaseCl;
import com.xbank.pageobjectmodle.OrangeHrmLoginPage;
import com.xbank.pageobjectmodle.OrangeHrmLoginPageDiffeentWaysToCallMethods;

public class TC01OHrmLoginPageTest extends BaseCl {

	
	@BeforeMethod
	public void setup() {
		startBrowser();
	}
	
	
	@Test(enabled = false)
	public void logintest() {
		OrangeHrmLoginPageDiffeentWaysToCallMethods loginpage = new OrangeHrmLoginPageDiffeentWaysToCallMethods();
		//ctrl+shift+o
		loginpage.enterTheUsername();
		loginpage.enterThePassword();
		loginpage.enterlogin();
		System.out.println("Title Of the Page "+driver.getTitle());
	}
	
	@Test(priority = 1)
	public void logintestApproachTwo() {
		OrangeHrmLoginPage loginpage = new OrangeHrmLoginPage();
		//ctrl+shift+o
		loginpage.login();
		System.out.println("comming form logintestApproachTwo method (): Title Of the Page "+driver.getTitle());
	}
	
	@Test(priority = 2)
	public void logintestApproachThree() {
		OrangeHrmLoginPageDiffeentWaysToCallMethods loginpage = new OrangeHrmLoginPageDiffeentWaysToCallMethods();
		//loginpage.login("Admin", "admin123");
		loginpage.loginWithUserProvidedDetails(prs.getProperty("username"), prs.getProperty("password"));
		System.out.println("comming form logintestApproachThree method (): Title Of the Page "+driver.getTitle());
	}
	
	@AfterMethod
	public void closConnections() throws InterruptedException {
		Thread.sleep(2000);
		closeBrowser();
	}
}
