package com.crm.qa.testcases;

import java.io.IOException;

//import org.apache.log4j.PropertyConfigurator;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ValidationPage;
import com.crm.qa.pages.LoginPage;

public class AddToCartTest extends TestBase {

	ValidationPage verifyPage;
	LoginPage loginPage;

	public AddToCartTest() {
		super();

	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		verifyPage = new ValidationPage();
		loginPage = new LoginPage();
		System.out.println("URL Is OPEN");
		Thread.sleep(1000);

	}

	@Test(priority = 1)
	public void verifyProductAddedTOCart() {
		loginPage.searchTheProduct(prop.getProperty("searchProduct"));
		Assert.assertTrue(verifyPage.verifyAddTOCart(), "AddToCart Validated");
		loginPage.amazonLogin();
		Assert.assertFalse(verifyPage.verifyAddressPage(), "Address Page Validated");
		loginPage.addAddress();
		Assert.assertTrue(verifyPage.verifyDeliveryOptionsPage(), "Delivery Option Page validated");
		loginPage.deleteTheProduct();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}