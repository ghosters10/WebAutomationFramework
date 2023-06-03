package pageflow;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;

import bo.CredentialsBO;
import pages.LoginPage;
import reports.ExtentManager;

public class LoginPageFlow {
	
	private static Logger logger = LogManager.getLogger(LoginPage.class);
	
	public static boolean performLogin(CredentialsBO creds) {
		logger.info("Perform Login Operation for User:: " + creds);
		//ExtentManager.getExtentTest().generateLog(Status.INFO, "Perform Login");
		LoginPage login = new LoginPage();
		login.open();
		login.fillUsername(creds.getUsername());
		login.fillPassword(creds.getPassword());		
		return login.login();
	}

}
