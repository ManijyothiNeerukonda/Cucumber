package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//div[@class='mTxt']")
	private WebElement NaukriLogo;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Edit Profile']")
	private WebElement editProfile;
	
	public void validateLabel() {
		boolean val=NaukriLogo.isDisplayed();
		Assert.assertEquals(true, val);
	}
	
	
	public void clickOnProfile() {
	
		Actions action=new Actions(driver);
		
		Action act=action.moveToElement(NaukriLogo).moveToElement(editProfile).click().build();
		act.perform();
		
		System.out.println("clicked on profile");
	}
	
	
	
	
}
