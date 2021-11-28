package org.testngn;

import java.io.IOException;

import org.project.Project;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;

public class TestNgn extends Project{
	
	@Parameters({"browsername"})
	@BeforeClass
	public static  void launchBro(String browsername) {
	       Browserlauncher(browsername);
		} 
	@BeforeMethod
	public  void startDate() {
        date();   
	}
	@Test
	public void a_loginPage() throws IOException {
		   System.out.println("..........login page testcase 1........");	
	       launchurl();
	       username();
	       password();
	       click_login();
	       System.out.println("........login success testcase 1..........");
		}
	@Test
	public void b_searchHotel() throws InterruptedException {
		System.out.println(".........search hotel testcase 2........");
        select_location();
        select_hotel();
        select_room_type();
        select_room_nos();
        select_adult_room();
        select_child_room();
        click_submit();
        System.out.println("........testcase 2 success..........");   
	}
	@Test
	public void c_selectHotel() {
	    System.out.println(".......testcase 3 select hotel........");
		click_radio_button();
		click_continue();
		System.out.println("........testcase 3 success.......");
		}
	@Test
	public void d_bookHotel() {
		System.out.println("......testcase 4 book a hotel......"); 	
		first_name();
		last_name();
		address();
		cc_num();
		cc_type();
		cc_exp_mounth();
		cc_exp_year();
		cc_cvv();
		click_booknow();
	    System.out.println("........testcase 4 success........");
		}
	@Test
	public void e_orderNumber() {
		System.out.println("....testcase 5....");
		order_id();
        System.out.println("......testcase 5 success");
	}
	@AfterMethod
	public  void afterDate() {
	      date();
	      System.out.println();
		} 
	@AfterClass(enabled = false)
	public static  void quit() throws InterruptedException {
     quitBrowser();
	} 


}
