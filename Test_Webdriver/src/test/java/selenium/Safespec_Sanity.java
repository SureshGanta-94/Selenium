package selenium;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Safespec_Sanity {
	public WebDriver driver;
	@BeforeTest
	public void Start() {
		System.setProperty("webdriver.chrome.driver", "D:\\Suresh\\Selenium Webdriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String URL = "https://www.safespec.dupont.com/";
		driver.get(URL);
	}
	@Test(priority=1)
	public void Search_Validation(){
		driver.findElement(By.id("search-input")).sendKeys("skdfbjsbdjfnbdsjfb"+Keys.ENTER);
		if(driver.getPageSource().contains("Sorry, we couldn't find anything that matched your search")){
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.close();
		driver.switchTo().window(tabs.get(0));
	}
	@Test(priority=2)
	public void Menu_Items(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".navbar-brand.safespec-logo")).click();
		List<WebElement> products = driver.findElements(By.cssSelector(".dropdown.first-level"));
		if(products.size()==5){
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	@Test(priority=3)
	public void Tyvek_Products(){ 
		List<WebElement> FirstLevelMenu = driver.findElements(By.cssSelector(".dropdown.first-level"));
		Actions action = new Actions(driver);
		action.moveToElement(FirstLevelMenu.get(0)).perform();
		Screenshot.screenshot();
		WebElement SecondLevelMenu = FirstLevelMenu.get(0).findElement(By.cssSelector(".dropdown-menu.first-submenu"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> middle = SecondLevelMenu.findElements(By.cssSelector(".dropdown.dropdown-submenu"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(middle.get(1)).perform();
		WebElement SecondLevelSubMenu = middle.get(1).findElement(By.cssSelector(".dropdown-menu.second-submenu"));
		List<WebElement> Tyvek_Items = SecondLevelSubMenu.findElements(By.tagName("a"));
		for(int i=0;i<Tyvek_Items.size();i++){
			System.out.println(Tyvek_Items.get(i).getAttribute("href"));
		}
		if(Tyvek_Items.size()==8){
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	@Test(priority=5)
	public void Nomex_Page(){
		List<WebElement> FirstLevelMenu = driver.findElements(By.cssSelector(".dropdown.first-level"));
		Actions action = new Actions(driver);
		action.moveToElement(FirstLevelMenu.get(1)).perform();
		Screenshot.screenshot();
		WebElement SecondLevelMenu = FirstLevelMenu.get(1).findElement(By.cssSelector(".dropdown-menu.first-submenu"));
		List<WebElement> middle = SecondLevelMenu.findElements(By.tagName("a"));
		middle.get(0).click();
		if(driver.getCurrentUrl().contains("https://www.safespec.dupont.com/nomex/featured-products.html")){
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	@Test(priority=6)
	public void Kevlar_Page(){
		List<WebElement> FirstLevelMenu = driver.findElements(By.cssSelector(".dropdown.first-level"));
		Actions action = new Actions(driver);
		action.moveToElement(FirstLevelMenu.get(2)).perform();
		Screenshot.screenshot();
		WebElement SecondLevelMenu = FirstLevelMenu.get(2).findElement(By.cssSelector(".dropdown-menu.first-submenu"));
		List<WebElement> middle = SecondLevelMenu.findElements(By.tagName("a"));
		middle.get(0).click();
		if(driver.getCurrentUrl().contains("https://www.safespec.dupont.com/kevlar/featured-products.html")){
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	@Test(priority=7)
	public void Country_Selection() throws InterruptedException{
		driver.findElement(By.cssSelector(".global-locations-language")).click();
		Thread.sleep(5000);
		List<WebElement> RegionList = driver.findElements(By.cssSelector(".reg-list"));
		List<String> Countries = new ArrayList<String>();
		for(int j=0;j<RegionList.size();j++){
		List<WebElement> regions = RegionList.get(j).findElements(By.tagName("a"));
		for(int i=0;i<regions.size();i++){
			Countries.add(regions.get(i).getText());
		}
		}
		Screenshot.screenshot();
		System.out.println(Countries.size());
		for(int k=0;k<Countries.size();k++){
		System.out.println(Countries.get(k));
		}
	}
	@Test(priority=0)
	public void Privacy_Text(){
		WebElement privacy = driver.findElement(By.cssSelector(".footer-text.white-clr"));
		String privacy_Text = privacy.getText();
		System.out.println(privacy_Text);
		if(privacy_Text.contains("Copyright © 2020 DuPont de Nemours Inc.")){
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	@Test(priority=8)
	public void Footer_Items(){
		List<WebElement> element = driver.findElements(By.cssSelector(".col-xs-12.col-sm-3.col-md-3.col-lg-3"));
		List<String> Footer_Items = new ArrayList<String>();
		for(int i=0;i<element.size();i++){
			WebElement element2 =element.get(i).findElement(By.cssSelector(".footer-sub-content.white-clr"));
			List<WebElement> element3 = element2.findElements(By.tagName("a"));
			for(int j=0;j<element3.size();j++){
				Footer_Items.add(element3.get(j).getText());
			}
		}
		for(int k=0;k<Footer_Items.size();k++){
			System.out.println(k+"  "+Footer_Items.get(k));
		}
	}
	@Test(priority=9)
	public void Language(){
		WebElement language = driver.findElement(By.cssSelector(".global-locations-language"));
		if(language.getText().contains("North America")){
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	@Test(priority=10)
	public void Navigation_Logo(){
		WebElement logo = driver.findElement(By.cssSelector(".navbar-brand"));
		String URL = logo.getAttribute("href");
		System.out.println(URL);
		if(URL.contains("https://www.safespec.dupont.com/")){
			System.out.println("Pass");
		} else{
			System.out.println("Fail");
		}
	}
	@AfterTest
	public void Teriminate(){
		driver.quit();
	}

}
