package com.xbank.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseCl {
	public static WebDriver driver;
	public static Properties prs;
	private static Logger log = LogManager.getLogger(BaseCl.class);
	public BaseCl() {
		System.out.println("default constrcuter");
	}

	// start browser
	public static void startBrowser() {
		loadProps();
		String runtimeBrowser = prs.getProperty("browser");
		log.info(prs.getProperty("browser"), "used for testing");
		if (runtimeBrowser.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// System.getProperty("user.dir")+properties.getProperty("driverbinary"));
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("ChromeDriver initilized successfully");

		} else if (runtimeBrowser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("FirefoxDriver initilized successfully");
		} else if (runtimeBrowser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			log.info("EdgeDriver initilized successfully");
		} else {
			log.error(prs.getProperty("browser"), "used for testing");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		if (runtimeBrowser.equalsIgnoreCase("chrome") || runtimeBrowser.equalsIgnoreCase("edge")) {
			driver.manage().window().maximize();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(prs.getProperty("url"));
		log.info("base url opend Successfully");
	}

	public static void closeBrowser() {
		driver.quit();
		log.info("browser closed Successfully");
	}

	public static void loadProps() {
		try {
			FileInputStream fis = new FileInputStream(
					new File(System.getProperty("user.dir") + "/src/main/resources/base.properties"));
			prs = new Properties();
			prs.load(fis);
		} catch (FileNotFoundException e) {
			log.error("FileNotFound", e.getMessage());
		} catch (IOException e) {
			log.error("IO Execption", e.getMessage());
		}
	}

}
