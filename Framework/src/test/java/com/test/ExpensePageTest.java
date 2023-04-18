package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.ExpensePage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.ExcelUtils;
import com.utils.PropertyUtils;
import com.utils.WebbrowserUtils;

public class ExpensePageTest extends AutomationBase  {

	ExcelUtils excel;
	WebDriver driver;
	WebbrowserUtils webbrowser;
	LoginPage login;
	HomePage home;
	ExpensePage expense;
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
		expense = home.navigateToExpensePage();
	}

	@Test(priority = 1, enabled = true)
	public void validateElementOnAddExpense() {
		expense.clickOnAddExpenseBtn();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(expense.isExpenseDateIsDisplayed(), "Failure messege : Expense Date is not displayed");
		soft.assertTrue(expense.isExpenseReferenceIsDisplayed(), "Failure messege : Expense Reference is not displayed");
		soft.assertTrue(expense.isExpenseCategoryIsDisplayed(), "Failure messege : Expense Categorty is not displayed");
		soft.assertTrue(expense.isExpenseStoreIsDisplayed(), "Failure messege : Expense Store is not displayed");
		soft.assertTrue(expense.isExpenseAmountIsDisplayed(), "Failure messege : Expense Amount is not displayed");
		soft.assertTrue(expense.isExpenseAttachmentIsDisplayed(), "Failure messege : Expense Attachment is not displayed");
		soft.assertTrue(expense.isExpenseNotesIsDisplayed(), "Failure messege : Expense Notes is not displayed");

	}

	@Test(priority = 2, enabled = true)
	public void validateValueToAddExpense() throws IOException {
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
	public void validateEditExpenseInExpensePage() throws IOException {
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
