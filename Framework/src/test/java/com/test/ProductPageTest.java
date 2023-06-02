package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationClass;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.utils.ExcelUtils;
import com.utils.PropertyUtils;
import com.utils.WebbrowserUtils;

public class ProductPageTest extends AutomationBase {

	ExcelUtils excel;
	WebDriver driver;
	WebbrowserUtils webbrowser;
	LoginPage login;
	HomePage home;
	ProductPage product;
	Properties prop;
	PropertyUtils propertyutil;

	@Test(priority = 1, enabled = true)
	public void validateElementsOnAddProductPage() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		propertyutil = new PropertyUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		product = home.navigateToProductPage();

		product.clickOnAddProduct();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(product.isAddProductIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(product.isTypeIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(product.isCodeIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(product.isNameIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(product.isCategoryIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(product.isSupplierIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(product.isPurchasePriceIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(product.isTaxIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(product.isTaxMethodIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(product.isPriceIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(product.isProductUnitIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(product.isAlertQuantityIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(product.isProductOptionsIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(product.isInputImageIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(product.isProductDescriptionIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(product.isChooseColorsIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 2, enabled = true)
	public void enterValueToProductPage() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		propertyutil = new PropertyUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		product = home.navigateToProductPage();
		excel = new ExcelUtils();
		product.clickOnAddProduct();
		String ptype = excel.readStringData("product", 1, 2);
		product.selectProductType(ptype);
		String pcode = excel.readStringData("product", 2, 2);
		product.enterProductCode(pcode);
		String pname = excel.readStringData("product", 3, 2);
		product.enterProductName(pname);
		String pcategory = excel.readStringData("product", 4, 2);
		product.selectProductcategory(pcategory);
		String psupplier = excel.readStringData("product", 5, 2);
		product.selectProductSupplier(psupplier);
		String ppurchaseprice = excel.readStringData("product", 6, 2);
		product.enterProductPurchasePrise(ppurchaseprice);
		String ptax = excel.readStringData("product", 7, 2);
		product.enterProductTax(ptax);
		String ptaxmethod = excel.readStringData("product", 8, 2);
		product.selectProductTaxmethod(ptaxmethod);
		String pprice = excel.readStringData("product", 9, 2);
		product.enterProductprice(pprice);
		String punit = excel.readStringData("product", 10, 2);
		product.enterProductunit(punit);
		String palertquantity = excel.readStringData("product", 11, 2);
		product.enterProductAlertQuantity(palertquantity);
		String poptions = excel.readStringData("product", 12, 2);
		product.enterProductOptions(poptions);
		String pdescription = excel.readStringData("product", 13, 2);
		product.enterProductDescription(pdescription);
		String pcolor = excel.readStringData("product", 14, 2);
		product.chooseProductColors(pcolor);
		product.clickOnSubmitBtn();
		product.clickProductModifyStockBtn();
		product.clickViewProductBtn();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(product.getProductCodeSearch(), "1234");
		soft.assertEquals(product.getProductNameSearch(), "Apple");
		soft.assertEquals(product.getProductCategorySearch(), "Fruits");
		soft.assertEquals(product.getProductSupplierSearch(), "abc");
		soft.assertEquals(product.getProductTaxSearch(), "10");
		soft.assertEquals(product.getProductPriceSearch(), "1000");
		soft.assertEquals(product.getProductDescriptionSearch(), "abcdefgh");
	}

	@Test(priority = 3, enabled = true)
	public void validateToEditProductInProductPage() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		propertyutil = new PropertyUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		product = home.navigateToProductPage();
		excel = new ExcelUtils();
		product.clickProductEditBtn();
		String etype = excel.readStringData("product", 19, 2);
		product.selectProductType(etype);
		String ecode = excel.readStringData("product", 20, 2);
		product.enterProductCode(ecode);
		String ename = excel.readStringData("product", 21, 2);
		product.enterProductName(ename);
		String ecategory = excel.readStringData("product", 22, 2);
		product.selectProductcategory(ecategory);
		String esupplier = excel.readStringData("product", 23, 2);
		product.selectProductSupplier(esupplier);
		String epurchaseprice = excel.readStringData("product", 24, 2);
		product.enterProductPurchasePrise(epurchaseprice);
		String etax = excel.readStringData("product", 25, 2);
		product.enterProductTax(etax);
		String etaxmethod = excel.readStringData("product", 26, 2);
		product.selectProductTaxmethod(etaxmethod);
		String eprice = excel.readStringData("product", 27, 2);
		product.enterProductprice(eprice);
		String eunit = excel.readStringData("product", 28, 2);
		product.enterProductunit(eunit);
		String ealert = excel.readStringData("product", 29, 2);
		product.enterProductAlertQuantity(ealert);
		String eoption = excel.readStringData("product", 30, 2);
		product.enterProductOptions(eoption);
		String edescription = excel.readStringData("product", 31, 2);
		product.enterProductDescription(edescription);
		String ecolor = excel.readStringData("product", 32, 2);
		product.chooseProductColors(ecolor);
	}

	@Test(priority = 4, enabled = true)
	public void validateToDeleteTheProductInProductPage() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		propertyutil = new PropertyUtils();
		prop = PropertyUtils.getProperty("config.properties");
		login.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		product = home.navigateToProductPage();
		product.clickProductDeleteBtn();
		product.clickProductConfirmDeleteBtn();

	}
}
