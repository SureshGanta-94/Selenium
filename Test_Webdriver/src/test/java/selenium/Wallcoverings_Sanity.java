package selenium;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Wallcoverings_Sanity {
	public WebDriver driver;
	@BeforeTest
	public void Start(){
		System.setProperty("webdriver.chrome.driver", "D:\\Suresh\\Selenium Webdriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tedlarwallcoverings.dupont.com/");
	}
	@Test(priority=0)
	public void HeaderProducts(){
		WebElement element = driver.findElement(By.cssSelector(".navbar-nav.nav.TIMenuSpacing"));
		List<WebElement> HeaderItems = element.findElements(By.tagName("a"));
		System.out.println(HeaderItems.size());
		for(int i=0;i<HeaderItems.size();i++){
			System.out.println(HeaderItems.get(i).getText());
		}
	}
	@Test(priority=1)
	public void PrivacyText(){
		WebElement privacy = driver.findElement(By.cssSelector(".col-12.TcopyRight"));
		if(privacy.getText().contains("Copyright © 2020 DuPont")){
			System.out.println("Pass");
		} else{
			System.out.println("Fail");
		}
	}
	@Test(priority=2)
	public void FooterItems(){
		WebElement footer = driver.findElement(By.cssSelector(".col-12.col-sm-12.col-md-8.col-lg-9.col-xl-9.policyLinks"));
		List<WebElement> footeritems = footer.findElements(By.tagName("a"));
		for(int i=0;i<footeritems.size();i++){
			System.out.println(footeritems.get(i).getText());
		}
		if(footeritems.size()==3){
			System.out.print("Pass");
		}
	}
	@Test(priority=3)
	public void News_Events_Page(){
		driver.findElement(By.partialLinkText("News & Events")).click();
		String events = driver.getCurrentUrl();
		Screenshot.screenshot();
		if(events.contains("https://www.tedlarwallcoverings.dupont.com/news-events.html")){
			System.out.print("Pass");
		}
	}
	@Test(priority=4)
	public void Collections(){
		Actions action = new Actions(driver);
		WebElement m = driver.findElement(By.cssSelector(".dropdown.nav-item.menu-large"));
		action.moveToElement(m).perform();
		WebElement element = driver.findElement(By.cssSelector(".dropdown-menu.TIMegaScroll.megamenu "));
		WebElement element1 = element.findElement(By.cssSelector(".dropdown-item"));
		List<WebElement> HeaderItems = element1.findElements(By.tagName("a"));
		Screenshot.screenshot();
		for(int i=0;i<HeaderItems.size();i++){
			System.out.println(HeaderItems.get(i).getText());
		}
	}	
	@Test(priority=5)
	public void Header_Link(){
		WebElement element = driver.findElement(By.cssSelector(".Tlogo-txt"));
		WebElement Header_Link = element.findElement(By.tagName("a"));
		if(Header_Link.getAttribute("href").contains("https://www.tedlarwallcoverings.dupont.com/")){
			System.out.print("Pass");
		}
	}
	@Test(priority=6)
	public void ContactUs(){
		driver.findElement(By.partialLinkText("Contact Us")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("first_name")).sendKeys("Test");
		driver.findElement(By.name("last_name")).sendKeys("Test");
		driver.findElement(By.name("email")).sendKeys("test@etest.com");
		Select Country = new Select(driver.findElement(By.name("00N30000001UlfP")));
		Country.selectByIndex(1);
		driver.findElement(By.name("company")).sendKeys("Test");
		Select PrimaryRole = new Select(driver.findElement(By.name("00N30000001Gopo")));
		PrimaryRole.selectByIndex(1);
		Select ProjectType = new Select(driver.findElement(By.name("00N30000001Vk4k")));
		ProjectType.selectByIndex(1);
		Select TypeofInquiry = new Select(driver.findElement(By.name("00N30000001Goqh")));
		TypeofInquiry.selectByIndex(1);
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/div[3]/div[1]/form/div[2]/div/fieldset[1]/textarea")).sendKeys("Test");
		Screenshot.screenshot();
		driver.findElement(By.id("wallcoveringFormSubmit")).click();
		System.out.println(driver.getCurrentUrl());
		Screenshot.screenshot();
		if(driver.getPageSource().contains("We appreciate your interest in DuPont™ Tedlar™ Wallcoverings.")){
			System.out.print("Pass");
		}
	}
	@AfterTest
	public void Teriminate(){
		driver.close();
	}
}
