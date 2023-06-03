package testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import bo.CredentialsBO;
import dataprovider.CredentialsProvider;
import drivermanager.DriverFactory;
import filereader.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageflow.LoginPageFlow;
import pages.LoginPage;

public class LoginPageTest extends BaseTest{

	@Test(dataProvider = "getLoginCredentials", dataProviderClass = CredentialsProvider.class)
	public void login(CredentialsBO creds) {
		Assert.assertTrue(LoginPageFlow.performLogin(creds), "User is not navigated to home page post login.");
	}

	@Test
	public void testErrorMessage() {

		LoginPage loginPage = new LoginPage();
		loginPage.open();
		loginPage.fillUsername("abc@gmail.com");
		loginPage.fillPassword("sadasdsa");

		boolean flag = loginPage.login();
		Assert.assertTrue(!flag, "User is able to login with invalid credentials");

		Assert.assertEquals(loginPage.getError(), "Login was unsuccessful. Please correct the errors and try again.");
	}
	/*
	 * @BeforeSuite public void setPrerequisites() { new ConfigReader(); }
	 */
	
	/*
	 * @Test(dataProvider = "getLoginCredentials", dataProviderClass =
	 * CredentialsProvider.class)
	 * 
	 * @Epic("Login Component")
	 * 
	 * @Story("Test for valid login")
	 * 
	 * @Severity(SeverityLevel.BLOCKER) public void login(CredentialsBO creds) {
	 * 
	 * Assert.assertTrue(LoginPageFlow.performLogin(creds)
	 * ,"User is not navigated to home page post login");
	 * 
	 * // driver.get("https://demo.nopcommerce.com/login"); // //
	 * driver.findElement(By.id("Email")).sendKeys("abc@gmail.com"); //
	 * driver.findElement(By.id("Password")).sendKeys("abc@gmail.com"); // //
	 * driver.findElement(By.cssSelector("div[class*=buttons]>[type=submit]")).click
	 * (); // // if(!driver.getCurrentUrl().contains("/home")) { //
	 * Assert.assertTrue(false, "User is not navigated to home page"); // } }
	 */
	
	/*
	 * @Test
	 * 
	 * @Epic("Login Component")
	 * 
	 * @Story("Test for valid login")
	 * 
	 * @Severity(SeverityLevel.BLOCKER) public void testErrorMessage() {
	 * 
	 * LoginPage loginPage = new LoginPage();
	 * loginPage.open("https://demo.nopcommerce.com/login");
	 * loginPage.fillUsername("abc@gmail.com");
	 * loginPage.fillPassword("abc@gmail.com");
	 * 
	 * boolean flag = loginPage.login();
	 * Assert.assertTrue(!flag,"User is able to login with invalid credentials");
	 * 
	 * Assert.assertEquals(loginPage.getError(),
	 * "Login was unsuccessful. Please correct the errors and try again.No customer account found"
	 * );
	 * 
	 * // driver.get("https://demo.nopcommerce.com/login"); // //
	 * driver.findElement(By.id("Email")).sendKeys("abc@gmail.com"); //
	 * driver.findElement(By.id("Password")).sendKeys("abc@gmail.com"); // //
	 * driver.findElement(By.cssSelector("div[class*=buttons]>[type=submit]")).click
	 * (); // // String error =
	 * driver.findElement(By.cssSelector(".validation-summary-errors")).getText();
	 * // // Assert.assertEquals(error,
	 * "Login was unsuccessful. Please correct the errors and try again.");
	 * 
	 * }
	 */
	
	@Test
	public void dummy() throws InterruptedException {
		System.out.println("Dummy Test");
		Thread.sleep(5000);
	}

}
