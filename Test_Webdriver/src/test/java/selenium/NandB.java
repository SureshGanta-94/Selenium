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

public class NandB {
	public WebDriver driver;
	String url = "https://www.dupontnutritionandbiosciences.com/" ;
	@BeforeTest
	public void Start(){
		driver = new ChromeDriver();	
	driver.get(url);
	driver.manage().window().maximize();
	}
  @Test(priority=1)
  public void VerifyLogo() {		
		driver.findElement(By.cssSelector("a[data-title=\"Nutrition & Biosciences\"]")).click();
		String a = driver.getCurrentUrl();
		if(a.equals(url)){
			System.out.println("Dupont Logo link is working");}
			
			else {
				System.out.println("No image");}
  }
  @Test(priority=0)
  public void VerifySearch() throws InterruptedException{
	  WebElement search= driver.findElement(By.id("searchInput"));
		search.sendKeys("jgjkdfbg"+Keys.ENTER);
		Thread.sleep(2000);
			 if (driver.getPageSource().contains("Total number of Records 0")){
				      System.out.println("Test pass");}
		            else {
		        	System.out.println("Test fail ");
		        }
			 driver.navigate().back();
  }
  @Test(priority=3)
  public void VerifyPrivacy(){
	   String a ="© 2019 DuPont." ;	
	  boolean c=driver.getPageSource().contains(a);
		
		if(c){
			
			System.out.println("privacy text is available");}
		else{
			
			System.out.println("privacy text is not available");}		
  }
  @Test(priority=5)
  public void VerifyFooterLogo(){
	  WebElement c=driver.findElement(By.cssSelector(".row.mrg0"));
	  String a=	c.findElement(By.cssSelector(".footerHeading")).getText();
	  String b="Nutrition & Biosciences";
				if(a.equals(b)){
					System.out.println("pass");}	
				else{
					System.out.println("fail");}
  }
  @Test(priority=4)
   public void NavList(){
	  WebElement a=driver.findElement(By.className("navbar-nav"));
		
		List<WebElement> NavList =  a.findElements(By.tagName("li"));
				
		System.out.println(NavList.size());
		if(NavList.size()==7){
			System.out.println("Menu list is matched");}
		else{
			System.out.println("Menu list is not matched");}
		for(WebElement title : NavList)
			System.out.println(title.getText());  
  }
  @Test(priority=0)
  public void VerifyNewsEvents(){
			String a=driver.findElement(By.id("topiclist")).getText();
			String b=driver.findElement(By.id("topiclist_682011513")).getText();
		WebElement c=	driver.findElement(By.cssSelector(".col-md-8.col-sm-12.topic-List__description"));
		List<WebElement> Newscount =c.findElements(By.cssSelector(".padding10"));
		System.out.println("News Count : " + Newscount.size());
		System.out.println(a);
		WebElement d=driver.findElement(By.cssSelector(".col-md-8.col-sm-12.topic-List__description"));
		List<WebElement> Eventscount = d.findElements(By.cssSelector(".padding10"));
		System.out.println("Events Count : " + Eventscount.size());
		System.out.println(b);	
	if(Newscount.size()==2 && Eventscount.size()==2)
		System.out.println("News and Events count Matched");
	else
		System.out.println("News and Events count not Matched");
  }
  @Test(priority=2)
  public void VerifyProblemSolver() throws InterruptedException{
	 WebElement b=driver.findElement(By.cssSelector(".nav.navbar-right.align-right.d-none.d-sm-block"));
	  WebElement c=b.findElement(By.cssSelector(".btn.btn-grey"));
	 c.click();
	 Thread.sleep(2000);
	  String h=driver.getCurrentUrl();
	  System.out.println(h);
	  List<WebElement> a=driver.findElements(By.cssSelector(".panel-body"));
	  System.out.println(a.size());
	  for(int i=0;i<a.size();i++){
	  List<WebElement> t=a.get(i).findElements(By.cssSelector(".radioclass"));
	  System.out.println(t.get(1).getText());
	  Actions actions = new Actions(driver);
	  actions.moveToElement(t.get(1)).click().build().perform();
	  Thread.sleep(2000);
	  }
	  Screenshot.screenshot();
	  if(h.equals("https://www.dupontnutritionandbiosciences.com/problem-solver.html")){
		  System.out.println("Problem Solver is working fine");}
	  else{
		  System.out.println("Problem Solver is not working");} 
  } 
  @AfterTest
  public void End(){
	  driver.close();
  }
}
