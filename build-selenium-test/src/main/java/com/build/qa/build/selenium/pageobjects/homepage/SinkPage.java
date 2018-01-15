package com.build.qa.build.selenium.pageobjects.homepage;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.build.qa.build.selenium.pageobjects.BasePage;
//import com.build.qa.build.selenium.tests.BuildTest;;

public class SinkPage extends BasePage {

	
	
	@FindBy (xpath=".//*[@id='shop-by-installation-type']/div/div[1]/a/div[1]") WebElement Dropin;
	@FindBy (xpath=".//*[@id='product-composite-1142249']/div[2]/a/div[2]") WebElement Product;
	@FindBy (xpath="//*[text()='Add to Cart']") WebElement AddCart;
	@FindBy (xpath="//button[@class='btn-standard header-cart-button js-cart-button']") WebElement Cart;
	@FindBy (xpath="//tbody/tr/td[2]/a")  WebElement Actualpdt;
	@FindBy (xpath="//button[@class='btn-standard btn-secondary btn-email js-email-cart-button']") WebElement Email;
	@FindBy (xpath=".//*[@id='yourName']")  WebElement Firstname;
	@FindBy (xpath=".//*[@id='yourEmail']")  WebElement Myemail;
	@FindBy (xpath=".//*[@id='recipientName']")  WebElement Recipientname;
	@FindBy (xpath=".//*[@id='recipientEmail']")  WebElement  Recipientemail;
	@FindBy (xpath=".//*[@id='quoteMessage']")  WebElement  Message;
	@FindBy (xpath="//button[@class='button-primary button js-email-cart-submit-button']")  WebElement  Emailcart;
	@FindBy (xpath=".//*[@id='header']/div[4]/div/ul/li")  WebElement  Sucessmessage;
	WebDriverWait wait = new WebDriverWait(driver, 40);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	public SinkPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		
	}
	

	public  void sink_addto_cart() throws InterruptedException {
	Thread.sleep(20000);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='shop-by-installation-type']/div/div[1]/a/div[1]")));
	Dropin.click();	
	jse.executeScript("scroll(0, 1000)");
	Thread.sleep(20000);	
	Product.click();
	jse.executeScript("scroll(0, 700)");
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Add to Cart']")));
	AddCart.click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-standard header-cart-button js-cart-button']")));
	Cart.click();
	}
	
	
	public  void verifyproduct() throws InterruptedException 	
	{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td[2]/a")));
	String actualproductname=Actualpdt.getText();
    String expectedpdtname="Kohler K-5373 22-5/8\" Vox Rectangle Vessel Sink with Overflow";
	assertEquals(actualproductname,expectedpdtname);
	System.out.println("Correct product is added succsessfully to cart");
	}
	
		
	
   public  void Sendemail() throws InterruptedException 
	
	{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-standard btn-secondary btn-email js-email-cart-button']")));
	Email.click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='yourName']")));
	Firstname.sendKeys("neethu");
	Myemail.sendKeys("neethuks1990@gmail.com");
	Recipientname.sendKeys("mahesh");
	Recipientemail.sendKeys("neethukrishnansindhu@gmail.com,jgilmore+SeleniumTest@build.com");
	Message.sendKeys("This is {neethu}, sending you a cart from my automation!");
	Emailcart.click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='header']/div[4]/div/ul/li")));
	String actualmessage= Sucessmessage.getText();
	String expectedmessage="Cart Sent! The cart has been submitted to the recipient via email.";
	assertEquals(actualmessage,expectedmessage);
	System.out.println("Email send successfully");
	}
	}

