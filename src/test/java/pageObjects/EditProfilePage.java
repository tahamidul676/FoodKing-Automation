package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditProfilePage extends BasePage {

	public EditProfilePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//body//div//header//div//div//a[2]")
	WebElement lnkEditProfile;
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement txtFirstName;
	@FindBy(xpath = "//input[@id='last_name']")
	WebElement txtLastName;
	@FindBy(xpath = "//input[@id='email']")
	WebElement txtEmail;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement txtPhone;
	@FindBy(xpath = "//button[normalize-space()='Update Profile']")
	WebElement btnUpdateProfile;

	// Explicit waits
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void clickEditProfile() {
		wait.until(ExpectedConditions.elementToBeClickable(lnkEditProfile)).click();

	}

	public void setFirstName(String fname) {
		wait.until(ExpectedConditions.visibilityOf(txtFirstName)).clear();
		txtFirstName.sendKeys(fname);

	}

	public void setLastName(String lname) {
		wait.until(ExpectedConditions.visibilityOf(txtLastName)).clear();

	}

	public void setEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(txtEmail)).clear();

	}

	public void setPhone(String phone) {
		wait.until(ExpectedConditions.visibilityOf(txtPhone)).clear();

	}

	public void clickUpdateProfileBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(btnUpdateProfile)).click();

	}

}
