package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyOrdersPage;
import pageObjects.PaymentGatewayPage;
import testBase.BaseClass;

public class TC007_PaymentGatewayTest extends BaseClass{

	
	
	@Test(groups= {"EndToEnd"})
	public void payNow() {
		
		logger.info("***** Starting TC007_PaymentGatewayTest *****");

		try {

		// Home Page
		HomePage homePage = new HomePage(driver);
		homePage.clickLogin();

		// Login Page
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(p.getProperty("email"));
		loginPage.setPassword(p.getProperty("password"));
		loginPage.clickLogin();
		
		//My Orders Page
		MyOrdersPage ordersPage = new MyOrdersPage(driver);
		homePage.clickAccount();
		ordersPage.clickMyOrders();
		ordersPage.clickSeeDetails();
		
		
		//Payment Gateway Page
		PaymentGatewayPage paymentpage = new PaymentGatewayPage(driver);
		
		paymentpage.clickPayNow();
		//Thread.sleep(7000);
		paymentpage.clickStripe();
		//Thread.sleep(7000);
		paymentpage.enterCardDetails(
			    p.getProperty("testCardNumber"), 
			    p.getProperty("testExpiryDate"), 
			    p.getProperty("testCVC")
			);
		Thread.sleep(7000);
		
		paymentpage.clickConfirm(); // Confirm the payment
		
		} catch (Exception e) {

			logger.error("Test failed due to an exception", e);
			Assert.fail("Test assertion failed due to an exception: " + e.getMessage());

		}

		logger.info("***** Finished TC007_PaymentGatewayTest *****");
		

		

	}
}
