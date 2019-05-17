package coreAction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;

import cucumber.api.testng.TestNGCucumberRunner;
import junitRunner.Runner2;

public class OpenAndCloseBrowser{
public WebDriver driver;
	
	public void setUp(String browser, String Url) throws InterruptedException {
		if(browser.equalsIgnoreCase("CHROME")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\kamlesh.maurya\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver =  new ChromeDriver();
		}else if(browser.equalsIgnoreCase("FireFox")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\kamlesh.maurya\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver =  new FirefoxDriver();
		}else{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\kamlesh.maurya\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver =  new InternetExplorerDriver();
		}
		
		System.out.println();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("OCB");
		//return driver;
		
	}

	public void openUrl(String url) throws InterruptedException {
		
		System.out.println("Open and close browser class method --> Open Url");
		Thread.sleep(5000);
		//return driver;
		

	}

	//@AfterClass
	public void closeBrowser() throws InterruptedException {
		//driver.close();
		//driver.quit();
		System.out.println("Closed the browser");
	}

}
