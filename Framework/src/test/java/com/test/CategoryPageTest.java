package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.CategoryPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.ExcelUtils;
import com.utils.PropertyUtils;
import com.utils.WebbrowserUtils;

public class CategoryPageTest extends AutomationBase  {

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
		excel = new ExcelUtils("testdataframe.xlsx");
		driver = getDriver();
		login = new LoginPage(driver);
		prop = propertyutil.getProperty("config.properties");
		webbrowser.launchUrl(driver, prop.getProperty("url"));
		home = login.login(prop.getProperty("admin"), prop.getProperty("password"));
		category = home.navigateToCategoryPage();
	}

	@Test(priority = 1, enabled = true)
	public void validateMenuIsDisplayedOnCategoryPage() {
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(category.isCategoryProductIsDisplayed(), "Failure messege : Category Product is not displayed");
		soft.assertTrue(category.isCategoryExpenseIsDisplayed(), "Failure messege : Category Expense is not displayed");
	}

	@Test(priority = 1, enabled = true)
	public void validateToAccessMenusInCategoryPage() {
		category.clickOnCategoryProduct();
		category.clickOnCategoryExpense();
	}
}
