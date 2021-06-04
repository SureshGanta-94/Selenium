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

public class Safespec_Asia_Sanity {
	public WebDriver driver;
	@BeforeTest
	public void Start() {
		System.setProperty("webdriver.chrome.driver", "D:\\Suresh\\Selenium Webdriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.safespec.dupont.asia/");
	}
	@Test(priority=0)
	public void Privacy_Text(){
		WebElement privacy = driver.findElement(By.cssSelector(".footer-text.white-clr"));
		System.out.println(privacy.getText());
		if(privacy.getText().contains("Copyright © 2020 DuPont de Nemours Inc.")){
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	@Test(priority=1)
	public void Search_Validation(){
		driver.findElement(By.id("inputSearchBox")).sendKeys("skdfbjsbdjfnbdsjfb");
		driver.findElement(By.id("inputSearchBox")).sendKeys(Keys.ENTER);
		if(driver.getPageSource().contains("No Search Results found.")){
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	@Test(priority=2)
	public void Menu_Items(){
		driver.findElement(By.cssSelector(".img-responsive.dupont-logo")).click();
		List<WebElement> products = driver.findElements(By.cssSelector(".dropdown.first-level"));
		for(int i=0;i<products.size();i++){
		System.out.println(products.get(i).getText());
		}
		if(products.size()==3){
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	@Test(priority=3)
	public void Tyvek_Products() throws InterruptedException{
		driver.findElement(By.cssSelector(".img-responsive.dupont-logo")).click();
		List<WebElement> FirstLevelMenu = driver.findElements(By.cssSelector(".dropdown.first-level"));
		Actions action = new Actions(driver);
		action.moveToElement(FirstLevelMenu.get(0)).perform();
		WebElement SecondLevelMenu = FirstLevelMenu.get(0).findElement(By.cssSelector(".dropdown-menu.first-submenu"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> middle = SecondLevelMenu.findElements(By.cssSelector(".dropdown.dropdown-submenu"));
		System.out.println(middle.size());
		for(int j=0;j<middle.size();j++){
			System.out.println(middle.get(j).getText());
		}
		Actions action1 = new Actions(driver);
		action1.moveToElement(middle.get(1)).perform();
		WebElement SecondLevelSubMenu = middle.get(1).findElement(By.cssSelector(".dropdown-menu.second-submenu.rev"));
		List<WebElement> Tyvek_Items = SecondLevelSubMenu.findElements(By.tagName("a"));
		System.out.println(Tyvek_Items.size());
		for(int i=0;i<Tyvek_Items.size();i++){
			System.out.println(Tyvek_Items.get(i).getAttribute("href"));
		}
	}
	@Test(priority=4)
	public void Country_Selection(){
		driver.findElement(By.cssSelector(".red-bgd-clr.dropdown-toggle")).click();
		List<WebElement> RegionList = driver.findElements(By.cssSelector(".reg-list"));
		List<String> Countries = new ArrayList<String>();
		for(int j=0;j<RegionList.size();j++){
		List<WebElement> regions = RegionList.get(j).findElements(By.tagName("a"));
		for(int i=0;i<regions.size();i++){
			Countries.add(regions.get(i).getText());
		}
		}
		System.out.println(Countries.size());
		for(int k=0;k<Countries.size();k++){
		System.out.println(Countries.get(k));
		}
	}
	@Test(priority=5)
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
	@Test(priority=6)
	public void Language(){
		WebElement language = driver.findElement(By.cssSelector(".white-clr"));
		if(language.getText().contains("Asia Pacific")){
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
	@Test(priority=7)
	public void Navigation_Logo(){
		WebElement logo = driver.findElement(By.cssSelector(".navbar-brand"));
		String URL = logo.getAttribute("href");
		System.out.println(URL);
		if(URL.contains("https://www.safespec.dupont.asia/")){
			System.out.println("Pass");
		} else{
			System.out.println("Fail");
		}
	}
	@AfterTest
	public void Teriminate(){
		driver.close();
	}
}
