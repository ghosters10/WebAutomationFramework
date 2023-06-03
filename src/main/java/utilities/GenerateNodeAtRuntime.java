package utilities;

import org.openqa.grid.selenium.GridLauncherV3;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenerateNodeAtRuntime {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		GridLauncherV3.main(new String[] { "-role", "node", "-hub", "http://192.168.1.3:4444/grid/register/",
				"-browser", "browserName=chrome,maxInstance=3", "-port", "5555" });
	}

}