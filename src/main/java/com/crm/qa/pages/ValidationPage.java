package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ValidationPage extends TestBase {

	@FindBy(xpath = "//*[contains(text(),'Added to Cart')]")
	WebElement txtAddedToCartLable;

	@FindBy(xpath = "//title[contains(text(),'Select a delivery address')]")
	WebElement txtAddressPage;

	@FindBy(xpath = "//*[contains(text(),'Choose your delivery options')]")
	WebElement txtDeliveryOptions;

// Initializing the Page Objects:
	public ValidationPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyAddTOCart() {
		return txtAddedToCartLable.isDisplayed();
	}

	public boolean verifyAddressPage() {
		return txtAddressPage.isDisplayed();
	}

	public boolean verifyDeliveryOptionsPage() {
		return txtDeliveryOptions.isDisplayed();
	}

}