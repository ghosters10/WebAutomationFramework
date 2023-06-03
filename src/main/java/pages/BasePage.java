package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivermanager.DriverFactory;

public class BasePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Logger logger = LogManager.getLogger(LoginPage.class);
	
	public BasePage() {
		this.driver=DriverFactory.getCurrentDriver();
		wait= new WebDriverWait(this.driver, 10);
	}
	
	public BasePage( int waitTime) {
		this();
		wait= new WebDriverWait(this.driver, waitTime);
	}
	
	protected void openPage(String url) {
		logger.info("Navigating to Page:: " + url);
		driver.get(url);
	}
	
	protected void fillText(By by, String value) {
		WebElement ele = waitForElementToBePresent(by);
		ele.clear();
		ele.sendKeys(value);		
	}
	
	protected void click(By by) {
		// Screenshot before click
		waitForElementToBePresent(by).click();
		// Screenshot after click
	}
	
	protected String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	protected String getText(By by) {
		return waitForElementToBePresent(by).getText();
	}
	
	private WebElement waitForElementToBePresent(By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	protected void waitForPageLoad() {
		((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	}

}
