package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CouponDeletePage;
import pageObjects.CouponsAddPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OffersAddPage;
import pageObjects.OffersDeletePage;
import pageObjects.UsersPage;
import testBase.BaseClass;
import utilities.RetryCountIfFailed;

public class TC021_AdministratorsAddTest extends BaseClass {
//retryAnalyzer = utilities.RetryAnalyzer.class

	@Test()
	// @RetryCountIfFailed(3)
	public void administratorsAdd() {

		logger.info("***** Starting TC021_AdministratorsAddTest *****");

		try {

			// Home Page
			HomePage homePage = new HomePage(driver);
			homePage.clickLogin();

			// Login Page
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail(p.getProperty("adminEmail"));
			loginPage.setPassword(p.getProperty("adminPassword"));
			loginPage.clickLogin();
			homePage.clickAccount();
			homePage.clickDashboard();

			// UsersPage Page
			UsersPage usersPage = new UsersPage(driver);
			usersPage.clickAdministrator();
			usersPage.clickaddAdministratorBtn();
			usersPage.setName(p.getProperty("administratorsName"));
			usersPage.setEmail(p.getProperty("administratorsEmail"));
			usersPage.setPhone(p.getProperty("administratorsPhone"));
			usersPage.activeBtn();
			usersPage.setPassword(p.getProperty("administratorsPassword"));
			usersPage.setPasswordConfirmation(p.getProperty("administratorsConfirmPassword"));
			usersPage.allBranchBtn();
			usersPage.clickSaveBtn();
			
		

			// Assert
			String expectedName = usersPage.getNameTxt(p.getProperty("administratorsName"));
		//	String expectedName = usersPage.getNameTxt();
			String originalItemName = p.getProperty("administratorsName");
			System.out.println("Extracted Text: " + expectedName);

			Assert.assertEquals(expectedName, originalItemName, "Administrators wasn't found successfully");

		} catch (Exception e) {
			logger.error("Test failed due to an exception", e);
			e.printStackTrace(); // Ensures full error visibility
			Assert.fail("Test assertion failed due to an exception: " + e.getMessage());

		}
		logger.info("***** Finished TC021_AdministratorsAddTest *****");
	}

}
