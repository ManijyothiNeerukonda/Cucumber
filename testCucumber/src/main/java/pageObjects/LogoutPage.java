package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LogoutPage {

	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//span[@class='fullname']")
	private WebElement profilelogo;
	
	@FindBy(how=How.XPATH,using="//div[@class='mTxt']")
	private WebElement NaukriLogo;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Logout']")
	private WebElement Logout;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Login']")
	private WebElement Login;
	
	public void validateLabel() {
		boolean val=NaukriLogo.isDisplayed();
		Assert.assertEquals(true, val);
	}
	
	
	public void clickOnLogOut() throws InterruptedException {
	
		Actions action=new Actions(driver);
		
		Action act=action.moveToElement(NaukriLogo).moveToElement(Logout).click().build();
		act.perform();
		
		System.out.println("clicked on Logout");
		
		Thread.sleep(3000);
		
		Login.isDisplayed();
	}
	
}
