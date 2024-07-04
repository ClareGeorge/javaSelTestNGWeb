package resources;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriverLogLevel;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class EComUtilsSeleniumWebApp {
	public static WebDriver driver;
	@BeforeClass(alwaysRun = true)
	public void initialzeDriver() {
		//System.setProperty("webdriver.chrome.driver", "C:\\3.Softwares\\WebDrivers\\chromedriver.exe");

		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		ChromeOptions options = new ChromeOptions().addArguments("--start_maximized","--ignore-certification-errors");
		ChromeDriverService service = ChromeDriverService.createDefaultService();

		
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	public String getScreenshotPath(String nameTestCase, WebDriver driver) throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\screenshots\\" +"_" +nameTestCase+ new SimpleDateFormat("yyyyMMddHHmm").format(new Date()) + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
		
	}

}
