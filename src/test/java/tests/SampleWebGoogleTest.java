package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import resources.EComUtilsSeleniumWebApp;

public class SampleWebGoogleTest extends EComUtilsSeleniumWebApp {

	@Test(priority =1 , enabled= true,  groups = {"Smoke" } ,alwaysRun = true)
	public void testChrome() {
						
		driver.get("http://google.com");
		System.out.println("Title is " + driver.getTitle());
	}	
	@Test(priority =2 ,enabled= true , groups = {"Smoke" } , alwaysRun = true)
	public void performSearch () {
		
		driver.findElement(By.id("APjFqb")).sendKeys("irctc share price");
		driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
		System.out.println("Title is " + driver.getTitle());
		String textEquityName = driver.findElement(By.xpath("//div[@data-attrid='title']")).getText();
		
		Assert.assertEquals(textEquityName, "Indian Railway Ctrng nd Trsm Corp Ltd");
	}

 
}
