package coreAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ActionDriver extends OpenAndCloseBrowser{

	
//protected RemoteWebDriver driver;
public static OpenAndCloseBrowser ocb = new OpenAndCloseBrowser();
protected Actions action;

public ActionDriver(WebDriver driver) {
	this.driver = driver;
	action = new Actions(driver);
	
}
	public void mouseHover(WebElement element) {
		
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

}
