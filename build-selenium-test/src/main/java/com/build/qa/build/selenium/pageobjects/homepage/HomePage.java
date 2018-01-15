package com.build.qa.build.selenium.pageobjects.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

import org.openqa.selenium.support.FindBy;


import com.build.qa.build.selenium.pageobjects.BasePage;

public class HomePage extends BasePage {
	String nofilter;
	String chromefilter;
	String filtermodern;
	int countnofilter;
	int countchromefilter;
	int countfiltermodern;
	
	@FindBy (xpath=".//*[@id='header']/nav/div/ul/li[2]/a") WebElement Bathroomtopnavigation;

	@FindBy (xpath=".//*[@id='main']/div[2]/section[2]/ul/li[1]/div/div/a/p") WebElement Bathroomfacets;
	@FindBy (xpath="//span[@class='total']") WebElement Totalcount;
	@FindBy (xpath=".//*[@id='facet-options']/li[4]/ul/li[1]/label") WebElement ModernChkbox;
	@FindBy (xpath="//*[text()='Shop by Finish']") WebElement shopbyfinish;
	@FindBy (xpath=".//*[@id='shop-by-finish']/div/div[2]/a/div[2]/h5") WebElement Chrome;
	WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	//private By searchbox;
	private By buildThemeBody;
	@FindBy (css="#search_txt") WebElement searchbox ;
	@FindBy (css=".button-primary.search-site-search") WebElement searchbutton ;
	public HomePage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		buildThemeBody = By.cssSelector("body.build-theme");
		//searchbox= By.cssSelector("#search_txt");
		
		
	}
	
	public boolean onBuildTheme() { 
		return wait.until(ExpectedConditions.presenceOfElementLocated(buildThemeBody)) != null;
	}
	
	
	public  void searchitem() throws InterruptedException {
		
		Thread.sleep(20000);
		
		searchbox.sendKeys("Quoizel MY1613ML");
		driver.findElement(By.cssSelector(".button-primary.search-site-search")).click();
		String actual=driver.findElement(By.xpath(".//*[@id='heading']")).getText();
		System.out.println(actual);
		 String expected="Quoizel MY1613ML";
		 assertEquals(actual,expected);
		 System.out.println("Product returned is correct");
		
	}
	
     public  void applyfilteritem() throws InterruptedException {
		
		Thread.sleep(20000);
		 
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='header']/nav/div/ul/li[2]/a")));
		Bathroomtopnavigation.click();
		jse.executeScript("scroll(0, 200)");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='main']/div[2]/section[2]/ul/li[1]/div/div/a/p")));
		Thread.sleep(20000);
		Bathroomfacets.click();
		Thread.sleep(20000);
		nofilter=Totalcount.getText();
		String numbernofilter = nofilter.replaceAll("[^\\.0123456789]","");
		countnofilter=Integer.parseInt(numbernofilter);
		System.out.println(countnofilter);
		jse.executeScript("scroll(0, 300)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Shop by Finish']")));
		shopbyfinish.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='shop-by-finish']/div/div[2]/a/div[2]/h5")));
		Chrome.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='total']")));
		chromefilter=Totalcount.getText();
		String numberchromefilter = chromefilter.replaceAll("[^\\.0123456789]","");
		countchromefilter=Integer.parseInt(numberchromefilter);
		System.out.println(countchromefilter);		
		jse.executeScript("scroll(0, 1000)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='facet-options']/li[4]/ul/li[1]/label")));
		ModernChkbox.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='total']")));
		filtermodern=Totalcount.getText();
		String numberfiltermodern = filtermodern.replaceAll("[^\\.0123456789]","");
		countfiltermodern=Integer.parseInt(numberfiltermodern);
		System.out.println(countfiltermodern);
		
    	
	}
     public boolean filtervalidation() {
    	 if(countnofilter>countchromefilter && countchromefilter>countfiltermodern)
    	 {
    		 return true;
    	 }
    	 else
    		 return false;
     }
}
