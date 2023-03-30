package com.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.utils.WebbrowserUtils;

public class ProductPageTest extends AutomationBase {

	WebDriver driver;
	LoginPage login;
	HomePage home;
	ProductPage product;
	
	
	WebbrowserUtils webbrowser = new WebbrowserUtils();
	@BeforeMethod
	public void preRun() throws Exception{
		driver=getDriver();
		login = new LoginPage(driver);
		webbrowser.launchUrl(driver, "https://qalegend.com/restaurant/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		home = login.login("admin", "password");
		product = home.navigateToProductPage();
	}
	
	@Test(priority=1, enabled=true)
	public void validateElementsOnAddProductPage() 
	{	
		product.clickOnAddProduct();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(product.isAddProductIsDisplayed(), "Failure messege : Add product is not displayed");
		soft.assertTrue(product.isTypeIsDisplayed(), "Failure messege : Product type is not displayed");
		soft.assertTrue(product.isCodeIsDisplayed(), "Failure messege : Product code is not displayed");
		soft.assertTrue(product.isNameIsDisplayed(), "Failure messege : Product name is not displayed");
		soft.assertTrue(product.isCategoryIsDisplayed(), "Failure messege : Product category is not displayed");
		soft.assertTrue(product.isSupplierIsDisplayed(), "Failure messege : Product supplier is not displayed");
		soft.assertTrue(product.isPurchasePriceIsDisplayed(), "Failure messege : Product purchase price is not displayed");
		soft.assertTrue(product.isTaxIsDisplayed(), "Failure messege : Product tax is not displayed");
		soft.assertTrue(product.isTaxMethodIsDisplayed(), "Failure messege : Product tax method is not displayed");
		soft.assertTrue(product.isPriceIsDisplayed(), "Failure messege : Product price is not displayed");
		soft.assertTrue(product.isProductUnitIsDisplayed(), "Failure messege : Product product unit is not displayed");
		soft.assertTrue(product.isAlertQuantityIsDisplayed(), "Failure messege : Product alert quantity is not displayed");
		soft.assertTrue(product.isProductOptionsIsDisplayed(), "Failure messege : Product options is not displayed");
		soft.assertTrue(product.isInputImageIsDisplayed(), "Failure messege : Input image is not displayed");
		soft.assertTrue(product.isProductDescriptionIsDisplayed(), "Failure messege : Product description is not displayed");
		soft.assertTrue(product.isChooseColorsIsDisplayed(), "Failure messege : Choose color is not displayed");
		soft.assertTrue(product.isCloseButtonIsDisplayed(), "Failure messege : Close button is not displayed");
		soft.assertTrue(product.isSubmitButtonIsDisplayed(), "Failure messege : Submit button is not displayed");	
		soft.assertAll();
	}
		
		@Test(priority=2, enabled=true)
		public void enterValueToProductPage()
		{	
			product.clickOnAddProduct();
			product.selectProductType("Standard");
			product.enterProductCode("1234");
			product.enterProductName("Apple");
			product.selectProductcategory("Fruits");
			product.selectProductSupplier("abc");
			product.enterProductPurchasePrise("500");
			product.enterProductTax("10");
			product.selectProductTaxmethod("exclusive");
			product.enterProductprice("1000");
			product.enterProductunit("7");
			product.enterProductAlertQuantity("7");
			product.enterProductOptions("more cheese");
			product.enterProductDescription("abcdefgh");
			product.chooseProductColors("C1");
			product.clickOnSubmitBtn();
			product.clickProductEditBtn();
			product.clickProductDeleteBtn();
			product.clickProductModifyStockBtn();
			product.clickViewProductBtn();
			product.clickOnUploadCsvBtn();
			product.clickOnDownloadCsvBtn();
			product.clickOnPrintMenuBtn();
			
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(product.getProductCodeSearch(), "1234");
			soft.assertEquals(product.getProductNameSearch(), "Apple");
			soft.assertEquals(product.getProductCategorySearch(), "Fruits");
			soft.assertEquals(product.getProductSupplierSearch(), "abc");
			soft.assertEquals(product.getProductTaxSearch(), "10");
			soft.assertEquals(product.getProductPriceSearch(), "1000");
			soft.assertEquals(product.getProductDescriptionSearch(), "abcdefgh");
		}

}
