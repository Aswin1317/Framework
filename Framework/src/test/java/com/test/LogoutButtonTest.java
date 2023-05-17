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
	Properties prop;
	PropertyUtils propertyutil;

	@BeforeMethod
	public void preRun() throws Exception {
		driver = getDriver();
		login = new LoginPage(driver);
		home = new HomePage(driver);
		propertyutil = new PropertyUtils();
		prop = propertyutil.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		logout = home.navigateToLogoutBtn();
	}

	@Test(priority = 1, enabled = true)
	public void clickOnLogoutButton() {
		logout.navigateToLogoutButton();
	}
}
