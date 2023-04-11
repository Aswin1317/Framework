package com.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.ExpensePage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.ExcelUtils;
import com.utils.WebbrowserUtils;

public class ExpensePageTest extends AutomationBase{

	//ExcelUtils excel;
	WebDriver driver;
	LoginPage login;
	HomePage home;
	ExpensePage expense;
	
	WebbrowserUtils webbrowser = new WebbrowserUtils();
	@BeforeMethod
	public void preRun() throws Exception{
	//	excel = new ExcelUtils("testdataframe.xlsx");
		driver=getDriver();
		login = new LoginPage(driver);
		webbrowser.launchUrl(driver, "https://qalegend.com/restaurant/login");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		home = login.login("admin", "password");
		expense = home.navigateToExpensePage();
	}
	
	@Test(priority=1, enabled=true)
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
		soft.assertTrue(expense.isCloseBtnIsDisplayed(), "Failure messege : Expense Close button is not displayed");
		soft.assertTrue(expense.isSubmitBtnIsDisplayed(), "Failure messege : Expense Submit button is not displayed");
	}
	
	@Test(priority=2, enabled=true)
	public void validateValueToAddExpense() throws IOException {
		expense.clickOnAddExpenseBtn();
		//String edate = excel.readStringData("expense", 1, 2);
		expense.enterExpenseDate("04-11-2023");
		//String ereference = excel.readStringData("expense", 2, 2);
		expense.enterExpenseReference("ref");
	//	String ecategory = excel.readStringData("expense", 3, 2);
		expense.selectExpenseCategory("Fruits");
	//	String estore = excel.readStringData("expense", 4, 2);
		expense.selectExpenseStore("MNC");
	//	String eamount = excel.readStringData("expense", 5, 2);
		expense.enterExpenseAmount("1000");
		expense.chooseAttachment();
	//	String enotes = excel.readStringData("expense", 6, 2);
		expense.enterExpenseNotes("abcdefgh");
		expense.clickOnSubmitBtn();
	}
	
/*	@Test(priority=3, enabled=true)
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
	
	@Test(priority=4, enabled=true)
	public void validateToDeleteExpense() {
		expense.clickOnDeleteBtn();
		expense.clickConfirmDeleteBtn();
	}*/
}
