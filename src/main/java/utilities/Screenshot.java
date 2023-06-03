package utilities;

import drivermanager.DriverFactory;

public class Screenshot {
	
	public static void capture(String imageName) {
		DriverFactory.getCurrentDriver();
	}

}
