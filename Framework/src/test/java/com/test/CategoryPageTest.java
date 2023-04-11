package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.CategoryPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.ExcelUtils;
import com.utils.WebbrowserUtils;

public class CategoryPageTest extends AutomationBase{

	ExcelUtils excel;
	WebDriver driver;
	LoginPage login;
	HomePage home;
	CategoryPage category;
	
	WebbrowserUtils webbrowser = new WebbrowserUtils();
	@BeforeMethod
	public void preRun() throws Exception{
		excel = new ExcelUtils("testdataframe.xlsx");
		driver=getDriver();
		login = new LoginPage(driver);
		webbrowser.launchUrl(driver, "https://qalegend.com/restaurant/login");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		home = login.login("admin", "password");
		category = home.navigateToCategoryPage();
	}
	
	@Test(priority=1, enabled=true)
	public void validateMenuIsDisplayedOnCategoryPage() {
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(category.isCategoryProductIsDisplayed(), "Failure messege : Category Product is not displayed");
		soft.assertTrue(category.isCategoryExpenseIsDisplayed(), "Failure messege : Category Expense is not displayed");
	}
	
	@Test(priority=1, enabled=true)
	public void validateToAccessMenusInCategoryPage() {
		category.clickOnCategoryProduct();
		category.clickOnCategoryExpense();
	}
}
