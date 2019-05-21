package coreAction;


import pageFunctions.LoginTestPF;

import org.openqa.selenium.remote.RemoteWebDriver;

import dataProvider.LoginDataProvider;
import junitRunner.Runner2;

public class Initialize extends Runner2{
	
	//DataProvider Class and others
	protected ActionDriver ad;
	protected LoginDataProvider ldp = new LoginDataProvider();
	
	// PageFunctions Class
	protected LoginTestPF lpf = new LoginTestPF((RemoteWebDriver) driver);

}
