package com.xbank.scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.xbank.core.BaseCl;
import com.xbank.pageobjectmodle.OrangeHrmHomePage;
import com.xbank.pageobjectmodle.OrangeHrmLoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HrmHomePageAdminMenuActionTest extends BaseCl {

	@Test
	public void userSearchInAdminMenu() {
		OrangeHrmLoginPage oo = new OrangeHrmLoginPage();
		oo.login();
		OrangeHrmHomePage homepage = new OrangeHrmHomePage();
		homepage.clickOnAdmin();
		String data = homepage.serachUserInUsersSubMenuAndGetUsersDetails(prs.getProperty("username"), "Enabled");
		System.out.println(data);
		String userDetails[]=data.split(":");
		
		//hard , soft
		Assert.assertEquals(userDetails[0], "amin", "username Verified ko");
		System.out.println("just after hardassert");
		Assert.assertEquals(userDetails[1], "Admin", "userRole not Ok");//hard assert
		Assert.assertEquals(userDetails[2], "Paulomar Collings", "emp name not Ok");//hard assert
		System.out.println("after hardassert");
		
		
	}
	
	@Test
	public void userSearchInAdminMenuWithSOftAssert() {
		OrangeHrmLoginPage oo = new OrangeHrmLoginPage();
		oo.login();
		OrangeHrmHomePage homepage = new OrangeHrmHomePage();
		homepage.clickOnAdmin();
		String data = homepage.serachUserInUsersSubMenuAndGetUsersDetails(prs.getProperty("username"), "Enabled");
		System.out.println(data);
		String userDetails[]=data.split(":");
		SoftAssert softAssert = new SoftAssert();
		//hard , soft
		softAssert.assertEquals(userDetails[0], "amin", "username Verified ko");
		softAssert.assertEquals(userDetails[1], "Admin", "userRole not Ok");//hard assert
		softAssert.assertEquals(userDetails[2], "Paulomar Collings", "emp name not Ok");//hard assert
		System.out.println(" after SoftAssert");
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
