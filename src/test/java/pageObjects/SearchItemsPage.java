package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchItemsPage extends BasePage {

	public SearchItemsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement txtSearch;
	
	// Explicit waits
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void setSearch(String nameOfSearchItems) {
		wait.until(ExpectedConditions.elementToBeClickable(txtSearch)).click();
		txtSearch.sendKeys(nameOfSearchItems);
		txtSearch.sendKeys(Keys.RETURN);
	}

}
