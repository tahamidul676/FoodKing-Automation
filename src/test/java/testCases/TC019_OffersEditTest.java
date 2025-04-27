package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CouponPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OffersPage;
import testBase.BaseClass;

public class TC019_OffersEditTest extends BaseClass {

	@Test()
	public void addOffers() {

		logger.info("***** Starting TC019_OffersEditTest *****");
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
			offersPage.chooseNameToUpdate();
			offersPage.setName(p.getProperty("updateOfferName"));
			offersPage.setDiscountPercentage(p.getProperty("updateOfferDiscountPercentage"));

			// Coupons Page
			CouponPage couponsPage = new CouponPage(driver);
			couponsPage.clickSaveBtn();

			// Assert
			String expectedName = offersPage.getTextNameOffer();
			System.out.println("Extracted Text: " + expectedName);

			Assert.assertTrue(expectedName.toLowerCase().contains("offer-2026"));

		} catch (Exception e) {

			logger.error("Test failed due to an exception", e);
			Assert.fail("Test assertion failed due to an exception: " + e.getMessage());

		}
		logger.info("***** Finished TC019_OffersEditTest *****");
	}

}
