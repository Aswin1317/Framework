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
import com.pages.StorePage;
import com.utils.ExcelUtils;
import com.utils.PropertyUtils;
import com.utils.WebbrowserUtils;

public class StorePageTest extends AutomationBase {

	ExcelUtils excel;
	WebDriver driver;
	WebbrowserUtils webbrowser;
	LoginPage login;
	HomePage home;
	StorePage store;
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
		store = home.navigateToStoresPage();
	}

	@Test(priority = 1, enabled = true)
	public void validateMenuIsDisplayedOnStorePage() {
		store.clickOnAddStoreButton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(store.isAddStoreIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(store.isStoreNameIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(store.isStoreEmailIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(store.isStorePhoneIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(store.isStoreCountryIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(store.isStoreCityIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(store.isStoreAddressIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(store.isStoreCustomeFooterReceiptIsDisplayed(), AutomationClass.elementDisplayCheck);

	}

	@Test(priority = 2, enabled = true)
	public void validateValueInStorePage() throws IOException {
		store.clickOnAddStoreButton();
		String sname = excel.readStringData("store", 1, 2);
		store.enterStoreName(sname);
		String smail = excel.readStringData("store", 2, 2);
		store.enterStoreEmail(smail);
		String sphone = excel.readStringData("store", 3, 2);
		store.enterStorePhoneNumber(sphone);
		String scountry = excel.readStringData("store", 4, 2);
		store.enterStoreCountryName(scountry);
		String scity = excel.readStringData("store", 5, 2);
		store.enterStoreCityName(scity);
		String saddress = excel.readStringData("store", 6, 2);
		store.enterStoreAddress(saddress);
		String sfooter = excel.readStringData("store", 7, 2);
		store.enterCustomeFooterreceipt(sfooter);
		store.clickOnSubmitButton();
	}

	@Test(priority = 3, enabled = true)

	public void validateEditStoreInStorePage() throws IOException {
		store.clickOnEditStoreButton();
		String ename = excel.readStringData("store", 12, 2);
		store.enterStoreName(ename);
		String email = excel.readStringData("store", 13, 2);
		store.enterStoreEmail(email);
		String enumber = excel.readStringData("store", 14, 2);
		store.enterStorePhoneNumber(enumber);
		String ecountry = excel.readStringData("store", 15, 2);
		store.enterStoreCountryName(ecountry);
		String ecity = excel.readStringData("store", 16, 2);
		store.enterStoreCityName(ecity);
		String eaddress = excel.readStringData("store", 17, 2);
		store.enterStoreAddress(eaddress);
		String efooter = excel.readStringData("store", 18, 2);
		store.enterCustomeFooterreceipt(efooter);
		store.clickOnSubmitButton();
	}

	public void validationForDeleteTheStoreInStorePage() {
		store.clickOnDeleteStoreButton();
	}
}
