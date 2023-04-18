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
import com.pages.PosPage;
import com.utils.ExcelUtils;
import com.utils.PropertyUtils;
import com.utils.WebbrowserUtils;

public class PosPageTest extends AutomationBase {

	ExcelUtils excel;
	WebDriver driver;
	WebbrowserUtils webbrowser;
	LoginPage login;
	HomePage home;
	PosPage ppage;
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
		ppage = home.navigateToPosPage();
	}

	@Test(priority = 1, enabled = true)
	public void validateMenuIsDisplayedOnPosPage() {
		ppage.clickOnTheStore();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(ppage.isCashinHandisDisplayed(), "Failure messege : Cash in hand is not displayed");
		soft.assertTrue(ppage.isCloseButtonIsDisplayed(), "Failure messege : Close button is not displayed");
		soft.assertTrue(ppage.isSubmitButtonIsDisplayed(), "Failure messege : Submit button is not displayed");
	}

	@Test(priority = 2, enabled = true)
	public void validateValueOnPosStore() throws IOException {
		ppage.clickOnTheStore();
		String cashinhand = excel.readStringData("pos", 1, 2);
		ppage.enterValueOnCashInHand(cashinhand);
		ppage.clickOnSubmitButton();
	}
}
