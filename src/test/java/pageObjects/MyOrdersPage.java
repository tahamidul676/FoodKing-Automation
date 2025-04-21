package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyOrdersPage extends BasePage {

	public MyOrdersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//body//div//header//div//div//nav//a[1]")
	WebElement lnkMyOrders;

	@FindBy(xpath = "//li//div[1]//div[1]//div[1]//p[1]")
	WebElement matchedID;

	@FindBy(xpath = "//a[normalize-space()='See Details']")
	WebElement lnkSeeDetails;

	// Dynamic xpath for get the OrderID
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/h3[1]/span[1]")
	WebElement getOrderId;

	// Dynamic xpath for get the OrderType
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]")
	WebElement getOrderType;

	// Explicit waits
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void clickMyOrders() {
		lnkMyOrders.click();
	}

	public void clickSeeDetails() {
		wait.until(ExpectedConditions.elementToBeClickable(lnkSeeDetails)).click();

	}

	public String getOrderId() {
		wait.until(ExpectedConditions.visibilityOf(getOrderId));
		return getOrderId.getText();

	}

	public String getOrderType() {
		wait.until(ExpectedConditions.visibilityOf(getOrderType));
		return getOrderType.getText();
	}

	// Search for OrderID
	public void clickSeeDetailsForOrder(String targetOrderId) {
		List<WebElement> orderBlocks = driver.findElements(By.xpath("//li"));

		for (WebElement block : orderBlocks) {
			try {
				WebElement orderIdElement = block.findElement(By.xpath("//li//div[1]//div[1]//div[1]//p[1]"));//  .//div[1]//div[1]//div[1]//p[1]
				String orderIdText = orderIdElement.getText().trim();

				if (orderIdText.equals(targetOrderId)) {
					WebElement seeDetailsBtn = block.findElement(By.xpath("//a[normalize-space()='See Details']"));
					seeDetailsBtn.click();
					return; // Exit once clicked
				}
			} catch (Exception e) {
				System.out.println("Skipping block due to error: " + e.getMessage());
			}
		}

		throw new NoSuchElementException("Order ID " + targetOrderId + " not found.");
	}

}
