package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<ExtentTest>();
	public static ExtentReports extentReport;

	static {
		extentReport = createReport();
	}

	public static ExtentReports createReport() {
		String reportName = "extentReport.html";
		String outputLocation = "output/";

		// create report path
		String finalReportPath = outputLocation + reportName;

		// set report look and feel config
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(finalReportPath);
		sparkReporter.config().setReportName("Demo Extent Report");
		sparkReporter.config().setTheme(Theme.DARK);

		// initialize report object with design config
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);

		// set some prefs
		extentReports.setSystemInfo("Browser", "Chrome");
		extentReports.setSystemInfo("Environment", "Intgeration");

		return extentReports;
	}

	public static void setExtentTest(ExtentTest test) {
		extentTestThreadLocal.set(test);
	}

	public static ExtentTest getExtentTest() {
		return extentTestThreadLocal.get();
	}

}
