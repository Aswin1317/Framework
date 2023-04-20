package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.WebActionUtils;
import com.utils.WebElementUtils;

public class ExpensePage {

	WebDriver driver;

	WebActionUtils webaction = new WebActionUtils();
	WebElementUtils webelement = new WebElementUtils();

	@FindBy(xpath = "//button[@class='btn btn-add btn-lg']")
	WebElement addexpensebtn;

	@FindBy(xpath = "//input[@id='Date']")
	WebElement expensedate;

	@FindBy(xpath = "//input[@id='Reference']")
	WebElement expensereference;

	@FindBy(xpath = "//select[@id='Category']")
	WebElement expensecategory;

	@FindBy(xpath = "//select[@id='store_id']")
	WebElement expensestore;

	@FindBy(xpath = "//input[@id='Amount']")
	WebElement expenseamount;

	@FindBy(xpath = "//input[@id='attachment']")
	WebElement expenseattachment;

	@FindBy(xpath = "//div[@class='note-editable panel-body']")
	WebElement expensenotes;

	@FindBy(xpath = "//button[text()='Close']")
	WebElement closebtn;

	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submitbtn;

	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	WebElement deletebtn;

	@FindBy(xpath = "//button[text()='Yes, delete it!']")
	WebElement confirmdeletebtn;

	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	WebElement editbtn;

	public ExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isAddExpenseBtnIsDisplayed() {
		boolean flag = webaction.checkElementisDisplayed(driver, addexpensebtn);
		return flag;
	}

	public boolean isExpenseDateIsDisplayed() {
		boolean flag = webaction.checkElementisDisplayed(driver, expensedate);
		return flag;
	}

	public boolean isExpenseReferenceIsDisplayed() {
		boolean flag = webaction.checkElementisDisplayed(driver, expensereference);
		return flag;
	}

	public boolean isExpenseCategoryIsDisplayed() {
		boolean flag = webaction.checkElementisDisplayed(driver, expensecategory);
		return flag;
	}

	public boolean isExpenseStoreIsDisplayed() {
		boolean flag = webaction.checkElementisDisplayed(driver, expensestore);
		return flag;
	}

	public boolean isExpenseAmountIsDisplayed() {
		boolean flag = webaction.checkElementisDisplayed(driver, expenseamount);
		return flag;
	}

	public boolean isExpenseAttachmentIsDisplayed() {
		boolean flag = webaction.checkElementisDisplayed(driver, expenseattachment);
		return flag;
	}

	public boolean isExpenseNotesIsDisplayed() {
		boolean flag = webaction.checkElementisDisplayed(driver, expensenotes);
		return flag;
	}

	public boolean isCloseBtnIsDisplayed() {
		boolean flag = webaction.checkElementisDisplayed(driver, closebtn);
		return flag;
	}

	public boolean isSubmitBtnIsDisplayed() {
		boolean flag = webaction.checkElementisDisplayed(driver, submitbtn);
		return flag;
	}

	public void clickOnAddExpenseBtn() {
		webaction.clickOnTheElement(driver, addexpensebtn);
	}

	public void enterExpenseDate(String date) {
		webaction.enterTheValue(driver, expensedate, date);
	}

	public void enterExpenseReference(String ref) {
		webaction.enterTheValue(driver, expensereference, ref);
	}

	public void selectExpenseCategory(String category) {
		webaction.enterTheValue(driver, expensecategory, category);
	}

	public void selectExpenseStore(String store) {
		webaction.enterTheValue(driver, expensestore, store);
	}

	public void enterExpenseAmount(String amount) {
		webaction.enterTheValue(driver, expenseamount, amount);
	}

	public void chooseAttachment() {
		webaction.clickOnTheElement(driver, expenseattachment);
	}

	public void enterExpenseNotes(String notes) {
		webaction.enterTheValue(driver, expensenotes, notes);
	}

	public void clickOnSubmitBtn() {
		webaction.clickOnTheElement(driver, submitbtn);
	}

	public void clickOnDeleteBtn() {
		webaction.clickOnTheElement(driver, deletebtn);
	}

	public void clickConfirmDeleteBtn() {
		webaction.clickOnTheElement(driver, confirmdeletebtn);
	}

	public void clickOnEditBtn() {
		webaction.clickOnTheElement(driver, editbtn);
	}
}
