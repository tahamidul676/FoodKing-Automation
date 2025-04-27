package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CouponPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OffersPage;
import testBase.BaseClass;

public class TC020_OffersDeleteTest extends BaseClass {

	@Test()
	public void offersDelete() {

		logger.info("***** Starting TC020_OffersDeleteTest *****");

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

			// Offers Page
			OffersPage offersPage = new OffersPage(driver);
			offersPage.clickOffers();
			offersPage.chooseNameToDelete();

			// Coupon Delete Page
			CouponPage couponPage = new CouponPage(driver);
			couponPage.deleteBtn();

			// Assert
			String expectedName = offersPage.getTextNameOfferEdit();
			String originalItemName = "Offer-2026";
			System.out.println("Extracted Text: " + expectedName);

			Assert.assertEquals(expectedName, originalItemName, "Item was deleted successfully");

		} catch (Exception e) {
			logger.error("Test failed due to an exception", e);
			Assert.fail("Test assertion failed due to an exception: " + e.getMessage());

		}
		logger.info("***** Finished TC020_OffersDeleteTest *****");
	}

}
