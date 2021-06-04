package cta_Automation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Water_CTA {
	
	public WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void HeaderValues() throws IOException{
		setCellData("Water",0,0,"SL No");
		setCellData("Water",1,0,"Main URL");
		setCellData("Water",2,0,"Target URL");
		setCellData("Water",3,0,"Staus Code");
	}
	@Test(priority=1)
	public void CTA1() throws IOException, InterruptedException {
		driver.manage().window().maximize();
		String Main_URL = "https://www.dupont.com/water.html";
		driver.get(Main_URL);
		WebElement element = driver.findElement(By.partialLinkText("Why work with us"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		Thread.sleep(3000);
		String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
		setCellData("Water",0,1,"1");
		setCellData("Water",1,1,Main_URL);
		setCellData("Water",2,1,Target_URL);
		setCellData("Water",3,1,Status_Code);
	}
	@Test(priority=2)
	public void CTA2() throws IOException, InterruptedException {
		driver.manage().window().maximize();
		String Main_URL = "https://www.dupont.com/water.html";
		driver.get(Main_URL);
		WebElement element = driver.findElement(By.partialLinkText("View all resources"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		Thread.sleep(3000);
		String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
		setCellData("Water",0,2,"2");
		setCellData("Water",1,2,Main_URL);
		setCellData("Water",2,2,Target_URL);
		setCellData("Water",3,2,Status_Code);
	}
	@Test(priority=3)
	public void CTA3() throws IOException, InterruptedException {
		driver.manage().window().maximize();
		String Main_URL = "https://www.dupont.com/water.html";
		driver.get(Main_URL);
		WebElement element = driver.findElement(By.cssSelector(".primary-CTA.white-bgd"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		Thread.sleep(3000);
	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
	    driver.close();
	    driver.switchTo().window(tabs2.get(0));
		setCellData("Water",0,3,"3");
		setCellData("Water",1,3,Main_URL);
		setCellData("Water",2,3,Target_URL);
		setCellData("Water",3,3,Status_Code);
	}
	@Test(priority=4)
	public void CTA4() throws IOException, InterruptedException {
		driver.manage().window().maximize();
		String Main_URL = "https://www.dupont.com/water/why-dupont.html";
		driver.get(Main_URL);
		List<WebElement> element = driver.findElements(By.cssSelector(".body2.ancSpc"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element.get(0));
		Thread.sleep(3000);
		String Target_URL = driver.getCurrentUrl();
		System.out.println(Target_URL);
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
		setCellData("Water",0,4,"4");
		setCellData("Water",1,4,Main_URL);
		setCellData("Water",2,4,Target_URL);
		setCellData("Water",3,4,Status_Code);
	}
	@Test(priority=5)
	public void CTA5() throws IOException, InterruptedException {
		driver.manage().window().maximize();
		String Main_URL = "https://www.dupont.com/water/industries/commercial.html";
		driver.get(Main_URL);
		List<WebElement> element = driver.findElements(By.cssSelector(".primary-CTA.white-bgd"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element.get(0));
		Thread.sleep(3000);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
	    driver.close();
	    driver.switchTo().window(tabs2.get(0));
		setCellData("Water",0,5,"5");
		setCellData("Water",1,5,Main_URL);
		setCellData("Water",2,5,Target_URL);
		setCellData("Water",3,5,Status_Code);
	}
	@Test(priority=6)
	public void CTA6() throws IOException, InterruptedException {
		driver.manage().window().maximize();
		String Main_URL = "https://www.dupont.com/water/industries/commercial.html";
		driver.get(Main_URL);
		List<WebElement> element = driver.findElements(By.cssSelector(".read-outer.cust-arrow"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element.get(0));
		Thread.sleep(3000);
		String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
		setCellData("Water",0,6,"6");
		setCellData("Water",1,6,Main_URL);
		setCellData("Water",2,6,Target_URL);
		setCellData("Water",3,6,Status_Code);
	}
	@AfterTest
	public void Close_Browser() {
		driver.quit();
	}
	
	public static int getHTTPResponseStatusCode(String u) throws IOException {
        URL url = new URL(u);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        return http.getResponseCode();
    }
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	Date date = java.util.Calendar.getInstance().getTime();
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
	String strDate = dateFormat.format(date);
	String xlFilePath = "D:\\Suresh\\CTA\\CTA_Metrics_"+strDate+".xlsx";
	
	public XSSFSheet setCellData(String sheetName, int colNumber, int rowNum, String value){
		try{
			FileInputStream fis = new FileInputStream(xlFilePath);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    sheet = workbook.getSheet(sheetName);
	    row = sheet.getRow(rowNum);
	    if(row==null)
	        row = sheet.createRow(rowNum);
	    	cell = row.getCell(colNumber);
	    		if(cell == null)
	    			cell = row.createCell(colNumber);
	    			cell.setCellValue(value);
	    			fos = new FileOutputStream(xlFilePath);
	    			workbook.write(fos);
	    			fos.close();
			}
		catch (Exception ex)
		{
	    ex.printStackTrace();
		}
	return sheet;
	}

}
