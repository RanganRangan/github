package org.project;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.baseclass.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;

//import junit.framework.Assert;

public class Project extends Baseclass {

	//......test 1.........
	
	//...........loginpage.............
		public static void launchurl() {
		       launchurl("https://adactinhotelapp.com/");
//		       String currentUrl = driver.getCurrentUrl();
//	           boolean contains = currentUrl.contains("adactinhotelapp");  
//		       Assert.assertTrue("url verified", contains);
		}
	      public static void username() throws IOException {  
	    	 filltextbox("UserData", 1, 0, "id", "username");
//	    	 getAttribute("id", "username");
//	    	 Assert.assertEquals("verify user name","ranganrangan","ranganrangan");
		}
	      public static void password() throws IOException {
	          filltextbox("UserData", 1, 1, "id", "password");
//	          getAttribute("id", "password");
//	          Assert.assertEquals("verify password","rangan123456","rangan123456");
//	          System.out.println(".....verified.....");
		}
	      public static void click_login() {
	          click("id", "login");
	   }
	//..........end loginpage............
	 
	    //........test 2...............
	      
	//........search hotel.........
	     public static void select_location() {
	 		selectByIndex("selectbyindex", 3, driver.findElement(By.id("location")));
	   	} 
	     public static void select_hotel() {
	 		selectByIndex("selectbyindex", 2, driver.findElement(By.id("hotels")));
	    } 
	     public static void select_room_type() {
	 		selectByIndex("selectbyindex", 3, driver.findElement(By.id("room_type")));
	    } 
	     public static void select_room_nos() {
	 		selectByIndex("selectbyindex", 2, driver.findElement(By.id("room_nos")));
	     }    
	     public static void select_adult_room() {
	     selectByIndex("selectbyindex", 2, driver.findElement(By.id("adult_room")));
	     }	
	     public static void select_child_room() {
			selectByIndex("selectbyindex", 2, driver.findElement(By.id("child_room")));
	     }
	      public static void click_submit() {
	          click("id", "Submit");
		}
	//.........end search hotel.......
	      
	      //.......test 3.........
	      
	//......select hotel..........
	    
	      public static void click_radio_button() {
	    		click("id", "radiobutton_0");    	  
		}
	      public static void click_continue() {
	    		click("id", "continue");
		}
	//........end select hotel.......      
	      
	      //.......test 4........
	      
	//........book hotel........
	      
	      public static void first_name() {
	    		sendkeys("id", "first_name", "rangan");
		}
	      public static void last_name() {
	    		sendkeys("id", "last_name", "rangan");
		}
	      public static void address() {
	    		sendkeys("id", "address", "adress");
		}
	      public static void cc_num() {
	    		sendkeys("id", "cc_num", "1234567812341234");
		}
	      public static void cc_type() {
	    		selectByIndex("selectbyindex", 4, driver.findElement(By.id("cc_type")));
		}
	      public static void cc_exp_mounth() {
	    		selectByIndex("selectbyindex", 4, driver.findElement(By.id("cc_exp_month")));
		}
	      public static void cc_exp_year() {
	    		selectByIndex("selectbyindex", 12, driver.findElement(By.id("cc_exp_year")));
		}
	      public static void cc_cvv() {
	    	    sendkeys("id","cc_cvv","123");
	      }
	      public static void click_booknow() {
	    	    click("id", "book_now");
		}
	//.......end of book hotel      
	      
	      //.......test 5.......
	      
	//.......order number......      
	      public static void order_id() {
	  	   getAttribute("id", "order_no","value");
		}
	      
	      //.....test 6,,,,,,,
	//......cancel order........
	      public static void cancel_order() throws InterruptedException, AWTException {
	    	  Thread.sleep(8000);
	  		click("xpath", "//a[contains(text(),'Booked Itinerary')]"); 
	  		List<WebElement> findElements = driver.findElements(By.xpath("//input[@type='checkbox']"));		
	  		String id = null;
	  		for(int i=0;i<findElements.size();i++) {
	         id= findElements.get(i).getAttribute("value");
	  		}
	  		click("xpath", "//input[@value='"+id+"']");
	  		}
	      public static void cancel_selected() {
	    	  click("name", "cancelall"); 
	      }
	      public static void alert() {  
	    	  alert("accept");
	      }
	
}
