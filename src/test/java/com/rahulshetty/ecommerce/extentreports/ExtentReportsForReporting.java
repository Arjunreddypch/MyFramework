package com.rahulshetty.ecommerce.extentreports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsForReporting {
	
	
	public static ExtentReports getReportObject() {
		
		File file=new File(System.getProperty("user.dir")+"//reports//"+"index.html");
		ExtentSparkReporter esr=new ExtentSparkReporter(file);
		esr.config().setReportName("web Automation results");
		esr.config().setDocumentTitle("test Results");
		
		ExtentReports extentReports=new ExtentReports();
		extentReports.attachReporter(esr);
		extentReports.setSystemInfo("Tester", "Arjun");
		return extentReports;
	}

}
