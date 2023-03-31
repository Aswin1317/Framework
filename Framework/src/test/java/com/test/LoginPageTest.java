package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.PropertyUtils;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.ExcelUtils;
import com.utils.WebbrowserUtils;

public class LoginPageTest extends AutomationBase{

	ExcelUtils excel;
	WebDriver driver;
	WebbrowserUtils webbrowser;
	LoginPage login;
	HomePage home;
	PropertyUtils propertyutil;
	Properties prop;
	
	@BeforeMethod
	public void preRun() throws IOException{
		excel = new ExcelUtils("testdataframe.xlsx");
		driver=getDriver();
		login = new LoginPage(driver);
		webbrowser = new WebbrowserUtils();
		home = new HomePage(driver);
		webbrowser.launchUrl(driver, "https://qalegend.com/restaurant/login");
	}
	
	@Test(priority=1, enabled=true)
	public void validateLogin() throws IOException {
		String uname = excel.readStringData("login", 1, 2);
		login.enterValueToUserName(uname);
		String pword = excel.readStringData("login", 2, 2);
		login.enterValueToPassword(pword);
		login.clickOnLoginButton();
	}	
}
