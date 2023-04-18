package com.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.constants.AutomationClass;
import com.pages.LoginPage;
import com.utils.PropertyUtils;
import com.utils.WebbrowserUtils;

public class AutomationBase {

	static WebDriver driver;
	LoginPage login;
	WebbrowserUtils webbrowser;
	Properties prop;
	PropertyUtils propertyutil;

	@BeforeTest
	@Parameters("browserName")
	public void preLaunch(String browserName) throws Exception {
		launchBrowser(browserName);
		login = new LoginPage(driver);
		webbrowser = new WebbrowserUtils();
		propertyutil = new PropertyUtils();
		prop = propertyutil.getProperty("config.properties");
		webbrowser.launchUrl(driver, prop.getProperty("url"));
	}

	public void launchBrowser(String browserName) throws Exception {
		switch (browserName) {
		case "chrome":
			launchChromeBrowser();
			break;

		case "edge":
			launchEdgeBrowser();
			break;

		case "firefox":
			launchFirefoxBrowser();
			break;

		default:
			System.out.println(AutomationClass.browserNameCheck);
			break;
		}
	}

	private void launchChromeBrowser() throws Exception {

		try {
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	private void launchEdgeBrowser() throws Exception {

		try {
			driver = new EdgeDriver();
			driver.manage().window().maximize();

		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	private void launchFirefoxBrowser() throws Exception {

		try {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public static WebDriver getDriver() {

		return driver;
	}

}