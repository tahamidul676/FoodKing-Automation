package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.AddItemsToCartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyOrdersPage;
import pageObjects.ProceedToCheckoutPage;
import pageObjects.SearchItemsPage;
import testBase.BaseClass;

public class TC006_MyOrdersTest extends BaseClass {

	@Test(groups= {"EndToEnd"})
	public void myOrders() {

		logger.info("***** Starting TC006_MyOrdersTest *****");

		try {
			// Home Page
			HomePage homePage = new HomePage(driver);
			homePage.clickLogin();

			// Login Page
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail(p.getProperty("email"));
			loginPage.setPassword(p.getProperty("password"));
			loginPage.clickLogin();

			// My Orders Page
			MyOrdersPage ordersPage = new MyOrdersPage(driver);
			homePage.clickAccount();
			ordersPage.clickMyOrders();
			ordersPage.clickSeeDetails();
			Thread.sleep(5000);
			String orderId = ordersPage.getOrderId();
			System.out.println("Order ID: " + orderId);

			String orderType = ordersPage.getOrderType();
			System.out.println("Order Type: " + orderType);

		} catch (Exception e) {

			logger.error("Test failed due to an exception", e);
			Assert.fail("Test assertion failed due to an exception: " + e.getMessage());

		}

		logger.info("***** Finished TC006_MyOrdersTest *****");

	}

}
