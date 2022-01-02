package com.appiumframwrok.listeners;



import com.appiumframwrok.helpers.Helpers;
import org.testng.ITestListener;
import org.testng.ITestResult;


import java.io.PrintWriter;
import java.io.StringWriter;


public class TestListener implements ITestListener {

	Helpers helper = new Helpers();
	public void onTestFailure(ITestResult result) {
		if(result.getThrowable() != null) {
			  StringWriter sw = new StringWriter();
			  PrintWriter pw = new PrintWriter(sw);
			  result.getThrowable().printStackTrace(pw);
			helper.log().error(sw.toString());
		}

	}


}
