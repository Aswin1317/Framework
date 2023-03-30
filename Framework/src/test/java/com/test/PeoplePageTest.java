package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PeoplePage;
import com.utils.WebbrowserUtils;

public class PeoplePageTest extends AutomationBase{

	WebDriver driver;
	LoginPage login;
	HomePage home;
	PeoplePage people;
	
	WebbrowserUtils webbrowser = new WebbrowserUtils();
	@BeforeMethod
	public void preRun() throws Exception
	{
		driver = getDriver();
		login = new LoginPage(driver);
		webbrowser.launchUrl(driver, "https://qalegend.com/restaurant/login");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		home = login.login("admin", "password");
		people = home.navigateToPeoplePage();
	}
	
	@Test(priority=1, enabled=true)
	public void validateMenuIsDisplayedOnPeoplePage() {
		
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(people.isPeopleWaiterIsDisplayed(), "Failure messege : Waiter is not displayed");
		soft.assertTrue(people.isPeopleCustomerIsDisplayed(), "Failure messege : Customer is not displayed");
		soft.assertTrue(people.isPeopleSupplierIsDisplayed(), "Failure messege : Supplier is ot displayed");
	}
	
	@Test(priority=3, enabled=true)
	public void validateElementIsDisplayedOnWaiterPage() 
	{
		people.clickOnWaiterPeople();
		people.clickOnAddWaiterButton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(people.isWaiterNameIsDisplayed(), "Failure messege : Waiter Name is not displayed");
		soft.assertTrue(people.isWaiterPhoneIsDisplayed(), "Failure messege : Waiter Phone is not displayed");
		soft.assertTrue(people.isWaiterEmailIsDisplayed(), "Failure messege : Waiter Email is not displayed");
		soft.assertTrue(people.isWaiterStoreIsDisplayed(), "Failure messege : Waiter Store is not displayed");
		soft.assertTrue(people.isWaiterCloseBtnIsDisplayed(), "Failure messege : Waiter Close Btn is not displayed");
		soft.assertTrue(people.isWaiterSubmitBtnIsDisplayed(), "Failure messege : Waiter Submit Btn is not displayed");
		soft.assertAll();
	}
	
	@Test(priority=4, enabled=true)
	public void validateCustomerInPeoplePage()  
	{
		people.clickOnCustomerPeople();
		people.clickOnAddCustomerButton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(people.isCustomerNameISDisplayed(), "Failure messege : Customer name is not displayed");
		soft.assertTrue(people.isCustomerPhoneISDisplayed(), "Failure messege : Customer Phone is not displayed");
		soft.assertTrue(people.isCustomerEmailISDisplayed(), "Failure messege : Customer Email is not displayed");
		soft.assertTrue(people.isCustomerDiscountISDisplayed(), "Failure messege : Customer Discount is not displayed");
		soft.assertTrue(people.isCustomerCloseBtnISDisplayed(), "Failure messege : Customer Close Btn is not displayed");
		soft.assertTrue(people.isCustomerSubmitBtnISDisplayed(), "Failure messege : Customer Submit Btn is not displayed");
		soft.assertAll();
	}
	
	@Test(priority=5, enabled=true)
	public void validateSupplierInPeoplePage()  
	{
		people.clickOnSupplierPeople();
		people.clickOnAddSupplierButton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(people.isSupplierNameIsDisplayed(), "Failure messege : Supplier Name is not displayed");
		soft.assertTrue(people.isSupplierPhoneIsDisplayed(), "Failure messege : Supplier Phone is not displayed");
		soft.assertTrue(people.isSupplierEmailIsDisplayed(), "Failure messege : Supplier Email is not displayed");
		soft.assertTrue(people.isSupplierCloseBtnIsDisplayed(), "Failure messege : Supplier Close Btn is not displayed");
		soft.assertTrue(people.isSupplierSubmitBtnIsDisplayed(), "Failure messege : Supplier Submit Btn is not displayed");
		soft.assertAll();
	}
	
	@Test(priority=2, enabled=true)
	public void enterValueInAddWaiter() {
		people.enterValueInWaiterName("Abcd");
		people.enterValueInWaiterPhone("1234567890");
		people.enterValueInWaiterEmail("abc@gmail.com");
	}
	
}
