package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOnPage {
	
	WebDriver driver;
	public SignOnPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements( driver, this);
	}
	
	//driver.findElement(By.xpath("//form//input[@name='username']")).sendKeys("clare");
	@FindBy(xpath="//form//input[@name='username']")
	private WebElement inputUsername;
	
	//driver.findElement(By.xpath("//form//input[@name='password']")).clear();
	@FindBy(xpath="//form//input[@name='password']")
	private WebElement inputPassword;
	
	
	//driver.findElement(By.xpath("//form//input[@name='signon']")).click();
	@FindBy(xpath="//form//input[@name='signon']")
	private WebElement inputSignOn;
	

	public CategoryPage enterUserCredentials() {
		
		inputUsername.sendKeys("clare");
		inputPassword.clear();
		inputPassword.sendKeys("test");
		inputSignOn.click();
		return new CategoryPage(driver);
	}
}
