package com.build.qa.build.selenium.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.homepage.HomePage;
import com.build.qa.build.selenium.pageobjects.homepage.SinkPage;

public class BuildTest extends BaseFramework { 
	
	
	/** 
	 * Extremely basic test that outlines some basic
	 * functionality and page objects as well as assertJ
	 */
	
	@Test
	public void navigateToHomePage() { 
		
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);
		
		softly.assertThat(homePage.onBuildTheme())
			.as("The website should load up with the Build.com desktop theme.")
			.isTrue();
	}
	
	/** 
	 * Search for the Quoizel MY1613 from the search bar
	 * @throws InterruptedException 
	 * @assert: That the product page we land on is what is expected by checking the product title
	 * @difficulty Easy
	 * */
	 
	@Test
	public void searchForProductLandsOnCorrectProduct() throws InterruptedException { 
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);
		homePage.onBuildTheme();
		homePage.searchitem();
				
	}
	
	/** 
	 * Go to the Bathroom Sinks category directly (https://www.build.com/bathroom-sinks/c108504) 
	 * and add the second product on the search results (Category Drop) page to the cart.
	 * @throws InterruptedException 
	 * @assert: the product that is added to the cart is what is expected
	 * @difficulty Easy-Medium
	 */
	@Test
	public void addProductToCartFromCategoryDrop() throws InterruptedException { 
		driver.get(getConfiguration("SINKPAGE"));
		SinkPage sinkpage = new SinkPage(driver, wait);
		sinkpage.sink_addto_cart(); 
		sinkpage.verifyproduct();
		
	}
	
	/** 
	 * Add a product to the cart and email the cart to yourself, also to my email address: jgilmore+SeleniumTest@build.com
	 * Include this message in the "message field" of the email form: "This is {yourName}, sending you a cart from my automation!"
	 * @throws InterruptedException 
	 * @assert that the "Cart Sent" success message is displayed after emailing the cart
	 * @difficulty Medium-Hard
	 */
	@Test
	public void addProductToCartAndEmailIt() throws InterruptedException { 
		driver.get(getConfiguration("SINKPAGE"));
		 SinkPage sinkpage = new SinkPage(driver, wait);
		// BuildTest buildtest = new BuildTest(driver, wait);
		 //buildtest.addProductToCartFromCategoryDrop();
		 sinkpage.sink_addto_cart(); 
		 sinkpage.verifyproduct();
		 sinkpage.Sendemail();
	}
	
	/** 
	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
	 * at least two filters (facets), e.g: Finish=Chromes and Theme=Modern
	 * @throws InterruptedException 
	 * @assert that the correct filters are being narrowed, and the result count
	 * is correct, such that each facet selection is narrowing the product count.
	 * @difficulty Hard
	 */
	@Test
	public void facetNarrowBysResultInCorrectProductCounts() throws InterruptedException { 
		// TODO: Implement this test
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);
		homePage.applyfilteritem();
		homePage.filtervalidation();		
		assertTrue(homePage.filtervalidation());
		System.out.println("Products filtered correctly");
	}

	
	
}
