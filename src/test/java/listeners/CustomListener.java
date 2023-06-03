package listeners;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import reports.ExtentManager;
import utilities.Screenshot;

public class CustomListener implements ITestListener {

	Logger logger = LogManager.getLogger(CustomListener.class);
	
	private int totalRun = 0;
	private int totalPass = 0;
	private int totalFail = 0;

	// private Map<String, Integer> testcaseMap = new HashedMap<String, Integer>();

	@Override
	public void onTestStart(ITestResult result) {

		// check if tc preset in map
//		if (testcaseName.contains(testcaseName)) {
//			int currentCount = testcaseMap.get(testcaseName);
//			testcaseMap.put(testcaseName, currentCount++);
//		} else
//			testcaseMap.put(testcaseName, 1);

		// MDC.put("testcaseName", "TC:" + result.getName() + "_" +
		// testcaseMap.get(testcaseName));
		MDC.put("testcaseName", "TC:" + result.getName());
		logger.info("Starting with testcase:: " + result.getName());
		ExtentTest test = ExtentManager.extentReport.createTest(result.getName());
		ExtentManager.setExtentTest(test);
		totalRun++;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("TestExecuted Successfully:: " + result.getName());
		ExtentManager.getExtentTest().pass("Execution Success");
		totalPass++;
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("TestExecution FAILED:: " + result.getName());
		Screenshot.capture(result.getName() + "FAILED!");
		ExtentManager.getExtentTest().fail("Execution Failed");
		totalFail++;
	}
	
	@Override
	public void onFinish(ITestContext context) {
		ExtentManager.extentReport.flush();
	}
}