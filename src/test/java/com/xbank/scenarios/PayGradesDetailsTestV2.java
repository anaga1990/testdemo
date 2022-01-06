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
		System.out.println("OrangeHrmLoginPageV2 object creation successfull");
		OrangeHrmHomePageV2 homePage = loginPage.login();
		System.out.println("OrangeHrmHomePageV2 object creation successfull");
		AdminMenuPageV2 adminMenu = homePage.clickOnAdmin();
		System.out.println("AdminMenuPageV2 object creation successfull");
		adminMenu.clickOnJobsubMenu();
		System.out.println("clickOnJobsubMenu clicked successfull");
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
