package junitRunner;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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
	
	public static WebDriver driver;
	private TestNGCucumberRunner testRunner;
	@Parameters({"browser","Url"})
	@BeforeClass
	public void setup(@Optional("ABC")String browser, String Url) throws InterruptedException, InvalidFormatException{
		
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
		
		LoginDataProvider ldp = new LoginDataProvider();
		String url = ldp.getUrlDetails(Url);
		driver.get(url);
		testRunner = new TestNGCucumberRunner(Runner2.class);
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
	}
	
	@AfterClass
	public void tearDown()
	{
		testRunner.finish();
	}

}
