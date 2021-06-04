package selenium;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Electronics {
	
	public WebDriver driver;
	String url = "https://www.dupont.com/electronic-materials.html";
	@BeforeTest
	public void start(){
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get(url);	
	}
	@Test(priority=0)
	public void VerifyLogo(){
		WebElement logourl= driver.findElement(By.className("header-logo"));
		WebElement b=logourl.findElement(By.tagName("a"));
		String c= b.getAttribute("href");
		if(c.equals("https://www.dupont.com/"))
			System.out.println("Logo is working fine -- pass");
		else
			System.out.println("Logo link is not working -- fail");	
	}
	
	@Test(priority=1)
	public void VerifyPrivacy(){ 
		  String a ="© 2019 DuPont." ;	
		  boolean c=driver.getPageSource().contains(a);
			if(c){
					System.out.println("privacy text is available");}
			else{
				System.out.println("privacy text is not available");}}
	@Test(priority=2)
	 public void MenuList(){
		WebElement a=driver.findElement(By.className("navbar-nav"));
		List<WebElement> NavList =  a.findElements(By.tagName("li"));
		int h=NavList.size();
					System.out.println(h);
			if(NavList.size()==226)
				System.out.println("Menu count is mathced");
			else
				System.out.println("Menu count is not mathced");
	}
	@Test(priority=5)
	public void VerifySearch(){
		driver.findElement(By.cssSelector(".header-search-bar")).click();
		//driver.get("https://www.dupont.com/electronic-materials/search-results.html");
		//WebElement b=driver.findElement(By.id("inputSearch"));
		WebElement b=driver.findElement(By.cssSelector(".header-search.inputSearch"));
		b.sendKeys("jgjkdfbg"+Keys.ENTER);
		String c= "No Results to show";
		boolean d=driver.getPageSource().contains(c);
		if(d){
			System.out.println("search is working");}
		else{
			System.out.println("search is not wroking");}
		driver.navigate().back();
	}
	@Test(priority=4)
	public void ContactFormValiation(){
		driver.navigate().to("https://www.dupont.com/electronic-materials/contact-us.html");
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		String a="Please enter a valid email address";
		if(driver.getPageSource().contains(a))
			System.out.println("Validations are working");
		else
			System.out.println("Validations are not wroking");
		driver.navigate().back();
	}

	@Test(priority=5)
	public void VerifyNewsCount(){
		driver.findElement(By.linkText("News")).click();
		WebElement d=driver.findElement(By.cssSelector(".news-card"));
		WebElement a=d.findElement(By.cssSelector(".news-card__card-container"));
		List<WebElement> b =a.findElements(By.cssSelector(".card-copy__tag"));
		System.out.println(b.size());
		if(b.size()==29)
			System.out.println("News count is matched");
		else
			System.out.println("News count is not matched");
		driver.navigate().back();
				}
	@Test(priority=6)
	public void VerifyFooterLeagalLinks(){
		WebElement a=driver.findElement(By.cssSelector(".col-7.col-md-9.footer-legal-notice"));
		List<WebElement> b =a.findElements(By.tagName("a"));
		System.out.println(b.size());
		if(b.size()==3)
			System.out.println("Footer legal links count is matched");
		else
			System.out.println("Footer legal links count is not mathced");
	}
	  @AfterTest
	  public void End(){
		  driver.close();
	  }
	 
}
