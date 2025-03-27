package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test()
	public void registrationOnAccount()  {

		logger.info("***** Starting TC001_AccountRegistrationTest *****");

		try {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickLogin();

		AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);

		registrationPage.clickSignupLink();
		registrationPage.setMobileNumber(p.getProperty("mobileNumber"));
		registrationPage.clickNext();
		String toastText = registrationPage.getToastNotification();
		System.out.println("Toast Message: " + toastText);
		// Assert.assertTrue(toastText.contains("Please check your phone for the code.")
		// || toastText.contains("Please check your phone for the code."), "Toast
		// message validation failed!");

		registrationPage.setFirstName(p.getProperty("firstName"));
		registrationPage.setLastName(p.getProperty("lastName"));
		registrationPage.setEmail(p.getProperty("email"));
		registrationPage.setPassword(p.getProperty("password"));
		registrationPage.clickSignupBtn();
		
		} catch (Exception e) {

			logger.error("Test failed due to an exception", e);
			Assert.fail("Test assertion failed due to an exception: " + e.getMessage());

		}
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		
	}
}
