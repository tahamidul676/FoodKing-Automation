package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.AddItemsToCartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchItemsPage;
import testBase.BaseClass;

public class TC004_AddItemsToCartTest extends BaseClass {

	@Test()
	public void addItems()  {
		
		logger.info("***** Starting TC004_AddItemsToCartTest *****");

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
			
			// AddItemsToCartPage
			AddItemsToCartPage addCartPage = new AddItemsToCartPage(driver);
			addCartPage.setSearch();
			addCartPage.setInstructions(p.getProperty("addInstructions"));
			addCartPage.clickAddToCart();
			
			
		} catch (Exception e) {
			logger.error("Test failed due to an exception", e);
			Assert.fail("Test assertion failed due to an exception: " + e.getMessage());

		}

		logger.info("***** Finished TC004_AddItemsToCartTest *****");

	}
}
