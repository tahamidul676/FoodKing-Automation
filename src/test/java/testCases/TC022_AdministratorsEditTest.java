package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CouponsAddPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UsersPage;
import testBase.BaseClass;

public class TC022_AdministratorsEditTest extends BaseClass{

	@Test()
	public void administratorsedit() {

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
			usersPage.clickAdministrator();
			//usersPage.chooseNameToEdit();
			usersPage.chooseNameToEdit(p.getProperty("administratorsName"));
			usersPage.setName(p.getProperty("updateAdministratorsName"));
			Thread.sleep(5000);
			// Coupons Page
			CouponsAddPage couponsPage = new CouponsAddPage(driver);
			couponsPage.clickSaveBtn();

			// Assert
		//	String expectedName = usersPage.getNameTxt();
		//	String originalItemName = "Jensen";
		//	System.out.println("Extracted Text: " + expectedName);

		//	Assert.assertEquals(expectedName, originalItemName, "Administrators not found successfully");

		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}
	}

}
