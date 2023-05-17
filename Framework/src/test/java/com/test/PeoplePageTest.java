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
import com.pages.PeoplePage;
import com.utils.ExcelUtils;
import com.utils.PropertyUtils;
import com.utils.WebbrowserUtils;

public class PeoplePageTest extends AutomationBase {

	ExcelUtils excel;
	WebDriver driver;
	WebbrowserUtils webbrowser;
	LoginPage login;
	HomePage home;
	PeoplePage people;
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
		people = home.navigateToPeoplePage();
	}

	@Test(priority = 1, enabled = true)
	public void validateMenuIsDisplayedOnPeoplePage() {
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(people.isPeopleWaiterIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(people.isPeopleCustomerIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(people.isPeopleSupplierIsDisplayed(), AutomationClass.elementDisplayCheck);
	}

	@Test(priority = 2, enabled = true)
	public void validateElementIsDisplayedInAddWaiter() {
		people.clickOnWaiterPeople();
		people.clickOnAddWaiterButton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(people.isWaiterNameIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(people.isWaiterPhoneIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(people.isWaiterEmailIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(people.isWaiterStoreIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 4, enabled = true)
	public void validateElementIsDisplayedInAddCustomer() {
		people.clickOnCustomerPeople();
		people.clickOnAddCustomerButton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(people.isCustomerNameISDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(people.isCustomerPhoneISDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(people.isCustomerEmailISDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(people.isCustomerDiscountISDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 6, enabled = true)
	public void validateElementIsDisplayedInAddSupplier() {
		people.clickOnSupplierPeople();
		people.clickOnAddSupplierButton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(people.isSupplierNameIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(people.isSupplierPhoneIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(people.isSupplierEmailIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 3, enabled = true)
	public void validateToEnterValueInAddWaiter() throws IOException {
		String wname = excel.readStringData("people", 1, 2);
		people.enterValueInWaiterName(wname);
		String wphone = excel.readStringData("people", 2, 2);
		people.enterValueInWaiterPhone(wphone);
		String wmail = excel.readStringData("people", 3, 2);
		people.enterValueInWaiterEmail(wmail);
		String wstore = excel.readStringData("people", 4, 2);
		people.enterValueInWaiterStore(wstore);
		people.clickOnWaiterSubmitBtn();
	}

	@Test(priority = 5, enabled = true)
	public void validateValueInAddCustomer() throws IOException {
		String cname = excel.readStringData("people", 6, 2);
		people.enterValueInCustomerName(cname);
		String cphone = excel.readStringData("people", 7, 2);
		people.enterValueInCustomerPhone(cphone);
		String cmail = excel.readStringData("people", 8, 2);
		people.enterValueInCustomerEmail(cmail);
		String cdiscount = excel.readStringData("people", 9, 2);
		people.enterValueInCustomerDsicount(cdiscount);
		people.clickOnCustomerSubmitBtn();
	}

	@Test(priority = 7, enabled = true)
	public void validateValueInAddSupplier() throws IOException {
		String sname = excel.readStringData("people", 11, 2);
		people.enterValueInSupplierName(sname);
		String sphone = excel.readStringData("people", 12, 2);
		people.enterValueInSupplierPhone(sphone);
		String smail = excel.readStringData("people", 13, 2);
		people.enterValueInSupplierEmail(smail);
		people.clickOnSupplierSubmitBtn();
	}
}
