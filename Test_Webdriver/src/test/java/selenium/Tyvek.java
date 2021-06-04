package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tyvek {
	public WebDriver driver ;
	String url = "https://www.dupont.com/tyvekdesign.html";
	@BeforeTest
	public void Start(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	driver.get(url);
	}
	@Test(priority=0)
	public void VerifyLogo(){
		driver.get(url);
		WebElement logourl= driver.findElement(By.className("top-header"));
		WebElement b=logourl.findElement(By.tagName("a"));
		String c= b.getAttribute("href");
		if(c.equals("https://www.dupont.com/tyvekdesign.html"))	
			System.out.println("Logo is working fine");
		else
			System.out.println("Logo link is not working");	}
	  @Test(priority=2)
	  public void VerifyLanguage(){	    
		  WebElement a=driver.findElement(By.cssSelector(".language"));
		  WebElement c=a.findElement(By.cssSelector(".maincountry"));
		  String d= "English" ;
		  String e= c.getText();
		 System.out.println( c.getText());	  
		 if (d.equals(e))
			 System.out.println("Content displayed in english language");
		 else
			 System.out.println("Content not displayed in english language");
	  }
	  @Test(priority=3)
	  public void VerifyMenu(){
		  WebElement a=driver.findElement(By.cssSelector(".hero-menu-bk.hide-for-small-only"));
		  WebElement d=a.findElement(By.cssSelector(".vertical.menu"));
		  List<WebElement> b=d.findElements(By.tagName("li"));
		  System.out.println(b.size());
		  for(int i=0;i<b.size();i++)
			  System.out.println(b.get(i).getText()); 
		  
		  if(b.size()==5)
			  System.out.println("Menu count Matched");
			  else
				  System.out.println("Menu has changed");
		  }
	  @Test(priority=4)
	  public void VerifyPrivacy(){
		  String a ="Copyright © 2019 DuPont" ;	
		  boolean c=driver.getPageSource().contains(a);
			if(c){
				System.out.println("privacy text is available");}
			else{
				System.out.println("privacy text is not available");}
				}
	  @Test(priority=5)
	  public void VerifyNews(){
		  driver.findElement(By.linkText("news and events")).click();
		  WebElement a= driver.findElement(By.cssSelector(".bgtyveknews-gridWrap.newscontainer"));
		  List<WebElement> b= a.findElements(By.cssSelector(".tyvek-newsitem"));
		  System.out.println(b.size());
		  for(int i=0;i<b.size();i++)
			  System.out.println(b.get(i).getText());
	  }
	  @AfterTest
	  public void End(){
		  driver.close();
	  }
	 
}
