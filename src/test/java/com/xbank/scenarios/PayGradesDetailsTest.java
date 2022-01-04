package com.xbank.scenarios;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xbank.core.BaseCl;
import com.xbank.pageobjectmodle.AdminMenuPage;
import com.xbank.pageobjectmodle.OrangeHrmHomePage;
import com.xbank.pageobjectmodle.OrangeHrmLoginPage;

public class PayGradesDetailsTest extends BaseCl{
	
	
	@Test
	public void getDetailsFrompayGrades() {
		OrangeHrmLoginPage oo = new OrangeHrmLoginPage();
		oo.login();
		OrangeHrmHomePage orangeHrmHomePage = new OrangeHrmHomePage();
		orangeHrmHomePage.clickOnAdmin();
		AdminMenuPage adminMenuPage = new AdminMenuPage();
		adminMenuPage.clickOnJobsubMenu();
		adminMenuPage.clickOnpayGrades();
		adminMenuPage.FetchDetailsFrompayGrades();
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		startBrowser();
	}

	@AfterMethod
	public void afterMethod() {
		closeBrowser();
	}

}
