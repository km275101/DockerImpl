package pageElements;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import coreAction.ActionDriver;

public class LoginTestPE{
	

	public LoginTestPE(RemoteWebDriver driver) {
		super();
		
	}
	

	@FindBy(xpath="//span[text()='Hello, Sign in']")
	public WebElement yourOrders ;
	
	@FindBy(xpath="//span[text()='Your Orders']")
	public WebElement yourOrders1 ;
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement userName ;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement password ;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement submit ;
	

}
