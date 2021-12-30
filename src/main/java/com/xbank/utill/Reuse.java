package com.xbank.utill;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.xbank.core.BaseCl;

public class Reuse extends BaseCl {
	public static void selectByVisibleText(WebElement dropDownElement, String visibleText) {
		Select select = new Select(dropDownElement);
		select.selectByVisibleText(visibleText);
	}
	
	public static void selectByIndex(WebElement dropDownElement, int indexNumber) {
		Select select = new Select(dropDownElement);
		select.selectByIndex(indexNumber);
	}
}
