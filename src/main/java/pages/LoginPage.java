package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import filereader.ConfigReader;
import utilities.Screenshot;

public class LoginPage extends BasePage{
	
	Logger logger = LogManager.getLogger(LoginPage.class);
	
	private String pageUrl = ConfigReader.getProperty("baseUrl") + "/login";
	
	// Page Locators
	By email_Textbox = By.id("Email");
	By password_Textbox = By.id("Password");
	By submit_Button = By.cssSelector("div[class*=buttons]>[type=submit]");
	By errorMessage_Text= By.cssSelector(".validation-summary-errors");
	
	
	public void open() {
		openPage(pageUrl);
	}
	
	public void fillUsername(String username) {
		fillText(email_Textbox, username);
	}
	
	public void fillPassword(String password) {
		fillText(password_Textbox, password);
	}
	
	public boolean login() {
		click(submit_Button);
		waitForPageLoad();
		Screenshot.capture("After Login");
		return getCurrentUrl().contains("/home");			
	}
	
	public String getError() {
		return getText(errorMessage_Text);
	}

}
