package junitRunner;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coreAction.OpenAndCloseBrowser;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import dataProvider.LoginDataProvider;



@CucumberOptions( 
	features = ".//src//test//resources//featureFile",
	glue = "defineStep"
	)

public class Runner2 extends OpenAndCloseBrowser{
	
	//public static RemoteWebDriver  driver;
	//public WebDriver  driver;
	public TestNGCucumberRunner testRunner;
	
	@Parameters({"browser","Url"})
	@BeforeClass
	public RemoteWebDriver setup(@Optional("ABC")String browser, String Url) throws InterruptedException, InvalidFormatException, MalformedURLException{
		/*DesiredCapabilities cap =  new DesiredCapabilities();
		ChromeOptions options;
		String node = "http://192.168.2.5:4444/wd/hub";
		if(browser.equalsIgnoreCase("CHROME")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\kamlesh.maurya\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver =  new ChromeDriver();
			
			
			//cap.setBrowserName("chrome");
			options = new ChromeOptions();
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new RemoteWebDriver(new URL(node), options);
			driver.manage().window().maximize();
			System.out.println(driver);
			
		}else if(browser.equalsIgnoreCase("FireFox")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\kamlesh.maurya\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver =  new FirefoxDriver();
		}else{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\kamlesh.maurya\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver =  new InternetExplorerDriver();
		}
		
		LoginDataProvider ldp = new LoginDataProvider();
		String url = ldp.getUrlDetails(Url);
		driver.get(url);*/
		setUp(browser,Url);
		testRunner = new TestNGCucumberRunner(Runner2.class);
		System.out.println(driver);
		return driver;
		
	}
	
	@Test(description="login", dataProvider = "features")
	public void login(CucumberFeatureWrapper cFeature)
	{
		testRunner.runCucumber(cFeature.getCucumberFeature());
		
		
	}
	
	@DataProvider(name="features")
	public Object[][] getFeatures()
	{
		return testRunner.provideFeatures();
		//return driver;
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
		testRunner.finish();
	}

}
