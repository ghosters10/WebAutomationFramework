package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import filereader.ConfigReader;

public class RegistrationPage extends BasePage {
	
	Logger logger = LogManager.getLogger(RegistrationPage.class);

	private String pageUrl = ConfigReader.getProperty("baseUrl") + "/register";

	// page specific locators
	By registerUser_Textbox = By.id("register");

	public void open() {
		openPage(pageUrl);
	}

	// page specific methods
	public void registrationName(String name) {
		fillText(registerUser_Textbox, name);
	}

}
