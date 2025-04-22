package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POSOrdersPage extends BasePage {

	public POSOrdersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()=\"POS Orders\"]")
	WebElement lnkPosOrders;

	@FindBy(xpath = "//table/tbody/tr[1]/td[1]")
	WebElement getOrderIdRowTxt;

	@FindBy(xpath = "//table//tr[1]/td[6]//a/i")
	WebElement btnViewPosOrders;

	// Payment Status-> Paid, Unpaid
	@FindBy(xpath = "//option[@value=\"5\" and contains(normalize-space(), \"Paid\")]")
	WebElement selectPaidPaymentStatusDropDown;

	@FindBy(xpath = "//option[@value=\"10\" and contains(normalize-space(), \"Unpaid\")]")
	WebElement selectUnPaidPaymentStatusDropDown;

	// Order Status -> Accept, Processing, Delivered
	@FindBy(xpath = "//option[@value=\"4\" and contains(normalize-space(), \"Accept\")]")
	WebElement selectAcceptOrderStatusDropDown;

	@FindBy(xpath = "//option[@value=\"7\" and contains(normalize-space(), \"Processing\")]")
	WebElement selectProcessingOrderStatusDropDown;

	@FindBy(xpath = "//option[@value=\"13\" and contains(normalize-space(), \"Delivered\")]")
	WebElement selectDeliveredOrderStatusDropDown;

	// Delivery Information
	@FindBy(xpath = "//h4[contains(normalize-space(), \"Dipon Das\")]")
	WebElement getNameTxt;
	@FindBy(xpath = "//span[contains(normalize-space(), \"das@gmail.com\")]")
	WebElement getEmailTxt;
	@FindBy(xpath = "//span[contains(normalize-space(), \"+8801790319999\")]")
	WebElement getPhoneTxt;
	
	// Delete POS Orders
	@FindBy(xpath ="//tbody/tr[1]/td[6]/div[1]/button[1]/i[1]")
	WebElement btnPosOrders;
	
	@FindBy(xpath ="//button[normalize-space()=\"Yes, Delete it!\"]")
	WebElement btnDeleteYes;
	
	


	// Explicit waits
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void clickPOSOrders() {
		lnkPosOrders.click();
	}

	public String getOrderIdTxt() {
		//wait.until(ExpectedConditions.elementToBeClickable(getOrderIdRowTxt));
		return getOrderIdRowTxt.getText();
	}

	public void clickViewPosOrdersBtn() {
		btnViewPosOrders.click();
	}

	// Payment Status
	public void selectPaidPaymentDropDown() {
		selectPaidPaymentStatusDropDown.click();
	}

	public void selectUnpaidPaymentDropDown() {
		selectUnPaidPaymentStatusDropDown.click();
	}

	// Order Status
	public void selectAcceptOrderDropDown() {
		selectAcceptOrderStatusDropDown.click();
	}

	public void selectProcessingOrderDropDown() {
		selectProcessingOrderStatusDropDown.click();
	}

	public void selectDeliveredOrderDropDown() {
		selectDeliveredOrderStatusDropDown.click();
	}

	// Delivery Information

	public String getPosOrdersNameTxt() {
		return getNameTxt.getText();
	}

	public String getPosOrdersEmailTxt() {
		return getEmailTxt.getText();
	}

	public String getPosOrdersPhoneTxt() {
		return getPhoneTxt.getText();
	}

	// Edit POS Order
	public void chooseNameToEdit(String orderID) {
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

		for (WebElement row : rows) {
			WebElement nameCell = row.findElement(By.xpath(".//td[1]"));
			if (nameCell.getText().trim().equalsIgnoreCase(orderID)) {
				WebElement viewButton = row.findElement(By.xpath(".//td[6]//a[1]"));

				wait.until(ExpectedConditions.elementToBeClickable(viewButton)).click();
				return;
			}
		}
		System.out.println("Not found: " + orderID);
	}
	
	// Delete POS Orders
	public void clickDeletePOSOrders() {
		btnPosOrders.click();
	}
	
	public void clickDeleteYesPOSOrders() {
		btnDeleteYes.click();
	}
	
	
	public void chooseNameToDelete(String orderID) {
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

		for (WebElement row : rows) {
			WebElement nameCell = row.findElement(By.xpath(".//td[1]"));
			if (nameCell.getText().trim().equalsIgnoreCase(orderID)) {
				WebElement viewButton = row.findElement(By.xpath(".//td/div[1]/button[1]"));

				wait.until(ExpectedConditions.elementToBeClickable(viewButton)).click();
				return;
			}
		}
		System.out.println("Not found: " + orderID);
	}
}
