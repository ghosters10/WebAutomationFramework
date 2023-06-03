package drivermanager.browsertypes;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import drivermanager.BrowserType;
import drivermanager.DriverManager;
import filereader.ConfigReader;

public class RemoteDriverManager implements DriverManager {

	@Override
	public WebDriver getDriver() {
		WebDriver driver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// get config from properties file
		String browser = ConfigReader.getProperty("browser");
		String os = ConfigReader.getProperty("platform");
		String hubUrl = ConfigReader.getProperty("hubUrl");

		// set browser specific configurations
		switch (BrowserType.valueOf(browser.toUpperCase())) {
		case CHROME:
			ChromeOptions options = new ChromeOptions();
			// set download = true, do not show windows popup while downloading
			Map<String, Object> preferences = new HashMap<String, Object>();
			preferences.put("download.prompt_for_download", false);
			preferences.put("download.default_directory", "/Users/user/Downloads");

			options.setExperimentalOption("prefs", preferences);

			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			break;
		case FIREFOX:
			// set firefox options
			// assign that option to capabilities object
			break;

		default:
			throw new IllegalStateException("Unsupported Browser Provided.");

		}

		capabilities.setBrowserName(browser);

		// best way is to write a switch case to set the platform
		capabilities.setPlatform(Platform.MAC);

		try {
			driver = new RemoteWebDriver(new URL(hubUrl), capabilities);
		} catch (MalformedURLException e) {
			throw new IllegalStateException("UNable to create driver to execute on Grid" + e);
		}

		return driver;
	}

}
