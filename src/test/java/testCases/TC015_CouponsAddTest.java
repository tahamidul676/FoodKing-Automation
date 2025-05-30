package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CouponPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OnlineOrdersPage;
import pageObjects.POSOrdersPage;
import pageObjects.TableOrdersPage;
import testBase.BaseClass;
import org.testng.asserts.SoftAssert;

public class TC015_CouponsAddTest extends BaseClass {

	@Test()
	public void addCoupons() {

		logger.info("***** Starting TC015_CouponsAddTest *****");
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
			couponsPage.clickAddCoupon();
			couponsPage.setName(p.getProperty("couponName"));
			couponsPage.setCode(p.getProperty("couponCode"));
			couponsPage.setDiscount(p.getProperty("couponDiscount"));
			couponsPage.clickStartDate();
			couponsPage.clickSDate();
			couponsPage.clickEndDate();
			couponsPage.clickEDate();
			couponsPage.setMinimumOrder(p.getProperty("couponMinimumOrder"));
			couponsPage.setMaximumDiscount(p.getProperty("couponMaximumDiscount"));
			couponsPage.setLimitUser(p.getProperty("coponLimitUser"));
			couponsPage.selectFileUpload();
			couponsPage.setDescription(p.getProperty("couponDescription"));
			couponsPage.clickSaveBtn();

			// Assert
			String expectedName = couponsPage.getNameTxt();
			Assert.assertTrue(expectedName.toLowerCase().contains("auth-2025"));

		} catch (Exception e) {
			
			logger.error("Test failed due to an exception", e);
			Assert.fail("Test assertion failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Finished TC015_CouponsAddTest *****");
	}

}
