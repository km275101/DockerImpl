package Reporting;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import coreAction.Initialize;


public class Log4j {

	static Logger logger = Logger.getLogger(Initialize.class);
	static String sFileName = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	static String TestCaseName = "";
	static String Filename = "";
	public void Log4j() {
		Filename = "TestNG_Report_" + sFileName;
		System.setProperty("file.name", "C:\\Log\\" + Filename + ".log");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Log4j appender configuration is successful !!");
	}
	
}
