package test.java;

import main.java.basepage.BasePage;
import main.java.pages.HomePage;
import org.testng.annotations.Test;

public class LoginTest extends BasePage {
	
	@Test
	public void appLogin() {
		try {
			HomePage homePage = new HomePage(driver);
			homePage.searchForMobile();
			homePage.selectBrand();
			homePage.captureSearchResults();
		} catch(Exception e){
			System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
		} finally {
			closeBroswer();
		}
	}
	
	@Test
	public void applicationInvoke() {
		try {
			HomePage homePage = new HomePage(driver);
			homePage.searchForMobile();
		} catch(Exception e){
			System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
		}
	}
	
	

}
