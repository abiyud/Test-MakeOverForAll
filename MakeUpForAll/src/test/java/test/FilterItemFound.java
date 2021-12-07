package test;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobject.HomePage;
import pageobject.SearchPage;

public class FilterItemFound {
	private WebDriver driver;
	

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void filterFound() {
		
		HomePage homePage = new HomePage(driver);
		SearchPage searchPage = new SearchPage(driver);
		String web = "https://www.makeoverforall.com/";
		String searchText = "lipstick";

//		Open web URL https://www.makeoverforall.com/
		driver.get(web);
		homePage.clickClosePopUp();
		
//		Click button search
		homePage.clickBtnSearch();
		
//		Input non existing item
		homePage.search(searchText);
		
//		Verify item name is "lipstick"
		List<WebElement> listResult = searchPage.getTextResult("lipstick");
		for (int i = 0; i < listResult.size(); i++) {
			boolean tempText = listResult.get(i).getText().toLowerCase().contains(searchText);
			Assert.assertEquals(tempText, true);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
	}
}
