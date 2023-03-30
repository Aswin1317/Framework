package com.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.StorePage;
import com.utils.WebbrowserUtils;

public class StorePageTest extends AutomationBase {

	WebDriver driver;
	LoginPage login;
	HomePage home;
	StorePage store;
	
	
	WebbrowserUtils webbrowser = new WebbrowserUtils();
	@BeforeMethod
	public void preRun() throws Exception
	{
		driver = getDriver();
		login = new LoginPage(driver);
		webbrowser.launchUrl(driver, "https://qalegend.com/restaurant/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		home = login.login("admin", "password");
		store = home.navigateToStoresPage();
	}

	@Test(priority=1, enabled=true)
	public void validateMenuIsDisplayedOnStorePage() 
	{
		store.clickOnAddStoreButton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(store.isAddStoreIsDisplayed(), "Failure messege : Add store is not displayed");
		soft.assertTrue(store.isStoreNameIsDisplayed(), "Failure messege  : Store name is not displayed");
		soft.assertTrue(store.isStoreEmailIsDisplayed(), "Failure mesege : Store email is not displayed");
		soft.assertTrue(store.isStorePhoneIsDisplayed(), "Failure messege : Store phone number is not displayed");
		soft.assertTrue(store.isStoreCountryIsDisplayed(), "Failure messege : Store country is not displayed");
		soft.assertTrue(store.isStoreCityIsDisplayed(), "Failure messege : Store city is not displayed");
		soft.assertTrue(store.isStoreAddressIsDisplayed(), "Failure messege : Store address is not displayed");
		soft.assertTrue(store.isStoreCustomeFooterReceiptIsDisplayed(), "Failure messege : Store customer footer receipt is not displayed");
		soft.assertTrue(store.isCloseButtonIsDisplayed(), "Failure messege : Close button is not displayed");
		soft.assertTrue(store.isSubmitButtonIsDisplayed(), "Failure messege : Submit button is not displayed");
		soft.assertTrue(store.isEditStoreIsDisplayed(), "Failure messege : Edit store button is not displayed");
		soft.assertTrue(store.isDeleteStoreIsDisplayed(), "Failue messege : Delete store button is not displayed");
		//soft.assertTrue(store.isSearchStoreIsDisplayed(), "Failure messege : Search store is not displayed");
	}
	
	@Test(priority=2, enabled=true)
	public void enterValueToStorePage() {
		
		store.clickOnAddStoreButton();
		store.enterStoreName("Gift Store");
		store.enterStoreEmail("abcd@gmail.com");
		store.enterStorePhoneNumber("1234567890");
		store.enterStoreCountryName("India");
		store.enterStoreCityName("Abc");
		store.enterStoreAddress("abcdefgh");
		store.enterCustomeFooterreceipt("abcd1234");
		store.clickOnSubmitButton();
		

	}
}
