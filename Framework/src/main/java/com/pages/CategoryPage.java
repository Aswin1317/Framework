package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.WebActionUtils;
import com.utils.WebElementUtils;

public class CategoryPage {

	WebDriver driver;

	WebActionUtils webaction = new WebActionUtils();
	WebElementUtils webelement = new WebElementUtils();

	@FindBy(xpath = "(//span[text()='Product'])[2]")
	WebElement categoryproduct;

	@FindBy(xpath = "(//span[text()='Expense'])[2]")
	WebElement categoryexpense;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isCategoryProductIsDisplayed() {
		boolean flag = webaction.checkElementisDisplayed(driver, categoryproduct);
		return flag;
	}

	public boolean isCategoryExpenseIsDisplayed() {
		boolean flag = webaction.checkElementisDisplayed(driver, categoryexpense);
		return flag;
	}

	public void clickOnCategoryProduct() {
		webaction.clickOnTheElement(driver, categoryproduct);
	}

	public void clickOnCategoryExpense() {
		webaction.clickOnTheElement(driver, categoryexpense);
	}
}
