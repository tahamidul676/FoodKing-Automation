package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentGatewayPage extends BasePage {

	public PaymentGatewayPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='Pay Now']")
	WebElement btnPayNow;

	@FindBy(xpath = "//input[@id='stripe']")
	WebElement selectStripe;
	
	
	@FindBy(xpath = "//button[@id='confirmBtn']")
	WebElement btnConfirm;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/dl[1]/dd[1]")
	WebElement getTransactionID;

	// Wait object for explicit waits
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	public void clickPayNow() {
		wait.until(ExpectedConditions.elementToBeClickable(btnPayNow)).click();
		// btnPayNow.click();
	}

	public void clickStripe() {
		selectStripe.click();
	}

	public void clickConfirm() {

		wait.until(ExpectedConditions.elementToBeClickable(btnConfirm)).click();

	}


	// Method to dynamically switch to the Stripe iframe with Explicit Wait
	public void switchToStripeIframe() {
		WebElement stripeIframe = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//iframe[contains(@name, 'privateStripeFrame')]")));
		driver.switchTo().frame(stripeIframe);
	}

	// Method to switch back to the main page
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public void enterCardDetails(String cardNumber, String expiryDate, String cvc) {
		switchToStripeIframe(); // Switch to iframe first

		WebElement cardInput = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Card number']")));
		WebElement expiryInput = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='MM / YY']")));
		WebElement cvcInput = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='CVC']")));

		cardInput.sendKeys(cardNumber);
		expiryInput.sendKeys(expiryDate);
		cvcInput.sendKeys(cvc);

		switchToDefaultContent(); // Switch back to main content
	}
	
	public String getTransactionID() {
		return getTransactionID.getText();
	}
	
	
	

}
