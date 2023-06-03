package testng;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import bo.TestcaseBO;
import filereader.ConfigReader;
import testcases.BaseTest;

public class RuntimeTestNG {
	
	private static String testcasePackagePath = "testcases";
	
	public TestNG create(List<TestcaseBO> testcaseList) {

		// create testng object
		TestNG testng = new TestNG();

		// list of suite
		List<XmlSuite> suiteList = new ArrayList<XmlSuite>();

		// create a new suite
		XmlSuite suite = new XmlSuite();
		suite.setName("Runtime TestNG Creation for Suite: " + ConfigReader.getProperty("suiteToRun"));
		suite.setThreadCount(Integer.parseInt(ConfigReader.getProperty("threadCount")));
		suite.setParallel(XmlSuite.ParallelMode.METHODS);

		// to set custom listeners to xml
//		List<String> customListeners = new ArrayList<String>();
//		customListeners.add("/ttt/bootcamp/listeners/CustomListener.java");
//		suite.setListeners(customListeners);

		// list of tests
		List<XmlTest> testList = new ArrayList<XmlTest>();
		XmlTest test = new XmlTest(suite);
		test.setName("Test From Excel File");

		// create list of classes
		List<XmlClass> classList = new ArrayList<XmlClass>();

		// to get all classes
		Reflections reflections = getAllTestClasses();

		Set<Class<? extends BaseTest>> allClasses = reflections.getSubTypesOf(BaseTest.class);

		// iterate on all the classes
		for (Class c : allClasses) {

			// create xml class
			XmlClass cls = new XmlClass(c);

			// fetch all methods of the class
			Method[] allMethods = c.getDeclaredMethods();
			System.out.println(Arrays.toString(allMethods));

			// method to include for execution
			List<XmlInclude> includeMethods = new ArrayList<XmlInclude>();

			// iterate on all methods of the class
			for (Method method : allMethods) {
				String methodName = method.getName();

				// main logic starts
				if (!testcaseList.isEmpty()) {

					// iterate on all the testcaes
					for (TestcaseBO testcase : testcaseList) {

						// check if current method is present in testcase list
						// use this condition to put all the filtering logic like ignore flaky, ignore
						// disabled, and so on
						if (testcase.getTestcaseName().equals(methodName)) {

							// add method for exection
							includeMethods.add(new XmlInclude(methodName));
						}
					}

				} else
					throw new IllegalStateException("No Testcases found for Execution!");
			}

			// if there is anything to include for execution
			if (!includeMethods.isEmpty()) {

				// add those methods to the class
				cls.setIncludedMethods(includeMethods);

				// add class to the class list
				classList.add(cls);
			}
		}

		// add class list to the test
		test.setXmlClasses(classList);

		// add test to testlist
		testList.add(test);

		// add testlis to suite
		suite.setTests(testList);

		// add suite to suite list
		suiteList.add(suite);

		System.out.println(suite.toXml());

		testng.setXmlSuites(suiteList);

		return testng;

	}

	public static Reflections getAllTestClasses() {
		ConfigurationBuilder config = new ConfigurationBuilder()
				.setScanners(new ResourcesScanner(), new SubTypesScanner(false))
				.setUrls(ClasspathHelper.forPackage(testcasePackagePath))
				.filterInputsBy(new FilterBuilder().includePackage(testcasePackagePath));

		Reflections reflect = new Reflections(config);

		return reflect;
	}

//	public static void main(String[] args) {
//		ConfigReader reader = new ConfigReader();
//
//		ExcelReader er = new ExcelReader();
//
//		RuntimeTestNG rt = new RuntimeTestNG();
//		rt.create(er.read());
//	}

}
