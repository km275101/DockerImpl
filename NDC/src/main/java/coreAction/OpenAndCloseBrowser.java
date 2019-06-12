package coreAction;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

import cucumber.api.testng.TestNGCucumberRunner;
import dataProvider.LoginDataProvider;
import junitRunner.Runner2;

public class OpenAndCloseBrowser{
//public WebDriver driver;
	public static RemoteWebDriver  driver;
	
	public RemoteWebDriver setUp(String browser, String locale) throws InterruptedException, InvalidFormatException, MalformedURLException {
		DesiredCapabilities cap =  new DesiredCapabilities();
			
			
			//String node = "http://192.168.2.5:4444/wd/hub";
			if(browser.equalsIgnoreCase("CHROME")){
				System.setProperty("webdriver.chrome.driver","C:\\Users\\kamlesh.maurya\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver =  new ChromeDriver();
				
				ChromeOptions options;
				//cap.setBrowserName("chrome");
				options = new ChromeOptions();
				cap.setCapability(ChromeOptions.CAPABILITY, options);
				//driver = new RemoteWebDriver(new URL(node), options);
				driver.manage().window().maximize();
				System.out.println(driver);
				
			}else if(browser.equalsIgnoreCase("firefox")){
				//System.setProperty("webdriver.chrome.driver","C:\\Users\\kamlesh.maurya\\Downloads\\chromedriver_win32\\chromedriver.exe");
				System.out.println("Opening firefox driver");
				cap = cap.firefox();
				//driver = new RemoteWebDriver(new URL(node), cap);
				driver.manage().window().maximize();
				System.out.println(driver);
			}else{
				System.setProperty("webdriver.chrome.driver","C:\\Users\\kamlesh.maurya\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver =  new InternetExplorerDriver();
			}
			
			
			LoginDataProvider ldp = new LoginDataProvider();
			String url = ldp.getUrlDetails(locale);
			driver.get(url);
			System.out.println(driver);
		
		return driver;
		
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
