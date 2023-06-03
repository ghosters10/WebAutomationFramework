package testcases;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLog {
	
	public static Logger logger = LogManager.getLogger(TestLog.class);

	public static void main(String[] args) {
		System.out.println("Print Username :: ");
		
		//BasicConfigurator.configure(); // %r [%t] %p %c %x - %m%n
		
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		logger.info("Informative Message");
		logger.debug("While Debugging");
		logger.warn("Suspicious Activity");
		logger.error("Error Occurred");
		logger.fatal("Fatal");
	}
	
	// DEBUG < INFO < WARN < ERROR < FATAL

}
