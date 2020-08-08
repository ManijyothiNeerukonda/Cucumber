package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//a[@class='nLogo fl']")
	private WebElement NaukriLogo;
	
	@FindBy(how=How.ID,using="usernameField")
	private WebElement username;
	
	@FindBy(how=How.ID,using="passwordField")
	private WebElement password;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Login']")
	private WebElement login;
	
	public void validateLabel() {
		boolean val=NaukriLogo.isDisplayed();
		Assert.assertEquals(true, val);
	}
	
	public void enterUsername(String name) {
		
		
		NaukriLogo.sendKeys(name);
		System.out.println("entered username");
	}
	
	public void enterPassword(String password) {
		
		NaukriLogo.sendKeys(password);
		System.out.println("entered Password");
	}
	
	public void clickOnLogin() {
		login.click();
		System.out.println("clicked on login");
	}
	
}
