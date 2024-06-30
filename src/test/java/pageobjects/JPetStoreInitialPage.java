package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JPetStoreInitialPage {
	
	WebDriver driver;
	
	public JPetStoreInitialPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//driver.findElement(By.xpath("//a[text()='Enter the Store']")).click();
	//driver.findElement(By.xpath("//a[text()='Sign In']")).click();
	@FindBy(xpath="//a[text()='Enter the Store']")
	private WebElement lnkEnterStore;
	
	@FindBy(xpath="//a[text()='Sign In']")
	private WebElement lnkSignIn;
	
	

	public SignOnPage navigateToJPetStore() {
		
		
		driver.get("https://petstore.octoperf.com/"); 
		driver.getTitle().equals("JPetStore Demo");
		driver.navigate().refresh();
		lnkEnterStore.click();
		lnkSignIn.click();
		return new SignOnPage(driver);
		
	}
	
	

}
