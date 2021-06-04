package selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Water {
	public WebDriver driver;
	String url = "https://www.dupont.com/water.html";
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
		if(c.equals("https://www.dupont.com/water.html"))	
			System.out.println("Logo is working fine");
		else
			System.out.println("Logo link is not working");	}	
	@Test(priority=1)
	  public void VerifyPrivacy(){
		  String a ="© 2019 DuPont." ;	
		  boolean c=driver.getPageSource().contains(a);
			if(c){
				System.out.println("privacy text is available");}
			else{
				System.out.println("privacy text is not available");}
				}
	 @Test(priority=4)
	  public void VerifySearch(){
		  driver.get("https://www.dupont.com/search.html?BU=water-solutions");
		  WebElement search= driver.findElement(By.id("search-input"));
			search.sendKeys("jgjkdfbg"+Keys.ENTER);
				boolean c=driver.getPageSource().contains("Sorry, we couldn’t find anything that matched your search.");
				if(c){
					System.out.println("Search is working fine");}
				else{
				System.out.println("Search failed");}		
	  }	  
	  @Test(priority=5)
		public void ContactValiation(){
			driver.get("https://www.dupont.com/water/contact-us.html");
			driver.findElement(By.cssSelector(".text-center.submit")).click();
			if(driver.getPageSource().contains("Enter email address"))
				System.out.println("Validations are working");		
				else		
				System.out.println("Validations are not wroking");
		}  
	  @Test(priority=2)
	  public void VerifyLanguage(){	  
		  WebElement a=driver.findElement(By.cssSelector(".quick-links"));
		  WebElement c=a.findElement(By.cssSelector(".dropbtn"));
		  String d= "English (USA)" ;
		  String e= c.getText();
		 System.out.println( c.getText());	  
		 if (d.equals(e))
			 System.out.println("Content displayed in english language");
		 else
			 System.out.println("Content not displayed in english language");
	  }	
	  @Test(priority=3)
	  public void VerifyNav(){
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
	  @AfterTest
	  public void End(){
		  driver.close();
	  }
}

