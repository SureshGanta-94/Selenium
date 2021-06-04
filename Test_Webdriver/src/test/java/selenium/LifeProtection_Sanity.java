package selenium;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.junit.Assert;

public class LifeProtection_Sanity {
public WebDriver driver;
	
	@BeforeTest
	public void Start() throws IOException{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String Sanity_Url = "https://www.dupont.com/life-protection.html";
		driver.get(Sanity_Url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority=0)
	public void Header_Links(){	
		Screenshot.screenshot();
		List<WebElement> Header_Links = driver.findElements(By.cssSelector(".navigation-item-contain"));
		int Count = Header_Links.size();
		Assert.assertTrue(Count==4);
	}
	@Test(priority=1)
	public void Header_Text(){	
		WebElement Header_Text = driver.findElement(By.cssSelector(".subsite-text"));
		String Text = Header_Text.getText();
		Assert.assertTrue(Text.contains("Life Protection"));
	}
	@Test(priority=2)
	public void Privacy_Text() {
		WebElement privacy = driver.findElement(By.cssSelector(".body3.copyrightinfo"));
		String Text = privacy.getText();
		Assert.assertTrue(Text.contains("Copyright © 2021 DuPont"));
	}
	@Test(priority=3)
	public void Footer_Links(){	
		WebElement Footer = driver.findElement(By.cssSelector(".footer-list-legal"));
		List<WebElement> links = Footer.findElements(By.tagName("a"));
		int count = links.size();
		Assert.assertTrue(count==4);
	}
	@Test(priority=4)
	public void Location_Language() {
		WebElement language = driver.findElement(By.cssSelector(".language.navigation-item-sm"));
		String Text = language.getText();
		Assert.assertTrue(Text.contains("English"));
	}
	@Test(priority=5)
	public void FooterChicklets(){	
		WebElement FooterChicklets = driver.findElement(By.cssSelector(".col-sm-1.footer-social-icons.social-icons"));
		List<WebElement> links = FooterChicklets.findElements(By.tagName("a"));
		int count = links.size();
		Assert.assertTrue(count==3);
	}
	@Test(priority=6)
	public void Contact_Copyright() {
		List<WebElement> contactus = driver.findElements(By.partialLinkText("Contact us"));
		contactus.get(0).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement language = driver.findElement(By.cssSelector(".text-center.tyvek-disclaimer.credits"));
		String Text = language.getText();
		Assert.assertTrue(Text.contains("DuPont cares about your privacy"));
	}
	@Test(priority=7)
	public void Error_messages() {
		WebElement element = driver.findElement(By.id("waterSubmit"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		jse.executeScript("window.scrollBy(0,100)");
		Screenshot.screenshot();
		List<WebElement> errormessage = driver.findElements(By.cssSelector(".credits.errormessage.field-validation-valid.requiredtext_form"));
		Boolean Text = errormessage.get(0).isDisplayed();
		Assert.assertTrue(Text);
	}
	@AfterTest
	public void Teriminate(){
		driver.close();
	}
}
