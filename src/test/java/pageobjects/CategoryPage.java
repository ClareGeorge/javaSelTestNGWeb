package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CategoryPage {
	WebDriver driver;
	public CategoryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements( driver, this);
	}

	//driver.findElement(By.id("WelcomeContent")).getText().strip().substring(0, 7).equals("Welcome");
	@FindBy(id="WelcomeContent")
	private WebElement textWelcome;
	
	public void verifyWelcomeMessage() {
		Assert.assertEquals(textWelcome.getText().strip().substring(0, 7), "Welcome"); 
	}
}
