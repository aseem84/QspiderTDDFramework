package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener interface of TestNG
 * @author Chaitra M
 *
 */
public class ListenersImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ----- Test Execution Started -----");
		
		//add @Test to extent reports
		test = report.createTest(methodName);
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ----- Test PASS -----");
		
		//Log the PASS status to extent Report
		test.log(Status.PASS,methodName+" ----- Test PASS -----" );
		
	}

	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ----- Test FAIL -----");
		
		//Log the Fail Status to extent Report
		test.log(Status.FAIL,methodName+" ----- Test FAIL -----" );
		
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		
		String screenshotName = methodName+"-"+j.getDate();
		
		try {
			
			String path = s.captureScreeShot(BaseClass.sDriver, screenshotName);
			
			//Attach screenshot to Extent reports
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ----- Test SKIP -----");
		
		//Log the SKIP status to extent reports
		test.log(Status.SKIP, methodName+" ----- Test SKIP -----");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("---- Suite execution started -----");
		
		//Extent Report Configuration
		ExtentSparkReporter rep = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getDate()+".html");
		rep.config().setDocumentTitle("Execution Report");
		rep.config().setReportName("Vtiger execution report");
		rep.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(rep);
		report.setSystemInfo("Base platform", "Windows");
		report.setSystemInfo("Base Browser", "Firefox");
		report.setSystemInfo("Base url", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Chaitra");
				
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("----- Suite execution finished -----");
		
		//Generate extent report
		report.flush();
		
	}
	
	

}
