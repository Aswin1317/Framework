package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.PropertyUtils;

public class LoginPageTest extends AutomationBase {
	WebDriver driver;
	LoginPage login;
	HomePage home;
	Properties prop;
	PropertyUtils propertyutil;

	@Test(priority = 1, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateLogin() throws Exception {
		driver = getDriver();
		login = new LoginPage(driver);
		home = new HomePage(driver);
		propertyutil = new PropertyUtils();
		prop = propertyutil.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		login.clickOnLoginButton();

	}
}
