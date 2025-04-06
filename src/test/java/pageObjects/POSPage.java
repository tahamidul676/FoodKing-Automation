package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.TokenGenerator;

public class POSPage extends BasePage {

	public POSPage(WebDriver driver) {
		super(driver);
	}

	

	@FindBy(xpath = "//span[normalize-space()='POS']")
	WebElement lnkPOS;

	// Dynamic xpaths for handle "Add" products in the Add to the product list
	@FindBy(xpath = "(//button[@data-modal='#item-variation-modal'])[3]")
	WebElement btnAddItems;

	@FindBy(xpath = "//textarea[@placeholder='Add note (extra mayo, cheese, etc.)']")
	WebElement txtSpecialInstructions;

	// Dynamic xpaths for handle "Add to Cart" products in the list
	@FindBy(xpath = "//span[contains(normalize-space(), 'Add to Cart')]")
	WebElement btnAddToCart;

	@FindBy(xpath = "//span[@class='icon arrow-downward']")
	WebElement selectDropDown;

	// Change Customer according to their Name
	@FindBy(xpath = "//span[normalize-space()='Dipon Das']")
	WebElement selectCustomerDropDown;

	@FindBy(xpath = "//input[@id='token']")
	WebElement txtToken;

	// Dynamic xpaths for handle items name
	@FindBy(xpath = "//table//tr[1]//td[2]//h3")
	WebElement getItemsTxt;

	// Dynamic xpaths for handle size
	@FindBy(xpath = "//table//tbody//tr[1]//td[2]//p//span//span[2]")
	WebElement getSizeTxt;

	@FindBy(xpath = "//option[@value='2']")
	WebElement selectCardDropdown;

	@FindBy(xpath = "//input[@placeholder=\"Enter last 4 digits of card\"]")
	WebElement txtLastDigitCard;

	@FindBy(xpath = "//button[normalize-space()=\"Order\"]")
	WebElement btnOrder;

	// Get Order ID from print(Dynamic xpath)
	@FindBy(xpath = "//td[contains(normalize-space(text()), 'Order')]")
	WebElement getOrderIdTxt;

	// Get Order Payment Type: from print(Dynamic xpath)
	@FindBy(xpath = "//p[normalize-space(text())='Payment Type: Card']")
	WebElement getPaymentTypeTxt;
	
	@FindBy(xpath = "//h4[normalize-space()='Token #%s']")
	WebElement getTokenTxt;
	

//	@FindBy(xpath = "//input[@type='number']")
//	WebElement getQuantityTxt;

	// Explicit waits
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


	public void clickPOS() {
		lnkPOS.click();
	}

	public void clickAddItemsBtn() {
		btnAddItems.click();
	}

	public void setSpecialInstruction(String specialInstructions) {
		txtSpecialInstructions.sendKeys(specialInstructions);
	}

	public void clickAddToCartBtn() {
		btnAddToCart.click();
	}

	// Select customer dropdown
	public void clickDropDown() {
		wait.until(ExpectedConditions.elementToBeClickable(selectDropDown)).click();
		//selectDropDown.click();
	}

	public void clickCustomerDropDown() {
		wait.until(ExpectedConditions.elementToBeClickable(selectCustomerDropDown)).click();
		//selectCustomerDropDown.click();
	}
	
	// It will increment the token and stored in a .text file
	public void setToken() {
	    String token = TokenGenerator.getNextToken();
	    txtToken.sendKeys(token);
	}


	public String getItemsText() {
		return getItemsTxt.getText();
	}

	public String getSizeText() {
		return getSizeTxt.getText();
	}

	public void selectPaymentMethodDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(selectCardDropdown)).click();
		//selectCardDropdown.click();
	}

	public void setLastDigitCard(String lastdigit) {
		txtLastDigitCard.sendKeys(lastdigit);
	}

	public void clickOrderBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(btnOrder)).click();
		//btnOrder.click();
	}

	public String getPrintOrderIDTxt() {
		wait.until(ExpectedConditions.visibilityOf(getOrderIdTxt));
		return getOrderIdTxt.getText();
	}

	public String getPrintPaymentTypeTxt() {
		wait.until(ExpectedConditions.visibilityOf(getPaymentTypeTxt));
		return getPaymentTypeTxt.getText();
	}
	
	public String getTokenNumberTxt() {
		wait.until(ExpectedConditions.visibilityOf(getTokenTxt));
		return getTokenTxt.getText();
	}

}
