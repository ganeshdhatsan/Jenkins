package TestReporter;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import Utilities.TestUtilities;

	public class ExtentReporter extends TestUtilities {
	    private ExtentReports extent;
	    private ExtentTest test;
	    private File reportFile;
	    private ExtentSparkReporter spark;
	    String ReportTime;

//	    public ExtentReporter() {
//	    	  Date date = new Date();
//	          SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy hhmmss");
//	          String ReportTime = sdf.format(date).replace(" ", "_");
//	         
//	        reportFile = new File(System.getProperty("user.dir") + "\\ReportLog\\"+ReportTime+".html");
//	        ExtentSparkReporter spark = new ExtentSparkReporter(reportFile);
//	        extent = new ExtentReports();
//	        extent.attachReporter(spark);
//	        test = extent.createTest("Login Function Validation");
//	       
//	    }
	    
	    public void testName(String testName) {
	    	  Date date = new Date();
	          SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy hhmmss");
	          ReportTime = sdf.format(date).replace(" ", "_");
	         
	        reportFile = new File(System.getProperty("user.dir") + "\\ReportLog\\"+ReportTime+".html");
	        spark = new ExtentSparkReporter(reportFile);
	        extent = new ExtentReports();
	        extent.attachReporter(spark);
	        test = extent.createTest(testName);
	       
	    }

	    public void addScreenShot(String stepDescription, String status) throws IOException {
	        String path = takeScreenShot();
	        switch (status.toUpperCase()) {
	            case "PASS":
	                test.pass(stepDescription, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	                break;
	            case "FAIL":
	                test.fail(stepDescription, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	                break;
	            case "INFO":
	                test.info(stepDescription, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	                break;
	            default:
	                test.info(stepDescription, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	                break;
	        }
	    }

	    public void flushReport() throws IOException {
	        extent.flush();
	        Desktop.getDesktop().browse(reportFile.toURI());
	    }
	}


