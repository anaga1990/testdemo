package com.xbank.sanity;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.xbank.core.BaseCl;
import com.xbank.pageobjectmodle.OrangeHrmHomePage;
import com.xbank.pageobjectmodle.OrangeHrmLoginPage;

import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HrmHomePageAdminMenuActionTest extends BaseCl {
	private Logger log = LogManager.getLogger(HrmHomePageAdminMenuActionTest.class);

	@Test(enabled = false)
	public void userSearchInAdminMenu() {
		OrangeHrmLoginPage oo = new OrangeHrmLoginPage();
		log.info("OrangeHrmLoginPage object created Success");
		oo.login();
		log.info("OrangeHrmLoginPage login action Success");
		OrangeHrmHomePage homepage = new OrangeHrmHomePage();
		homepage.clickOnAdmin();
		log.info("OrangeHrmLoginPage login action Success");
		String data = homepage.serachUserInUsersSubMenuAndGetUsersDetails(prs.getProperty("username"), "Enabled");
		log.info(data);
		String userDetails[] = data.split(":");

		// hard , soft
		if (userDetails[0].equalsIgnoreCase("Admffin")) {
			log.info("Admin valuse verified");
		} else {
			log.error("Admin value not ok, or verification Failed");
		}
		Assert.assertEquals(userDetails[0], "amin", "username Verified ko");
		Assert.assertEquals(userDetails[1], "Admin", "userRole not Ok");// hard assert
		Assert.assertEquals(userDetails[2], "Paulomar Collings", "emp name not Ok");// hard assert

	}

	@Test
	public void userSearchInAdminMenuWithSOftAssert() {
		OrangeHrmLoginPage oo = new OrangeHrmLoginPage();
		log.info("OrangeHrmLoginPage created");
		oo.login();
		OrangeHrmHomePage homepage = new OrangeHrmHomePage();
		homepage.clickOnAdmin();
		log.info("clickOnAdmin success");
		String data = homepage.serachUserInUsersSubMenuAndGetUsersDetails(prs.getProperty("username"), "Enabled");
		System.out.println(data);
		String userDetails[] = data.split(":");
		SoftAssert softAssert = new SoftAssert();
		// hard , soft
		if (userDetails[0].equalsIgnoreCase("Adfgghhmin")) {
			log.info("Admin valuse verified");
		} else {
			log.error("Admin value not ok, or verification Failed");
		}
		softAssert.assertEquals(userDetails[0], "amin", "username Verified ko");
		softAssert.assertEquals(userDetails[1], "Admin", "userRole not Ok");// hard assert
		softAssert.assertEquals(userDetails[2], "Paulomar Collings", "emp name not Ok");// hard assert
		log.info("userSearchInAdminMenuWithSOftAssert completed");
		softAssert.assertAll();
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
