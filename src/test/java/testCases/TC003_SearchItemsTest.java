package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchItemsPage;
import testBase.BaseClass;

public class TC003_SearchItemsTest extends BaseClass {

	@Test()
	public void search() {

		logger.info("***** Starting TC003_SearchItemsTest *****");

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
			System.out.println("Searching Text :" + getSearchText);

			Assert.assertEquals("Burger", getSearchText);
 
			
		} catch (Exception e) {
			logger.error("Test failed due to an exception", e);
			Assert.fail("Test assertion failed due to an exception: " + e.getMessage());

		}

		logger.info("***** Finished TC003_SearchItemsTest *****");

	}
}
