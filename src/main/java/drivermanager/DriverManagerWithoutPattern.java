package drivermanager;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManagerWithoutPattern {
	
	
	public static WebDriver getDriver() {
		// read browser from config.properties file
		String browser = "Chrome";
		WebDriver driver = null;
		switch(browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			
			Map<String, Object> preferences = new HashMap<String, Object>();
			preferences.put("download.prompt_for_download", false);
			preferences.put("download.default_directory", "/Users/user");
			
			options.setExperimentalOption("prefs", preferences);
			
			driver = new ChromeDriver(options);
			break;
		
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options1 = new FirefoxOptions();
			
			FirefoxProfile profile = new FirefoxProfile();
			//profile.setPreference(browser, false);
			
			profile.setPreference("browser.download.manager.showWhenStarting", false);
			profile.setPreference("browser.helperApps.alwaysAsk.force", false);
			profile.setPreference("browser.download.dir", "/Users/user");
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
			options1.setProfile(profile);
			
			
			driver = new FirefoxDriver();
			break;
		}
		
		driver.manage().window().maximize();
		return driver;
	}

}
