package cta_Automation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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

public class CA_CTA {
public WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void HeaderValues() throws IOException{
		setCellData("CA",0,0,"SL No");
		setCellData("CA",1,0,"Main URL");
		setCellData("CA",2,0,"Target URL");
		setCellData("CA",3,0,"Staus Code");
	}
	@Test(priority=1)
	public void CTA1() throws IOException {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Main_URL = "https://www.dupont.ca/";
		driver.get(Main_URL);
		WebElement element = driver.findElement(By.cssSelector(".heroImage-Text_Link.heroImage_Button.default"));
		element.click();
		String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
		setCellData("CA",0,1,"1");
		setCellData("CA",1,1,Main_URL);
		setCellData("CA",2,1,Target_URL);
		setCellData("CA",3,1,Status_Code);
	}
	@Test(priority=2)
	public void CTA2() throws IOException, InterruptedException {
		String Main_URL = "https://www.dupont.ca/en/about.html";
		driver.get(Main_URL);
		WebElement element = driver.findElement(By.partialLinkText("See what we're doing with science"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		Thread.sleep(3000);
		String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
		setCellData("CA",0,2,"2");
		setCellData("CA",1,2,Main_URL);
		setCellData("CA",2,2,Target_URL);
		setCellData("CA",3,2,Status_Code);
	}
	@Test(priority=3)
	public void CTA3() throws IOException {
		String Main_URL = "https://www.dupont.ca/en/news.html";
		driver.get(Main_URL);
		WebElement element = driver.findElement(By.cssSelector(".cta.white"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
		setCellData("CA",0,3,"3");
		setCellData("CA",1,3,Main_URL);
		setCellData("CA",2,3,Target_URL);
		setCellData("CA",3,3,Status_Code);
	}
	@Test(priority=4)
	public void CTA4() throws IOException, InterruptedException {
		String Main_URL = "https://www.dupont.ca/";
		driver.get(Main_URL);
		WebElement element = driver.findElement(By.partialLinkText("Watch the talks"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		Thread.sleep(5000);
		String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
		setCellData("CA",0,4,"4");
		setCellData("CA",1,4,Main_URL);
		setCellData("CA",2,4,Target_URL);
		setCellData("CA",3,4,Status_Code);
	}
	@Test(priority=5)
	public void CTA5() throws IOException, InterruptedException {
		String Main_URL = "https://www.dupont.ca/";
		driver.get(Main_URL);
		WebElement element = driver.findElement(By.partialLinkText("Get started"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		Thread.sleep(5000);
		String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
		setCellData("CA",0,5,"5");
		setCellData("CA",1,5,Main_URL);
		setCellData("CA",2,5,Target_URL);
		setCellData("CA",3,5,Status_Code);
	}
	@Test(priority=6)
	public void CTA6() throws IOException, InterruptedException {
		String Main_URL = "https://www.dupont.ca/";
		driver.get(Main_URL);
		WebElement element = driver.findElement(By.partialLinkText("Learn more"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		Thread.sleep(5000);
		String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
		setCellData("CA",0,6,"6");
		setCellData("CA",1,6,Main_URL);
		setCellData("CA",2,6,Target_URL);
		setCellData("CA",3,6,Status_Code);
	}
	@Test(priority=7)
	public void CTA7() throws IOException, InterruptedException {
		String Main_URL = "https://www.dupont.ca/";
		driver.get(Main_URL);
		WebElement element = driver.findElement(By.partialLinkText("Browse brands"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		Thread.sleep(5000);
		String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
		setCellData("CA",0,7,"7");
		setCellData("CA",1,7,Main_URL);
		setCellData("CA",2,7,Target_URL);
		setCellData("CA",3,7,Status_Code);
	}
	@Test(priority=8)
	public void CTA8() throws IOException, InterruptedException {
		String Main_URL = "https://www.dupont.ca/";
		driver.get(Main_URL);
		WebElement element = driver.findElement(By.partialLinkText("Browse product lines"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		Thread.sleep(5000);
		String Target_URL = driver.getCurrentUrl();
		int S_Code = getHTTPResponseStatusCode(Target_URL);
		String Status_Code = String.valueOf(S_Code);
		setCellData("CA",0,8,"8");
		setCellData("CA",1,8,Main_URL);
		setCellData("CA",2,8,Target_URL);
		setCellData("CA",3,8,Status_Code);
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
