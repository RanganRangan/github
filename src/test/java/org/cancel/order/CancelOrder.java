package org.cancel.order;

import java.awt.AWTException;

import org.project.Project;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CancelOrder extends Project {
	
	
	@BeforeMethod
	public  void startDate() {
        date();   
	}
	@Test
	 private void cancelorder() throws InterruptedException, AWTException {
		System.out.println("......testcase 6 cance order......"); 	
		cancel_order();
        cancel_selected();
        alert();
		System.out.println("......testcase 6 cance order success......"); 	
	}
	@AfterMethod
	public  void endDate() {
        date();   
	}
	@AfterClass
	public static  void quit() throws InterruptedException {
	     quitBrowser();
		}
	

}
