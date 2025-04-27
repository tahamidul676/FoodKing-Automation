package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CouponPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC016_CouponsEditTest extends BaseClass {

	@Test()
	public void editCoupons() {
		
		logger.info("***** Starting TC016_CouponsEditTest *****");
		
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

			// Coupons Page
			CouponPage couponsPage = new CouponPage(driver);
			couponsPage.clickCoupon();
			couponsPage.chooseNameToUpdate();
			couponsPage.setName(p.getProperty("updateCouponName"));
			couponsPage.setCode(p.getProperty("updateCouponCode"));
			Thread.sleep(5000);
			couponsPage.clickSaveBtn();
			
			// Assert
			 String expectedName = couponsPage.getTxtNameCoupon();
			 System.out.println("Extracted Text: " + expectedName);
			// Assert.assertTrue(expectedName.toLowerCase().contains("Auth-"));

		} catch (Exception e) {
			logger.error("Test failed due to an exception", e);
			Assert.fail("Test assertion failed due to an exception: " + e.getMessage());

		}
		logger.info("***** Finished TC016_CouponsEditTest *****");
	}

}
