package testCases;

import org.testng.Assert;

import pageObjects.CouponsAddPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UsersPage;
import testBase.BaseClass;

public class TC030_EmployeeAddTest extends BaseClass{

	public void employeeAdd() { // Test

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

			// UsersPage Page //
			UsersPage usersPage = new UsersPage(driver);
			usersPage.clickCustomer();
			usersPage.setName(p.getProperty("customerName"));
			usersPage.setEmail(p.getProperty("customerEmail"));
			usersPage.setPhone(p.getProperty("customerPhone"));
			usersPage.activeBtn();
			usersPage.setPassword(p.getProperty("password"));
			usersPage.setPasswordConfirmation(p.getProperty("confirmPassword"));

			// Coupons Page
			CouponsAddPage couponsPage = new CouponsAddPage(driver);
			couponsPage.clickSaveBtn();

			// Assert
			String expectedName = usersPage.getNameTxt();
			String originalItemName = "Miron";
			System.out.println("Extracted Text: " + expectedName);

			Assert.assertEquals(expectedName, originalItemName, "Customer wasn't found successfully");

		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}
	}
}
