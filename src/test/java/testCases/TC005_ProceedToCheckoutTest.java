package testCases;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.AddItemsToCartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProceedToCheckoutPage;
import pageObjects.SearchItemsPage;
import testBase.BaseClass;

public class TC005_ProceedToCheckoutTest extends BaseClass {

	@Test()
	public void checkOut() throws InterruptedException {

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
		//Thread.sleep(3000);
		// Add Items To Cart Page
		AddItemsToCartPage addCartPage = new AddItemsToCartPage(driver);
		addCartPage.setSearch();
		addCartPage.setInstructions(p.getProperty("addInstructions"));
		addCartPage.clickAddToCart();
		//Thread.sleep(3000);
		ProceedToCheckoutPage proceedCheckoutPage = new ProceedToCheckoutPage(driver);
		proceedCheckoutPage.clickMyCart();
		proceedCheckoutPage.clickTakeaway();
		proceedCheckoutPage.clickProceedToCheckout();
		proceedCheckoutPage.clickPlaceOrder();
		

	}

}
