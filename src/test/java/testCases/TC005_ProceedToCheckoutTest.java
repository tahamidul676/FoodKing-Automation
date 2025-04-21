package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.AddItemsToCartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProceedToCheckoutPage;
import pageObjects.SearchItemsPage;
import testBase.BaseClass;

public class TC005_ProceedToCheckoutTest extends BaseClass {

	@Test(groups = { "EndToEnd" })
	public void checkOut()  {

		logger.info("***** Starting TC005_ProceedToCheckoutTest *****");

		try {
			// Home Page
			HomePage homePage = new HomePage(driver);
			homePage.clickLogin();

			// Login Page
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail(p.getProperty("email"));
			loginPage.setPassword(p.getProperty("password"));
			loginPage.clickLogin();

			// Search Page
			SearchItemsPage searchPage = new SearchItemsPage(driver);
			String getSearchText = p.getProperty("searchItems");
			searchPage.setSearch(getSearchText);

			// Add Items To Cart Page
			AddItemsToCartPage addCartPage = new AddItemsToCartPage(driver);
			addCartPage.setSearch();
			//addCartPage.setInstructions(p.getProperty("addInstructions"));
			addCartPage.clickAddToCart();

			// Proceed To Checkout Page
			ProceedToCheckoutPage proceedCheckoutPage = new ProceedToCheckoutPage(driver);
			proceedCheckoutPage.clickMyCart();
			proceedCheckoutPage.clickTakeaway();
			proceedCheckoutPage.clickProceedToCheckout();
			proceedCheckoutPage.clickPlaceOrder();

			String orderConfirmed = proceedCheckoutPage.orderConfirmedText();
			System.out.println("Notification Is: " + orderConfirmed);

			// Assert
			Assert.assertTrue(orderConfirmed.contains("Order Confirmed"),
					"Order Confirmed text mismatch. Expected: 'Order Confirmed', Actual: "
							+ orderConfirmed);

		} catch (Exception e) {

			logger.error("Test failed due to an exception", e);
			Assert.fail("Test assertion failed due to an exception: " + e.getMessage());

		}
		logger.info("***** Finished TC005_ProceedToCheckoutTest *****");
	}

}
