package com.base;

import java.io.IOException;
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
	public void preLaunch(String browserName) {

		launchBrowser(browserName);
		login = new LoginPage(driver);
		webbrowser = new WebbrowserUtils();
		propertyutil = new PropertyUtils();
		try {
			prop = propertyutil.getProperty("config.properties");
		} catch (IOException e) {
			throw new RuntimeException("unable to load config files");
		}
		webbrowser.launchUrl(driver, prop.getProperty("url"));
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
			System.out.println(AutomationClass.browserNameCheck);
			break;
		}
	}

	private void launchChromeBrowser() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	private void launchEdgeBrowser() {

		driver = new EdgeDriver();
		driver.manage().window().maximize();

	}

	private void launchFirefoxBrowser() {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	public static WebDriver getDriver() {

		return driver;
	}

}