package testcases;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import drivermanager.DriverFactory;
import filereader.ConfigReader;

public class BaseTest {
	
	@BeforeSuite
	public void setPrerequisites() {
		// read all config file
		new ConfigReader();

		// initialize log properties
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
	}

	@BeforeMethod
	public void browserOpen() {
		DriverFactory.initiateDriver();
		System.out.println("Driver opened on Thread ID::" + Thread.currentThread().getId());
	}

	@AfterMethod
	public void closeBrowser() {
		DriverFactory.getCurrentDriver().quit();
	}

}
