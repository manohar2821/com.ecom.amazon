package main.java.basepage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.apache.commons.io.FileUtils;

public class BasePage {
	
	protected WebDriver driver;
	public WebDriverWait wait;
	
	public WebDriver getDriver() {
        return driver;
    }

	@BeforeSuite
	public void invokeBrowser() {
		 driver = new ChromeDriver();
		 System.out.println("Broswer Invoked");
		 wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
		 driver.manage().window().maximize();
	}
	
	public void closeBroswer() {
		driver.quit();
		System.out.println("Test Completed");
	}
	
	@BeforeMethod
	public void launchApplication() throws Exception {
		driver.get("https://www.amazon.in/");
		captureScreenshot("Home Page");
	}
	
	public WebElement waitForElementToBePresent(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitForPageToBeloaded(int num) {
		ExpectedCondition<Boolean> pageLoadCondition = driver ->
        	((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        new WebDriverWait(driver, Duration.ofSeconds(num)).until(pageLoadCondition);
	}
	
	public void clickOnElement(By locator) {
		WebElement ele = waitForElementToBePresent(locator);
		ele.click();
	}
	
	public void sendKeys(By locator, String value) {
		WebElement ele = waitForElementToBePresent(locator);
		ele.sendKeys(value);
	}
	
	public boolean isElementPresent(By locator) {
		if(driver.findElement(locator).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void scrollToElement(By ele) {
		WebElement element = driver.findElement(ele);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void captureScreenshot(String webPageName) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File(webPageName+".png");
		FileUtils.copyFile(screenshot, destination);
	}
	

}
