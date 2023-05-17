package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationClass;
import com.pages.CategoryPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.ExcelUtils;
import com.utils.PropertyUtils;
import com.utils.WebbrowserUtils;

public class CategoryPageTest extends AutomationBase {

	ExcelUtils excel;
	WebDriver driver;
	WebbrowserUtils webbrowser;
	LoginPage login;
	HomePage home;
	CategoryPage category;
	Properties prop;
	PropertyUtils propertyutil;

	@BeforeMethod
	public void preRun() throws Exception {
		excel = new ExcelUtils();
		driver = getDriver();
		login = new LoginPage(driver);
		home = new HomePage(driver);
		propertyutil = new PropertyUtils();
		prop = propertyutil.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		category = home.navigateToCategoryPage();
	}

	@Test(priority = 1, enabled = true)
	public void validateMenuIsDisplayedOnCategoryPage() {
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(category.isCategoryProductIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(category.isCategoryExpenseIsDisplayed(), AutomationClass.elementDisplayCheck);
	}

	@Test(priority = 1, enabled = true)
	public void validateToAccessMenusInCategoryPage() {
		category.clickOnCategoryProduct();
		category.clickOnCategoryExpense();
	}
}
