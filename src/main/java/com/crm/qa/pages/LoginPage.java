package com.crm.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(css = "#twotabsearchtextbox")
	WebElement txtSearchProduct;

	@FindBy(xpath = "//*[@id='nav-search-submit-button']")
	WebElement btnSearchSubmit;

	@FindBy(xpath = "//*[contains(text(),'New Apple iPhone 11 (128GB) - Black')]")
	WebElement selectproduct;

	@FindBy(xpath = "//*[@id='addToCart']//*[@id='add-to-cart-button']")
	private WebElement btnAddTOCart;

	@FindBy(css = "#a-autoid-11-announce")
	private WebElement btnExtraGB;

	@FindBy(css = "#hlb-ptc-btn-native")
	private WebElement btnProceedToBuy;
	
	@FindBy(xpath = "//*[@id='ap_email']")
	private WebElement email;

	@FindBy(xpath = "(//a[@data-action='page-spinner-show'])[1]")
	private WebElement btnAddress;

	

	@FindBy(xpath = "//input[@id='continue']")
	private WebElement btnContine;

	@FindBy(xpath = "//input[@id='ap_password']")
	private WebElement pwd;
	
	
	

	@FindBy(css = "#signInSubmit")
	private WebElement btnSubmit;

	

	@FindBy(xpath = "//*[@class='a-row a-spacing-medium']//*[@class='a-button-inner']")
	private WebElement btnContinue;

	@FindBy(xpath = "//*[@class='a-row sc-action-links']//*[@data-action='delete']")
	private WebElement btnDelete;

	public WebElement getBtnAddTOCart() {
		return btnAddTOCart;
	}

	public WebElement getBtnProceedToBuy() {
		return btnProceedToBuy;
	}

	public WebElement getTxtEmail() {
		return email;
	}

	public WebElement getBtnContine() {
		return btnContine;
	}

	public WebElement getTxtPwd() {
		return pwd;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

//Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

//public HomePage login(String un, String pwd){
//username.sendKeys(un);
//password.sendKeys(pwd);
//loginBtn.click();
	// JavascriptExecutor js = (JavascriptExecutor)mdriver;
	// js.executeScript("arguments[0].click();", loginBtn);

// return new HomePage();
//}

	public void searchTheProduct(String searchProduct) {
		txtSearchProduct.sendKeys(searchProduct);
//password.sendKeys(pwd);
//loginBtn.click();
		btnSearchSubmit.click();
		System.out.println("First Window " + driver.getTitle());
		selectproduct.click();
		explicitWait(5);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String parent = it.next();
			String newwin = it.next();
			driver.switchTo().window(newwin);
		}

		explicitWait(5);
		btnAddTOCart.click();

	}

	public void amazonLogin() {
		getBtnProceedToBuy().click();
		getTxtEmail().sendKeys("userName");
		getBtnContine().click();
		getTxtPwd().sendKeys("Test@123");
		getBtnSubmit().click();

	}

	public void addAddress() {
		btnAddress.click();

	}

	public void deleteTheProduct() {
		btnContinue.click();
		driver.navigate().to("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");
		explicitWait(5);
		btnDelete.click();

	}

	public static void explicitWait(int waitTime) {

		try {
			Thread.sleep(waitTime * 1000);
		} catch (InterruptedException e) {

		}
	}

}
