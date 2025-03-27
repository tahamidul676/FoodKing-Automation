package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProceedToCheckoutPage extends BasePage {

	public ProceedToCheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[2]/button[1]")
	WebElement btnMyCart;

	@FindBy(xpath = "//input[@id='takeaway']")
	WebElement btnTakeaway;

	@FindBy(xpath = "//a[normalize-space()='Proceed to Checkout']")
	WebElement btnProceedToCheckout;
	
	@FindBy(xpath = "//button[normalize-space()='Place Order']")
	WebElement btnPlaceOrder;
	
	@FindBy(xpath = "//h3[normalize-space()='Order Confirmed']")
	WebElement getOrderConfirmText;

	// Explicit waits
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void clickMyCart() {

		wait.until(ExpectedConditions.elementToBeClickable(btnMyCart)).click();
		 btnMyCart.click();
	}

	public void clickTakeaway() {
		
		 btnTakeaway.click();
	}

	public void clickProceedToCheckout() {
		
		 btnProceedToCheckout.click();
	}

	public void clickPlaceOrder() {
		wait.until(ExpectedConditions.elementToBeClickable(btnPlaceOrder)).click();
	}
	
	public String orderConfirmedText() {
		try {
			wait.until(ExpectedConditions.visibilityOf(getOrderConfirmText));
			return getOrderConfirmText.getText();
		} catch (Exception e) {
			return "Order Confirm not found or text not visible";
		}
	}

}
