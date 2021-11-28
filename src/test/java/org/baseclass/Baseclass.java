package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MenuKeyEvent;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	 public static WebDriver driver;
		public static WebDriver Browserlauncher(String browsername) {
	     switch (browsername) {
		case "chrome"://chrome browser
			WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
			break;
	    case "firefox"://firefox browser
	    	WebDriverManager.firefoxdriver().setup();
	    	driver =new FirefoxDriver();
			break;
	     case "edge"://edge browser
	 		WebDriverManager.edgedriver().setup(); 
	          driver = new EdgeDriver();
	 		break;
		default:
			System.err.println("invalid browser");
			break;
			}return driver;
		}          //..........2 launchurl,maximize,implicitlywait...............
		public static void launchurl(String url) {         
			driver.get(url);
	        driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}             //..........3 webelement sendkeys.............
		public static void sendkeys(String casee,String element,String value) {
			switch (casee) {
			case "id":
				driver.findElement(By.id(element)).sendKeys(value);
				break;
	     	case "name":
	     		driver.findElement(By.name(element)).sendKeys(value);
				break;
		    case "classname":
		    	driver.findElement(By.className(element)).sendKeys(value);
			break;
		    case "xpath":
			    driver.findElement(By.xpath(element)).sendKeys(value);
			break;
	     	default:
	     		System.err.println("inalidelement");
				break;
			}
		}      //..........4 findelement.............
		public static void FindElement(String casee,String element) {
			switch (casee) {
			case "id":
				driver.findElement(By.id(element));
				break;
	     	case "name":
	     		driver.findElement(By.name(element));
				break;
		    case "classname":
		    	driver.findElement(By.className(element));
			break;
		    case "xpath":
			    driver.findElement(By.xpath(element));
			break;
	     	default:
	     		System.err.println("inalidelement");
				break;
			}
		}  	//.........5 browser quit............
	       public static void quitBrowser() {
			     driver.quit();     
		 }    //..........6 webelement click.........
	       public static void click(String casee,String element) {
	   		switch (casee) {
	   		case "id":
	   			driver.findElement(By.id(element)).click();
	   			
	   			break;
	        	case "name":
	        		driver.findElement(By.name(element)).click();
	   			break;
	   	    case "classname":
	   	    	driver.findElement(By.className(element)).click();
	   		break;
	   	    case "xpath":
	   		    driver.findElement(By.xpath(element)).click();
	   		break;
	        	default:
	        		System.err.println("inalidelement");
	   			break;
	   		}
	   	}     //..........7 getText.............
	       
	       public static void getText(String casee,String element) {
	    	   
	      		switch (casee) {
	      		case "id":
	      			System.out.println(driver.findElement(By.id(element)).getText());
	      			break;
	           	case "name":
	      			System.out.println(driver.findElement(By.name(element)).getText());
	      			break;
	      	    case "classname":
	      			System.out.println(driver.findElement(By.className(element)).getText());
	      		break;
	      	    case "xpath":
	      			System.out.println(driver.findElement(By.xpath(element)).getText());
	      		break;
	           	default:
	           		System.err.println("inalidelement");
	      			break;
	      		}	
	      	}   //..............8 getAttribute..................
	       public static void getAttribute(String casee,String element,String value) {
	     		switch (casee) {
	     		case "id":
	     			System.out.println(driver.findElement(By.id(element)).getAttribute(value));
	     			break;
	          	case "name":
	     			driver.findElement(By.name(element)).getAttribute(value);
	     			break;
	     	    case "classname":
	     			driver.findElement(By.className(element)).getAttribute(value);
	     		break;
	     	    case "xpath":
	     			driver.findElement(By.xpath(element)).getAttribute(value);
	     		break;
	          	default:
	          		System.err.println("inalidelement");
	     			break;
	     		}
	     	}   //..............9 Action movetoelement...................
	       public static void MoveToElement(String casee,String element) {
	    	   Actions drop=new Actions(driver);  
	    		switch (casee) {
	    		case "id":
	    			drop.moveToElement(driver.findElement(By.id(element))).perform();
	    			break;
	         	case "name":
	    			drop.moveToElement(driver.findElement(By.name(element))).perform();;
	    			break;
	    	    case "classname":
	    			drop.moveToElement(driver.findElement(By.className(element))).perform();
	    		break;
	    	    case "xpath":
	    			drop.moveToElement(driver.findElement(By.xpath(element))).perform();
	    		break;
	         	default:
	         		System.err.println("inalidelement");
	    			break;
	    		}
	    	}          //.......10 Action draganddrop..............
	       public static void draganddrop(String casee,String DragElement,String DropElement) {
	    	   Actions drop=new Actions(driver);  
	    		switch (casee) {
	    		case "id":
	    			drop.dragAndDrop(driver.findElement(By.id(DragElement)), driver.findElement(By.id(DropElement))).perform();
	    			break;
	         	case "name":
	    			drop.dragAndDrop(driver.findElement(By.name(DragElement)), driver.findElement(By.id(DropElement))).perform();
	    			break;
	    	    case "classname":
	    			drop.dragAndDrop(driver.findElement(By.className(DragElement)),driver.findElement(By.id(DropElement))).perform();
	    		break;
	    	    case "xpath":
	    			drop.dragAndDrop(driver.findElement(By.xpath(DragElement)),driver.findElement(By.id(DropElement))).perform();
	    		break;
	         	default:
	         		System.err.println("inalidelement");
	    			break;
	    		}
	    	}    //..............11 Action RightClick................
	       public static void RightClick(String casee,String element) {
	    	   Actions drop=new Actions(driver);  
	    		switch (casee) {
	    		case "id":
	    			drop.moveToElement(driver.findElement(By.id(element))).contextClick().perform();
	    			break;
	         	case "name":
	    			drop.moveToElement(driver.findElement(By.name(element))).contextClick().perform();;
	    			break;
	    	    case "classname":
	    			drop.moveToElement(driver.findElement(By.className(element))).contextClick().perform();
	    		break;
	    	    case "xpath":
	    			drop.moveToElement(driver.findElement(By.xpath(element))).contextClick().perform();
	    		break;
	         	default:
	         		System.err.println("inalidelement");
	    			break;
	    		}
	    	}   //................12 Action DoubleClick..................
	       public static void DoubleClick(String casee,String element) {
	    	   Actions drop=new Actions(driver);  
	    		switch (casee) {
	    		case "id":
	    			drop.moveToElement(driver.findElement(By.id(element))).doubleClick().perform();
	    			break;
	         	case "name":
	    			drop.moveToElement(driver.findElement(By.name(element))).doubleClick().perform();;
	    			break;
	    	    case "classname":
	    			drop.moveToElement(driver.findElement(By.className(element))).doubleClick().perform();
	    		break;
	    	    case "xpath":
	    			drop.moveToElement(driver.findElement(By.xpath(element))).doubleClick().perform();
	    		break;
	         	default:
	         		System.err.println("inalidelement");
	    			break;
	    		}
	    	}          //.............13 Action click................
	       public static void Actionclick(String casee,String element) {
	    	   Actions drop=new Actions(driver);  
	    		switch (casee) {
	    		case "id":
	    			drop.moveToElement(driver.findElement(By.id(element))).click().perform();
	    			break;
	         	case "name":
	    			drop.moveToElement(driver.findElement(By.name(element))).click().perform();;
	    			break;
	    	    case "classname":
	    			drop.moveToElement(driver.findElement(By.className(element))).click().perform();
	    		break;
	    	    case "xpath":
	    			drop.moveToElement(driver.findElement(By.xpath(element))).click().perform();
	    		break;
	         	default:
	         		System.err.println("inalidelement");
	    			break;
	    		}
	    	}          //...........14 Robot..............
	       public static void Robot(int downcount,int enter ) throws AWTException {
	    	     Robot keyboard=new Robot();  
	    	     for(int i=0;i<=downcount;i++) {
	    	       keyboard.keyPress(MenuKeyEvent.VK_DOWN);
	    	       keyboard.keyRelease(MenuKeyEvent.VK_DOWN);
	    		}
	    	     for(int i=0;i<=enter;i++) {
	     	       keyboard.keyPress(MenuKeyEvent.VK_ENTER);
	       	       keyboard.keyRelease(MenuKeyEvent.VK_ENTER);
	    	     }
	    	}          //.......15robot copy.........
		public static void Copy() throws AWTException {
		     Robot keyboard=new Robot();  
		       keyboard.keyPress(MenuKeyEvent.VK_CONTROL);
		       keyboard.keyPress(MenuKeyEvent.VK_C);           
		}     //.........16robot paste...........
		public static void Paste() throws AWTException {
		     Robot keyboard=new Robot();  
		       keyboard.keyPress(MenuKeyEvent.VK_CONTROL);
		       keyboard.keyPress(MenuKeyEvent.VK_V);       
		}    //...........17 dropdown select by index............
		public static void selectByIndex(String casee,int index,WebElement Element) {
			Select select=new Select(Element);
			switch (casee) {
			 case "selectbyindex":
				 select.selectByIndex(index);
				 break;
			 case "deselectbyindex":
				 select.deselectByIndex(index);
				 break;
			}		//......select by value	
		}public static void selectBy(WebElement Element,String casee,String value) {
			 Select select=new Select(Element);
			 switch (casee) {
			case "selectbyvalue":
				select.selectByValue(value);
				break;
			case "selectbyvisibletext":
				select.selectByVisibleText(value);
				break;
		    case "getoption":
				System.out.println(select.getOptions()); 
				break;
		     case "getallselectedoption":
				select.getAllSelectedOptions();
				break;
		     case "ismutiple":
				System.out.println(select.isMultiple());
				break;
		   case "deselectall":
				select.deselectAll();
				break;
		   case "deselectbyvalue":
			     select.deselectByValue(value);	
				break;
		  case "deselectbyvisibletext":
				select.deselectByVisibleText(value);
				break;
		    case "getfirstselectedoption ":
			   select.getFirstSelectedOption();
			break;	
			default:
				break;
			}
			  select.selectByValue(value);
			  select.selectByVisibleText(value);
		}
			
		//........18 alert.........
		public static void  alert(String casee) {
			Alert a=driver.switchTo().alert();
			switch (casee) {
			case "accept":
				a.accept();
				break;
			case "dismiss":
				a.dismiss();
				break;
			case "gettext":
				System.out.println(a.getText());
				break;
			default:System.err.println("invalid");
				break;
			}
		} // ............19 alert sendkeys............... 
		public static void  alertSendkeys(String casee,String Text) {
	         Alert a=driver.switchTo().alert(); 
			switch (casee) {
			case "sendkeys":
				a.sendKeys(Text);
				break;
			default:
				System.err.println("invalid");
				break;
			}
		}//..........20 screenshort...........
		public static void ScreenShort(String location) throws IOException {
			TakesScreenshot ss=(TakesScreenshot)driver;
			File srcfile=ss.getScreenshotAs(OutputType.FILE);
			System.out.println("ScreenShort src File Created Done "+ srcfile);	
			File file=new File(location);
			FileUtils.copyFile(srcfile, file);
			System.out.println("screenshort taken done");		
		}//...........21 scroll.........
		public static void scroll(String casee,WebElement element) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			switch (casee) {
			case "scrolldown":
				js.executeScript("arguments[0].scrollIntoView(true);", element);
				break;
			case "scrollup":
				js.executeScript("arguments[0].scrollIntoView(false);", element);
				break;  
			default:System.err.println("invalid scroll");
				break;
			}	
		}//...........22 navigation..........
		public static void navigate(String casee) {
			switch (casee) {
			case "forward":
				driver.navigate().forward();
				break;
			case "backward":
				driver.navigate().back();
				break;
			case "refresh":
				driver.navigate().refresh();
				break;
			default:System.err.println("invalid navigation");
				break;
			}	
		}//.........23 frames........
	    public static void frames(String casee,String element){
	    	switch (casee) {
			case "name":
				driver.switchTo().frame(driver.findElement(By.name(element)));
				break;
			case "id":
				driver.switchTo().frame(driver.findElement(By.id(element)));
				break;	
			case "element":
		      	driver.switchTo().frame(driver.findElement(By.xpath(element)));
				break;
			default:
				break;
			}   
	    }//.........24 frames........
	    public static void frames(int index) {
	        driver.switchTo().frame(index);
	      }//........25 windows handling.........
	     public static void switchtowindow(int index) throws InterruptedException { 
	    	 Thread.sleep(2000);
	 		Set<String> windows = driver.getWindowHandles();
	 		List<String>li=new ArrayList<String>();
	 		li.addAll(windows);
	 		driver.switchTo().window(li.get(index));  	 
	     }//........26 findelements...........
	     public static void findelements(String locators,String element) {   
	    	 switch (locators) {
			case "id":
			       List<WebElement>id = driver.findElements(By.id(element));
				break;
			case "xpath":
			       List<WebElement> xpath = driver.findElements(By.xpath(element));       
				break;
			case "name":
			       List<WebElement> name = driver.findElements(By.name(element));       
				break;
			case "classname":
			       List<WebElement> classname = driver.findElements(By.className(element));       
				break;
			default:System.out.println("invalid elements");
				break;
			}}//............27 xlsx data.....
	     public static void xlsxdata(String filename) throws IOException {
	    	 File location=new File("C:\\Users\\tsmt\\eclipse\\Maven\\src\\test\\resources\\excel\\"+filename+".xlsx");
	    	 FileInputStream FIS=new FileInputStream(location);
	    	 Workbook WB=new XSSFWorkbook(FIS);
	    	 Sheet sheet = WB.getSheet("UserData");
	    	 for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
	    		 Row row = sheet.getRow(i);
	    		 System.out.println("row "+i);
	    		 for(int j=0;j<row.getPhysicalNumberOfCells();j++) {
	    			 Cell cell = row.getCell(j);
	    			    int cellType = cell.getCellType();
	    		    	 if(cellType==1){
	    		             String stringCellValue = cell.getStringCellValue();
	    		       	 System.out.println(stringCellValue+ " cell "+j );
	        		
	    		       	 }
	    		    	 else { 
	    		        	 double numericCellValue = cell.getNumericCellValue();
	    		        	 long l=(long)numericCellValue;
	    		        	 String valueOf = String.valueOf(l);      
	    		     System.out.println(valueOf + "  cell "+j);
	    
	    			  }
//	    			 System.out.print(cell+"  cell ");
	    		 }}   	 
	     }//..........28 xlsx data to web application ......
	     public static void filltextbox(String filename,int row,int cell,String casee,String value) throws IOException {
			 File location=new File("C:\\Users\\tsmt\\eclipse\\Maven\\src\\test\\resources\\excel\\"+filename+".xlsx");
	    	 FileInputStream FIS=new FileInputStream(location);
	    	 Workbook WB=new XSSFWorkbook(FIS);
	    	 Sheet sheet = WB.getSheet("UserData");
	         Row rows = sheet.getRow(row);
	         Cell cells = rows.getCell(cell);  
	          int cellType = cells.getCellType(); 
//	         String string = cells.toString();
	         switch (casee) {
			case "id":
				 if(cellType==1){
		             String stringCellValue = cells.getStringCellValue();
			         driver.findElement(By.id(value)).sendKeys(stringCellValue); }
		         else {
		        	 double numericCellValue = cells.getNumericCellValue();
		        	 long l=(long)numericCellValue;
		        	 String valueOf = String.valueOf(l);
			         driver.findElement(By.id(value)).sendKeys(valueOf);}
		    break;
	        case "name":
	        	if(cellType==1){
		             String stringCellValue = cells.getStringCellValue();
			         driver.findElement(By.name(value)).sendKeys(stringCellValue); }
		         else {
		        	 double numericCellValue = cells.getNumericCellValue();
		        	 long l=(long)numericCellValue;
		        	 String valueOf = String.valueOf(l);
			         driver.findElement(By.name(value)).sendKeys(valueOf);}
				break;
	        case "classname":
	        	if(cellType==1){
		             String stringCellValue = cells.getStringCellValue();
			         driver.findElement(By.className(value)).sendKeys(stringCellValue); }
		         else {
		        	 double numericCellValue = cells.getNumericCellValue();
		        	 long l=(long)numericCellValue;
		        	 String valueOf = String.valueOf(l);
			         driver.findElement(By.className(value)).sendKeys(valueOf);}	   
	        	break;
	        case "xpath":
	        	if(cellType==1){
		             String stringCellValue = cells.getStringCellValue();
			         driver.findElement(By.xpath(value)).sendKeys(stringCellValue); }
		         else {
		        	 double numericCellValue = cells.getNumericCellValue();
		        	 long l=(long)numericCellValue;
		        	 String valueOf = String.valueOf(l);
			         driver.findElement(By.xpath(value)).sendKeys(valueOf);}	   
	        	break;
			default:System.err.println("******invalid casee*******");
				break;
			}
		}//............webtable............
	     public static void webtable() {
	    	 List<WebElement> table = driver.findElements(By.tagName("table"));
	 		int size = table.size();
	 		System.out.println(size); 	 
	     }//........date.......
	     public static void date() {
	    	 Date date=new Date();
	 	    System.out.println("date "+date);
	     }
	     
	   
	   
	   
	   
	   
	

}
