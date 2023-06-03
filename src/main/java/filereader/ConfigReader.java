package filereader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties properties = new Properties();
	private String configFilePath = "src/main/resources/config.properties";
	private String envFilePath = "src/main/resources/environments/%s.properties";

	public ConfigReader() {
		readProperties(configFilePath);

		String environmentToRun = getProperty("environment");
		readProperties(String.format(envFilePath, environmentToRun));
	}

	private void readProperties(String filePath) {
		try {
			FileReader reader = new FileReader(new File(filePath));

			properties.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	

	public static String getProperty(String propertyName) {
		return properties.getProperty(propertyName);
	}

}
