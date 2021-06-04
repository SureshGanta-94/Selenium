package cta_Automation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

public class NandB_CTA {
public WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void HeaderValues() throws IOException{
		setCellData("N&B",0,0,"SL No");
		setCellData("N&B",1,0,"Main URL");
		setCellData("N&B",2,0,"Target URL");
		setCellData("N&B",3,0,"Staus Code");
	}
	@Test(priority=1)
	public void CTA1() throws IOException, InterruptedException {
		driver.manage().window().maximize();
		String Main_URL = "https://www.dupontnutritionandbiosciences.com/";
		driver.get(Main_URL);
		List <WebElement> element = driver.findElements(By.cssSelector(".Carousel_link"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element.get(0));
		Thread.sleep(3000);
		String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
		setCellData("N&B",0,1,"1");
		setCellData("N&B",1,1,Main_URL);
		setCellData("N&B",2,1,Target_URL);
		setCellData("N&B",3,1,Status_Code);
	}
	@Test(priority=2)
	public void CTA2() throws IOException, InterruptedException {
		driver.manage().window().maximize();
		String Main_URL = "https://www.dupontnutritionandbiosciences.com/";
		driver.get(Main_URL);
		List <WebElement> element = driver.findElements(By.partialLinkText("Read More"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element.get(0));
		Thread.sleep(3000);
		String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
		setCellData("N&B",0,2,"2");
		setCellData("N&B",1,2,Main_URL);
		setCellData("N&B",2,2,Target_URL);
		setCellData("N&B",3,2,Status_Code);
	}
	@Test(priority=3)
	public void CTA3() throws IOException, InterruptedException {
		driver.manage().window().maximize();
		String Main_URL = "https://www.dupontnutritionandbiosciences.com/";
		driver.get(Main_URL);
		WebElement element = driver.findElement(By.partialLinkText("View all News"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		Thread.sleep(3000);
		String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
		setCellData("N&B",0,3,"3");
		setCellData("N&B",1,3,Main_URL);
		setCellData("N&B",2,3,Target_URL);
		setCellData("N&B",3,3,Status_Code);
	}
	@Test(priority=4)
	public void CTA4() throws IOException, InterruptedException {
		driver.manage().window().maximize();
		String Main_URL = "https://www.dupontnutritionandbiosciences.com/";
		driver.get(Main_URL);
		WebElement element = driver.findElement(By.partialLinkText("View All Events"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		Thread.sleep(3000);
		String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
		setCellData("N&B",0,4,"4");
		setCellData("N&B",1,4,Main_URL);
		setCellData("N&B",2,4,Target_URL);
		setCellData("N&B",3,4,Status_Code);
	}
	@Test(priority=5)
	public void CTA5() throws IOException, InterruptedException {
		driver.manage().window().maximize();
		String Main_URL = "https://www.dupontnutritionandbiosciences.com/product-range.html";
		driver.get(Main_URL);
		List <WebElement> element = driver.findElements(By.partialLinkText("View Details"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element.get(0));
		Thread.sleep(3000);
		String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
		setCellData("N&B",0,5,"5");
		setCellData("N&B",1,5,Main_URL);
		setCellData("N&B",2,5,Target_URL);
		setCellData("N&B",3,5,Status_Code);
	}
	@Test(priority=6)
	public void CTA6() throws IOException, InterruptedException {
		driver.manage().window().maximize();
		String Main_URL = "https://www.dupontnutritionandbiosciences.com/sign-up-for-news.html";
		driver.get(Main_URL);
		WebElement element = driver.findElement(By.partialLinkText("View all News"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		Thread.sleep(3000);
		String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
		setCellData("N&B",0,6,"6");
		setCellData("N&B",1,6,Main_URL);
		setCellData("N&B",2,6,Target_URL);
		setCellData("N&B",3,6,Status_Code);
	}
	@Test(priority=7)
	public void CTA7() throws IOException, InterruptedException {
		driver.manage().window().maximize();
		String Main_URL = "https://www.dupontnutritionandbiosciences.com/contact-us.html";
		driver.get(Main_URL);
		WebElement element = driver.findElement(By.partialLinkText("View Products"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		Thread.sleep(3000);
		String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
		setCellData("N&B",0,7,"7");
		setCellData("N&B",1,7,Main_URL);
		setCellData("N&B",2,7,Target_URL);
		setCellData("N&B",3,7,Status_Code);
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
