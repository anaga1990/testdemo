package com.xbank.scenarios;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xbank.core.BaseCl;
import com.xbank.page.AdminMenuPageV2;
import com.xbank.page.OrangeHrmHomePageV2;
import com.xbank.page.OrangeHrmLoginPageV2;

public class PayGradesDetailsTestV2 extends BaseCl{
	
	
	@Test
	public void getDetailsFrompayGrades() {
		OrangeHrmLoginPageV2 loginPage = new OrangeHrmLoginPageV2();
		OrangeHrmHomePageV2 homePage = loginPage.login();
		AdminMenuPageV2 adminMenu = homePage.clickOnAdmin();
		adminMenu.clickOnJobsubMenu();
		adminMenu.clickOnpayGrades();
		adminMenu.FetchDetailsFrompayGrades();
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
