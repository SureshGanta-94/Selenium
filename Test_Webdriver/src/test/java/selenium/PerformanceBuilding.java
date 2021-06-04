package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PerformanceBuilding {
	public WebDriver driver;
	String url ="https://www.dupont.com/building.html";
	@BeforeTest
	public void Start(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		}
@Test(priority=0)
public void VerifyLogo(){
	WebElement logourl= driver.findElement(By.className("component-navigation--logo"));
	WebElement b=logourl.findElement(By.tagName("a"));
	String c= b.getAttribute("href");
	if(c.equals("https://www.dupont.com/"))
		System.out.println("Logo is working fine");
	else
		System.out.println("Logo link is not working");	
}
@Test(priority=5)
public void ContactValiation(){
	driver.get("https://www.dupont.com/building/contact-us.html");
	driver.findElement(By.cssSelector(".btn.btn-default.successButton")).click();
	if(driver.getPageSource().contains("Email is empty."))
		System.out.println("Validations are working");
	else
		System.out.println("Validations are not wroking");
}
@Test(priority=1)
public void VerifyFooterLogo(){
	WebElement logourl= driver.findElement(By.cssSelector(".row.footer-header"));
	WebElement b=logourl.findElement(By.tagName("a"));
	String c= b.getAttribute("href");
	if(c.equals("https://www.dupont.com/"))
		System.out.println("Footer Logo is working fine");
	else
		System.out.println("Footer Logo link is not working");	
}
@Test(priority=2)
public void VerifyNavigation(){
  	WebElement a= driver.findElement(By.cssSelector(".component-navigation--items-top"));
  	List<WebElement> d= a.findElements(By.cssSelector(".navigation-item-contain"));
  	System.out.println(d.size());
  	for(int j=0;j<d.size();j++){
  	WebElement c= d.get(j);
  	System.out.println(d.get(j).getText());
  	List<WebElement> g =null;
  	try{
  	WebElement e = c.findElement(By.cssSelector(".navigation-sub"));
  	 g = e.findElements(By.tagName("a"));
  	System.out.println(g.size());
  	for (int i=0; i<g.size() ; i++){
  		System.out.println(g.get(i).getAttribute("href"));	
  	}}
  	catch (NoSuchElementException e) {
  	    System.out.println("No child pages");
  	}
  	}	
}
@Test(priority=3)
public void VerifyPrivacy(){
   String a ="2019 DuPont de Nemours" ;	
  boolean c=driver.getPageSource().contains(a);
	
	if(c){
		
		System.out.println("privacy text is available");}
	else{
		
		System.out.println("privacy text is not available");}	
}
@Test(priority=4)
public void News(){
	driver.get("https://www.dupont.com/building/news.html");
	WebElement a=driver.findElement(By.cssSelector(".row.grid-container-article"));
	String b= a.getText();
	if(b!=null)
	 System.out.println(b);
}
@AfterTest
public void End(){
	  driver.close();
}

}
