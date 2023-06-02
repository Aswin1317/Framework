package com.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.constants.AutomationClass;
import com.pages.LoginPage;
import com.utils.PropertyUtils;
import com.utils.WebbrowserUtils;

public class AutomationBase {

	public WebDriver driver;
	LoginPage login;
	WebbrowserUtils webbrowser = new WebbrowserUtils();
	Properties prop;
	PropertyUtils propertyutil;

	@BeforeMethod
	@Parameters("browserName")
	public void preLaunch(String browserName) {

		launchBrowser(browserName);
		propertyutil = new PropertyUtils();
		prop = PropertyUtils.getProperty("config.properties");
		webbrowser.launchUrl(driver, prop.getProperty("url"));
	}

	@BeforeGroups("Smoke")
	@Parameters("browserName")
	public void grouping(String browserName) {
		launchBrowser(browserName);
		login = new LoginPage(driver);
		webbrowser = new WebbrowserUtils();
		propertyutil = new PropertyUtils();
		prop = PropertyUtils.getProperty("config.properties");
		webbrowser.launchUrl(driver, prop.getProperty("url"));
		webbrowser.browserMaximize(driver);
	}

	public void launchBrowser(String browserName) {
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
			throw new RuntimeException(AutomationClass.browserNameCheck);
		}
	}

	private void launchChromeBrowser() {

		driver = new ChromeDriver();
		webbrowser.browserMaximize(driver);
	}

	private void launchEdgeBrowser() {

		driver = new EdgeDriver();
		webbrowser.browserMaximize(driver);

	}

	private void launchFirefoxBrowser() {

		driver = new FirefoxDriver();
		webbrowser.browserMaximize(driver);

	}

	public WebDriver getDriver() {

		return driver;
	}

}