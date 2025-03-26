package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test()
	public void login() {

		logger.info("***** Starting TC002_LoginTest *****");

		try {
			// Home Page
			HomePage homePage = new HomePage(driver);
			homePage.clickLogin();

			// Login Page
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail(p.getProperty("email"));
			loginPage.setPassword(p.getProperty("password"));
			loginPage.clickLogin();
			
			String toasterNotification = loginPage.toaster();
			System.out.println("Notification Is: " + toasterNotification);

			// Assert
			Assert.assertTrue(toasterNotification.contains("Login Successfully"),
					"Toaster notification text mismatch. Expected: 'Login Successfully', Actual: "
							+ toasterNotification);

			
		} catch (Exception e) {
			
			logger.error("Test failed due to an exception", e);
			Assert.fail("Test assertion failed due to an exception: " + e.getMessage());

		}
		
		logger.info("***** Finished TC002_LoginTest *****");

	}

}
