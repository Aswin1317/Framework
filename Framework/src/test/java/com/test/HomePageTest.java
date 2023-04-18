package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
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
		prop = propertyutil.getProperty("config.properties");
		home = login.login(prop.getProperty("admin"), prop.getProperty("password"));
	}

	@Test(priority = 1, enabled = true)
	public void validateMenuIsDisplayyedOnHomePage() throws IOException {

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(home.isPosLinkIsDisplayed(), "Failure messege : Pos link is not displayed");
		soft.assertTrue(home.isProductLinkIsDisplayed(), "Failure messege : Product link is not displayed");
		soft.assertTrue(home.isStoresLinkIsDisplayed(), "Failure messege : Stores link is not displayed");
		soft.assertTrue(home.isPeopleLinkIsDisplayed(), "Failure messege : People link is not displayed");
		soft.assertTrue(home.isSalesLinkIsDisplayed(), "Failure messege : Sales link is not displayed");
		soft.assertTrue(home.isExpenseLinkIsDisplayed(), "Failure messege : Expense link is not displayed");
		soft.assertTrue(home.isCategoriesLinkIsDisplayed(), "Failure messege : Categories link is not displayed");
		soft.assertTrue(home.isSettingLinkIsDisplayed(), "Failure messege : Setting link is not displayed");
		soft.assertTrue(home.isReportsLinkIsDisplayed(), "Failure messege : RFeports link is not displayed");
		home.isLanguageIsDisplayed();
		home.isLogoutButtonIsDisplayed();
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
