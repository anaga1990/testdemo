package com.xbank.pageobjectmodle;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.xbank.core.BaseCl;

public class AdminMenuPage extends BaseCl{

	@FindBy(xpath = "//a[@id='menu_admin_Job']")
	WebElement jobsubMenu;
	
	@FindBy(id = "menu_admin_viewPayGrades")
	WebElement payGradesSubMenuInJobs;
	
	@FindBys({@FindBy(xpath = "//tbody/tr/td[2]/a")})
	List<WebElement>  payGradesList;
	
	public AdminMenuPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnJobsubMenu() {
		jobsubMenu.click();
	}
	public void clickOnpayGrades() {
		payGradesSubMenuInJobs.click();
	}
	
	public void FetchDetailsFrompayGrades() {
		for (WebElement ele : payGradesList) {
			System.out.println(ele.getText());
		}
	}
	
	
}
