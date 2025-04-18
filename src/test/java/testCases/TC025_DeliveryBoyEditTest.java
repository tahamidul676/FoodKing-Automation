package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CouponsAddPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UsersPage;
import testBase.BaseClass;

public class TC025_DeliveryBoyEditTest extends BaseClass{

	@Test()
	public void deliveryBoyEdit() {

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

			// UsersPage Page
			UsersPage usersPage = new UsersPage(driver);
			usersPage.clickDeliveryBoy();
			usersPage.chooseNameToEdit();
			usersPage.setName(p.getProperty("updateDeliveryBoyName"));
			Thread.sleep(5000);

			// Coupons Page
			CouponsAddPage couponsPage = new CouponsAddPage(driver);
			couponsPage.clickSaveBtn();

			// Assert
			String expectedName = usersPage.getNameTxt();
			String originalItemName = "Zero";
			System.out.println("Extracted Text: " + expectedName);

			Assert.assertEquals(expectedName, originalItemName, "Delivery Boys wasn't found successfully");

		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}
	}
	
}
