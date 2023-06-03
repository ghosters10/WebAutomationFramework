package run;
import java.util.List;

import bo.TestcaseBO;
import filereader.ConfigReader;
import filereader.ExcelReader;
import testng.RuntimeTestNG;

public class StartUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// read config data
		new ConfigReader();

		// read data from excel
		ExcelReader reader = new ExcelReader();
		List<TestcaseBO> testcaseList = reader.read();

		// create an xml file
		RuntimeTestNG runtime = new RuntimeTestNG();
		runtime.create(testcaseList).run();

		System.out.println("After running TestNG");

	}

}
