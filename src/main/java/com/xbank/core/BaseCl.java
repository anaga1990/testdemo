package com.xbank.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseCl {
	WebDriver driver;
	Properties properties;
	
	public BaseCl() {
		System.out.println("default constrcuter");
		try {
			FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/resources/base.properties"));
			properties = new Properties();
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// start browser
	public void startBrowser(String runtimeBrowser) {
		if (runtimeBrowser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+properties.getProperty("driverbinary"));
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if (runtimeBrowser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (runtimeBrowser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		if(runtimeBrowser.equalsIgnoreCase("chrome") || runtimeBrowser.equalsIgnoreCase("edge")) {
			driver.manage().window().maximize();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
	}
	
	public void closeBrowser() {
		driver.quit();
	}

	public static void main(String[] args) {
		BaseCl cc = new BaseCl();
		cc.startBrowser("chrome");
		cc.closeBrowser();
	}

}
