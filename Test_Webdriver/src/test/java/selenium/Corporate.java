package selenium;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Corporate {
public WebDriver driver;
	
	@BeforeTest
	public void Start() throws IOException{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String Sanity_Url = "https://www.dupont.com";
		driver.get(Sanity_Url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		int Response_Code= HttpResponse.getHTTPResponseStatusCode(Sanity_Url);
//		System.out.println(Response_Code);
	}
	@Test(priority=0)
	public void Header_Products(){	
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.partialLinkText("Brands & Products"));
		action.moveToElement(element).perform();
		List<WebElement> Products = driver.findElements(By.className("crprate-hide-for-desk"));
		int Count = Products.size();
		if(Count==33){
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	@Test(priority=1)
	public void Search_Validation() throws InterruptedException{
		driver.findElement(By.linkText("Search")).click();
		driver.findElement(By.id("search-input")).sendKeys("sdjdjvbdsfjvnjdfnv");
		driver.findElement(By.id("search-input")).sendKeys(Keys.ENTER);
		Thread.sleep(1500);
		List<WebElement> ItemResult = driver.findElements(By.className("item-result"));
		if(ItemResult.size() == 0){
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	@Test(priority=2)
		public void News_Validation() throws ParseException{
			driver.findElement(By.partialLinkText("Newsroom")).click();
			if(driver.getPageSource().contains("No news found for this month")){
				System.out.println("No News");
			}else{
			List<WebElement> element1 = driver.findElements(By.cssSelector(".col-12.date"));
			int Count = element1.size();
			List<Date> dates =new ArrayList<Date>();
			for(int i=0;i<Count;i++){
				String Dates = element1.get(i).getText();
				SimpleDateFormat parser  = new SimpleDateFormat("MMM dd, yyyy");
				Date thedate = parser.parse(Dates);
				dates.add(thedate);
			}	
			Date minDate = Collections.min(dates);
			Date maxDate = Collections.max(dates);
			LocalDate date1 = maxDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			int month1 = date1.getMonthValue();
			LocalDate date2 = minDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			int month2 = date2.getMonthValue();
			Date date = new Date();
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			int month = localDate.getMonthValue();
			if(month == month1){
				if(month1==month2){
					System.out.println("Pass");
				} else{
					System.out.println("failed at first level");
				}
			} else {
				System.out.println("failed at second level");
			}
		}
	}
		@Test(priority=4)
		public void PrivacyText_Validation(){
			WebElement element = driver.findElement(By.cssSelector(".navigation-logo"));
			Actions action = new Actions(driver);
			action.moveToElement(element).click().perform();
			WebElement privacy = driver.findElement(By.cssSelector(".body3"));
			System.out.println(privacy.getText());
			String PrivacyText = privacy.getText();
			if(PrivacyText.contains("© 2020 DuPont")){
				System.out.println("Pass");
			} else{
				System.out.println("Fail");
			}
		}
		@Test(priority=5)
		public void Locations_Validation() throws InterruptedException{
			driver.findElement(By.partialLinkText("English")).click();
			Thread.sleep(1500);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
			WebElement column1 = driver.findElement(By.id("bodycopy"));
			List<String> links = new ArrayList<String>();
			List<WebElement> element = column1.findElements(By.tagName("a"));
			for(int i=0;i<element.size()-1;i++){
				links.add(element.get(i).getText());
			}
			WebElement column2 = driver.findElement(By.id("bodycopy_195808145"));
			List<WebElement> element1 = column2.findElements(By.tagName("a"));
			for(int i=0;i<element1.size();i++){
				links.add(element1.get(i).getText());
			}
			WebElement column3 = driver.findElement(By.id("bodycopy_1335862077_"));
			List<WebElement> element2 = column3.findElements(By.tagName("a"));
			for(int i=0;i<element2.size();i++){
				links.add(element2.get(i).getText());
			}
			System.out.println(links);
			if(links.size()==33){
				System.out.println("Pass");
			} else {
				System.out.println("Fail");
			}
		}
		@Test(priority=6)
		public void FooterChiclets_Validation(){
			driver.findElement(By.className("navigation-logo")).click();
			WebElement SocialIcons = driver.findElement(By.cssSelector(".col-sm-12.col-lg-2.footer-social-icons"));
			List<WebElement> element12 = SocialIcons.findElements(By.tagName("a"));
					for(int i=0;i<element12.size();i++){
				System.out.println(element12.get(i).getAttribute("href"));		
			} if(element12.size()==3){
				System.out.println("Pass");
			}
		}
		@Test(priority=7)
		public void Navigation_Logo_Validation(){
			WebElement navigationlogo = driver.findElement(By.className("navigation-logo"));
			String URL = navigationlogo.getAttribute("href");
			if(URL.contains("https://www.dupont.com/")){
				System.out.println("Pass");
			} else{
				System.out.println("Fail");
			}
		}
		@Test(priority=8)
		public void Location_Language(){
			WebElement link = driver.findElement(By.cssSelector(".language.navigation-item-sm"));
			String link1 = link.getText();
			if(link1.contains("English")){
				System.out.println("Pass");
			} else{
				System.out.println("Fail");
			}
		}
	@AfterTest
	public void Close(){
		driver.close();
	}


}
