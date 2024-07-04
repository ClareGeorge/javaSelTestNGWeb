package tests;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pageobjects.CategoryPage;

import pageobjects.JPetStoreInitialPage;
import pageobjects.SignOnPage;
import resources.EComUtilsSeleniumWebApp;

/*
 * - uses Page Objects
 * - uses Findby decorators
 * - uses listeners
 * - no test data file
 */
public class SampleTest_1 extends EComUtilsSeleniumWebApp {
	
	SignOnPage signon_page;
	CategoryPage home_page ;
	@Test(priority = 1)
	public void navigate_to_JPetStore_SignIn_page() {

		JPetStoreInitialPage initial_page = new JPetStoreInitialPage(driver);
		signon_page = initial_page.navigateToJPetStore();
		
		/*
		 * driver.get("https://petstore.octoperf.com/");
		 * driver.getTitle().equals("JPetStore Demo");
		 * driver.findElement(By.xpath("//a[text()='Enter the Store']")).click();
		 * driver.findElement(By.xpath("//a[text()='Sign In']")).click()
		 */;

	}

	@Test(priority = 2)
	public void enter_user_credential_and_login() {

		/*
		 * driver.findElement(By.xpath("//form//input[@name='username']")).sendKeys(
		 * "clare");
		 * driver.findElement(By.xpath("//form//input[@name='password']")).clear();
		 * driver.findElement(By.xpath("//form//input[@name='password']")).sendKeys(
		 * "test");
		 * driver.findElement(By.xpath("//form//input[@name='signon']")).click();
		 */
		home_page = signon_page.enterUserCredentials("clare", "test");
	}

	@Test(priority = 3)
	public void verifyHomePage() {
		//driver.findElement(By.id("WelcomeContent")).getText().strip().substring(0, 7).equals("Welcome");
		home_page.verifyWelcomeMessage("Welcome");
		
	}
}
