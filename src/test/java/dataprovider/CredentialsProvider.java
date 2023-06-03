package dataprovider;

import org.testng.annotations.DataProvider;

import com.github.javafaker.Faker;

import bo.CredentialsBO;

public class CredentialsProvider {
	
	@DataProvider
	public Object[][] getLoginCredentials() {
		// get data from the json collection
		// iterate on all the data
		// store it in Object[][] form
		// return data to testcase

		Faker faker = new Faker();
		int dataSize = 2;

		Object[][] object = new Object[dataSize][1];

		for (int i = 0; i < dataSize; i++) {
			CredentialsBO creds = new CredentialsBO();
			creds.setUsername(faker.name().username());
			creds.setPassword(faker.random().hex(5));
			object[i][0] = creds;

		}

		return object;
	}

}
