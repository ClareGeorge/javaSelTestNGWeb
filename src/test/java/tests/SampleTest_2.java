package tests;

import static org.testng.Assert.assertFalse;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.CategoryPage;

import pageobjects.JPetStoreInitialPage;
import pageobjects.SignOnPage;
import resources.EComUtilsSeleniumWebApp;
import resources.TestDataBuild;

/*
 * - uses Page Objects
 * - uses Findby decorators
 * - uses listeners
 * - uses JSON test data file
 */
public class SampleTest_2 extends EComUtilsSeleniumWebApp {
	
	SignOnPage signon_page;
	CategoryPage home_page ;
	@Test(priority = 1, dataProvider = "getTestJsonData")
	public void navigate_to_JPetStore_SignIn_page(HashMap<String, String> testData) {

		JPetStoreInitialPage initial_page = new JPetStoreInitialPage(driver);
		signon_page = initial_page.navigateToJPetStore();
		
		/*
		 * driver.get("https://petstore.octoperf.com/");
		 * driver.getTitle().equals("JPetStore Demo");
		 * driver.findElement(By.xpath("//a[text()='Enter the Store']")).click();
		 * driver.findElement(By.xpath("//a[text()='Sign In']")).click()
		 */;

	
		/*
		 * driver.findElement(By.xpath("//form//input[@name='username']")).sendKeys(
		 * "clare");
		 * driver.findElement(By.xpath("//form//input[@name='password']")).clear();
		 * driver.findElement(By.xpath("//form//input[@name='password']")).sendKeys(
		 * "test");
		 * driver.findElement(By.xpath("//form//input[@name='signon']")).click();
		 */
		home_page = signon_page.enterUserCredentials(testData.get("username"), testData.get("password"));
	
		//driver.findElement(By.id("WelcomeContent")).getText().strip().substring(0, 7).equals("Welcome");
		home_page.verifyWelcomeMessage(testData.get("welcome-text"));
		
	}
	
	@DataProvider(name = "getTestJsonData")
	public  Iterator<HashMap<String, String>> getTestJsonData(Method m) throws IOException{
		return TestDataBuild.readJsonData(System.getProperty("user.dir")+ TestDataBuild.getConfigValue("jsonDataFile"), m.getName())
				.iterator();
		
	}
}
