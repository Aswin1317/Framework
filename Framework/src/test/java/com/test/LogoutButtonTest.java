package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.LogoutButton;
import com.utils.PropertyUtils;
import com.utils.WebbrowserUtils;

public class LogoutButtonTest extends AutomationBase {

	WebDriver driver;
	WebbrowserUtils webbrowser;
	LoginPage login;
	HomePage home;
	LogoutButton logout;
	Properties prop = new Properties();
	PropertyUtils propertyutil = new PropertyUtils();

	@Test(priority = 1, enabled = true)
	public void clickOnLogoutButton() {
		login = new LoginPage(driver);
		prop = PropertyUtils.getProperty("config.properties");
		webbrowser.launchUrl(driver, prop.getProperty("url"));
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));

		logout.navigateToLogoutButton();
	}
}
