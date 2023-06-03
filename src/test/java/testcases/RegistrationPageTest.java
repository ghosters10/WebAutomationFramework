package testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.RegistrationPage;

public class RegistrationPageTest extends BaseTest {
	
	@BeforeMethod
	public void performLogin() {
		// LoginPageFlow.performLogin();
	}
	
	
	@Test
	public void registerNewStudent() {
		RegistrationPage reg = new RegistrationPage();
		reg.open();
	}

	/*
	 * @Test
	 * 
	 * @Epic("Login Component")
	 * 
	 * @Story("Test for valid login")
	 * 
	 * @Severity(SeverityLevel.BLOCKER) public void registerNewStudent() {
	 * RegistrationPage reg = new RegistrationPage(); reg.open(); }
	 */

}
