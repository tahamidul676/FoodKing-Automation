package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CouponPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OffersPage;
import testBase.BaseClass;

public class TC018_OffersAddTest extends BaseClass {

	@Test()
	public void addOffers() {
		
		logger.info("***** Starting TC018_OffersAddTest *****");

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
			offersPage.addOffersBtn();
			offersPage.setName(p.getProperty("offerName"));
			offersPage.setDiscountPercentage(p.getProperty("offerDiscountPercentage"));
			offersPage.clickStartDate();
			offersPage.clickSDate();
			offersPage.clickEndDate();
			offersPage.clickEDate();
			offersPage.selectFileUpload();

			// Coupons Page
			CouponPage couponsPage = new CouponPage(driver);
			couponsPage.clickSaveBtn();

			// Assert
			String expectedName = offersPage.getNameTxt();
			Assert.assertTrue(expectedName.toLowerCase().contains("offer-2025"));

		} catch (Exception e) {
			
			logger.error("Test failed due to an exception", e);
			Assert.fail("Test assertion failed due to an exception: " + e.getMessage());

		}
		
		logger.info("***** Finished TC018_OffersAddTest *****");
	}

}
