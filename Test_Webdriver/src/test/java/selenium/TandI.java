package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TandI {
	
	public WebDriver driver ;
	String url = "https://www.dupont.com/transportation-industrial.html";
	@BeforeTest
	public void Start(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	driver.get(url);
	}
	@Test(priority=0)
	public void VerifyLogo(){
		WebElement logourl= driver.findElement(By.cssSelector(".container.TIMegaListedItems"));
		String a=logourl.findElement(By.tagName("a")).getAttribute("href");
		String b="https://www.dupont.com/";
		if(a.equals(b)){
			System.out.println("pass");}
		else{
			System.out.println("fail");
		}	}
	@Test (priority=1)
	public void VerifyPrivacy(){
		    String a ="© 2019 DuPont." ;	
		    boolean c=driver.getPageSource().contains(a);
			if(c){
					System.out.println("privacy text is available");}
			else{
				System.out.println("privacy text is not available");}}
	@Test(priority=2)
	public void NavList(){
		  WebElement a=driver.findElement(By.className("navbar-nav"));
			List<WebElement> NavList =  a.findElements(By.tagName("li"));
					System.out.println(NavList.size());
			if(NavList.size()==32)
				System.out.println("Menu list count Matched");
			else{
				System.out.println("Menu list count not matched");}
			for(WebElement title : NavList)
				System.out.println(title.getText());		  
	  }
	@Test(priority=3)
	public void Findproduct(){
		WebElement b=driver.findElement(By.cssSelector(".btn.NavButton"));
		b.click();
		WebElement a=driver.findElement(By.id("search-input"));
		a.sendKeys("sdflsdf"+Keys.ENTER);
		WebElement g=driver.findElement(By.cssSelector(".search-result.col-8"));
		WebElement c=g.findElement(By.id("noResultFound"));
		String d=c.getText();
		String e="Sorry, we couldn't find anything that matched your search";
		if(d.equals(e)){
			System.out.println("Find product is working");}
		else{
			System.out.println("Find product is not wroking");}
		driver.navigate().back();
	}
	@Test(priority=4)
	public void VerifySearch(){
		WebElement search= driver.findElement(By.cssSelector(".input-group"));
		  WebElement b=search.findElement(By.id("Theadersearch"));
			Actions actions = new Actions(driver);
			actions.moveToElement(b);
			actions.click();
			actions.sendKeys("fhjgfjhgjk"+Keys.ENTER);
			actions.build().perform();
		  String c= "Sorry, we couldn’t find anything that matched your search.";
			boolean d=driver.getPageSource().contains(c);
			if(d){
				System.out.println("search is working");}
			else{
				System.out.println("search is not wroking");}}
	@Test
	public void VerifyNews(){
		driver.findElement(By.linkText("News & Events")).click();
		WebElement a=driver.findElement(By.cssSelector(".container.component-listing"));
		WebElement b=a.findElement(By.cssSelector(".row.grid-container-article"));
		System.out.println(b.getText());
		
	}
	@Test
	public void Footer(){
		WebElement a=driver.findElement(By.cssSelector(".row.TFpolicy"));
		List<WebElement> b=a.findElements(By.tagName("a"));
		System.out.println(b.size());
		for(int i=0;i<b.size();i++){
			System.out.println(b.get(i).getText());
		}
		if(b.size()==10)
			System.out.println("pass");
		else
			System.out.println("fail");
	}
	 @AfterTest
	  public void End(){
		  driver.close();
	  }
}
