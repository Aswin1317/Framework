package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationClass;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.PropertyUtils;
import com.utils.WebbrowserUtils;

public class HomePageTest extends AutomationBase {

	WebDriver driver;
	WebbrowserUtils webbrowser;
	LoginPage login;
	HomePage home;
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
	}

	@Test(priority = 1, enabled = true)
	public void validateMenuIsDisplayyedOnHomePage() throws IOException {

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(home.isPosLinkIsDisplayed(), AutomationClass.pageDisplayCheck);
		soft.assertTrue(home.isProductLinkIsDisplayed(), AutomationClass.pageDisplayCheck);
		soft.assertTrue(home.isStoresLinkIsDisplayed(), AutomationClass.pageDisplayCheck);
		soft.assertTrue(home.isPeopleLinkIsDisplayed(), AutomationClass.pageDisplayCheck);
		soft.assertTrue(home.isSalesLinkIsDisplayed(), AutomationClass.pageDisplayCheck);
		soft.assertTrue(home.isExpenseLinkIsDisplayed(), AutomationClass.pageDisplayCheck);
		soft.assertTrue(home.isCategoriesLinkIsDisplayed(), AutomationClass.pageDisplayCheck);
		soft.assertTrue(home.isSettingLinkIsDisplayed(), AutomationClass.pageDisplayCheck);
		soft.assertTrue(home.isReportsLinkIsDisplayed(), AutomationClass.pageDisplayCheck);

	}

	@Test(priority = 2, enabled = true)
	public void validateTheMenuIsClickableOnHomePage() {
		home.navigateToPosLink();
		home.navigateToProductLink();
		home.navigateToStoresLink();
		home.navigateToPeopleLink();
		home.navigateToSalesLink();
		home.navigateToExpenseLink();
		home.navigateToCategoriesLink();
		home.navigateToSettingLink();
		home.navigateToReportsLink();
		home.navigateToLanguage();
		home.navigateToLogoutButton();
	}
}
