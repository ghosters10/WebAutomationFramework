package drivermanager.browsertypes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import drivermanager.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager implements DriverManager{

	@Override
	public WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}

}
