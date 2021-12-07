package test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class FilterItemNotFound {
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
	public void filterNotFound() {
		
		HomePage homePage = new HomePage(driver);
		SearchPage searchPage = new SearchPage(driver);
		String web = "https://www.makeoverforall.com/";
		String searchText = "testing x";
		
//		Open web URL https://www.makeoverforall.com/
		driver.get(web);
		homePage.clickClosePopUp();
		
//		Click button search
		homePage.clickBtnSearch();
		
//		Input non existing item
		homePage.search(searchText);
		
//		Verify not found messagge
		boolean getNotFound = searchPage.getText(driver.findElement(By.xpath("//*[contains(text(),'Nothing matches your search')]")));
		Assert.assertEquals(getNotFound, true);
	}

	@AfterMethod
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
	}
}
