package drivermanager.browsertypes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import drivermanager.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager implements DriverManager {

	@Override
	public WebDriver getDriver() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}

}
