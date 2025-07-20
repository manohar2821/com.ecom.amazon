package main.java.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.basepage.BasePage;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
	}
	
	private static final By CONTINUE_SHOPPING = By.xpath("//button[@type='submit' or .='Continue shopping']");
	private static final By TEXT_BOX = By.xpath("//input[@id='twotabsearchtextbox']");
	private static final By SEARCH = By.xpath("//input[@type='submit']");
	private static final By SEARCH_RESULTS = By.xpath("//div[@class='a-section']/div[@class='puisg-row']");
	private static final By APPLE_CHECKBOX = By.xpath("//span[text()='Apple']//parent::a//div//..//i[@class='a-icon a-icon-checkbox']");
	
	public void searchForMobile() throws Exception {
		handleContinueShopping();
		clickOnElement(TEXT_BOX);
		sendKeys(TEXT_BOX, "iPhone 16");
		captureScreenshot("search");
		clickOnElement(SEARCH);
		waitForPageToBeloaded(30);
	}
	
	public void selectBrand() throws Exception {
		scrollToElement(APPLE_CHECKBOX);
		captureScreenshot("apple");
		clickOnElement(APPLE_CHECKBOX);
		waitForPageToBeloaded(30);	
	}
	
	public void handleContinueShopping() {
		if(isElementPresent(CONTINUE_SHOPPING)) {
			clickOnElement(CONTINUE_SHOPPING);
		}
	}
	
	public void captureSearchResults() throws Exception {
		List<WebElement> results = driver.findElements(SEARCH_RESULTS);
		int num = results.size();
		System.out.println("No. of search results displayed: "+num);
	}
	

}
