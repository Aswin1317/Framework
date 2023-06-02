package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationClass;
import com.pages.ExpensePage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.ExcelUtils;
import com.utils.PropertyUtils;
import com.utils.WebbrowserUtils;

public class ExpensePageTest extends AutomationBase {

	ExcelUtils excel;
	WebDriver driver;
	WebbrowserUtils webbrowser;
	LoginPage login;
	HomePage home;
	ExpensePage expense;
	Properties prop;
	PropertyUtils propertyutil;

	@Test(priority = 1, enabled = true)
	public void validateElementOnAddExpense()  {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		propertyutil = new PropertyUtils();
		prop = PropertyUtils.getProperty("config.properties");
		home = login.login(prop.getProperty("username"), prop.getProperty("password"));
		expense = home.navigateToExpensePage();
		expense.clickOnAddExpenseBtn();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(expense.isExpenseDateIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(expense.isExpenseReferenceIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(expense.isExpenseCategoryIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(expense.isExpenseStoreIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(expense.isExpenseAmountIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(expense.isExpenseAttachmentIsDisplayed(), AutomationClass.elementDisplayCheck);
		soft.assertTrue(expense.isExpenseNotesIsDisplayed(), AutomationClass.elementDisplayCheck);

	}

	@Test(priority = 2, enabled = true)
	public void validateValueToAddExpense()  {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		propertyutil = new PropertyUtils();
		prop = PropertyUtils.getProperty("config.properties");
		home = login.login(prop.getProperty("username"), prop.getProperty("password"));
		expense = home.navigateToExpensePage();
		excel = new ExcelUtils();
		expense.clickOnAddExpenseBtn();
		excel.readStringData("expense", 1, 2);
		expense.enterExpenseDate("04-11-2023");
		excel.readStringData("expense", 2, 2);
		expense.enterExpenseReference("ref");
		excel.readStringData("expense", 3, 2);
		expense.selectExpenseCategory("Fruits");
		excel.readStringData("expense", 4, 2);
		expense.selectExpenseStore("MNC");
		excel.readStringData("expense", 5, 2);
		expense.enterExpenseAmount("1000");
		expense.chooseAttachment();
		excel.readStringData("expense", 6, 2);
		expense.enterExpenseNotes("abcdefgh");
		expense.clickOnSubmitBtn();
	}

	@Test(priority = 3, enabled = true)
	public void validateEditExpenseInExpensePage() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		propertyutil = new PropertyUtils();
		prop = PropertyUtils.getProperty("config.properties");
		home = login.login(prop.getProperty("username"), prop.getProperty("password"));
		expense = home.navigateToExpensePage();
		excel = new ExcelUtils();
		expense.clickOnEditBtn();
		String editdate = excel.readStringData("expense", 11, 2);
		expense.enterExpenseDate(editdate);
		String editreference = excel.readStringData("expense", 12, 2);
		expense.enterExpenseReference(editreference);
		String editcategory = excel.readStringData("expense", 13, 2);
		expense.selectExpenseCategory(editcategory);
		String editstore = excel.readStringData("expense", 14, 2);
		expense.selectExpenseStore(editstore);
		String editamount = excel.readStringData("expense", 15, 2);
		expense.selectExpenseStore(editamount);
		expense.chooseAttachment();
		String editnotes = excel.readStringData("expense", 16, 2);
		expense.enterExpenseNotes(editnotes);
		expense.clickOnSubmitBtn();
	}

	@Test(priority = 4, enabled = true)
	public void validateToDeleteExpense() {
		expense.clickOnDeleteBtn();
		expense.clickConfirmDeleteBtn();
	}
}
