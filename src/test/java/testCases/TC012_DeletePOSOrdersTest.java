package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.POSOrdersPage;
import testBase.BaseClass;

public class TC012_DeletePOSOrdersTest extends BaseClass {

	@Test()
	public void deletePosOrders() {

		logger.info("***** Starting TC012_DeletePOSOrdersTest *****");

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

			// POS Order Page
			POSOrdersPage posOrdersPage = new POSOrdersPage(driver);
			posOrdersPage.clickPOSOrders();
			posOrdersPage.chooseNameToDelete(p.getProperty("DeleteOrderID"));
			// posOrdersPage.clickDeletePOSOrders();
			posOrdersPage.clickDeleteYesPOSOrders();

		} catch (Exception e) {

			logger.error("Test failed due to an exception", e);
			Assert.fail("Test assertion failed due to an exception: " + e.getMessage());

		}

		logger.info("***** Finished TC012_DeletePOSOrdersTest *****");
	}

}
